import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    final appTitle = 'Drawer Demo';

    return MaterialApp(
       title: appTitle,
       debugShowCheckedModeBanner: false,
       // MyMomePage 위젯 라우트를 home으로 설정, 생성자로 appTitle 값 전달
       home: MyHomePage(title: appTitle),
     );
  }
}

// 앱 실행시 출력되는 초기 라우트 위젯
class MyHomePage extends StatelessWidget {
  final String title;

  // 생성자, title 아규먼트를 전달받아 필드에 저장
  MyHomePage({Key ?key, required this.title}):super(key: key);

  @override
  Widget build(BuildContext context){
    // 스카폴드 추가
    return Scaffold(
      appBar: AppBar(title: Text(title)),
      body: Center(child: Text('My Page!')),
      // 드로워 추가
      drawer: Drawer(
        // 리스트뷰 추가
        child: ListView(
          padding: EdgeInsets.zero,
          children: <Widget>[
            // 드로워헤더 추가
            DrawerHeader(
              child: Text('Drawer Header'),
              decoration: BoxDecoration(
                color: Colors.blue,
              ),
            ),
            // 리스트타일 추가
            ListTile(
              title: Text('Item 1'),
              onTap: (){
                // 네비게이터 팝을 통해 드로워를 닫는다.
                Navigator.pop(context);
              },
            ),

            // 리스트타일 추가
            ListTile(
              title: Text('Item 2'),
              onTap: (){
                // 네비게이터 팝을 통해 드로워를 닫는다.
                Navigator.pop(context);
              },
            ),

          ],
        ),
      ),
    );
  }
}