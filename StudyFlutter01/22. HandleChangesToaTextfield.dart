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
  // TextEditingController를 생성하여 필드에 할당
  final myController = TextEditingController();

  // _MyCustomFormState가 생성될 때 호출
  @override
  void initState(){
    super.initState();
    // myController에 리스너 추가
    myController.addListener(_printLatestValue);
  }

  // _MyCustomFormState가 소멸될 때 호출
  @override
  void dispose(){
    // TextEditingController를 제거하고, 등록된 리스너도 제거
    myController.dispose();
    super.dispose();
  }

  // myController의 텍스트를 콘솔에 출력하는 메소드
  void _printLatestValue(){
    print("Second text filed: ${myController.text}");
  }

  /*
      텍스트필드의 값의 변화를 핸들링 하는 방법
       1. 텍스트필드에 onChange 항목 구현
       2. TextEditingController 인스턴스에 핸들링하는 함수를 리스너로 추가
   */

  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(title: Text('Retrieve Text Input')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: <Widget>[
            // 첫 번째 텍스트필드, 텍스트필드에 onChange함수를 구현하여 핸들링
          TextField(
            // 텍스트필드의 입력된 텍스트의 변화가 발생할 때마다 호출
            onChanged: (text){
              // 현재 텍스트필드의 텍스트를 출력
              print("First text field: ${text}");
              },
            ),

            // 두 번째 텍스트필드, 텍스트필드에 controller를 등록하여 리스너를 통한 핸들링
            TextField(
              //컨트롤러에 필드 myController를 부여
              controller: myController,
            )
          ],
        ),
      ),
    );
  }
}
