import 'package:flutter/material.dart';
import 'dart:async'; // async/await 를 이용하기 위한 라이브러리나 선언하지 않아도 이용가능
import 'dart:convert'; // json 데이터 변환용 라이브러리
import 'package:http/http.dart' as http; // Http 프로토콜을 이용하기 위한 패키지

// Futures: Dart의 핵심 클래스, async 동작을 가지는 작업 처리
// Future 객체는 일정 소요시간 이후에 값이나 에러를 반환
Future<Post> fetchPost() async{
  // 해당 URL의 데이터를 수신.
  // await 처리: 응답 메시지가 도착하거나 타임아웃이 발생할 때까지 대기
  final response =
      await http.get(Uri.parse('https://jsonplaceholder.typicode.com/albums/1'));

  // 응답의 상태코드가 200인 경우. 정상적으로 응답메시지를 수신한 경우
  if(response.statusCode == 200){
    // 수신 메시지의 body부분을 JSON 객체로 디코딩한 후 Post.fromJson 메소드를 통해 다시 파싱
    return Post.fromJson(jsonDecode(response.body));
  }
  // 서버로부터 정상응답을 받지 못한 경우. 어떤 에러가 발생한 경우
  else {
    // 에러 발생
    throw Exception('Failed to load post');
  }
}


class Post{
  final int userId;
  final int id;
  final String title;

  Post({
    required this.userId,
    required this.id,
    required this.title,
  });

  //factory 생성자. Post 타입의 인스턴스를 반환
  factory Post.fromJson(Map<String, dynamic> json){
    return Post(
        userId: json['userId'],
        id: json['id'],
        title: json['title'],
    );
  }
}

/*
* StatelessWidget을 이용하는 경우
* StatelessWidget으로 화면을 구성할 경우
* StatelessWidget 클래스의 생성자 호출 시
* fetchPost 함수를 호출결과를 전달해 주는 것이 적당
* 아래의 코드가 이에 해당
*/
void main() => runApp(MyApp(post: fetchPost()));

class MyApp extends StatelessWidget {
  final Future<Post> post;

  MyApp({Key? key, required this.post}) : super(key: key);

  @override
  Widget build(BuildContext context){
    return MaterialApp(
      title: 'Fetch Data Example',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(primarySwatch: Colors.blue),
      home: Scaffold(
        appBar: AppBar(title: const Text('Fetch Data Example')),
        body: Center(
          // FutureBuilder: Future 객체를 처리하기 위한 builder
          child: FutureBuilder<Post>(
            // Future 객체 post를 future 항목에 할당
            future: post,
            // builder는 post값의 변화가 발생할 때마다 호출
            builder: (context, snapshot){
              // 정상 데이터 수신 시 해당 데이터의 title 출력
              if(snapshot.hasData){
                return Text(snapshot.data!.title);
              }
              // 에러 수신 시 에러메시지 출력
              else if(snapshot.hasError){
                return Text('${snapshot.error}');
              }
              // 상태처리 인디케이터 표시. 앱 초기에 출력
              return CircularProgressIndicator();
            },
          ),
        ),
      ),
    );
  }
}

/*
* StatefulWidget을 이용하는 경우
* StatefulWidget으로 화면을 구성할 경우
* 상태 클래스의 initState() 메소드 안에서 fechPost 함수가 호출되도록 재정의
* 1번만 통신이 발생하도록 구현한다.


void main() => runApp(const MyApp());

class MyApp extends StatefulWidget{
  const MyApp({Key? key}) : super(key: key);

  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp>{
  late Future<Post> post;

  @override
  void initState(){
    super.initState();
    post = fetchPost();
  }

  @override
  Widget build(BuildContext context){
    return MaterialApp(
      title: 'Fetch Data Example',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(primarySwatch: Colors.blue),
      home: Scaffold(
        appBar: AppBar(title: const Text('Fetch Data Example')),
        body: Center(
          // FutureBuilder: Future 객체를 처리하기 위한 builder
          child: FutureBuilder<Post>(
            // Future 객체 post를 future 항목에 할당
            future: post,
            // builder는 post값의 변화가 발생할 때마다 호출
            builder: (context, snapshot){
              // 정상 데이터 수신 시 해당 데이터의 title 출력
              if(snapshot.hasData){
                return Text(snapshot.data!.title);
              }
              // 에러 수신 시 에러메시지 출력
              else if(snapshot.hasError){
                return Text('${snapshot.error}');
              }
              // 상태처리 인디케이터 표시. 앱 초기에 출력
              return CircularProgressIndicator();
            },
          ),
        ),
      ),
    );
  }
}
*/
