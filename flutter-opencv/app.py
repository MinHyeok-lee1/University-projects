# app.py
from flask import Flask, request, jsonify
from werkzeug.serving import WSGIRequestHandler
import detection

app = Flask(__name__)

@app.route('/detection', methods = ['POST'])
def detection():
    data = request.get_json()
    if 'video' not in data:
         return "", 400
    detect_video = detection.capturing(data['video'])
    return detect_video, 200
        
@app.route("/")
def index():
    return "<h1>Welcome to hyeok's server to openCV</h1>"
    
if __name__ == "__main__":
    WSGIRequestHandler.protocol_version = "HTTP/1.1"
    app.run(threaded=True, host='0.0.0.0', port=5000)
