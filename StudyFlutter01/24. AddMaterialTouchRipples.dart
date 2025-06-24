import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    final appTitle = 'InkWell Demo';
    // MaterailApp 생성/반환
    return MaterialApp(
      title: appTitle,
      debugShowCheckedModeBanner: false,
      home: MyHomePage(title: appTitle)
    );
  }
}

class MyHomePage extends StatelessWidget{
  final String title;
  MyHomePage({Key? key, required this.title}): super(key: key);
  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(title: Text(title)),
      body: Center(child: MyButton()),
    );
  }
}

/*  InkWell 위젯
   Container와 같이 제스쳐기능을 제공하지 않는 위젯을 래핑하여 onTap 기능 제공
   InkWell 위젯을 탭하면 물결모양의 애니메이션 효과가 발생함
 */

class MyButton extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return InkWell(
      onTap: () {
        ScaffoldMessenger.of(context).showSnackBar(
            SnackBar(content: Text('Tap')));
      },
      child: Container(
        padding: EdgeInsets.all(12.0),
        child: Text('Flat Button'),
      ),
    );
  }
}
