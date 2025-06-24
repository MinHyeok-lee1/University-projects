import 'package:flutter/material.dart';
import 'package:flutter/foundation.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    final appName = 'Custom Themes';

    // MaterailApp 생성/반환
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: appName,
      theme: ThemeData(
        // 밝기는 어둡게
        brightness: Brightness.dark,
        // Color의 색상의 배열값 = 색의 농도를 의미 (100 ~ 900) per 100
        // 사용자와 상호작용하는 엘리먼트들의 기본색상
        primaryColor: Colors.lightBlue[800],

        // 위젯을 위한 전경색상
        accentColor: Colors.cyan[600],

        // 사용할 폰트
        fontFamily: 'Montserrat',

        // 텍스트 테마 설정
        textTheme: TextTheme(
          headline1: TextStyle(fontSize: 72.0, fontWeight: FontWeight.bold),
          headline6: TextStyle(fontSize: 36.0, fontStyle: FontStyle.italic),
          bodyText2: TextStyle(fontSize: 14.0, fontFamily: 'Hind'),
        ),
      ),
      // 홈으로 MyHomePage를 직접 구현
      home: MyHomePage(title: appName),
    );
  }
}

// 초기 스크린의 MyHomePage를 구성
class MyHomePage extends StatelessWidget{
  final String title;

  MyHomePage({Key? key, required this.title}) : super(key: key);

  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(title: Text(title)),
      body: Center(
        child: Container(
          color: Theme.of(context).accentColor,
          child: Text(
            'Text with a background color ',
            style: Theme.of(context).textTheme.headline6,
          ),
        ),
      ),

      // 일반적인 플로팅액션버튼 생성 방법
      // 이 때 accentColor 값을 기본 테마값(Colors.cyan[600])으로 가진다.
      floatingActionButton: FloatingActionButton(
        onPressed: (){},
        child: Icon(Icons.add),
      ),

      // 플로팅 액션버튼에 독자적인 테마를 이용하는 방법
      // 1. ThemeData를 새로 생성한다.
    /*  floatingActionButton: Theme(
        data: ThemeData(
          accentColor: Colors.red,
        ),
        child: FloatingActionButton(
          onPressed: () {},
          child: Icon(Icons.add),
        ),
      )

      // 2. 부모 테마를 상속하여 재정의한다.
      floatingActionButton: Theme(
        data: Theme.of(context),copyWith(
        colorScheme: Theme.of(context).colorScheme.copyWith(secondary: Colors.yellow),
       ),
      child: FloatingActionButton(
        onPressed: () {},
        child: Icon(Icons.add),
         ),
       ),
    */

    );
  }
}