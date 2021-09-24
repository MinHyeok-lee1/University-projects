import 'package:flutter/material.dart';
import 'package:module/screen/screen_game01.dart';
import 'package:module/screen/screen_game02.dart';
import 'package:module/screen/screen_game03.dart';
import 'package:module/screen/screen_game04.dart';
import 'package:module/screen/screen_game05.dart';

class HomeScreen extends StatefulWidget {
  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  @override
  Widget build(BuildContext context) {
    Size screenSize = MediaQuery.of(context).size;
    double width = screenSize.width;
    double height = screenSize.height;
    var blue = const Color(0xff0000ff);
    var red = const Color(0xffff0000);

    return WillPopScope(
      onWillPop: () async => false,
      child: SafeArea(
        child: Scaffold(
          appBar: AppBar(
            title: Center(child: Text('Duo Battle')),
            flexibleSpace: Container(
              decoration: BoxDecoration(
                gradient: LinearGradient(
                  colors: [
                    blue,
                    red,
                  ],
                  begin: Alignment.centerLeft,
                  end: Alignment.centerRight,
                ),
              ),
            ),
          ),
          body: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Center(
                  child: Image.asset(
                    'images/title.jpg',
                    width: width * 0.8,
                  )),
              Padding(
                padding: EdgeInsets.all(width * 0.024),
              ),
              gradientText('Duo Battle', width),
              Text(
                'You can play the game with two people on one smartphone.',
                textAlign: TextAlign.center,
              ),
              Padding(
                padding: EdgeInsets.all(width * 0.048),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: <Widget>[
                  _buildStep(width, '1. Test Speed Game'),
                  _gradient(width, height, FirstGameScreen()),
                ],
              ),
              Padding(
                padding: EdgeInsets.all(width * 0.024),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: <Widget>[
                  _buildStep(width, '2. Try Faster than rival1'),
                  _gradient(width, height, SecondGameScreen()),
                ],
              ),
              Padding(
                padding: EdgeInsets.all(width * 0.024),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: <Widget>[
                  _buildStep(width, '3. Try Faster than rival2'),
                  _gradient(width, height, ThirdGameScreen()),
                ],
              ),
              Padding(
                padding: EdgeInsets.all(width * 0.024),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: <Widget>[
                  _buildStep(width, '4. Try Faster than rival3'),
                  _gradient(width, height, FourthGameScreen()),
                ],
              ),
              Padding(
                padding: EdgeInsets.all(width * 0.024),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: <Widget>[
                  _buildStep(width, '5. Try Faster than rival4'),
                  _gradient(width, height, FifthGameScreen()),
                ],
              ),
              Padding(
                padding: EdgeInsets.all(width * 0.024),
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

  Widget _gradient(double width, double height, Widget widget) {
    return Container(
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(80),
        gradient: LinearGradient(
          colors: [
            const Color(0xff0000ff),
            const Color(0xffff0000),
          ],
          begin: Alignment.centerLeft,
          end: Alignment.centerRight,
        ),
      ),
      child: Center(
        child: MaterialButton(
          materialTapTargetSize: MaterialTapTargetSize.shrinkWrap,
          minWidth: width * 0.4,
          height: height * 0.004,
          shape: StadiumBorder(),
          child: Padding(
            padding: EdgeInsets.all(width * 0.015),
            child: Row(
              children: <Widget>[
                Text(
                  'Battle Start   ',
                  style: TextStyle(color: Colors.white),
                ),
                Icon(
                  Icons.arrow_forward,
                  color: Colors.white,
                )
              ],
            ),
          ),
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => widget,
              ),
            );
          },
        ),
      ),
    );
  }

  Widget gradientText(String text, double width) {
    final Shader linearGradientShader = LinearGradient(
      colors: [
        const Color(0xff0000ff),
        const Color(0xffff0000),
      ],
      begin: Alignment.centerLeft,
      end: Alignment.centerRight,
    ).createShader(Rect.fromLTWH(150.0, 20.0, 150.0, 20.0));
    return Text(text,
        style: TextStyle(
            fontSize: width * 0.065,
            fontWeight: FontWeight.bold,
            foreground: Paint()..shader = linearGradientShader));
  }
}
