import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'LayoutDemo',
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
          primaryColor: Colors.white,
        ),
        home: Scaffold(
          appBar: AppBar(title: Text('WOW')),
          body:
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: <Widget>[

                Column(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: <Widget>[
                Text('CENTER'),
                Icon(
                  Icons.star,
                  color: Colors.red[500],
                ),
                Text('BOTTOM'),
                Text('TOP'),
                    ],
                  ),
          Stack(
            alignment: const Alignment(0, -0.6),
            children: [
              const CircleAvatar(
                backgroundImage: AssetImage('images/lake.jpg',),
                radius: 100,
              ),
              Container(
                decoration: const BoxDecoration(
                  color: Colors.black45,
                ),
                child: const Text(
                  'Lake',
                  style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                  ),
                ),
              ),
            ],
          ),
                Expanded(child:
                Image.asset(
                  'images/lake.jpg',
                  fit: BoxFit.cover,
                 ),
                )

              ],
            ),

        )
    );
  }
}