import 'package:flutter/material.dart';

void main() => runApp(
    // SnackBarFail()
    // SnackBarDemo()
    // SnackBarDemo2()
       SnackBarDemo3()
);

class SnackBarFail extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    // MaterailApp 생성/반환
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Snackbar DemoF',
      // 홈으로 Scaffold를 직접 구현
      home: Scaffold(
        appBar: AppBar(title: Text('SnackBar DemoF')),
        // SnackBarPage 클래스 호출
        body:Center(
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
        ),
      ),
    );
  }
}

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

class SnackBarDemo2 extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    // MaterailApp 생성/반환
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Snackbar Demo2',
      // 홈으로 Scaffold를 직접 구현
      home: Scaffold(
        appBar: AppBar(title: Text('SnackBar Demo2')),
        // SnackBarPage 클래스 호출
        body: Builder(builder: (BuildContext context)
         => Center(
           child: ElevatedButton(
           child: Text('Show SnackBar'),
           onPressed: (){
             // 생성한 스낵바를 노출, 화면 하단에 스낵바가 출력됨
             ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text("Snack Test")));
             },
            ),
          ),
        )
      ),
    );
  }
}

// Scaffold의 key값을 이용하여 참조하는 방법
class SnackBarDemo3 extends StatelessWidget{
  // Scaffold용 글로벌 키를 발급 받음
  final scaffoldKey = GlobalKey<ScaffoldState>();

  @override
  Widget build(BuildContext context){
    // MaterailApp 생성/반환
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Snackbar Demo3',
      // 홈으로 Scaffold를 직접 구현
      home: Scaffold(
        key: scaffoldKey, // 발급한 키를 Scaffold에 등록
          appBar: AppBar(title: Text('SnackBar Demo3')),
          // SnackBarPage 클래스 호출
          body: Center(
            child: Column(
              children: <Widget>[
                 ElevatedButton(
                  child: Text('Show SnackBar1'),
                  onPressed: (){
//            스낵바 출력 시도 - 에러 발생
//            Scaffold.of(context)
//            .showSnackBar(SnackBar(content: Text("Snack Test")));


                // 키를 통해 Scaffold를 참조하여 스낵바 출력
                   scaffoldKey.currentState!
                       .showSnackBar(SnackBar(content: Text("Snack Test 1")));
                  },
                ),
                ElevatedButton(
                  child: Text('Show SnackBar2'),
                  onPressed: (){
                    //showSnackbarWithKey메소드 접근
                    showSnackbarWithKey();
                  },
                ),
                ElevatedButton(
                  child: Text('Show SnackBar3'),
                  onPressed: (){
                    // SnackbarManager클래스 showSnackBar메소드 접근
                    SnackbarManager.showSnackBar(scaffoldKey, "Snack Test 3");
                  },
                ),
              ],
            ),
          ),
        ),
      );
    }

    showSnackbarWithKey(){
      // 키를 통해 Scaffold에 접근하여 스낵바 출력
      scaffoldKey.currentState!
          .showSnackBar(SnackBar(content: Text("SnackBarTest2")));
    }
}

class SnackbarManager{
  static void showSnackBar(
      GlobalKey<ScaffoldState> scaffoldKey, String message){
    scaffoldKey.currentState!.showSnackBar(SnackBar(content: Text(message)));
  }//
}