import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      title: 'Returning Data',
      debugShowCheckedModeBanner: false,
      home: HomeScreen(), // HomeScreen을 홈으로 설정
    ),
  );
}

// 앱 실행시 처음 출력되는 스크린
class HomeScreen extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Returning Data Demo'),
      ),
      body: Center(
        child: SelectionButton(),
      ),
    );
  }
}

// 앱의 초기 스크린의 body를 구성하는 위젯 클래스
class SelectionButton extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return ElevatedButton(  // 버튼을 하나 추가
      onPressed: (){  // 버튼을 누르면
      _navigatedAndDisplaySelection(context); // 메소드 호출
    },
        child: Text('Pick an option, any option!'), // 버튼에 텍스트 추가
    );
  }

  // 버튼을 누를 때 호출되는 async 메소드. async 메소드는 구현코드가 모드 실행될 때까지 반환되지 않음
  void _navigatedAndDisplaySelection(BuildContext context) async{

  /*
      새로운 스크린을 push하고 그 스크린으로부터 결과값을 받아 result로 저장
      await 설정하면 result값을 수신할 때까지 대기
     */

    final result = await Navigator.push(
      context,
      MaterialPageRoute(builder: (context)=>SelectionScreen())  // 새로운 스크린(라우트)를 적재함
    );

    // 현재 Scaffold 스크린의 컨텍스트를 추출해서
    ScaffoldMessenger.of(context)
      ..removeCurrentSnackBar() // 현재 스낵바를 제거하고
      ..showSnackBar(SnackBar(content: Text('$result'))); // 새로운 스낵바를 생성하여 결과값을 출력
  }
}

// 초기 스크린에서 ElevaletedButton을 누룰때 생성되는 두번째 스크린
class SelectionScreen extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(title: Text('Pick an option')),
      //가운데 정렬로 컬럼 정렬
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Padding(  // 첫번째 자식
              padding: const EdgeInsets.all(8.0),
            child: ElevatedButton(  // 버튼 추가
              onPressed: (){ // 버튼을 누르면
                Navigator.pop(context,'Yep!'); // 현재 스크린을 제거하고, 결과값 Yep!을 반환
              },
              child: Text('Yep!'),
            ),),
            Padding(  // 두번째 자식
                padding: const EdgeInsets.all(8.0),
              child: ElevatedButton(
                onPressed: (){
                  Navigator.pop(context,'Nope.');
                },
                child: Text('Nope.'),
              ),
            )


          ],
        ),
      ),
    );
  }
}