#Import necessary libraries
from flask import Flask, jsonify

number = 0
#Initialize the Flask app
app = Flask(__name__)
        
@app.route('/', methods = ['GET'])
def index():
    response = jsonify({'greetings': 'Hi! this is python %d'%number+1})
    response.headers.add("Access-Control-Allow-Origin", "*")
    return response
           
if __name__ == "__main__":
    app.run(debug=True)