import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'BusinessCard Demo',
      home: Scaffold(
        appBar: AppBar(
          title: Text('BusinessCard Demo'),
          backgroundColor: Colors.orangeAccent,
        ),
        backgroundColor: Colors.teal,
        body: SafeArea(
          child: Column(
            children: <Widget>[
              CircleAvatar(
                radius: 50.0,
                backgroundImage: AssetImage('images/lion.png'),
              ),
              Text(
                  'Lion',
                style: TextStyle(
                  fontFamily: 'Roboto',
                  fontSize: 40.0,
                  fontWeight: FontWeight.bold,
                  color: Colors.white,
                ),
              ),
              Text(
                 'FLUTTER DEVELOPER',
                 style: TextStyle(
                    fontFamily: 'Roboto',
                    fontSize: 20.0,
                    color: Colors.<em>teal</em>.shade100,
                    letterSpacing: 2.5,
                    fontWeight: FontWeight.<em>bold</em>,
                ),
              ),
             ],
          ),
        ),
      ),
    );
  }
}
