import 'package:flutter/material.dart';
import 'dart:convert';

void main() {
  // 인코딩
  String korean = base64.encode(utf8.encode("한글 데이터"));

  // 디코딩
  utf8.decode(base64.decode(korean));
}
