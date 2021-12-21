// ignore: avoid_web_libraries_in_flutter
import 'dart:html';
import 'dart:typed_data';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'dart:ui' as ui;
import 'package:opencv_4/factory/pathfrom.dart';
import 'package:opencv_4/opencv_4.dart';
import 'package:image_picker/image_picker.dart';
import 'package:video_player/video_player.dart';

void main() => runApp(const WebcamApp());

class WebcamApp extends StatelessWidget {
  const WebcamApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) => const MaterialApp(
        home: WebcamPage(),
      );
}

class WebcamPage extends StatefulWidget {
  const WebcamPage({Key? key}) : super(key: key);

  @override
  _WebcamPageState createState() => _WebcamPageState();
}

class _WebcamPageState extends State<WebcamPage> {
  // Webcam widget to insert into the tree
  late Widget _webcamWidget;

  // VideoElement
  late VideoElement _webcamVideoElement;
  bool flag = false;

  Uint8List? _byte;
  String _versionOpenCV = 'OpenCV';
  bool _visible = false;

  //uncomment when image_picker is installed
  final picker = ImagePicker();

  @override
  void initState() {
    super.initState();
    _getOpenCVVersion();

    // Create an video element which will be provided with stream source
    _webcamVideoElement = VideoElement();

    // Register an webcam
    ui.platformViewRegistry.registerViewFactory(
        'webcamVideoElement', (int viewId) => _webcamVideoElement);

    // Create video widget
    _webcamWidget =
        HtmlElementView(key: UniqueKey(), viewType: 'webcamVideoElement');
    // Access the webcam stream
    window.navigator.getUserMedia(video: true).then((MediaStream stream) {
      _webcamVideoElement.srcObject = stream;
    });
  }

  testOpenCV({
    required String pathString,
    required CVPathFrom pathFrom,
    required double thresholdValue,
    required double maxThresholdValue,
    required int thresholdType,
  }) async {
    try {
      //test with threshold
      _byte = await Cv2.threshold(
        pathFrom: pathFrom,
        pathString: pathString,
        maxThresholdValue: maxThresholdValue,
        thresholdType: thresholdType,
        thresholdValue: thresholdValue,
      );

      setState(() {
        _byte;
        _visible = false;
      });
    } on PlatformException catch (e) {
      print(e.message);
    }
  }

  /// metodo que devuelve la version de OpenCV utilizada
  Future<void> _getOpenCVVersion() async {
    String? versionOpenCV = await Cv2.version();
    setState(() {
      _versionOpenCV = 'OpenCV: ' + versionOpenCV!;
    });
  }

  late VideoPlayerController _controller;
  _testFromUrl() async {
    // Create an video element which will be provided with stream source

    _byte = Cv2.threshold(
      pathFrom: CVPathFrom.URL,
      pathString:
      'https://flutter.github.io/assets-for-api-docs/assets/videos/bee.mp4',
      thresholdValue: 150,
      maxThresholdValue: 200,
      thresholdType: Cv2.THRESH_BINARY,
    ) as Uint8List?;


    setState(() {
      _visible = true;
    });
  }d

  @override
  Widget build(BuildContext context) => Scaffold(
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              const Text(
                'Webcam MediaStream:',
                style: TextStyle(fontSize: 30, fontStyle: FontStyle.italic),
              ),
              SizedBox(width: 250, height: 250, child: _webcamWidget),
              Text(
                _versionOpenCV,
                style: const TextStyle(fontSize: 23),
              ),
              Container(
                margin: const EdgeInsets.only(top: 5),
                width: 250,
                height: 250,
                child: _byte != null
                    ? Image.memory(
                        _byte!,
                        width: 300,
                        height: 300,
                        fit: BoxFit.fill,
                      )
                    : SizedBox(
                        width: 300,
                        height: 300,
                        child: Icon(
                          Icons.camera_alt,
                          color: Colors.grey[800],
                        ),
                      ),
              ),
              Visibility(
                  maintainAnimation: true,
                  maintainState: true,
                  visible: _visible,
                  child: const CircularProgressIndicator()),
              SizedBox(
                width: MediaQuery.of(context).size.width - 40,
                child: TextButton(
                  child: const Text('test url'),
                  onPressed: _testFromUrl,
                  style: TextButton.styleFrom(
                    primary: Colors.white,
                    backgroundColor: Colors.teal,
                    onSurface: Colors.grey,
                  ),
                ),
              ),
            ],
          ),
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: () => (flag = !flag)
              ? _webcamVideoElement.play()
              : _webcamVideoElement.pause(),
          tooltip: 'Start stream, stop stream',
          child: const Icon(Icons.camera_alt),
        ),
      );
}
