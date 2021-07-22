import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    final appTitle = 'Form Validation Demo';

    // MaterailApp 생성/반환
    return MaterialApp(
      title: appTitle,
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(title: Text(appTitle)),
        // StatefulWidget인 MyCustom을 body로 설정
      body: MyCustomForm(),
      ),
    );
  }
}

// 커스텀 폼 위젯을 정의
class MyCustomForm extends StatefulWidget{
  @override
  MyCustomFormState createState(){
    return MyCustomFormState();
  }
}

// 폼 위젯에 상응하는 상태 클래스
class MyCustomFormState extends State<MyCustomForm>{
  // 폼에 부여할 수 있는 유니크한 글로벌 키를 생성한다.
  // MyCustomFormState의 키가 아닌 FormState의 키를 생성해야함을 유의
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context){
    // 폼 위젯 생성
    // 폼 위젯은 컨테이너처럼 동작하면서, 복수의 폼 필드를 그룹화하고 적합성을 확인함
    return Form(
      // 필드에 부여했던 글로벌키를 폼에 할당함
      key: _formKey,
      child: Column(
        // 컬럼내 위젯들을 왼쪽부터 정렬함
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          // 텍스트폼필드 추가
          TextFormField(
            // 텍스트폼필드에 validator 추가
            validator: (value){
              // 입력값이 없으면 메시지 출력
              if(value == null || value.isEmpty) {
                return 'Enter some text!';
              }else return null;
            },

            // 텍스트폼필드에 스타일 적용
            decoration: InputDecoration(
              // 텍스트필드의 외각선
              border: InputBorder.none,
              // 텍스트필드상에 출력되는 텍스트, 실제 값이 되진 않음
              hintText: 'Enter a search term',
              // 텍스트필드의 상단에 출력되는 레이블 텍스트
              labelText: "Enter your username"
            ),

          ),
          Padding(
            padding: const EdgeInsets.symmetric(vertical: 16.0),
            child: ElevatedButton(
              onPressed: () {
                // 텍스트폼필드의 상태가 적합한
                if(_formKey.currentState!.validate()){
                  // 스낵바를 통해 메시지 출력
                  ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text('Processing Data')));
                }
              },
              // 버튼에 텍스트 부여
              child: Text('Submit'),
            ),
          )
        ],
      ),
    );
  }
}