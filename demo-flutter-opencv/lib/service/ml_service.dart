import 'dart:convert';
import 'dart:typed_data';

import 'package:dio/dio.dart';
import 'package:flutter/foundation.dart';

class MLService {
  Dio dio = Dio();

  Future<Uint8List?> convertImage (Uint8List imageData) async {
    try {
      var encodedData = await compute(base64Encode, imageData);
      Response response = await dio.post('http://127.0.0.1:5000/user',
          data: {
            'image': encodedData
          }
      );

      String result = response.data;
      return compute(base64Decode, result);
    } catch (e) {
      return null;
    }
  }
}
