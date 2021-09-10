import 'package:flutter/material.dart';
import 'package:untitled/model/model_quiz.dart';
import 'package:untitled/screen/screen_quiz.dart';

class HomeScreen extends StatefulWidget {
  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  List<Quiz> quizs = [
    Quiz.fromMap({
      'title': 'test',
      'candidates': ['a', 'b', 'c', 'd'],
      'answer': 0
    }),
    Quiz.fromMap({
      'title': 'test',
      'candidates': ['a', 'b', 'c', 'd'],
      'answer': 0
    }),
    Quiz.fromMap({
      'title': 'test',
      'candidates': ['a', 'b', 'c', 'd'],
      'answer': 0
    }),
  ];

  @override
  Widget build(BuildContext context) {
    Size screenSize = MediaQuery.of(context).size;
    double width = screenSize.width;
    double height = screenSize.height;

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
          body: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Center(
                  child: Image.asset(
                'images/lake.jpg',
                width: width * 0.8,
              )),
              Padding(
                padding: EdgeInsets.all(width * 0.024),
              ),
              Text(
                'Home Title',
                style: TextStyle(
                  fontSize: width * 0.065,
                  fontWeight: FontWeight.bold,
                ),
              ),
              Text(
                'Explain This Application.\n What is this App?',
                textAlign: TextAlign.center,
              ),
              Padding(
                padding: EdgeInsets.all(width * 0.048),
              ),
              _buildStep(width, '1. First Your Action'),
              _buildStep(width, '2. Second Your Action'),
              _buildStep(width, '3. Third Your Action'),
              Padding(
                padding: EdgeInsets.all(width * 0.048),
              ),
              Container(
                padding: EdgeInsets.only(bottom: width * 0.036),
                child: Center(
                  child: ElevatedButton(
                    child: Text('Do it Something!'),
                    style: ElevatedButton.styleFrom(
                      primary: Colors.teal,
                      onPrimary: Colors.white,
                      padding:
                          EdgeInsets.symmetric(horizontal: 50, vertical: 20),
                      minimumSize: Size(width * 0.8, height * 0.05),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10),
                      ),
                    ),
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (context) => QuizScreen(
                            quizs: quizs,
                          ),
                        ),
                      );
                    },
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildStep(double width, String title) {
    return Container(
      padding: EdgeInsets.fromLTRB(
          width * 0.048, width * 0.024, width * 0.048, width * 0.024),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          Icon(
            Icons.check_box,
            size: width * 0.04,
          ),
          Padding(
            padding: EdgeInsets.only(right: width * 0.024),
          ),
          Text(title),
        ],
      ),
    );
  }
}
