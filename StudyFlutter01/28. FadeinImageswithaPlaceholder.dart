import 'package:flutter/material.dart';
import 'package:transparent_image/transparent_image.dart';
//   transparent_image: ^2.0.0 (pubspec.yaml)

void main() => runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    final title = 'Fade in Images';

    return MaterialApp(
      title: title,
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(title: Text(title)),
        body: Stack(
          children: <Widget>[
           // FadeInImage 등록
            Center(child: CircularProgressIndicator()),
            Center(
              // FadeInImage 등록
              child: FadeInImage(
                // Placeholder는 메모리에 있는 것을 사용
                placeholder: MemoryImage(kTransparentImage),
                image: NetworkImage('https://picsum.photos/250?image=9'),
              ),

              // 아래와 같이 사용할 수도 있다.
              // memoryNetwork은 placeholder는 메모리의 것을, 이미지는 network의 것을 사용하느는 의미
              // child: FadeInImage.memoryNetwork(
              //    placeholder: kTransparentImage,
              //    image: 'https://picsum.photos/250?image=10'),

            )
          ],
        ),
      ),
    );
  }
}