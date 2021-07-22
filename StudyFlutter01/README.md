# Study Flutter
소스코드를 살펴보면, Flutter 언어도 main 함수가 프로그램의 시작점입니다. 
앱을 실행하기 위해 main 함수에서 runApp함수를 호출하는데 실행될 로직을 runApp 함수 내부에 직접 기술하고 있습니다.
Center함수는 화면의 중앙 부분을 구성할 수 있는 함수입니다. 그리고 Center 함수 내부에 child 항목을 이용해서 화면 중앙을 실제로 구성합니다. child 항목에 텍스트를 추가하기 위해 Text 함수를 이용하고 있으며 파라미터로 출력할 텍스트와 함께 텍스트의 기술 순서를 설정하는 textDirection 속성이 기술되어 있습니다.
ltr은 left to right의 약자로 왼쪽에서 오른쪽으로 기술한다는 의미입니다.


main 함수
앱을 main함수에서 runApp함수를 통해 시작합니다. Flutter에서 제공하는 Material UI를 이용하는 Material 앱을 이용하기 위해서는 runApp함수에서 MaterialApp 함수를 호출합니다. title 속성으로 "My App"을 설정하였고, home 속성을 이용해서 MyScaffold 클래스를 생성하여 호출합니다.

MyScaffold 클래스
MyScaffold 클래스는 main함수의 MaterialApp함수의 home속성에서 호출되는 클래스입니다.
MyScaffold는 StatelessWidget을 상속하는 클래스로 build함수를 통해 매트리얼(Material)을 생성하여 반환합니다. 매트리얼은 매트리얼 앱을 구성하는 기본 단위입니다.
이 매트리얼은 단일 자식으로 칼럼(Column)을 가집니다. 칼럼은 수직으로 UI를 구성할 수 있습니다. 칼럼은 다시 두 개의 위젯을 자식들로 가집니다.
첫 번째 자식인 MyAppBar는 본 앱의 상단에 표시될 바를 구성하는 것으로 별도의 클래스로 구현되어 있습니다.
두 번째 자식인 Expanded는 Center를 자식으로 가지며, Center는 다시 Text를 자식으로 가지고 있기 때문에 앱의 중앙에 텍스트를 출력하는 역할을 합니다.

MyAppBar 클래스
MyAppBar 클래스는 MyScaffold 클래스의 Build 함수에 의해 호출되어 앱의 상단을 꾸며주는 클래스입니다.
MyAppBar 클래스도 StatelessWidget을 상속하는 클래스로 build함수를 통해 컨테이너(Container)를 생성하여 반환합니다. 컨테이너는 사각형  모양의 앨리먼트들을 구성할 수 있습니다.
MyAppBar 클래스는 MyScaffold 클래스의 Build 함수에서 생성/호출되는데 생성자 호출 시 넘겨받은 title을 내부 필드에 저장하게 됩니다.
height와 padding 그리고 decoration 항목을 통해 컨테이너의 높이와 내부 패딩, 컨테이너의 색상을 설정하고 있습니다.
단일 자식으로 로우(Row)를 가지고 있는데 로우를 이용하면 수평적으로 위젯들을 구성할 수 있습니다. 로우의 자식들로는 IconButton과 Expanded 그리고 IconButton을 구성하고 있습니다.
첫 번째와 세 번째 자식인 아이콘 버튼들을 메뉴 아이콘과 검색 아이콘을 설정하고 있으며 onPressed 항목에서 null로 설정하였기 때문에 아이콘을 클릭하더라도 실행되는 로직은 없습니다.
두 번째 자식은 Expanded로 설정되었기 때문에 첫 번째와 세 번째 아이콘 버튼이 차지하는 영역을 제외한 모든 영역이 Expanded의 영역으로 할당되며, MyAppBar 클래스가 생성될 때 넘겨받은 title 위젯으로 Expanded를 구성하게 됩니다.


main 함수
runApp함수를 통해 MaterialApp을 생성하여 실행합니다. 매트리얼앱의 홈(home) 위젯으로 TutorialHome 클래스를 할당합니다.
TutorialHome 클래스
main 함수에서 생성하는 매트리얼앱의 홈 위젯에 해당하는 Scaffold 위젯을 생성하여 반환하는 클래스입니다. 본 앱에서 사용하는 Scaffold 위젯의 서브 항목들은 다음과 같습니다.
appBar: 앱의 상단에 표시되는 바형태의 위젯
body: 앱의 중앙에 출력되는 위젯
floatingActionButton: 앱을 구성하는 컨텐츠 위에 떠있는 원형의 위젯
본 앱의 appBar는 AppBar 위젯을 이용해서 구성하며, 본 앱에서 사용한 AppBar 위젯의 서브 항목들은 다음과 같습니다.
leading: 타이틀 위젯 앞에 출력되는 위젯
title: 앱바에 출력되는 주요 위젯
actions: 타이틀 위젯 뒤에 출력되는 위젯

old code:
final ScreenArguments args = routeSettings.arguments;

Scaffold.of(context)
      ..removeCurrentSnackBar()
      ..showSnackBar(SnackBar(content: Text('$result')));
      
Key key
@required this.todos


new code:
final args = routeSettings.arguments as ScreenArguments;

ScaffoldMessenger.of(context)
      ..removeCurrentSnackBar()
      ..showSnackBar(SnackBar(content: Text('$result')));

Key ? key
required this.todos
