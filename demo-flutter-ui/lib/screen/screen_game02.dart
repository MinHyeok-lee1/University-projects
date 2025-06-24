// 1 vs 1 ManyTouch, Add Timer
import 'dart:async';

import 'package:flutter/material.dart';
import 'dart:math';
import 'dart:ui' as ui;
import 'package:animated_text_kit/animated_text_kit.dart';
import 'package:duobattle/model/timer_model.dart';
import 'package:async/async.dart';

class SecondGameScreen extends StatefulWidget {
  @override
  _SecondGameScreenState createState() => _SecondGameScreenState();
}

class _SecondGameScreenState extends State<SecondGameScreen> {
  var book = [
    const Color(0xffff0000),
    const Color(0xff0000ff),
    Colors.white,
  ];
  var index = [
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    2,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
  ];
  bool _visibility = false;
  var colorOne = Colors.red[200];
  var colorTwo = Colors.blue[200];
  var colorThree = Colors.white;

  var colorWinner = Colors.purple[200];

  var winnerText = 'The Winner is ';
  var name = '';

  var rnd = Random().nextInt(3) + 3;
  var t = Random().nextInt(8) + 3;
  var time = 0;

  int baseline = 10;
  var score1 = 10;
  var score2 = 10;
  var flag = 2;

  late SecTimer timer = new SecTimer();
  bool _first = true;

  @override
  Widget build(BuildContext context) {
    Size screenSize = MediaQuery.of(context).size;
    double width = screenSize.width;

    return SafeArea(
      child: Scaffold(
        body: mainBody(width),
      ),
    );
  }

  Widget mainBody(double width) {
    if (_first) {
      _first = !_first;
      return FutureBuilder(
          future: Future.delayed(Duration(seconds: 3)),
          builder: (context, snapshot) {
// Checks whether the future is resolved, ie the duration is over
            if (snapshot.connectionState == ConnectionState.done) {
              timer.start();
              return bodyPart1(width);
            } else
              return bodyPart2(
                  width); // Return empty container to avoid build errors
          });
    }

    return bodyPart1(width);
  }

  Widget bodyPart1(double width) {
    var time = timer.saveTime();
    print('time: $time');
    print('t: $t');
    if (baseline == 21 || timeOut(time, t) == 1) {
      name = 'Red';
      colorWinner = Colors.red;
      colorTwo = colorOne;
      colorThree = colorOne!;
      _visibility = true;
      return bodyPart2(width);
    }
    else if (baseline == -1 || timeOut(time, t) == 2) {
      name = 'Blue';
      colorWinner = Colors.blue;
      colorOne = colorTwo;
      colorThree = colorTwo!;
      _visibility = true;
      return bodyPart2(width);
    }
    else if (timeOut(time, t) == 3) {
      winnerText = 'Draw!';
      name = '';
      colorWinner = Colors.purple;
      colorOne = Colors.purple[200];
      colorThree = Colors.purple[200]!;
      _visibility = true;
      return bodyPart2(width);
    }
    else {
      Future.delayed(const Duration(seconds: 1), () {
        // Timer
        time = timer.saveTime();
        setState(() {});
        //Timer End
      });
    }
    return Stack(
      children: <Widget>[
        Column(
          mainAxisSize: MainAxisSize.max,
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Container(height: 5.0, width: 500, color: Colors.redAccent),
            Flexible(
              flex: 10,
              child: Column(
                mainAxisSize: MainAxisSize.max,
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  Flexible(
                    child: InkWell(
                      child: Column(
                        children: <Widget>[
                          Flexible(
                            child: Container(color: book[index[0]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[1]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[2]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[3]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[4]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[5]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[6]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[7]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[8]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[9]]),
                          ),
                        ],
                      ),
                      onTap: () {
                        colorChange(0);
                      },
                    ),
                  ),
                ],
              ),
            ),
            Expanded(
              flex: 1,
              child: Container(
                color: book[index[10]],
              ),
            ),
            Flexible(
              flex: 10,
              child: Column(
                mainAxisSize: MainAxisSize.max,
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  Flexible(
                    child: InkWell(
                      child: Column(
                        children: <Widget>[
                          Flexible(
                            child: Container(color: book[index[11]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[12]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[13]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[14]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[15]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[16]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[17]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[18]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[19]]),
                          ),
                          Flexible(
                            child: Container(color: book[index[20]]),
                          ),
                        ],
                      ),
                      onTap: () {
                        colorChange(1);
                      },
                    ),
                  ),
                ],
              ),
            ),
            Container(height: 5.0, width: 500, color: Colors.blueAccent),
          ],
        ),
      ],
    );
  }

  Widget bodyPart2(double width) {
    return Stack(
      children: <Widget>[
        childBody(),
        BackdropFilter(
          filter: ui.ImageFilter.blur(
            sigmaX: 8.0,
            sigmaY: 8.0,
          ),
          child: Opacity(
            opacity: 0.01,
            child: childBody(),
          ),
        ),
        Visibility(
            visible: !_visibility,
            child: RotatedBox(
              quarterTurns: 1,
              child: Center(
                child: DefaultTextStyle(
                  style: TextStyle(
                    fontSize: width * 0.04,
                    color: Colors.white,
                    fontWeight: FontWeight.bold,
                  ),
                  child: AnimatedTextKit(
                    animatedTexts: [
                      FadeAnimatedText('Ready for Touch...'),
                      FadeAnimatedText('Ready for Touch..!'),
                    ],
                  ),
                ),
              ),
            )),
        Visibility(
          visible: _visibility,
          child: RotatedBox(
            quarterTurns: 1,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Text(
                  winnerText + name,
                  style: TextStyle(
                    fontSize: width * 0.05,
                    color: colorWinner,
                  ),
                ),
                Padding(
                  padding: EdgeInsets.all(width * 0.048),
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: <Widget>[
                    IconButton(
                      color: colorWinner,
                      hoverColor: Colors.white,
                      onPressed: () {
                        Navigator.pop(context);
                      },
                      icon: const Icon(
                        Icons.arrow_back_sharp,
                      ),
                    ),
                    IconButton(
                      color: colorWinner,
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
        Visibility(
          visible: _visibility,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: <Widget>[
              RotatedBox(
                quarterTurns: 1,
                child: Text(
                  'Red: $score1개 ',
                  style: TextStyle(
                    fontSize: width * 0.04,
                    color: const Color(0xffff0000),
                  ),
                ),
              ),
              Padding(
                padding: EdgeInsets.all(width * 0.048),
              ),
              RotatedBox(
                quarterTurns: 1,
                child: Text(
                  'Blue: $score2개 ',
                  style: TextStyle(
                    fontSize: width * 0.04,
                    color: const Color(0xff0000ff),
                  ),
                ),
              ),
            ],
          ),
        ),
      ],
    );
  }

  Widget childBody() {
    return Column(
      mainAxisSize: MainAxisSize.max,
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        Flexible(
          flex: 10,
          child: Container(
            color: colorOne,
          ),
        ),
        Flexible(
          flex: 1,
          child: Container(
            color: colorThree,
          ),
        ),
        Flexible(
          flex: 10,
          child: Container(
            color: colorTwo,
          ),
        ),
      ],
    );
  }

  void reprint() {
    index = [
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      2,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
    ];
    score1 = 10;
    score2 = 10;

    rnd = Random().nextInt(3) + 3;
    t = Random().nextInt(8) + 3;
    timer.reset();

    colorOne = Colors.red[200];
    colorTwo = Colors.blue[200];
    colorThree = Colors.white;
    colorWinner = Colors.purple[200];

    baseline = 10;
    _visibility = false;
    flag = 2;
    winnerText = 'The Winner is ';
    name = '';
    _first = true;
  }

  void colorChange(int num) {
    // timer로 _visibiility 조정
    // _visibility = true;

    setState(() {
      switch (num) {
        case 0:
          {
            if (baseline < 21) {
              if (flag == 2) {
                score2++;
              }
              if (flag == 0) {
                ++baseline;
              }
              flag = 1;
              ++baseline;
              --score2;
              ++score1;
            }
            for (int i = 0; i < baseline; i++) {
              index[i] = 0;
            }
            for (int i = 20; i > baseline; i--) {
              index[i] = 1;
            }
            break;
          }
        case 1:
          {
            if (baseline > -1) {
              if (flag == 2) {
                score1++;
              }
              if (flag == 1) {
                --baseline;
              }
              flag = 0;
              --baseline;

              --score1;
              ++score2;
            }
            for (int i = 0; i < baseline; i++) {
              index[i] = 0;
            }
            for (int i = 20; i > baseline; i--) {
              index[i] = 1;
            }
            break;
          }
      }
    });

    // print('$baseline');
  }

// 시간 초과되면 colorchange해주자.
  int timeOut(int time, int t) {
    if (score1 > score2 && time > t) {
      return 1;
    } else if (score2 > score1 && time > t) {
      return 2;
    } else if (score1 == score2 && time > t) {
      return 3;
    }

    return 0;
  }

// Widget timeCheck(double width){
//   // Timer
//   if (baseline == 21 || timeOut(time, t) == 1) {
//     name = 'Red';
//     colorWinner = Colors.red;
//     colorTwo = colorOne;
//     colorThree = colorOne!;
//     _visibility = true;
//     return bodyPart2(width);
//   }
//   else if (baseline == -1 || timeOut(time, t) == 2) {
//     name = 'Blue';
//     colorWinner = Colors.blue;
//     colorOne = colorTwo;
//     colorThree = colorTwo!;
//     _visibility = true;
//     return bodyPart2(width);
//   }
//   else if (timeOut(time, t) == 3) {
//     winnerText = 'Draw!';
//     name = '';
//     colorWinner = Colors.purple;
//     colorOne = Colors.purple[200];
//     colorThree = Colors.purple[200]!;
//     _visibility = true;
//     return bodyPart2(width);
//   }
//   print('time: $time');
//   print('t: $t');
//   // Timer End
//
//   return bodyPart2(width);
// }
}
