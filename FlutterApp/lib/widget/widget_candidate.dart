import 'package:flutter/material.dart';

class CandWidget extends StatefulWidget{
  late VoidCallback tap;
  late String text;
  late int index;
  late double width;
  late bool answerState;

  CandWidget({required this.index, required this.text, required this.width, required this.answerState, required this.tap});
  _CandWidgetState createState() => _CandWidgetState();

}

class _CandWidgetState extends State<CandWidget>{
  @override
  Widget build(BuildContext context){
    return Container(
      width: widget.width * 0.8,
      height: widget.width * 0.1,
      padding: EdgeInsets.fromLTRB(
          widget.width * 0.048,
          widget.width * 0.024,
          widget.width * 0.048,
          widget.width * 0.024
      ),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(20),
        border: Border.all(color: Colors.deepPurple),
        color: widget.answerState ? Colors.deepPurple : Colors.white,
      ),
      child: InkWell(
        child: Text(
          widget.text,
          style: TextStyle(
            fontSize: widget.width * 0.035,
            color: widget.answerState ? Colors.white : Colors.black,
          ),
        ),
        onTap: (){
          setState(() {
            widget.tap();
            widget.answerState = !widget.answerState;
          });
        },
      ),
    );
  }
}