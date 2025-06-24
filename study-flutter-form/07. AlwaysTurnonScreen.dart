import 'package:flutter/material.dart';
import 'package:screen/screen.dart';

void main(){
  // 화면이 항상 켜지도록 유지
  Screen.keepOn(true);

  runApp(
    MaterialApp(
      title: "Keep On Screen",
      home: Scaffold(
        appBar: AppBar(title: Text("Keep Screen")),
        body: Center(child: Text("Always Turn On Screen")),
      ),
    ),
  );
}

// pubspec.yaml 파일에 screen패키지를 추가
// screen: ^0.0.5 #screen

// Android의 AndroidManifest.xml 파일에 퍼미션 추가
// <usues-permission android:name="android.permission.WAKE_LOCK" />

