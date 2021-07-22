import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    final appTitle = 'Text Field Focus';
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
  // 포커스노드 선언
  late FocusNode myFocusNode;

  // 폼이 생성될 때 호출
  @override
  void initState(){
    super.initState();
    // myFocusNode에 포커스 인스턴스 저장
    myFocusNode = FocusNode();
  }

  // 폼이 소멸될 때 호출
  @override
  void dispose(){
    // 폼이 삭제되면 myFocusNode도 삭제됨
    myFocusNode.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(title: Text('Text Field Focus')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: <Widget>[
            // 첫 번째 텍스트필드
          TextField(
            // autofocus를 true로 설정하여 앱이 실해오디면서 자동으로 포커스를 가진다.
            autofocus: true,
            ),

            // 두 번째 텍스트필드
            TextField(
              //focusNode에 myFocusNode를 설정
              focusNode: myFocusNode,
            )
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        // 버튼이 눌리면 myFocusNode를 설정하고 있는 두 번째 텍스트필드에 포커스 전달
        onPressed: () => FocusScope.of(context).requestFocus(myFocusNode),
        tooltip: 'Focus Second Text Field',
        child: Icon(Icons.edit),
      ),
    );
  }
}