// ignore: avoid_web_libraries_in_flutter
import 'dart:html';
import 'package:flutter/material.dart';
import 'dart:ui' as ui;
import 'dart:convert';
import 'package:http/http.dart' as http;

void main() => runApp(const WebcamApp());

class WebcamApp extends StatelessWidget {
  const WebcamApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) => MaterialApp(
    home: WebcamPage(),
  );
}

class WebcamPage extends StatefulWidget {
  const WebcamPage({Key? key}) : super(key: key);

  @override
  _WebcamPageState createState() => _WebcamPageState();
}

class _WebcamPageState extends State<WebcamPage> {
  String greetings = '';
  // Webcam widget to insert into the tree
  late Widget _webcamWidget;
  bool flag = false;
  // VideoElement
  late VideoElement _webcamVideoElement;

  @override
  void initState() {
    super.initState();

    // Create an video element which will be provided with stream source
    _webcamVideoElement = VideoElement();

    // Register an webcam
    ui.platformViewRegistry.registerViewFactory('webcamVideoElement', (int viewId) => _webcamVideoElement);

    // Create video widget
    _webcamWidget = HtmlElementView(key: UniqueKey(), viewType: 'webcamVideoElement');

    // Access the webcam stream
    window.navigator.getUserMedia(video: true).then((MediaStream stream) {
      _webcamVideoElement.srcObject = stream;
    });
  }

  @override
  Widget build(BuildContext context) => Scaffold(
    body: Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Text(greetings,
            style: TextStyle(fontSize: 30, fontStyle: FontStyle.italic),
          ),
          Center(child: Container(
            width: 150,
            height: 60,
            child: TextButton(
              onPressed: () async {
                var uri = Uri.parse('http://127.0.0.1:5000/');
                final response = await http.get(uri);
                final decoded = json.decode(response.body) as Map<String, dynamic>;
                setState((){
                  greetings = decoded['greetings'];
                });
              },
              child: Text('Press', style: TextStyle(fontSize: 24)),

            ),
          )),
          Text(
            'Webcam MediaStream:',
            style: TextStyle(fontSize: 30, fontStyle: FontStyle.italic),
          ),
          Container(width: 750, height: 750, child: _webcamWidget),
        ],
      ),
    ),
    floatingActionButton: FloatingActionButton(
      onPressed: () => (flag = !flag) ? _webcamVideoElement.play() : _webcamVideoElement.pause(),
      tooltip: 'Start stream, stop stream',
      child: Icon(Icons.camera_alt),
    ),
  );
}
