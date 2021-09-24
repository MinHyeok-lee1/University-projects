// ManyTouch
import 'package:flutter/material.dart';

class FifthGameScreen extends StatefulWidget {
  @override
  _FifthGameScreenState createState() => _FifthGameScreenState();
}

class _FifthGameScreenState extends State<FifthGameScreen> {
  var colorOne = const Color(0xffff0000);
  var colorTwo = const Color(0xff0000ff);
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
                      color: Colors.white,
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
        print('player one win!');
      } else {
        colorOne = Colors.blue;
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