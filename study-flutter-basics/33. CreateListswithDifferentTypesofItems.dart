import 'package:flutter/material.dart';

void main()
{
  // 1000개의 아이템을 가지는 리스트를 생성하여 MyApp의 생성자로 전달
  runApp(MyApp(
    // 0을 포함한 6의 배수번쨰는 HeadingItem을 그 외에는 MessageItem으로 List생성
    items: List<ListItem>.generate(1000,
            (i) => i % 6 == 0
                ? HeadingItem("Heading $i")
                : MessageItem("Sender $i", "Message body $i")
    )));
}

// ListView의 아이템으로 이용할 추상 클래스
abstract class ListItem {
  // list item에 표시할 제목 줄
  Widget buildTitle(BuildContext context);

  // Subtitle이 있는경우 list item에 표시
  Widget buildSubtitle(BuildContext context);
}

// 추상 클래스 ListItem을 구현하는 HeadingItem
class HeadingItem implements ListItem{
  final String heading;

  HeadingItem(this.heading);

  @override
  Widget buildTitle(BuildContext context){
    return Text(
      heading,
      style: Theme.of(context).textTheme.headline5,
    );
  }

  @override
  Widget buildSubtitle(BuildContext context) => SizedBox();
}

// 추상클래스 ListItem을 구현하는 MessageItem
class MessageItem implements ListItem{
  final String sender;
  final String body;

  MessageItem(this.sender, this.body);

  @override
  Widget buildTitle(BuildContext context) => Text(sender);

  @override
  Widget buildSubtitle(BuildContext context) => Text(body);
}

class MyApp extends StatelessWidget{
  final List<ListItem> items;

  // 리스트를 필드 items에 저장
  MyApp({Key? key, required this.items}) : super(key: key);

  @override
  Widget build(BuildContext context){
    final title = "Mixed List";

    return MaterialApp(
      title: title,
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
            title: Text(title)
        ),
        body: ListView.builder(
          itemCount: items.length,
          itemBuilder: (context, index) {
            final item = items[index];

              return ListTile(
                title: item.buildTitle(context),
                subtitle: item.buildSubtitle(context),
              );
          },
        ),
      ),
    );
  }
}