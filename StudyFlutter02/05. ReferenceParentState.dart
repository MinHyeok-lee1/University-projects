import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    title: 'child',
    debugShowCheckedModeBanner: false,
    home: ParentPage(),
  ));
}

ParentPageState ppState = new ParentPageState();

class ParentPage extends StatefulWidget{
  @override
  ParentPageState createState() => ppState;
}

class ParentPageState extends State<ParentPage>{
  bool flag = false;

  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: MyAppBar(),
      body: ListView(
        children: <Widget>[
          ChildPage1(),
          ChildPage2(),
        ],
      ),
    );
  }
}

class ChildPage1 extends StatefulWidget{
  @override
  _ChildPage1State createState() => _ChildPage1State();
}

class _ChildPage1State extends State<ChildPage1>{
  @override
  Widget build(BuildContext context){
    return Center(
      child: Text(ppState.flag.toString()),
    );
  }
}

class ChildPage2 extends StatefulWidget{
  @override
  _ChildPage2State createState() => _ChildPage2State();
}

class _ChildPage2State extends State<ChildPage2>{
  @override
  Widget build(BuildContext context){
    return Center(
      child: ElevatedButton(
        child: Text("Toggle"),
        onPressed: (){
          ppState.setState(() {
            ppState.flag = !ppState.flag;
          });
          print(ppState.flag);
        },
      ),
    );
  }
}

AppBar MyAppBar(){
  return AppBar(
    title: Text("Pomodoro Timer"),
    actions: <Widget>[
      IconButton(
          onPressed: () {
            print("onPressed");
          },
          icon: Icon(Icons.settings))
    ],
  );
}
