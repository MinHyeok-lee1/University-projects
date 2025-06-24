import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() => runApp(TabBarDemo());

class TabBarDemo extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    // MaterailApp 생성/반환
    return MaterialApp(
      debugShowCheckedModeBanner: false,

      /*
          Tab 사용법
          스크린을 TabController 위젯으로 구성
          TabBar: 사용할 탭을 구성. appBar의 bottom으로 구현
          TabBarView: 탭이 선택될 시 디스플레이할 컨텐트 구성. body로 구현
       */

      home: DefaultTabController(
        // 탭의 수 설정
        length: 3,
        child: Scaffold(
         appBar: AppBar(
           title: Text('Tabs Demo'),
           // TabBar 구현, 각 컨텐트를 호출할 탭들을 등록
           bottom: TabBar(
             tabs: [
               Tab(icon: Icon(Icons.directions_car)),
               Tab(icon: Icon(Icons.directions_transit)),
               Tab(icon: Icon(Icons.directions_bike)),
             ],
           ),
         ),

         // TabVarView 구현, 각 탭에 해당하는 컨텐트 구성
         body: TabBarView(
           children: [
             Icon(Icons.directions_car),
             Icon(Icons.directions_transit),
             Icon(Icons.directions_bike),

             /*Image.asset(
                 'images/lake.jpg',
                 width: 600, height: 240, fit: BoxFit.cover),
             */
           ],
         ),
        ),
      ),
    );
  }
}