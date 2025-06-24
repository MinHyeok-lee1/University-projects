import 'package:flutter/material.dart';
import 'package:cached_network_image/cached_network_image.dart';
//   cached_network_image 3.1.0 (pubspec.yaml)

void main() => runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    final title = 'Cached Images';

    return MaterialApp(
      title: title,
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(title: Text(title)),
        body: Center(
          // CachedNetworkImage 추가, 한번 다운로드하면 재활용 가능
          child: CachedNetworkImage(
            placeholder: (context,url) => CircularProgressIndicator(),
            imageUrl: 'https://picsum.photos/250?image=9',
          ),
        ),
      ),
    );
  }
}