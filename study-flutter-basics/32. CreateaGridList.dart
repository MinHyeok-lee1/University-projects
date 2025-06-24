import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context){
    final title = 'Grid List';

    return MaterialApp(
      title: title,
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(title: Text(title)),
        body: GridView.count(crossAxisCount: 2,
        children: List.generate(100, (index) => Center(
          child: Text(
            'Item $index',
            style: Theme.of(context).textTheme.headline5,
          )
        ))),
      ),
    );
  }
}