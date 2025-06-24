import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(
    MyApp(
      items: List<String>.generate(10000, (i) => 'Item $i'),
    ),
  );
}

class MyApp extends StatelessWidget {
  final List<String> items;

  const MyApp({Key? key, required this.items}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    const title = 'Long List';

    return MaterialApp(
      title: title,
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: const Text(title),
        ),
        /*
        body: ListView(
          children: <Widget>[
            ListTile(
              //leading. 타일 앞에 표시되는 위젯. 참고로 타일 뒤에는 trailing 위젯으로 사용 가능
              leading: Icon(Icons.map),
              title: Text('Map'),
            ),
            ListTile(
              leading: Icon(Icons.photo_album),
              title: Text('Album'),
            ),
            ListTile(
              leading: Icon(Icons.phone),
              title: Text('Phone'),
            )
          ],
        ),
        
        리스트뷰의 생성자를 이용하는 방법 - (
        
        해당 방법은 ListView의 생성자에서 아이템(ListTile)을 직접 구현하여 ListView를 구성하는 방법이다.
        모든 아이템이 생성되고 리스트뷰에 등록된 후에 리스트뷰가 화면에 출력된다. 이 방법은 아이템의 수가 적을 경우 정상 동작한다.
        그러나 천개 단위 혹은 만개 단위의 아이템을 가지를 리스트를 생성자를 통해 생성한다면 문제가 발생할 수 있다.
        모든 아이템이 생성되고 메모리에 로딩된 후에 리스트뷰가 출력되기 때문에 많은 시간과 자원이 소비되어야 한다.
        그리고 대부분의 경우 사용자는 리스트의 일부만 보고 앱을 종료할 가능성이 더 많다.
        builder를 이용하면 이러한 문제를 예방할 수 있다. 빌더를 이용하면 리스트가 스크롤 되면서 필요한 아이템이 동적으로 생성된다. 
        
        )
        */
        // 리스트뷰 빌더를 이용하는 방법
        body: ListView.builder(
          itemCount: items.length,
          itemBuilder: (context, index) {
            return ListTile(
              title: Text(items[index]),
            );
          },
        ),
        
      ),
    );
  }
}
