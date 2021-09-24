// 1 vs 1 Faster Tap
import 'package:flutter/material.dart';
import 'package:module/screen/screen_home.dart';

class FirstGameScreen extends StatefulWidget {

  @override
  _FirstGameScreenState createState() => _FirstGameScreenState();
}

class _FirstGameScreenState extends State<FirstGameScreen> {
  var colorOne = const Color(0xffff0000);
  var colorTwo = const Color(0xff0000ff);
  bool _visibility = false;
  var winnerText = 'The Winner is ';
  var name = '';
  int winner = 0;

  @override
  Widget build(BuildContext context) {
    Size screenSize = MediaQuery
        .of(context)
        .size;
    double width = screenSize.width;
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
                      name = 'Red';
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
                      name = 'Blue';
                      colorChange();
                    },
                  ),
                ),
              ],
            ),
            Visibility(
              visible: _visibility,
              child: RotatedBox(
                quarterTurns: 1,
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Text(winnerText+name,
                        style: TextStyle(
                          fontSize: width * 0.05,
                          color: Colors.white,
                        ),
                      ),
                    Padding(
                      padding: EdgeInsets.all(width * 0.048),
                    ),
                    Row(
                        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                        children: <Widget>[
                          IconButton(
                            color: Colors.white,
                            hoverColor: Colors.white,
                            onPressed: () {
                              Navigator.pop(context);
                            },
                            icon: const Icon(
                              Icons.arrow_back_sharp,
                            ),
                          ),
                          IconButton(
                            color: Colors.white,
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
                      ),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  void reprint() {
    colorOne = const Color(0xffff0000);
    colorTwo = const Color(0xff0000ff);
    winner = 0;
    _visibility = false;
  }

  void colorChange() {
    _visibility = true;

    setState(() {
      if (winner == 1) {
        colorTwo = const Color(0xffff0000);
      } else {
        colorOne = const Color(0xff0000ff);
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