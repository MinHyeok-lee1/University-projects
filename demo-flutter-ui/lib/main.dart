import 'package:flutter/material.dart';
import 'package:duobattle/screen/screen_home.dart';

//final Color darkBlue = Color.fromARGB(255, 18, 32, 47);

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Material App Title',
      //theme: ThemeData.dark().copyWith(scaffoldBackgroundColor: darkBlue),
      // debugShowCheckedModeBanner: false,
      home: HomeScreen(),
    );
  }
}
