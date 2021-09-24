// 5 vs 5 Tab1 5x2
import 'package:flutter/material.dart';

class SecondGameScreen extends StatefulWidget {
  @override
  _SecondGameScreenState createState() => _SecondGameScreenState();
}

class _SecondGameScreenState extends State<SecondGameScreen> {
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
    0,1,2,3,4,5,6,7,8,9
  ];
  bool _visibility = false;
  var winnerText = 'The Winner is ';
  var name = '';
  int winner = 0;

  var score1 = 0;
  var score2 = 0;


  @override
  Widget build(BuildContext context) {
    Size screenSize = MediaQuery
        .of(context)
        .size;
    double width = screenSize.width;

    if(score1 == 5) {
      name = 'Red';
      _visibility = true;
    }
    else if(score2 == 5) {
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
                Container(height: 0.01, width: 500, color: Colors.white),
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
        ),
      ),
    );
  }

  void reprint() {
    index = [
      0,1,2,3,4,5,6,7,8,9
    ];
    score1 = 0;
    score2 = 0;
    winner = 0;
    _visibility = false;
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
            }

            index[0] = 0;
            index[5] = 0;

            score1++;
            score2--;
          }
          break;
        }
        case 1:{
          if(index[6] != 1) {
            if(index[1] != 1) {
              score1++;
              score2--;
            }

            index[1] = 1;
            index[6] = 1;

            score1++;
            score2--;
          }
          break;
        }
        case 2:{
          if(index[7] != 2) {
            if(index[2] != 2) {
              score1++;
              score2--;
            }

            index[2] = 2;
            index[7] = 2;

            score1++;
            score2--;
          }
          break;
        }
        case 3:{
          if(index[8] != 3) {
            if(index[3] != 3) {
              score1++;
              score2--;
            }

            index[3] = 3;
            index[8] = 3;

            score1++;
            score2--;
          }
          break;
        }
        case 4:{
          if(index[9] != 4) {
            if(index[4] != 4) {
              score1++;
              score2--;
            }

            index[4] = 4;
            index[9] = 4;

            score1++;
            score2--;
          }
          break;
        }

        case 5:{
          if(index[0] != 5) {
            if(index[5] != 5) {
              score2++;
              score1--;
            }

            index[5] = 5;
            index[0] = 5;

            score1--;
            score2++;
          }
          break;
        }
        case 6:{
          if(index[1] != 6) {
            if(index[6] != 6) {
              score2++;
              score1--;
            }

            index[6] = 6;
            index[1] = 6;

            score1--;
            score2++;
          }
          break;
        }
        case 7:{
          if(index[2] != 7) {
            if(index[7] != 7) {
              score2++;
              score1--;
            }

            index[7] = 7;
            index[2] = 7;

            score1--;
            score2++;
          }
          break;
        }
        case 8:{
          if(index[3] != 8) {
            if(index[8] != 8) {
              score2++;
              score1--;
            }

            index[8] = 8;
            index[3] = 8;

            score1--;
            score2++;
          }
          break;
        }
        case 9:{
          if(index[4] != 9) {
            if(index[9] != 9) {
              score2++;
              score1--;
            }

            index[9] = 9;
            index[4] = 9;

            score1--;
            score2++;
          }
          break;
        }
      }
    });
  }
}