#Import necessary libraries
from flask import Flask, jsonify, request
from werkzeug.serving import WSGIRequestHandler

#Initialize the Flask app
app = Flask(__name__)
        
@app.route('/user', methods = ['POST'])
def communication():
    data = request.get_json()
    
    if 'image' not in data:
        return "", 400
    
    return data

@app.route("/")
def index():
    return "<h1>Welcome to hyeok ml server !!</h1>"
           
if __name__ == "__main__":
    WSGIRequestHandler.protocol_version = "HTTP/1.1"
    app.run(debug=True)
