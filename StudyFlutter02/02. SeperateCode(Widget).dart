import 'package:flutter/material.dart';

void main(){
  // 터미널에 Hello World를 출력
  print('Hello World 2');

  runApp(new MyApp());
}

class MyApp extends StatelessWidget {
  final String title = "Hello World App";
  final String helloWorldText = "Hello World 2";

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: title, // 앱에 대한 설명
      home: MyHomePage(
        title: "Hello World",
        helloWorldText: helloWorldText,
      ),
    );
  }
}

  class MyHomePage extends StatelessWidget{
    final String title;
    final String helloWorldText;

    MyHomePage({Key? key, required this.title, required this.helloWorldText}) : super(key: key);

    @override
    Widget build(BuildContext context){
      return Scaffold(
        appBar: AppBar(title: Text(title)),
        // body: MyBody(helloWorldText: helloWorldText),
        body: buildBody(),
      );
    }
    
    // 별도의 클래스가 아닌 메소드로 분리한 것
    Widget buildBody(){
      return Text(helloWorldText+"!!");
    }
  }

  class MyBody extends StatelessWidget{
    final String helloWorldText;

    const MyBody({Key? key, required this.helloWorldText}) : super(key: key);

    @override
    Widget build(BuildContext context){
      return Text(helloWorldText);
    }
  }

/*
1. print함수를 이용해 터미널 상애  Hello World 출력
2. MaterialApp의 title을 이용한 Hello World 출력
3. Scaffold의 body를 이용한 Hello World 출력
4. Scaffold의 appBar를 이용한 Hello World 출력
*/
