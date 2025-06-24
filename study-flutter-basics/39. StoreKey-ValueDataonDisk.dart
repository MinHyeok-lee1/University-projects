import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget{
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context){
    final title = 'Shared preferences demo';
    return MaterialApp(
      title: title,
      debugShowCheckedModeBanner: false,
      theme: ThemeData(primarySwatch: Colors.blue),
      home: MyHomePage(title: title),
    );
  }
}

class MyHomePage extends StatefulWidget{
  final String title;

  MyHomePage({Key? key, required this.title}) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  @override
  void initState() {
    super.initState();
    _loadCounter();
  }

  _loadCounter() async {
    // SharedPreferences의 인스턴스를 필드에 저장
    final _prefs = await SharedPreferences.getInstance();
    setState(() {
      // SharedPreferences에 counter로 저장된 값을 읽어 필드에 저장, 없을 경우 0으로 대입
      _counter = (_prefs.getInt('counter') ?? 0);
    });
  }

  _incrementCounter() async {
    final _prefs = await SharedPreferences.getInstance();
    setState(() {
      // 카운터 값을 1 증가
      _counter = (_prefs.getInt('counter') ?? 0) + 1;
      // 카운터 최신 값을 SharedPreferences에 counter라는 이름으로 저장
      _prefs.setInt('counter', _counter);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // 앱바에 타이틀 텍스트 설정, widget을 통해 MyHomePage의 필드에 접근 가능
      appBar: AppBar(title: Text(widget.title)),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text('You have pushed the button this many times: '),
            Text(
              // 카운터 값을 설정
              '$_counter',
              style: Theme
                  .of(context)
                  .textTheme
                  .headline4,
            )
          ],
        ),
      ),
      // 플로팅 버튼이 눌리면 _incrementCounter 메소드 호출
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: Icon(Icons.add),
      ),
    );
  }
}