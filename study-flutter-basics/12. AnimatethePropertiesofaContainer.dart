import 'package:flutter/material.dart';
import 'dart:math';
void main() => runApp(AnimatedContainerApp());

class AnimatedContainerApp extends StatefulWidget{
  @override
  _AnimatedContainerAppState createState() => _AnimatedContainerAppState();
}

class _AnimatedContainerAppState extends State<AnimatedContainerApp>{
  // 속성값의 초기값 설정
  double _width = 50;
  double _height = 50;
  Color _color = Colors.green;
  BorderRadiusGeometry _borderRadius = BorderRadius.circular(8);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text('AnimatedContainer Demo'),
        ),
        body: Center(
          // AnimatedContainer 등록
          child: AnimatedContainer(
            // 너바와 높이 설정
            width: _width,
            height: _height,
            // 컨테이너의 색상과 테두리 모양 설정
            decoration:
              BoxDecoration(color: _color, borderRadius: _borderRadius),
            // 애니메이션 효과 소요시간
            duration: Duration(seconds: 1),
            // 애니메이션 효과 커브
            curve: Curves.fastOutSlowIn,
          ),
        ),

        // flagtingActionButton 추가
        floatingActionButton: FloatingActionButton(
          // 아이콘 추가
          child: Icon(Icons.play_arrow),
          onPressed: (){
            setState(() {
              final random = Random();

              _width = random.nextInt(300).toDouble();
              _height = random.nextInt(300).toDouble();
              _color = Color.fromARGB(
                  random.nextInt(256),
                  random.nextInt(256),
                  random.nextInt(256),
                  1,
              );
              _borderRadius = BorderRadius.circular(random.nextInt(100).toDouble());
            });
          },
        ),
      ),
    );
  }
}