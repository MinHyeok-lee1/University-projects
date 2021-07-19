import 'package:flutter/material.dart';

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context){
    return MaterialApp(
      title: 'Using Material Components',
      theme: ThemeData(primarySwatch: Colors.blue),
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
          title: Text('Using Material Components'),
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
        floatingActionButton: FloatingActionButton(
          tooltip: "Add",
          child: Icon(Icons.add),
          onPressed: null,
        ),
    );
  }
}