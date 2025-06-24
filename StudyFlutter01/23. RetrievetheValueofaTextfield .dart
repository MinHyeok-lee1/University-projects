import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    final appTitle = 'Retrive Text Input';
    // MaterailApp 생성/반환
    return MaterialApp(
      title: appTitle,
      debugShowCheckedModeBanner: false,
      home: MyCustomForm(),
    );
  }
}

// 커스텀 폼 위젯을 정의
class MyCustomForm extends StatefulWidget{
  @override
  _MyCustomFormState createState() => _MyCustomFormState();
}

class _MyCustomFormState extends State<MyCustomForm>{
  // TextEditingController 인스턴스를 필드에 저장
  final myController = TextEditingController();

  // _MyCustomFormState가 소멸될 때 호출
  @override
  void dispose(){
    // TextEditingController를 제거하고, 등록된 리스너도 제거
    myController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(title: Text('Retrieve Text Input')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        // 텍스트필드의 controller 항목에 TextEditingController 인스턴스 연결
        child: TextField(
          controller: myController,
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          showDialog(
            context: context,
            builder: (context) {
              return AlertDialog(
                // myController의 현재 텍스트 값을 컨텐트로 AlertDialog 출력
                content: Text(myController.text),
              );
            });
        },
        tooltip: 'Show me the value.',
        child: Icon(Icons.text_fields),
      ));
  }
}