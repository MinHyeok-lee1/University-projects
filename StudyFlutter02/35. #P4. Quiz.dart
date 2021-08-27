import 'package:flutter/material.dart';

void main() => runApp(Quizzer());

class Quizzer extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return MaterialApp(
      debugShowCheckedModeBanner: false,
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


/*
List<String> questions = [
  '사과는 빨간색인가요?',
  '남극의 최초 발견자는 피어로인가요?',
  '나는 \'잘\' 생겼나요?',
];
List<bool> answer = [true, true, true];
bool correctAnswer = answer[questionNumber];
--> 클래스로 관리
*/
int _questionNumber = 0;

class Question{
  late String questionText;
  late bool questionAnswer;

  Question({required String q, required bool a}){
    questionText = q;
    questionAnswer = a;
  }
}

class QuizBrain{

  List<Question> _questionBank = [
    Question(q: '사과는 빨간색인가요?', a: true),
    Question(q: '남극의 최초 발견자는 피어로인가요?', a: false),
    Question(q: '나는 \'잘\' 생겼나요?', a: true),
    Question(q: 'Flutter 에서 클래스명의 첫 문자는 소문자이다?', a: false),
  ];

  String getQuestionText(int qNumber){
    return _questionBank[qNumber].questionText;
  }

  bool getQuestionAnswer(int qNumber){
    return _questionBank[qNumber].questionAnswer;
  }

  void nextQuestion(){
    if(_questionNumber < _questionBank.length - 1) _questionNumber++;
    else _questionNumber = 0;
  }
}

QuizBrain quizBrain = QuizBrain();

/*questionBank[questionNumber].questionText -> quizBrain.questionBank[questionNumber].questionText;
  questionBank[questionNumber].questionAnswer -> quizBrain.questionBank[questionNumber].questionAnswer;
  --> 함수로 관리     */


class _QuizPageState extends State<QuizPage>{
  List<Widget> scoreKeeper = [];
  void checkAnswer(bool userPickedAnswer){
    bool correctAnswer = quizBrain.getQuestionAnswer(_questionNumber);

    if(userPickedAnswer == correctAnswer) {
      print('정답');
      setState(() {
        scoreKeeper.add(
          Icon(
            Icons.check,
            color: Colors.green,
          ),
        );
      });
    }
    else {
      print('오답');
      setState(() {
        scoreKeeper.add(
          Icon(
            Icons.close,
            color: Colors.red,
          ),
        );
      });
    }

    setState((){
      quizBrain.nextQuestion();
    });
  }

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
                quizBrain.getQuestionText(_questionNumber),
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
                checkAnswer(true);
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
                checkAnswer(false);
              },
            ),
          ),
        ),
        Row(
          children: scoreKeeper,
        )
      ],
    );
  }
}
