import 'package:flutter/material.dart';

final Color darkBlue = Color.fromARGB(255, 18, 32, 47);

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'MediaQueryDemo',
      theme: ThemeData.dark().copyWith(scaffoldBackgroundColor: darkBlue),
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text('MediaQueryDemo'),
        ),
        body: Center(
          child: MyMediaQuery(),
        ),
      ),
    );
  }
}

class MyMediaQuery extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final data = MediaQuery.of(context);
    final screenSize = data.size;
    final orientation = data.orientation;
    final padding = data.padding;
    final insets = data.viewInsets;

    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          "width: ${screenSize.width}\nheight: ${screenSize.height}\naspect ratio: ${screenSize.aspectRatio}",
        ),
        Text(
          "orientation: ${orientation.toString()}",
        ),
        Text(
          "top padding: ${padding.top}\nbottom padding: ${padding.bottom}",
        ),
        Text(
          "top insets: ${insets.top}\nbottom insets: ${insets.bottom}\n",
        ),
        SizedBox(
          height: 30,
        ),
        Container(
          height: 100,
          width: 100 * screenSize.aspectRatio,
          color: Colors.blueGrey[100],
        )
      ],
    );
  }
}
