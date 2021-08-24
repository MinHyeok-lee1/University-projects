import 'package:flutter/material.dart';

void main() => runApp(Quizzer());

class Quizzer extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return MaterialApp(
      title: 'Quiz Demo',
      home: Scaffold(
        appBar: AppBar(
          title: Text('Quiz Demo'),
          backgroundColor: Colors.pinkAccent,
        ),
        backgroundColor: Colors.grey.shade900,
        body: SafeArea(
          child: Padding(
            padding: EdgeInsets.symmetric(horizontal: 10.0),
            child: QuizPage(),
          ),
        ),
      ),
    );
  }
}

class QuizPage extends StatefulWidget{
  @override
  _QuizPageState createState() => _QuizPageState();
}

List<Widget> scoreKeeper = [];
List<String> questions = [
  '사과는 빨간색인가요?',
  '남극의 최초 발견자는 피어로인가요?',
  '나는 \'잘\' 생겼나요?',
];
List<bool> answer = [true, true, true];
int questionNumber = 0;
bool correctAnswer = answer[questionNumber];

class _QuizPageState extends State<QuizPage>{
  @override
  Widget build(BuildContext context){
    return Column(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: <Widget>[
        Expanded(
          flex: 5,
          child: Padding(
            padding: EdgeInsets.all(10.0),
            child: Center(
              child: Text(
                questions[questionNumber],
                textAlign: TextAlign.center,
                style: TextStyle(
                  fontSize: 25.0,
                  color: Colors.white,
                ),
              ),
            ),
          ),
        ),
        Expanded(
          child: Padding(
            padding: EdgeInsets.all(15.0),
            child: TextButton(
              style: TextButton.styleFrom(
                backgroundColor: Colors.green,
              ),
              child: Text(
                '맞음',
                style: TextStyle(
                  color: Colors.white,
                  fontSize: 20.0,
                ),
              ),
              onPressed: (){
                questionNumber++;
                if(correctAnswer) print('정답');
                else print('오답');
                // The user picked true.
                setState(() {
                  scoreKeeper.add(
                    Icon(
                      Icons.check,
                      color: Colors.green,
                    ),
                  );
                });
              },
            ),
          ),
        ),
        Expanded(
          child: Padding(
            padding: EdgeInsets.all(15.0),
            child: TextButton(
              style: TextButton.styleFrom(
                backgroundColor: Colors.red,
                //primary: Colors.redAccent,
              ),
              child: Text(
                '틀림',
                style: TextStyle(
                  color: Colors.white,
                  fontSize: 20.0,
                ),
              ),
              onPressed: (){
                questionNumber++;
                if(!correctAnswer) print('정답');
                else print('오답');
                // The user picked true.
                setState(() {
                  scoreKeeper.add(
                    Icon(
                      Icons.close,
                      color: Colors.red,
                    ),
                  );
                });
              },
            ),
          ),
        ),
        Row(
          children: scoreKeeper,
        )
        // TODO: 스코어 발생 처리
      ],
    );
  }
}
