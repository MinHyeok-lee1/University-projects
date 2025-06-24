import 'package:flutter/material.dart';

void main(){
  // 터미널에 Hello World를 출력
  print('Hello World');

  runApp(MyApp());
}

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return MaterialApp(
      title: 'Hello World', // 앱에 대한 설명
      home: Scaffold(
        appBar: AppBar(
          title: Text('Hello World'), // 앱바 타이틀
        ),
        body: Text('Hello World!'), // 텍스트를 출력하는 위젯
      ),
    );
  }
}

/*
1. print함수를 이용해 터미널 상애  Hello World 출력
2. MaterialApp의 title을 이용한 Hello World 출력
3. Scaffold의 body를 이용한 Hello World 출력
4. Scaffold의 appBar를 이용한 Hello World 출력
*/
