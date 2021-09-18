// ManyTouch

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    const title = 'Timer Demo';
    return const MaterialApp(
      title: title,
      home: MyHomePage(
        title: title,
      ),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);
  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  var colorOne = Colors.red;
  var colorTwo = Colors.blue;
  bool _visibility = false;
  int winner = 0;
  var buttonColor = Colors.red;
  var score1 = 0;
  var score2 = 0;

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: Stack(
          children: <Widget>[
            Column(
              mainAxisSize: MainAxisSize.max,
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Expanded(
                  child: InkWell(
                    child: Container(
                      color: colorOne,
                    ),
                    onTap: () {
                      score1++;
                      print(score1);
                    },
                  ),
                ),
                Expanded(
                  child: InkWell(
                    child: Container(
                      color: colorTwo,
                    ),
                    onTap: () {
                      score2++;
                      print(score2);
                    },
                  ),
                ),
              ],
            ),
            Visibility(
              child: Center(
                child: Row(
                  children: <Widget>[
                    IconButton(
                      color: buttonColor,
                      hoverColor: Colors.white,
                      onPressed: () {
                        setState(() {
                        });
                      },
                      icon: const Icon(
                        Icons.arrow_back_sharp,
                      ),
                    ),
                    IconButton(
                      color: buttonColor,
                      hoverColor: Colors.white,
                      onPressed: () {
                        setState(() {
                          reprint();
                        });
                      },
                      icon: const Icon(
                        Icons.refresh_sharp,
                      ),
                    ),
                  ],
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                ),
              ),
              visible: _visibility,
            ),
          ],
        ),
      ),
    );
  }

  void reprint() {
    colorOne = Colors.red;
    colorTwo = Colors.blue;
    winner = 0;
    _visibility = false;
  }

  void colorChange() {
    _visibility = true;

    setState(() {
      if (winner == 1) {
        colorTwo = Colors.red;
        buttonColor = Colors.blue;
        print('player one win!');
      } else {
        colorOne = Colors.blue;
        buttonColor = Colors.red;
        print('player two win!');
      }
    });
  }

// 시간 초과되면 colorchange해주자.
 void timeOut(){
    if(score1 > score2) print('Winner: Player Red');
    else if(score2 > score1) print('Winner: Player Blue');
    else print('draw');
    colorChange();
 }
}
