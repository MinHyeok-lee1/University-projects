import 'package:flutter/material.dart';

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context){
    return MaterialApp(
      title: 'Baicwidgets',
      theme: ThemeData(primarySwatch: Colors.red),
      home: MyPage(),
      debugShowCheckedModeBanner: false,
    );
  }
}

class MyPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Baicwidgets'),
          centerTitle: true,
          elevation: 0.0,
          leading: IconButton(
            icon: Icon(Icons.menu),
            onPressed: null,
            tooltip: "Navigation menu",
          ),
          actions: <Widget>[
            IconButton(
              tooltip: "Search",
              onPressed: null,
              icon: Icon(Icons.search)),
          ],
        ),
        body: Container(
          child: Center(
            child: Text("Hello, world!"),
          ),
        ),
    );
  }
}
