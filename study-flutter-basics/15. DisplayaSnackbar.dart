import 'package:flutter/material.dart';

void main() => runApp(SnackBarDemo());

class SnackBarDemo extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    // MaterailApp 생성/반환
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Snackbar Demo',
      // 홈으로 Scaffold를 직접 구현
      home: Scaffold(
        appBar: AppBar(title: Text('SnackBar Demo')),
        // SnackBarPage 클래스 호출
        body: SnackBarPage(),
      ),
    );
  }
}

// 초기 스크린의 body를 구성
class SnackBarPage extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return Center(
      // 화면 중앙에 버튼 추가
      child: ElevatedButton(
        child: Text('Show SnackBar'),
        // ElevatedButton 누르면 호출
        onPressed: (){
          // 스낵바 생성
          final snackbar = SnackBar(
            // 컨텐트 구성, 텍스트 삽입
            content: Text('Yay! It\'s a SnackBar!'),
            // 스낵바 액션
            action: SnackBarAction(
              // 스낵바에 label 추가
              label: 'Undo',
              // 스낵바에 label 누를 때 호출
              onPressed: (){
                // Some code to undo the change.
              },
            ),
          );
          // 생성한 스낵바를 노출, 화면 하단에 스낵바가 출력됨
          ScaffoldMessenger.of(context).showSnackBar(snackbar);
        },
      ),
    );
  }
}