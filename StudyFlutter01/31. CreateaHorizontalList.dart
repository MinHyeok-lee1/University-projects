import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    final title = 'Horizontal List';

    return MaterialApp(
      title: title,
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(title: Text(title)),
        body: Container(
          // 수평적으로 대칭 (symmetric)의 마진을 추가 -> 화면 위, 아래에 20px의 마진 삽입
          margin: EdgeInsets.symmetric(vertical: 20.0),
          // 컨테이너의 높이를 200으로 설정
          height: 200.0,
          // 리스트뷰 추가
          child: ListView(
            // 스크롤 방향 설정, 수평적으로 스크롤 되도록 설정
            scrollDirection: Axis.horizontal,
            // 컨테이너들을 ListView의 자식들로 추가
            children: <Widget>[
              Container(
                width: 160.0,
                color: Colors.red,
              ),

              Container(
                width: 160.0,
                color: Colors.blue,
              ),

              Container(
                width: 160.0,
                color: Colors.green,
              ),

              Container(
                width: 160.0,
                color: Colors.yellow,
              ),

              Container(
                width: 160.0,
                color: Colors.orange,
              ),

              Container(
                width: 160.0,
                color: Colors.purple,
              ),

            ],
          ),
        )
      ),
    );
  }
}