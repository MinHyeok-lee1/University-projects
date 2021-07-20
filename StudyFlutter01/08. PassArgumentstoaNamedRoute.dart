import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Navigation with arguments',
      home: HomeScreen(),

      //라우트 설정
      // ExtractArgumentsScreen 라우트만 등록
      routes: {
        // '/extractArguments': (context)=>ExtractArgumentsScreen() 을 의미
        ExtractArgumentsScreen.routeName:(context)=>ExtractArgumentsScreen()
      },

    /*
    onGenerateRoute: 앱이 이름이 부여된 라우트를 네비게이팅할 때 호출됨. RouteSettings 가 전달됨
    RouteSettings: 다음과 같은 구조를 가짐
    const RouteSettings({
    String name,  // 라우터 이름
    bool isInitialRoute: false, // 초기 라우터인지 여부
    Object arguments })  // 파라미터
    */

    // routes 테이블에 PassArgumentsScreen이 등록되지 않았지만 onGenerateRoute 함수로 호출
    onGenerateRoute: (routeSettings){ // Navigator.pushNamed()가 호출될 때 실행
      // 라우트 이름이 PassArgumentScreen의 routeName과 같은 라우트가 생성될 수 있도록 함
      if(routeSettings.name == PassArgumentsScreen.routeName){
        // 라우트세팅에서 파라미터 추출
        final args = routeSettings.arguments as ScreenArguments;

        return MaterialPageRoute(
            builder: (context){
          // 추출한 파라미터를 PassArgumentScreen의 아규먼트로 직접 전달하면서 라우트 생성 후 반환
          return PassArgumentsScreen(
             title: args.title,
             message: args.message,
          );
        });
       }

      assert(false, 'Need to implement ${routeSettings.name}');
      return null;
      },
    );
  }
}

class HomeScreen extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Home Screen'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center, // 자식들 중앙정렬
          children: <Widget>[
            // 첫 번째 자식, 파라미터를 명시적으로 전달하는 방식으로 라우트 호출
            ElevatedButton(
              child: Text('Navigate to screen that extracts arguments'),
              onPressed:(){
                Navigator.pushNamed(
                    context,
                    ExtractArgumentsScreen.routeName,
                    arguments: ScreenArguments(
                        'Extract Arguments Screen',
                        'This message is extracted in the build method.'
                    )
                );
              },
            ),

            // 두 번째 자식
            ElevatedButton(
              child: Text('Navigate to a named that accepts arguments'),
              onPressed:(){
                Navigator.pushNamed( // (context, routeName, arguments)
                    context,
                    PassArgumentsScreen.routeName,
                    arguments: ScreenArguments(
                        'Accept Arguments Screen',
                        'This message is extracted in the onGenerateRoute function.'
                    )
                );
              },
            )
          ],
        ),
      ),
    );
  }
}

// 넘겨받은 context에서 아규먼트를 추출하여 라우트를 동적 구성하는 클래스
class ExtractArgumentsScreen extends StatelessWidget{
  // 라우트 이름 설정
  static const routeName = '/extractArguments';
  @override
  Widget build(BuildContext context) {
    // context로부터 settings.arguments 값을 추출하여 arg로 저장
    final args = ModalRoute.of(context)!.settings.arguments as ScreenArguments;

    // 추출한 아규먼트로 Scaffold를 구성하여 반환
    return Scaffold(
      appBar: AppBar(
        title: Text(args.title),
      ),
      body: Center(
        child: Text(args.message),
      ),
    );
  }
}

// 전달받은 아규먼트를 이용하여 라우트를 동적 구성하는 클래스
class PassArgumentsScreen extends StatelessWidget{
  // 라우트 이름 설정
  static const routeName = '/passArguments';

  final String title; // 라우트의 타이틀로 활용
  final String message; // 라우트의 바디로 활용

  // 생성자, 라우트 생성 시 전달한 파라미터를 아규먼트로 넘겨받아 필드에 저장
  const PassArgumentsScreen({
    Key? key,
    required this.title,
    required this.message
  }):super(key:key);

  @override
  Widget build(BuildContext context) {
    // 추출한 아규먼트로 Scaffold를 구성하여 반환
    return Scaffold(
      appBar: AppBar(
        title: Text(title),
      ),
      body: Center(
        child: Text(message),
      ),
    );
  }
}

// 라우트 생성시 전달할 아규먼트 클래스
class ScreenArguments{
  // 아규먼트의 타이틀과 메시지, 생성자에 의해서만 초기화되고 변경
  final String title;
  final String message;
  // 생성자
  ScreenArguments(this.title, this.message);
}