import 'package:flutter/material.dart';

final Color darkBlue = Color.fromARGB(255, 18, 32, 47);

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'LayoutBuilderDemo',
      theme: ThemeData.dark().copyWith(scaffoldBackgroundColor: darkBlue),
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text(
              'LayoutBuilderDemo'
          ),
        ),
        body: Center(
          child: MyLayoutBuilder(),
        ),
      ),
    );
  }
}


class MyLayoutBuilder extends StatelessWidget {
  Widget oneBoxedContainer() {
    return Container(
      color: Colors.green,
      width: 100,
      height: 100,
    );
  }

  Widget twoBoxedContainer() {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Container(
          color: Colors.red,
          width: 100,
          height: 100,
        ),
        Container(
          color: Colors.blue,
          width: 100,
          height: 100,
        ),
      ],
    );
  }

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(
      builder: (BuildContext context, BoxConstraints constraints) {
        final width = constraints.maxWidth;
        final height = constraints.maxHeight;
        final ratio = width / height;
        return Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              "width: $width\nheight: $height\naspect ratio: $ratio",
            ),
            SizedBox(
              height: 20,
            ),
            Container(
              height: 300,
              width: 300 * ratio,
              color: Colors.blueGrey[100],
            ),
            SizedBox(
              height: 20,
            ),
            ratio >= 1 ? twoBoxedContainer() : oneBoxedContainer()
          ],
        );
      },
    );
  }
}
