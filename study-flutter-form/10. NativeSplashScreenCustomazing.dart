/*
 앱 시작 화면 수정 방법, 네이티브 스플래쉬 스크린 수정

pubspec.yaml 파일의 dev_dependencies 항목에 플러그인을 추가
> dev_dependencies:
   flutter_native_splash: ^1.2.0

pubspec.yaml 파일 하단에 네이티브 스플래쉬 스크린의 배경색을 설정하는 내용을 추가
> flutter_native_splash:
    color: "42a5f5"

설정을 마쳤으며 터미널에서 다음의 명령어를 실행
> flutter pub pub run flutter_native_splash:create

네이티브 스크린에 이미지를 추가할 수도 있다.
프로젝트 root에 assets 폴더를 생성하고 이미지 파일을 추가한 후 pubspec.yaml 파일의 설정에 이미지의 위치를 추가
> flutter_native_splash:
   image: assets/ic_launcher.png
   color: "42a5f5"

*  splash.png 파일로 이름이 변경
 두번째 아이템으로 bitmap 이미지를 추가하면서 이미지의 경로를 drawable의 splash 파일로 지정

 <?xml version="1.0" encoding="utf-8"?>
<!-- Modify this file to customize your launch splash screen -->
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@color/splash_color" />

    <item>
        <bitmap android:gravity="center" android:src="@drawable/splash" />
    </item>

</layer-list>


>
이미지가 출력되지 시작했다. 그런데 이미지의 위치가 바뀌면서 흔들리는 느낌이 난다. 이것은 네이티브 스크린이 풀스크린(Fullscreen)으로 변경되면서 발생
이를 해결하기 위해서는 values 폴더의 styles.xml 파일의 windowFullscreen 항목을 false로 변경
*/
