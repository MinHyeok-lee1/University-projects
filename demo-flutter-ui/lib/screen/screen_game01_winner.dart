// 1 vs 1 Faster Tap winnerOnly
import 'dart:math';
//import 'package:duobattle/screen/screen_home.dart';
import 'dart:ui' as ui;
import 'package:animated_text_kit/animated_text_kit.dart';
import 'package:flutter/material.dart';
import 'package:duobattle/model/timer_model.dart';

class FirstGameScreen extends StatefulWidget {
  @override
  _FirstGameScreenState createState() => _FirstGameScreenState();
}

class _FirstGameScreenState extends State<FirstGameScreen> {
  var colorOne = const Color(0xffff0000);
  var colorTwo = const Color(0xff0000ff);
  bool _visibility = false;
  bool _first = true;
  var winnerText = 'The Winner is ';
  var name = '';
  int winner = 0;
  var rnd = Random().nextInt(1) + 1;
  late MilliTimer timer = new MilliTimer();

  var scoreWinner = 0.0;

  @override
  void initState() {
    super.initState();
  }

  @override
  void dispose() {
    timer.reset();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    Size screenSize = MediaQuery.of(context).size;
    double width = screenSize.width;
    return SafeArea(
      child: Scaffold(
          body: mainBody(width)
      ),
    );
  }

  Widget mainBody(double width) {
    if(_first){
      _first = !_first;
      return FutureBuilder(
          future: Future.delayed(Duration(seconds: rnd)),
          builder: (context, snapshot) {
// Checks whether the future is resolved, ie the duration is over
            if (snapshot.connectionState == ConnectionState.done){
              timer.start();
              return bodyPart2(width);
            }
            else
              return bodyPart1(
                  width); // Return empty container to avoid build errors
          });
    }
    return bodyPart1(width);
  }

  Widget bodyPart1(double width) {
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
                      FadeAnimatedText('Ready for Touch..!'),
                      FadeAnimatedText('Ready for Touch...'),
                    ],
                  ),
                ),
              ),
            )
        ),
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
                    color: Colors.white,
                  ),
                ),
                Text(
                  '$scoreWinner초 ',
                  style: TextStyle(
                    fontSize: width * 0.04,
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
                  scoreWinner = timer.saveTime();
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
                  scoreWinner = timer.saveTime();
                  colorChange();
                },
              ),
            ),
          ],
        ),
      ],
    );
  }

  Widget childBody() {
    return Column(
      mainAxisSize: MainAxisSize.max,
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        Expanded(
          child: Container(
            color: Colors.redAccent,
          ),
        ),
        Expanded(
          child: Container(
            color: Colors.blueAccent,
          ),
        ),
      ],
    );
  }

  void reprint() {
    colorOne = const Color(0xffff0000);
    colorTwo = const Color(0xff0000ff);
    winner = 0;
    _visibility = false;
    _first = true;
    timer.reset();
    rnd = Random().nextInt(1) + 1;
    scoreWinner =0.0;
  }

  void colorChange() {
    _visibility = true;
    _first = false;
    //print(scoreRed);
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
