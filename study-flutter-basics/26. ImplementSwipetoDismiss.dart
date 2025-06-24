import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget{
 MyApp({Key? key}) : super(key: key);

 MyAppState createState() => MyAppState();
}

class MyAppState extends State<MyApp>{
  // 30개의 스트링 타입의 아이템을 가지는 리스트 생성
  final items = List<String>.generate(30, (i) => "Item ${i + 1}");

  @override
  Widget build(BuildContext context){
    final appTitle = 'Dismissing Items';
    // MaterailApp 생성/반환
    return MaterialApp(
     title: appTitle,
     debugShowCheckedModeBanner: false,
     theme: ThemeData(primarySwatch: Colors.blue),
     home: Scaffold(
       appBar: AppBar(title: Text(appTitle)),
       // 리스트 뷰를 생성
       body: ListView.builder(
         itemCount: items.length,
         itemBuilder: (context, index){
          // 리스트의 index번째의 엘리먼트를 item으로 할당
           final item = items[index];

           return Dismissible(
               key: Key(item),
               // Dismissible의 자식으로 리스트타일을 생성. 리스트 뷰에 타일로 등록
               child: ListTile(title: Text('$item')),
               // Dismissible의 배경색 설정
               background: Container(color: Colors.red),
               // Dismissible이 Swipe될 때 호출, Swipe된 방향을 아규먼트로 수신
               onDismissed: (direction){
               // 해당 index의 item을 리스트에서 삭제
               setState(() {
                 items.removeAt(index);
               });
               // 삭제한 아이템을 스낵바로 출력
               ScaffoldMessenger.of(context).showSnackBar(
                 SnackBar(content: Text("$item dismissed"))
               );
             },
           );
         }),
       )
     );
  }
}