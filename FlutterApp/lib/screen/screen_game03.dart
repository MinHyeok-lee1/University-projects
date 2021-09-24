// 5 vs 5 Tab2 5x2
import 'package:flutter/material.dart';

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
  int winner = 0;

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
              child: Center(
                child: Row(
                  children: <Widget>[
                    IconButton(
                      color: Colors.white,
                      onPressed: () {
                        setState(() {
                        });
                      },
                      icon: const Icon(
                        Icons.arrow_back_sharp,
                      ),
                    ),
                    IconButton(
                      color: Colors.white,
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
}