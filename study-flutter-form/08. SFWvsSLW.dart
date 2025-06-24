import 'package:flutter/material.dart';

void main(){
  runApp(
    MaterialApp(
      title: "SFWvsSLW",
      debugShowCheckedModeBanner: false,
      home: MainPage(),
    ),
  );
}

class MainPage extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(title: Text("MainPage")),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(
              child: Text("Launch StatelessWidget"),
              onPressed: (){
                Navigator.push(context,
                    MaterialPageRoute(builder: (context) => SLWdemo()));
              },
            ),

          ElevatedButton(
            child: Text("Launch StatefulWidget"),
            onPressed: (){
              Navigator.push(context,
              MaterialPageRoute(builder: (context) => SFWdemo()));
            },
           )
          ]
            .map((children) => Container(
              width: 200,
              child: children,
          ))
            .toList()
        ),
      ),
    );
  }
}

class SLWdemo extends StatelessWidget{
  int _count = 0;

  @override
  Widget build(BuildContext context){
    print("** build - StatelessWidget Demo");
    return Scaffold(
      appBar: AppBar(title: Text("Stateless Widget")),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              "$_count",
              style: TextStyle(fontSize: 30),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                FloatingActionButton(
                    heroTag: null,
                    child: Icon(Icons.add),
                    onPressed: (){
                      _count++;
                      print("value of _count = $_count");
                    }),

                FloatingActionButton(
                    heroTag: null,
                    child: Icon(Icons.remove),
                    onPressed: (){
                      _count--;
                      print("value of _count = $_count");
                    }),
              ],
            )
          ],
        ),
      ),
    );
  }
}

class SFWdemo extends StatefulWidget{
  @override
  SFWdemoState createState() => SFWdemoState();
}

class SFWdemoState extends State<SFWdemo>{
  int _count = 0;

  @override
  Widget build(BuildContext context){
    print("** build - StatefulWidget Demo");
    return Scaffold(
      appBar: AppBar(title: Text("Stateful Widget")),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              "$_count",
              style: TextStyle(fontSize: 30),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                FloatingActionButton(
                    heroTag: null,
                    child: Icon(Icons.add),
                    onPressed: (){
                      setState(() {
                        _count++;
                      });
                      print("value of _count = $_count");
                    }),

                FloatingActionButton(
                    heroTag: null,
                    child: Icon(Icons.remove),
                    onPressed: (){
                      setState(() {
                        _count--;
                    });
                    print("value of _count = $_count");
                  }),
              ],
            )
          ],
        ),
      ),
    );
  }
}