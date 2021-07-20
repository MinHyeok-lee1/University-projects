import 'package:flutter/material.dart';

void main() => runApp(HeroApp());

class HeroApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return MaterialApp(
       title: 'Transition Demo',
      debugShowCheckedModeBanner: false,
       home: MainScreen(),
     );
  }
}

class MainScreen extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(
        title: Text('Main Screen'),
      ),
      // Hero 위젯이 onTap을 제공하지 않으므로 GestureDetector로 묶어서 기능부여
      body: GestureDetector(
        // Hero 추가
        child: Hero(
          // Hero의 tag. 애니메이션될 Hero들은 동일tag를 가져야함
          tag: 'imageHero',
          child: Image.network('https://picsum.photos/250?image=9'),
        ),
        // 탭되면 DetailScreen을 생성하여 적재
        onTap: (){
          Navigator.push(context, MaterialPageRoute(builder: (context){
            return DetailScreen();
          }));
        },
      ),
    );
  }
}

class DetailScreen extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return Scaffold(
      // Hero 위젯이 onTap을 제공하지 않으므로 GestureDetector로 묶어서 기능부여
      body: GestureDetector(
        child: Center(
          child: Hero(
              // Hero의 tag. 애니메시연 될 Hero는 동일 tag
              tag: 'imageHero',
              // Hero에 이미지 추가. 동일 이미지를 이용
              child: Image.network('https://picsum.photos/250?image=9')),
        ),
        // 탭하면 현재 스크린을 pop하여 제거
        onTap: (){
          Navigator.pop(context);
        },
      ),
    );
  }
}