/*
 Android 10 외부 저장소 접근정책때문에 생기는
 image_picker를 사용하여 갤러리나 카메라로부터 이미지를 읽어올 때
 이미지를 읽어오지 못하는 문제가 발생한다.

 - 이에 대한 해결 방법
 AndroidManifest.xml 파일에 Application 항목에 requestLegacyExternalStorage = "true" 속성 추가


 ...

 <application
   android:name = "io.flutter.appFlutterApplication"
   android:icon = "@mipmap/ic_launcher"
   android:label = "앱 이름"
   android:requestLegacyExternalStorage = "true" >

   ...

*/
