// 10 vs 10 TapFourth 5x4
import 'package:flutter/material.dart';

class FourthGameScreen extends StatefulWidget {

  @override
  _FourthGameScreenState createState() => _FourthGameScreenState();
}

class _FourthGameScreenState extends State<FourthGameScreen> {
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
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9
  ];
  bool _visibility = false;

  var winnerText = 'The Winner is ';
  var name = '';
  int winner = 0;

  var score1 = 10;
  var score2 = 10;

  @override
  Widget build(BuildContext context) {
    Size screenSize = MediaQuery
        .of(context)
        .size;
    double width = screenSize.width;

    if(score1 == 20) {
      name = 'Red';
      _visibility = true;
    }
    else if(score2 == 20) {
      name = 'Blue';
      _visibility = true;
    }

    return SafeArea(
      child: Scaffold(
        body: Stack(
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
                          child: Column(
                            children: <Widget>[
                              Flexible(
                                child: Container(color: book[index[0]]),
                              ),
                              Flexible(
                                child: Container(color: book[index[10]]),
                              ),
                            ],
                          ),
                          onTap: () {
                            colorChange(0);
                          },
                        ),
                      ),
                      Flexible(
                        child: InkWell(
                          child: Column(
                            children: <Widget>[
                              Flexible(
                                child: Container(color: book[index[1]]),
                              ),
                              Flexible(
                                child: Container(color: book[index[11]]),
                              ),
                            ],
                          ),
                          onTap: () {
                            colorChange(1);
                          },
                        ),
                      ),
                      Flexible(
                        child: InkWell(
                          child: Column(
                            children: <Widget>[
                              Flexible(
                                child: Container(color: book[index[2]]),
                              ),
                              Flexible(
                                child: Container(color: book[index[12]]),
                              ),
                            ],
                          ),
                          onTap: () {
                            colorChange(2);
                          },
                        ),
                      ),
                      Flexible(
                        child: InkWell(
                          child: Column(
                            children: <Widget>[
                              Flexible(
                                child: Container(color: book[index[3]]),
                              ),
                              Flexible(
                                child: Container(color: book[index[13]]),
                              ),
                            ],
                          ),
                          onTap: () {
                            colorChange(3);
                          },
                        ),
                      ),
                      Flexible(
                        child: InkWell(
                          child: Column(
                            children: <Widget>[
                              Flexible(
                                child: Container(color: book[index[4]]),
                              ),
                              Flexible(
                                child: Container(color: book[index[14]]),
                              ),
                            ],
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
                          child: Column(
                            children: <Widget>[
                              Flexible(
                                child: Container(color: book[index[5]]),
                              ),
                              Flexible(
                                child: Container(color: book[index[15]]),
                              ),
                            ],
                          ),
                          onTap: () {
                            colorChange(5);
                          },
                        ),
                      ),
                      Flexible(
                        child: InkWell(
                          child: Column(
                            children: <Widget>[
                              Flexible(
                                child: Container(color: book[index[6]]),
                              ),
                              Flexible(
                                child: Container(color: book[index[16]]),
                              ),
                            ],
                          ),
                          onTap: () {
                            colorChange(6);
                          },
                        ),
                      ),
                      Flexible(
                        child: InkWell(
                          child: Column(
                            children: <Widget>[
                              Flexible(
                                child: Container(color: book[index[7]]),
                              ),
                              Flexible(
                                child: Container(color: book[index[17]]),
                              ),
                            ],
                          ),
                          onTap: () {
                            colorChange(7);
                          },
                        ),
                      ),
                      Flexible(
                        child: InkWell(
                          child: Column(
                            children: <Widget>[
                              Flexible(
                                child: Container(color: book[index[8]]),
                              ),
                              Flexible(
                                child: Container(color: book[index[18]]),
                              ),
                            ],
                          ),
                          onTap: () {
                            colorChange(8);
                          },
                        ),
                      ),
                      Flexible(
                        child: InkWell(
                          child: Column(
                            children: <Widget>[
                              Flexible(
                                child: Container(color: book[index[9]]),
                              ),
                              Flexible(
                                child: Container(color: book[index[19]]),
                              ),
                            ],
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
        ),
      ),
    );
  }

  void reprint() {
    index = [
      0,
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9,
      0,
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      9
    ];
    score1 = 10;
    score2 = 10;
    winner = 0;
    _visibility = false;
  }

  void colorChange(int num) {
    // timer로 _visibiility 조정
    // _visibility = true;

    setState(() {
      switch (num) {
        case 0:
          {
            if (index[15] != 0) {
              if (index[0] != 0) {
                score1++;
                score2--;
                index[0] = 0;
                break;
              } else if (index[10] != 0) {
                score1++;
                score2--;
                index[10] = 0;
                break;
              } else if (index[5] != 0) {
                score1++;
                score2--;
                index[5] = 0;
                break;
              }

              score1++;
              score2--;
              index[15] = 0;
            }
            break;
          }
        case 1:
          {
            if (index[16] != 1) {
              if (index[1] != 1) {
                score1++;
                score2--;
                index[1] = 1;
                break;
              } else if (index[11] != 1) {
                score1++;
                score2--;
                index[11] = 1;
                break;
              } else if (index[6] != 1) {
                score1++;
                score2--;
                index[6] = 1;
                break;
              }

              score1++;
              score2--;
              index[16] = 1;
            }
            break;
          }
        case 2:
          {
            if (index[17] != 2) {
              if (index[2] != 2) {
                score1++;
                score2--;
                index[2] = 2;
                break;
              } else if (index[12] != 2) {
                score1++;
                score2--;
                index[12] = 2;
                break;
              } else if (index[7] != 2) {
                score1++;
                score2--;
                index[7] = 2;
                break;
              }

              score1++;
              score2--;
              index[17] = 2;
            }
            break;
          }
        case 3:
          {
            if (index[18] != 3) {
              if (index[3] != 3) {
                score1++;
                score2--;
                index[3] = 3;
                break;
              } else if (index[13] != 3) {
                score1++;
                score2--;
                index[13] = 3;
                break;
              } else if (index[8] != 3) {
                score1++;
                score2--;
                index[8] = 3;
                break;
              }

              score1++;
              score2--;
              index[18] = 3;
            }
            break;
          }
        case 4:
          {
            if (index[19] != 4) {
              if (index[4] != 4) {
                score1++;
                score2--;
                index[4] = 4;
                break;
              } else if (index[14] != 4) {
                score1++;
                score2--;
                index[14] = 4;
                break;
              } else if (index[9] != 4) {
                score1++;
                score2--;
                index[9] = 4;
                break;
              }

              score1++;
              score2--;
              index[19] = 4;
            }
            break;
          }

        case 5:
          {
            if (index[0] != 5) {
              if (index[15] != 5) {
                score2++;
                score1--;
                index[15] = 5;
                break;
              } else if (index[5] != 5) {
                score2++;
                score1--;
                index[5] = 5;
                break;
              } else if (index[10] != 5) {
                score2++;
                score1--;
                index[10] = 5;
                break;
              }

              score2++;
              score1--;
              index[0] = 5;
            }
            break;
          }
        case 6:
          {
            if (index[1] != 6) {
              if (index[16] != 6) {
                score2++;
                score1--;
                index[16] = 6;
                break;
              } else if (index[6] != 6) {
                score2++;
                score1--;
                index[6] = 6;
                break;
              } else if (index[11] != 6) {
                score2++;
                score1--;
                index[11] = 6;
                break;
              }

              score2++;
              score1--;
              index[1] = 6;
            }
            break;
          }
        case 7:
          {
            if (index[2] != 7) {
              if (index[17] != 7) {
                score2++;
                score1--;
                index[17] = 7;
                break;
              } else if (index[7] != 7) {
                score2++;
                score1--;
                index[7] = 7;
                break;
              } else if (index[12] != 7) {
                score2++;
                score1--;
                index[12] = 7;
                break;
              }


              score2++;
              score1--;
              index[2] = 7;
            }
            break;
          }
        case 8:
          {
            if (index[3] != 8) {
              if (index[18] != 8) {
                score2++;
                score1--;
                index[18] = 8;
                break;
              } else if (index[8] != 8) {
                score2++;
                score1--;
                index[8] = 8;
                break;
              } else if (index[13] != 8) {
                score2++;
                score1--;
                index[13] = 8;
                break;
              }

              score2++;
              score1--;
              index[3] = 8;
            }
            break;
          }
        case 9:
          {
            if (index[4] != 9) {
              if (index[19] != 9) {
                score2++;
                score1--;
                index[19] = 9;
                break;
              } else if (index[9] != 9) {
                score2++;
                score1--;
                index[9] = 9;
                break;
              } else if (index[14] != 9) {
                score2++;
                score1--;
                index[14] = 9;
                break;
              }

              score2++;
              score1--;
              index[4] = 9;
            }
            break;
          }
      }
      print('score1 = $score1\n');
      print('score2 = $score2\n');
    });
  }
}