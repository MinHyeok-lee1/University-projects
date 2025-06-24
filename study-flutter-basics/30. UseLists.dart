import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    final title = 'Basic List';

    return MaterialApp(
      title: title,
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(title: Text(title)),
        body: ListView(
          children: <Widget>[
            ListTile(
              // leading. 타일 앞에 표시되는 위젯. 참고로 타일 뒤에는 trailing 위젯으로 사용가능
              leading: Icon(Icons.map),
              title: Text('Map'),
            ),
            ListTile(
              // leading. 타일 앞에 표시되는 위젯. 참고로 타일 뒤에는 trailing 위젯으로 사용가능
              leading: Icon(Icons.photo_album),
              title: Text('Album'),
            ),
            ListTile(
              // leading. 타일 앞에 표시되는 위젯. 참고로 타일 뒤에는 trailing 위젯으로 사용가능
              leading: Icon(Icons.phone),
              title: Text('Phone'),
            ),
          ],
        )
      ),
    );
  }
}