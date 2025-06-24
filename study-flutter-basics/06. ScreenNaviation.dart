import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    title: "Navigation Basics",
    debugShowCheckedModeBanner: false,
    theme: ThemeData(primarySwatch: Colors.blue),
    home: FirstRoute(), // FirstRoute를 홈으로 설정
  ));
}


class FirstRoute extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('This Page is First Route'),
      ),
      body: Center(
        // RaisedButton(평평한 레이아웃 위에 버튼)을 자식으로 등록
        child: RaisedButton(
          child: Text('Open second route'),
          onPressed: () {
            Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => SecondRoute())
            );
          },
        ),
      ),
    );
  }
}

class SecondRoute extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('This Page is Second Route'),
      ),
      body: Center(
        // RaisedButton(평평한 레이아웃 위에 버튼)을 자식으로 등록
        child: RaisedButton(
          child: Text('Open First route'),
          onPressed: () {
            Navigator.pop(context);
          },
        ),
      ),
    );
  }
}