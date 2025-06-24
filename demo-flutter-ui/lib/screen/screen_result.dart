import 'package:flutter/material.dart';
import 'package:untitled/model/model_quiz.dart';
import 'package:untitled/screen/screen_home.dart';

class ResultScreen extends StatefulWidget {
  List<int> answers;
  List<Quiz> quizs;

  ResultScreen({required this.answers, required this.quizs});

  @override
  _ResultScreenState createState() => _ResultScreenState();
}

class _ResultScreenState extends State<ResultScreen> {
  @override
  Widget build(BuildContext context) {
    Size screenSize = MediaQuery
        .of(context)
        .size;
    double width = screenSize.width;
    double height = screenSize.height;

    int score = 0;
    for (int i = 0; i < widget.quizs.length; i++) {
      if (widget.quizs[i].answer == widget.answers[i]) {
        score += 1;
      }
    }

    return WillPopScope(
        onWillPop: () async => false,
        child: SafeArea(
          child: Scaffold(
            appBar: AppBar(
              title: Text('Layout Demo'),
              centerTitle: true,
              elevation: 0.0,
              backgroundColor: Colors.teal,
              leading: Container(),
            ),
            body: Center(
              child: Container(
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(20),
                  border: Border.all(color: Colors.teal),
                  color: Colors.teal,
                ),
                width: width * 0.85,
                height: height * 0.5,
                child: Column(
                  children: <Widget>[
                    Padding(
                      padding: EdgeInsets.only(bottom: width * 0.048),
                    ),
                    Container(
                      decoration: BoxDecoration(
                        borderRadius: BorderRadius.circular(20),
                        border: Border.all(color: Colors.teal),
                        color: Colors.white,
                      ),
                      width: width * 0.73,
                      height: height * 0.3,
                      child: Column(
                        children: <Widget>[
                          Container(
                            padding: EdgeInsets.fromLTRB(
                                0, width * 0.048, 0, width * 0.012),
                            child: Text(
                              '끝났습니다!',
                              style: TextStyle(
                                fontSize: width * 0.055,
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                          ),
                          Text('당신의 점수는',
                            style: TextStyle(
                              fontSize: width * 0.048,
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                          Expanded(
                            child: Container(),
                          ),
                          Text(
                            score.toString() + '/' + widget.quizs.length.toString(),
                            style: TextStyle(
                              fontSize: width * 0.21,
                              fontWeight: FontWeight.bold,
                              color: Colors.red,
                            ),
                          ),
                          Padding(
                            padding: EdgeInsets.all(width * 0.012),
                          ),
                        ],
                      ),
                    ),
                    Expanded(
                      child: Container(),
                    ),
                    Container(
                      padding: EdgeInsets.only(bottom: width * 0.048),
                      child: ElevatedButton(
                          child: Text('홈으로 돌아가기'),
                          style: ElevatedButton.styleFrom(
                            primary: Colors.white,
                            onPrimary: Colors.black,
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(10),
                            ),
                            minimumSize: Size(width * 0.5, height * 0.05),
                          ),
                          onPressed: () {
                            Navigator.push(context,
                              MaterialPageRoute(builder: (context) {
                                return HomeScreen();
                              }),
                            );
                          }
                      ),
                    )
                  ],
                ),
              ),
            ),
          ),
        ),
    );
  }
}