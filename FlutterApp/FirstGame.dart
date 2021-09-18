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
                      winner = 1;
                      colorChange();
                    },
                  ),
                ),
                Expanded(
                  child: InkWell(
                    child: Container(
                      color: colorTwo,
                    ),
                    onTap: () {
                      winner = 2;
                      colorChange();
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

  // Widget makeButton(String title, VoidCallback callback) {
  //   return IconButton(
  //     hoverColor: buttonColor,
  //     onPressed: () {
  //       setState(() {
  //         callback();
  //       });
  //     },
  //     icon: const Icon(
  //       Icons.arrow_back_sharp,
  //       color: Colors.white,
  //     ),
  //   );
  // }
}
