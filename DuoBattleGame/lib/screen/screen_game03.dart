// 5 vs 5 Tab2 5x2
import 'dart:async';
import 'package:flutter/material.dart';
import 'dart:math';
import 'dart:ui' as ui;
import 'package:animated_text_kit/animated_text_kit.dart';
import 'package:duobattle/model/timer_model.dart';

class ThirdGameScreen extends StatefulWidget {

  @override
  _ThirdGameScreenState createState() => _ThirdGameScreenState();
}

class _ThirdGameScreenState extends State<ThirdGameScreen> {
  var book = [
    const Color(0xffff0000),
    const Color(0xffdc143c),
    const Color(0xffb22222),
    const Color(0xff800000),
    const Color(0xff8b0000),
    const Color(0xff0000ff),
    const Color(0xff0000cd),
    const Color(0xff000080),
    const Color(0xff00008b),
    const Color(0xff191970),
  ];
  var index = [
    0,1,2,3,4,
    5,6,7,8,9
  ];
  bool _visibility = false;

  var winnerText = 'The Winner is ';
  var name = '';
  int winner = 0;

  var score1 = 5;
  var score2 = 5;

  // ToDo: add Initpage and Timer
  var colorOne = Colors.red[200];
  var colorTwo = Colors.blue[200];
  var colorThree = Colors.white;

  var colorWinner = Colors.purple[200];
  late SecTimer timer = new SecTimer();
  bool _first = true;

  var flag = 2;
  var rnd = Random().nextInt(4) + 2;
  var t = Random().nextInt(8) + 3;
  var time = 0;

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
    if (score1 == 10 || timeOut(time, t) == 1) {
      name = 'Red';
      colorWinner = Colors.red;
      colorTwo = colorOne;
      colorThree = colorOne!;
      _visibility = true;
      return bodyPart2(width);
    }
    else if (score2 == 10 || timeOut(time, t) == 2) {
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
      colorTwo = Colors.purple[200];
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
            Expanded(
              child: Row(
                mainAxisSize: MainAxisSize.max,
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  Flexible(
                    child: InkWell(
                      child: Container(
                        color: book[index[0]],
                      ),
                      onTap: () {
                        colorChange(0);
                      },
                    ),
                  ),
                  Flexible(
                    child: InkWell(
                      child: Container(
                        color: book[index[1]],
                      ),
                      onTap: () {
                        colorChange(1);
                      },
                    ),
                  ),
                  Flexible(
                    child: InkWell(
                      child: Container(
                        color: book[index[2]],
                      ),
                      onTap: () {
                        colorChange(2);
                      },
                    ),
                  ),
                  Flexible(
                    child: InkWell(
                      child: Container(
                        color: book[index[3]],
                      ),
                      onTap: () {
                        colorChange(3);
                      },
                    ),
                  ),
                  Flexible(
                    child: InkWell(
                      child: Container(
                        color: book[index[4]],
                      ),
                      onTap: () {
                        colorChange(4);
                      },
                    ),
                  ),
                ],
              ),
            ),
            Container(height: 1.0, width: 500, color: Colors.white),
            Expanded(
              child: Row(
                mainAxisSize: MainAxisSize.max,
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  Flexible(
                    child: InkWell(
                      child: Container(
                        color: book[index[5]],
                      ),
                      onTap: () {
                        colorChange(5);
                      },
                    ),
                  ),
                  Flexible(
                    child: InkWell(
                      child: Container(
                        color: book[index[6]],
                      ),
                      onTap: () {
                        colorChange(6);
                      },
                    ),
                  ),
                  Flexible(
                    child: InkWell(
                      child: Container(
                        color: book[index[7]],
                      ),
                      onTap: () {
                        colorChange(7);
                      },
                    ),
                  ),
                  Flexible(
                    child: InkWell(
                      child: Container(
                        color: book[index[8]],
                      ),
                      onTap: () {
                        colorChange(8);
                      },
                    ),
                  ),
                  Flexible(
                    child: InkWell(
                      child: Container(
                        color: book[index[9]],
                      ),
                      onTap: () {
                        colorChange(9);
                      },
                    ),
                  ),
                ],
              ),
            ),
            Container(height: 5.0, width: 500, color: Colors.blueAccent),
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
      0,1,2,3,4,5,6,7,8,9
    ];
    score1 = 5;
    score2 = 5;
    winner = 0;

    // Add Reprint Variable
    rnd = Random().nextInt(5) + 1;
    t = Random().nextInt(8) + 3;
    timer.reset();

    colorOne = Colors.red[200];
    colorTwo = Colors.blue[200];
    colorThree = Colors.white;
    colorWinner = Colors.purple[200];

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
      switch(num){
        case 0:{
          if(index[5] != 0){
            if(index[0] != 0) {
              score1++;
              score2--;
              index[0] = 0;
              break;
            }

            score1++;
            score2--;
            index[5] = 0;
          }
          break;
        }
        case 1:{
          if(index[6] != 1) {
            if(index[1] != 1) {
              score1++;
              score2--;
              index[1] = 1;
              break;
            }

            score1++;
            score2--;
            index[6] = 1;
          }
          break;
        }
        case 2:{
          if(index[7] != 2) {
            if(index[2] != 2) {
              score1++;
              score2--;
              index[2] = 2;
              break;
            }

            score1++;
            score2--;
            index[7] = 2;
          }
          break;
        }
        case 3:{
          if(index[8] != 3) {
            if(index[3] != 3) {
              score1++;
              score2--;
              index[3] = 3;
              break;
            }

            score1++;
            score2--;
            index[8] = 3;
          }
          break;
        }
        case 4:{
          if(index[9] != 4) {
            if(index[4] != 4) {
              score1++;
              score2--;
              index[4] = 4;
              break;
            }

            score1++;
            score2--;
            index[9] = 4;
          }
          break;
        }

        case 5:{
          if(index[0] != 5) {
            if(index[5] != 5) {
              score2++;
              score1--;
              index[5] = 5;
              break;
            }

            score1--;
            score2++;
            index[0] = 5;
          }
          break;
        }
        case 6:{
          if(index[1] != 6) {
            if(index[6] != 6) {
              score2++;
              score1--;
              index[6] = 6;
              break;
            }

            score1--;
            score2++;
            index[1] = 6;
          }
          break;
        }
        case 7:{
          if(index[2] != 7) {
            if(index[7] != 7) {
              score2++;
              score1--;
              index[7] = 7;
              break;
            }

            score1--;
            score2++;
            index[2] = 7;
          }
          break;
        }
        case 8:{
          if(index[3] != 8) {
            if(index[8] != 8) {
              score2++;
              score1--;
              index[8] = 8;
              break;
            }

            score1--;
            score2++;
            index[3] = 8;
          }
          break;
        }
        case 9:{
          if(index[4] != 9) {
            if(index[9] != 9) {
              score2++;
              score1--;
              index[9] = 9;
              break;
            }

            score1--;
            score2++;
            index[4] = 9;
          }
          break;
        }
      }
      print('score1 = $score1\n');
      print('score2 = $score2\n');
    });
  }

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
}