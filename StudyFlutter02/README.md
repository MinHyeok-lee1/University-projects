# StudyFlutter - Diff

Flutter에서는 runApp함수의 파라미터로 화면을 구성할 클래스(더 정확히는 위젯)의 인스턴스를 넘겨주어 앱을 실행하게 된다.

runApp 함수에 의해 생성/호출되는 MyApp을 살펴보면 StatelessWidget 클래스를 상속하고 있다. Flutter에서 화면을 구성할 때 사용할 수 있는 위젯은 StatelessWidget과 StatefulWidget이 존재한다.

이번 강좌에서는 한번 꾸며지면 변화가 필요없는 화면을 구성할 땐 StatelessWidget을, 필요시 화면을 재구성 할 수 있을 경우에는 StatefulWidget을 이용한다고만 이해하고 넘어가자.

이번 강좌에서는 Hello World라는 문구만 출력하면 되므로 StatelessWidget를 이용한다. StatelessWidget 클래스를 상속하면 반드시 build 메소드를 재구현해야 한다. 우선 build 메소드의 선언 형태를 살펴보자.

반환자의 타입이 Widget이므로 build 메소드에서 위젯을 구성해서 반환하고 이 반환된 위젯이 화면에 뿌려진다고 추론할 수 있다. 아규먼트로 넘겨받는 BuildContext의 인스턴스 context는 해당 위젯의 인스턴스라고 이해하자.

내부 구성을 살펴보면 MaterialApp 클래스의 생성자를 통해 MaterialApp의 인스턴스를 생성한 후 반환하고 있다. 생성자 내부를 보면 Scaffold 클래스의 생성자를 또 호출하고 있다. 이런 방식이 기존의 자바 개발자에겐 생소하게 느껴질 것이다. 내 경우에는 그렇다. Flutter에서는 이러한 패턴을 많이 사용한다. 아니 대부분 이런식으로 사용한다고 느껴지기도 한다.

그래도 차근차근 풀어보면 이해할 수 있다.

build 메소드에서는 MaterialApp 클래스의 인스턴스를 하나 만들어서 반환하고자 한다.

MaterialApp의 인스턴스 생성을 위해 MaterialApp의 생성자를 호출하고 있고 이 때 두 개의 파라미터(title, home)를 넘겨주고 있다. 기존의 언어에서는 호출하고자 하는 함수나 메소드(생성자)의 아규먼트 형태와 순서에 따라 파라미터를 넘겨주는 패턴을 이용해왔다. Flutter(더 정확히 Dart) 언어에서는 넘겨줄 파라미터의 프로퍼티를 기술해 줌으로써 아규먼트의 순서를 무시할 수 있고, 필요한 프로퍼티만을 넘겨줄 수 도 있다. 마치 JSON 객체를 다루는 방식과도 꽤 유사하다.

다시 소스코드로 돌아가면 MaterialApp이라는 클래스는 title과 home라는 필드(프로퍼티)가 존재할 것이고 생성자를 통해 title과 home의 값을 넘겨받을 수 있다는 것이다.

여기서 title은 MaterialApp을 설명하는 1줄짜리 텍스트 문구를 저장할 수 있으며, 이 값은 Android의 경우 앱의 지시자로 사용된다. 실행 중인 앱 목록을 확인할 때 표시되는 텍스트 문구로 활용된다.

home 항목은 앱의 화면을 구성하는 위젯을 설정하는 항목이다. 소스에서는 Scaffold라는 클래스의 인스턴스를 담아서 생성자를 호출하고 있다. 즉 Scaffold 클래스의 인스턴스과 화면으로 그려지게 된다.

이번엔 Scaffold 클래스에 대해서 알아보자. Scaffold의 생성자에 body라는 프로퍼티에 Text 함수를 통해 텍스트를 추가하고 있다.

Text는 텍스트를 화면에 출력하는 Flutter의 위젯이다. 이 텍스트 위젯을 Scaffold 인스턴스의 body 항목으로 설정

Scaffold의 appBar 항목에 AppBar 클래스(위젯)의 생성자를 대입하고 있다. AppBar 위젯의 인스턴스를 생성해서 Scaffold의 appBar 항목에 추가한다는 의미
AppBar 위젯는 앱 화면의 상단에 위치해서 다양한 기능을 제공해 주는데 이 강좌에서는 title 항목만 이용한다. title 항목에 텍스트를 추가하기 위해 Text 위젯을 이용

계층을 잘 이해하자 화면을 구성하는 Scaffold의 내부에 Scaffold의 상단을 꾸며주는 appBar로 AppBar 위젯을 추가하였고, 이 AppBar 위젯에 타이틀로 Text 위젯을 추가한 것



메소드 방식의 경우 메소드가 직접 호출되고, 위젯을 직접 반환하는 심플한 구조를 가진다. 하지만 클래스 방식은 클래스 생성자를 호출하는 방식이고 생성자는 반환값이 없는 메소드다 그러므로 반드시 build 메소드를 재정의해서 위젯이 리턴될 수 있도록 구현


 + 화면회전을 방지하는 방법
pubspec.yaml 파일에 screen패키지를 추가
screen: ^0.0.5 #screen

Android의 AndroidManifest.xml 파일에 퍼미션 추가
<usues-permission android:name="android.permission.WAKE_LOCK" />

패키지 추가
import 'package:flutter/services.dart';

main 함수 안에 runApp() 함수 호출 전 단계에서 다음의 코드를 추가
SystemChrome.setPreferredOrientations([DeviceOrientation.portraitUp]);

만약 가로모드 전용 앱을 개발하고자 한다면 landscapeLeft이나 landscapeRight를 설정하거나 둘 다 설정하면 가로모드 전용으로 앱을 이용가능
