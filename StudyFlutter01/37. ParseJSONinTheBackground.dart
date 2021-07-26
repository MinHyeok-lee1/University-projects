import 'package:flutter/material.dart';
import 'dart:async'; // async/await 를 이용하기 위한 라이브러리나 선언하지 않아도 이용가능
import 'dart:convert'; // json 데이터 변환용 라이브러리
import 'package:flutter/foundation.dart'; // compute 함수를 제공
import 'package:http/http.dart' as http; // Http 프로토콜을 이용하기 위한 패키지

// 사진의 정보를 저장하는 클래스
class Photo{
  final int albumId;
  final int id;
  final String title;
  final String url;
  final String thumbnailUrl;

  Photo({
    required this.albumId,
    required this.id,
    required this.title,
    required this.url,
    required this.thumbnailUrl,
  });

  //factory 생성자. Photo 타입의 인스턴스를 반환 (사진의 정보를 포함하는 인스턴스 생성 및 반환)
  factory Photo.fromJson(Map<String, dynamic> json){
    return Photo(
      albumId: json['albumId'] as int,
      id: json['id'] as int,
      title: json['title'] as String,
      url: json['url'] as String,
      thumbnailUrl: json['thumbnailUrl'] as String,
    );
  }
}

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget{
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    const appTitle = 'Isolate Demo';

    return const MaterialApp(
      title: appTitle,
      debugShowCheckedModeBanner: false,
      home: MyHomePage(title: appTitle),
    );
  }
}

class MyHomePage extends StatelessWidget{
  const MyHomePage({Key? key, required this.title}) : super(key: key);
  final String title;

  @override
  Widget build(BuildContext context){
    return Scaffold(
          appBar: AppBar(title:Text(title)),
          // Photo의 리스트를 처리하는 FutureBuilder 추가
          body: FutureBuilder<List<Photo>>(
          // future 항목에 fetchPhotos 함수 설정. fetchPhotos는 Future 객체를 결과값으로 반환
          future: fetchPhotos(http.Client()),
          // Future 객체를 처리할 빌더
          builder: (context, snapshot){
            // 에러가 발생하면 에러 출력
            if(snapshot.hasError) {
              print(snapshot.error);
            }
            // 정상적으로 데이터가 수신된 경우
            return snapshot.hasData
                ? PhotosList(photos: snapshot.data!) // PhotoList를 출력
                : Center(
              child: CircularProgressIndicator()); // 데이터 수신 전에 Indicator 출력
          },
        )
      );
  }
}

// 서버로부터 데이터를 수신하여 그 결과를 List<Photo> 형태의 Future 객체로 반환하는 async 함수
Future<List<Photo>> fetchPhotos(http.Client client) async {
  // 해당 URL로 데이터를 요청하고 수신함
  final response =
  await client.get(Uri.parse('https://jsonplaceholder.typicode.com/photos'));

  // parsePhotos 함수를 백그라운드 격리 처리
  return compute(parsePhotos, response.body);
}

// 수신한 데이터를 파싱하여 List<Photo> 형태로 반환
List<Photo> parsePhotos(String responseBody){
  // 수신 데이터를 JSON 포맷(JSON Array)으로 디코딩
  final parsed = jsonDecode(responseBody).cast<Map<String, dynamic>>();

  // JSON Array를 List<Photo>로 변환하여 반환
  return parsed.map<Photo>((json) => Photo.fromJson(json)).toList();
}

class PhotosList extends StatelessWidget{
  const PhotosList({Key? key, required this.photos}) : super(key: key);

  final List<Photo> photos;

  @override
  Widget build(BuildContext context){
    return GridView.builder(
      gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 2),
      itemCount: photos.length,
      itemBuilder: (context, index){
        var photo = photos[index];
        return Container(
          child: Column(
            children: <Widget>[
              // 이미지의 albumId와 Id값 출력
              Text("albumId: ${photo.albumId} / ID: ${photo.id.toString()}"),
              // thumbnailUrl에 해당하는 이미지를 온라인으로부터 다운로드하여 출력
              Image.network(photo.thumbnailUrl)
            ],
          ),
        );
      },
    );
  }
}