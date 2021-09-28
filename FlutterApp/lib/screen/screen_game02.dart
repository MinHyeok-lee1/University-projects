// ManyTouch
import 'package:flutter/material.dart';

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

  var winnerText = 'The Winner is ';
  var name = '';
  int winner = 0;
  int baseline = 10;
  var score1 = 10;
  var score2 = 10;
  var start_flag = 2;

  @override
  Widget build(BuildContext context) {
    Size screenSize = MediaQuery
        .of(context)
        .size;
    double width = screenSize.width;

    if(baseline == 21) {
      name = 'Red';
      _visibility = true;
    }
    else if(baseline == -1) {
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
                Flexible(
                  flex: 1,
                  child: Container(color: book[index[10]]),
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
    winner = 0;
    baseline = 10;
    _visibility = false;
    start_flag = 2;
  }

  void colorChange(int num) {
    // timer로 _visibiility 조정
    // _visibility = true;

    setState(() {
      switch (num) {
        case 0:
          {
            if(baseline < 21){
              if(start_flag == 0) {
                ++baseline;
              }
              start_flag = 1;
              ++baseline;
            }
            for(int i = 0; i < baseline; i++){
              index[i] = 0;
            }
            for(int i = 20; i > baseline; i--){
              index[i] = 1;
            }
            break;
          }
        case 1:
          {
            if(baseline > -1){
              if(start_flag == 1) {
                --baseline;
              }
              start_flag = 0;
              --baseline;
            }
            for(int i = 0; i < baseline; i++){
              index[i] = 0;
            }
            for(int i = 20; i > baseline; i--){
              index[i] = 1;
            }
            break;
          }
      }
      print('start_flag = $start_flag\n');
    });
  }

// 시간 초과되면 colorchange해주자.
  void timeOut(){
    if(score1 > score2) print('Winner: Player Red');
    else if(score2 > score1) print('Winner: Player Blue');
    else print('draw');
  }
}