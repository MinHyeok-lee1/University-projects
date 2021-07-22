import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    final appName = 'Custom Fonts';

    // MaterailApp 생성/반환
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: appName,
      // 홈으로 MyHomePage를 직접 구현
      home: MyHomePage(),
      theme: ThemeData(
        // 사용할 폰트
        fontFamily: 'Raleway',
      ),
    );
  }
}

// 초기 스크린의 MyHomePage를 구성
class MyHomePage extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(title: Text('Custom Fonts Demo')),
      body: Center(
        child: Text(
          'Roboto Sample',
          // 텍스트 폰트 설정
          style: TextStyle(fontFamily: "Roboto"),
        ),
      ),
    );
  }
}