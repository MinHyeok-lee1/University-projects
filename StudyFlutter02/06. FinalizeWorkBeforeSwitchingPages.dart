import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    title: "WillPopScope Demo",
    debugShowCheckedModeBanner: false,
    home: FirstPage(),
  ));
}

class FirstPage extends StatefulWidget {
  @override
  _FirstPageState createState() => _FirstPageState();
}

class _FirstPageState extends State<FirstPage> {
  void updateState(){
    print("Update State of FirstPage");
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: MyAppBar(),
      body: Center(
        child: ElevatedButton(
          child: Text("Move to Second Page"),
          onPressed: () async {
            // SecondPage를 화면에 푸쉬
            await Navigator.push(context,
                MaterialPageRoute(builder: (context) => SecondPage()));
            updateState();
          },
        ),
      ),
    );
  }
}

class SecondPage extends StatefulWidget {
  @override
  _SecondPageState createState() => _SecondPageState();
}

class _SecondPageState extends State<SecondPage> {
  @override
  void initState() {
    print("initState() of _SecondPage");
    super.initState();
  }

  @override
  void dispose() {
    print("dispose() of _SecondPage");
    // StoreSettingValues();
    super.dispose();
  }

  void storeSettingValues() {
    print("Store setting Values");
  }

  @override
  Widget build(BuildContext context) {
    return WillPopScope(
        onWillPop: () async {
          storeSettingValues();
          Navigator.pop(context);
          return false;
        },

      child: Scaffold(
        appBar: AppBar(title: Text("Second Page")),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Text("Second Page"),
              Text("Set something on this page.")
            ],
          ),
        ),
      )
    );
  }
}

AppBar MyAppBar() {
  return AppBar(
    title: Text("First Page"),
    actions: <Widget>[
      IconButton(
        icon: Icon(Icons.settings),
        onPressed: () {
          print("onPressed");
        },
      )
    ],
  );
}