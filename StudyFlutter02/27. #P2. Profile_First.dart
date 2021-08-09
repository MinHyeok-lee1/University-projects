import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';
import 'dart:convert';
import 'package:intl/intl.dart';

const double common_xxs_gap = 8.0;
const double common_xs_gap = 10.0;
const double common_s_gap = 12.0;
const double common_gap = 14.0;
const double common_l_gap = 16.0;
const double profile_radius = 16.0;

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'BottomNavigator Demo',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primaryColor: Colors.white,
      ),
      home: MainPage(),
    );
  }
}

Widget _iconButton(onPressed, imageUrl, color) {
  return IconButton(
    onPressed: onPressed,
    icon: ImageIcon(
      AssetImage(imageUrl),
      color: color,
    ),
  );
}

String getProfileImgPath(String userName) {
  final encoder = AsciiEncoder();
  List<int> codes = encoder.convert(userName);
  int sum = 0;

  codes.forEach((code) => sum += code);
  final imgNum = sum % 1000;
  return "https://picsum.photos/id/$imgNum/30/30";
}
/*
45줄 why not use ' List<Widget> ' ?
List<Widget> : bottomNavigationBar 에서 하단탭을 클릭하면 화면 전환이 이루어 지는데 기존에 생성되어 있는 화면은 삭제가 되고 새로운 위젯이 생성되어 화면을 보여줌. 10번의 화면 전환이 이루어 지면 10번의 생성과 소멸이 이루어짐.
IndexedStack : 이 위젯은 5개의 자식이 있으면 5개의 자식이 한번만 생성이 되고 Stack처럼 겹쳐져 있다가 사용자가 보고자 하는 화면은 맨위로 올라와서 보여줌. 10번의 화면 전환이 이루어 져도 각각 화면의 갯수만큼만 1번씩의 생성만 이루어짐.
 */

class Comment extends StatelessWidget {
  final String userName;
  final bool showProfile;
  final String dateTime;
  final String caption;

  Comment({
    required this.userName,
    this.showProfile = false,
    this.dateTime = '',
    required this.caption
  });

  @override
  Widget build(BuildContext context) {
    return Row(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Visibility(
          visible: showProfile,
          child: CircleAvatar(
            backgroundImage: NetworkImage(getProfileImgPath(userName)),
            radius: profile_radius,
          ),
        ),
        Visibility(
          visible: showProfile,
          child: SizedBox(
            width: common_xs_gap,
          ),
        ),
        Expanded(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: <Widget>[
              RichText(
                text: TextSpan(
                    style: DefaultTextStyle.of(context).style,
                    children: <TextSpan>[
                      TextSpan(
                        text: userName,
                        style: TextStyle(fontWeight: FontWeight.bold),
                      ),
                      TextSpan(text: '  '),
                      TextSpan(
                          text: '무플방지 위원회'),
                    ]),

              ),
              SizedBox(
                height: common_xxs_gap,
              ),
              Visibility(
                visible: dateTime != null,
                child: dateTime == null
                    ? SizedBox()
                    : Text(
                        new DateFormat('yyyy-MM-dd').format(DateTime.parse(dateTime)).toString(),
                        style: TextStyle(color: Colors.grey[700], fontSize: 11),
                      ),
              ),
            ],
          ),
        ),
      ],
    );
  }
}

class FeedPage extends StatelessWidget {
  CachedNetworkImage _feedImage(int index) {
    return CachedNetworkImage(
      imageUrl: 'https://picsum.photos/id/$index/200/200',
      imageBuilder: (BuildContext context, ImageProvider imageProvider) {
        return AspectRatio(
          aspectRatio: 1,
          child: Container(
            decoration: BoxDecoration(
                image: DecorationImage(
              image: imageProvider,
              fit: BoxFit.cover,
            )),
          ),
        );
      },
    );
  }

  Widget _feedHeader(int index) {
    return Row(
      children: <Widget>[
        Padding(
          padding: const EdgeInsets.all(14.0),
          child: CircleAvatar(
            backgroundImage:
                CachedNetworkImageProvider(getProfileImgPath('$index')),
            radius: 16,
          ),
        ),
        Expanded(child: Text('UserName$index')),
        IconButton(
          icon: Icon(
            Icons.more_horiz,
            color: Colors.black,
          ),
          onPressed: null,
        )
      ],
    );
  }

  Row _feedAction(int index) {
    return Row(children: <Widget>[
      _iconButton(null, 'images/heart_selected.png', Colors.red),
      _iconButton(null, 'images/comment.png', Colors.black87),
      _iconButton(null, 'images/direct_message.png', Colors.black87),
      Spacer(),
      _iconButton(null, 'images/bookmark.png', Colors.black87),
    ]);
  }

  Padding _feedLikes(int index) {
    return Padding(
      padding: EdgeInsets.only(left: common_gap, bottom: common_gap),
      child: Text(
        '좋아요 57개',
        style: TextStyle(
          fontWeight: FontWeight.bold,
        ),
      ),
    );
  }

/*
  Padding _feedCaption(BuildContext context, int index) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: common_gap),
      child: RichText(
        text: TextSpan(
            style: DefaultTextStyle.of(context).style,
            children: <TextSpan>[
              TextSpan(
                text: 'username $index',
                style: TextStyle(fontWeight: FontWeight.bold),
              ),
              TextSpan(text: '  '),
              TextSpan(text: 'ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ'),
            ]),
      ),
    );
  }
*/

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
          // leading: Appbar 왼쪽에 들어갈 위젯설정
          leading:
              _iconButton(null, 'images/actionbar_camera.png', Colors.black),
// 아래코드를 중복을 줄이기 위해 _iconButton 사용
/*
          leading: IconButton(
          onPressed: null,
          icon: ImageIcon(
            AssetImage('images/actionbar_camera.png'),
            color: Colors.black,
          ),
        ),
*/

          // title: Appbar에서 leading영역 오른쪽에 들어갈 타이틀영역
          title: Image.asset('images/insta_text_logo.png', height: 26),
          // Appbar에서 오른쪽영역에 들어갈 위젯들 설정
          actions: <Widget>[
            _iconButton(null, 'images/actionbar_igtv.png', Colors.black),
            _iconButton(null, 'images/direct_message.png', Colors.black),
          ]),
      body: ListView.builder(
          itemCount: 15,
          itemBuilder: (BuildContext context, int index) {
            return Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                _feedHeader(index),
                _feedImage(index),
                _feedAction(index),
                _feedLikes(index),
                Comment(userName: 'commentMan', caption: '', showProfile: true, dateTime: '20210827'),
                Divider()
              ],
            );
          }),
    );
  }
}

class MainPage extends StatefulWidget {
  @override
  _MainPageState createState() => _MainPageState();
}

class _MainPageState extends State<MainPage> {
  // _selectedIndex: IndexedStack 위젯에서 사용할 현재 선택된 인덱스 정보를 담고 있는 변수
  int _selectedIndex = 0;

  // _widgetOptions: 현재 선택된 인덱스에 따른 body에 표현해줄 화면정보를 담고 있는 변수
  static List<Widget> _widgetOptions = <Widget>[
    FeedPage(),
    Container(color: Colors.primaries[1]),
    Container(color: Colors.primaries[2]),
    Container(color: Colors.primaries[3]),
    Profile(),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // IndexedStack: 인덱스 번호를 매긴 자식들을 가지고 있는 위젯
      body: IndexedStack(
        index: _selectedIndex,
        children: _widgetOptions,
      ),
      bottomNavigationBar: BottomNavigationBar(
        showSelectedLabels: false,
        showUnselectedLabels: false,
        unselectedItemColor: Colors.grey[900],
        selectedItemColor: Colors.black,
        type: BottomNavigationBarType.fixed,
        backgroundColor: Color.fromRGBO(249, 249, 249, 1),
        items: <BottomNavigationBarItem>[
          _buildBottomNavigationBarItem(
              activeIconPath: "images/home_selected.png",
              iconPath: 'images/home.png'),
          _buildBottomNavigationBarItem(
              activeIconPath: "images/search_selected.png",
              iconPath: 'images/search.png'),
          _buildBottomNavigationBarItem(iconPath: "images/add.png"),
          _buildBottomNavigationBarItem(
              activeIconPath: "images/heart_selected.png",
              iconPath: 'images/heart.png'),
          _buildBottomNavigationBarItem(
              activeIconPath: "images/profile_selected.png",
              iconPath: 'images/profile.png'),
        ],
        currentIndex: _selectedIndex,
        onTap: (index) => _onItemTapped(index),
      ),
    );
  }

  BottomNavigationBarItem _buildBottomNavigationBarItem(
      {String? activeIconPath, required String iconPath}) {
    return BottomNavigationBarItem(
      activeIcon:
          activeIconPath == null ? null : ImageIcon(AssetImage(activeIconPath)),
      icon: ImageIcon(AssetImage(iconPath)),
      label: '',
    );
  }

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }
}

// Start the Class Profile

class Profile extends StatefulWidget {
  @override
  _ProfileState createState() => _ProfileState();
}

// MediaQuery.of(context).size: 현재 디스플레이 화면 사이즈정보
// _size.width / 1.5: 현재 디스플레이 사이즈에 75%정도 크기로 설정
// Stack: 여러 위젯을 겹쳐서 관리할 때, 사용하는 위젯
// _rightSideMenu: 햄버거 버튼을 눌렀을 때, 오른쪽에서 튀어나오는 메뉴영역
// _profile: 바닥페이지 profile 영역

class _ProfileState extends State<Profile>{
  bool _menuOpenState = false; // 상단 햄버거 버튼 눌렀을 때, 사이드메뉴 오픈여부
  late Size _size; // size 변수
  late double menuWidth; // 메뉴가로길이
  int duration = 200; // 사이드 메뉴가 열리고 닫힐 시간

  @override
  Widget build(BuildContext context){
    _size = MediaQuery.of(context).size;
    menuWidth = _size.width / 1.5;
    return Scaffold(
      body: Stack(
        children: <Widget>[
          _rightSideMenu(),
          _profile(),
        ],
      ),
    );
  }

  Widget _rightSideMenu(){
    return AnimatedContainer(
      width: menuWidth,
      curve: Curves.linear,
      color: Colors.grey[200],
      duration: Duration(milliseconds: duration),
      transform: Matrix4.translationValues(
          _menuOpenState ? _size.width - menuWidth : _size.width, 0, 0),
      child: SafeArea(
        child: SizedBox(
          width: menuWidth,
          child: Column(
            mainAxisSize: MainAxisSize.max,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: <Widget>[
              TextButton(
                onPressed: null,
                child: Text(
                  'userName',
                  style: TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: 20.0
                  ),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }

// AnimatedContainer: 일정 시간동안 점차적으로 변화하는 애니메이션 위젯
// width: 해당 애니메이션을 적용할 가로크기지정
// curve: 애니메이션을 적용할 방식지정
// color: 적용할 위젯 색깔지정
// duration: 시간지정(얼마동안 애니메이션을 지속할지 Duration 위젯으로 지정)
// transform: 애니메이션을 어느형식으로 재생할지(x,y,z 지정, 오른쪽에서 왼쪽으로, 아래서 위로 등등)
// SafeArea: 보통 디스플레이에서 맨 위에 시간, 배터리 정보 등등 이랑 겹쳐서 보여지는데 SafeArea는 그런 정보 바로 아래서부터 보여주는 위젯


  Widget _profile(){
    return AnimatedContainer(
      curve: Curves.linear,
      color: Colors.transparent,
      duration: Duration(milliseconds: duration),
      transform: Matrix4.translationValues(_menuOpenState ? -menuWidth : 0, 0, 0),
      child: SafeArea(
        child: Column(
          children: <Widget>[
            _appBar(),
            _profileHeader(),
          ],
        ),
      ),
    );
  }

  Row _appBar() {
    return Row(
      children: <Widget>[
        Expanded(
          child: Padding(
            padding: const EdgeInsets.only(left: common_gap),
            child: Text(
              'userName',
              style: TextStyle(
                fontWeight: FontWeight.bold,
                fontSize: 20.0,
              ),
            ),
          ),
        ),
        IconButton(
            onPressed: () {
              setState(() {
                _menuOpenState = !_menuOpenState;
              });
            },
            icon: Icon(Icons.menu))
      ],
    );
  }

  Expanded _profileHeader() {
    return Expanded(
      child: CustomScrollView(
        slivers: <Widget>[
          SliverList(
            delegate: SliverChildListDelegate([
              _header(),
              _userName(),
              _profileComment(),
              _editProfile(),
            ]),
          )
        ],
      ),
    );
  }
// silvers: CustomScrollView의 자식들을 넣는 스크롤 가능영역의 설정속성
// SliverList: ListView와 비슷하게 동작하며 sliver 하위 위젯으로 사용하고 하위로 delegate속성을 사용한다.
// SliverChildListDelegate: delegate속성에 사용하는 위젯이며, List 적용 (List 이므로 [] 배열로 작성해준다.)

  Row _header() {
    return Row(
      children: <Widget>[
        Padding(
          padding: const EdgeInsets.all(common_gap),
          child: CircleAvatar(
            radius: 40,
            backgroundImage: NetworkImage(getProfileImgPath('userName')),
          ),
        ),
        Expanded(
          child: Table(
            children: [
              TableRow(children: [
                _getStatusValue('473'),
                _getStatusValue('8k'),
                _getStatusValue('45k'),
              ]),
              TableRow(children: [
                _getStatusLabel('Posts'),
                _getStatusLabel('Followers'),
                _getStatusLabel('Following'),
              ])
            ],
          ),
        )
      ],
    );
  }
  // CircleAvatar: 프로필 사진같은 아바타 적용 위젯
  // Table: 이름과 같이 테이블 형식의 데이터를 적용할 때, 사용
  // TableRow: Table 하위 자식으로 들어가며 위젯 하나당 한 줄씩 설정해줄 수 있음

  Center _getStatusValue(String value) => Center(
    child: Padding(
      padding: const EdgeInsets.symmetric(horizontal: common_s_gap),
      child: FittedBox(
        fit: BoxFit.scaleDown,
        child: Text(
          value,
          textAlign: TextAlign.center,
          style: TextStyle(fontWeight: FontWeight.bold),
        ),
      ),
    ),
  );
  Center _getStatusLabel(String value) => Center(
    child: Padding(
      padding: const EdgeInsets.symmetric(horizontal: common_s_gap),
      child: FittedBox(
        fit: BoxFit.scaleDown,
        child: Text(
          value,
          textAlign: TextAlign.center,
          style: TextStyle(fontWeight: FontWeight.w300),
        ),
      ),
    ),
  );
// Post, Followers, Following 영역을 만들어주는 자식들이며, FittedBox는 부모범위 안에서 자식위젯의 범위를 맞추는 위젯
// 자식이 데이터가 길어도 부모 영역을 벗어나지 않게 해준다.

  Padding _userName() {
    return Padding(
      padding: const EdgeInsets.only(left: common_gap),
      child: Text(
        'userName',
        style: TextStyle(fontWeight: FontWeight.bold),
      ),
    );
  }

  Padding _profileComment() {
    return Padding(
      padding: const EdgeInsets.only(left: common_gap),
      child: Text(
        '프로필을 만들고 수정하는 중!',
        style: TextStyle(fontWeight: FontWeight.w400),
      ),
    );
  }

  Padding _editProfile() {
    return Padding(
      padding: const EdgeInsets.all(common_gap),
      child: SizedBox(
        height: 24,
        child: Container(
            color: Colors.white,
            child: OutlinedButton(
              onPressed: (){},
              child: Text(
                'Edit profile',
                style: TextStyle(fontWeight: FontWeight.bold, color: Colors.black),
              ),
              style: OutlinedButton.styleFrom(
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(6),
                ),
                side: BorderSide(color: Colors.black45),
              ),
            )
        ),
      ),
    );
  }
// OutlineButton: border가 자동으로 잡혀있는 버튼입니다. 버튼을 흰색으로 만들기 위해 Container로 감싸고 white 색상을 줌
// RoundedRectangleBorder: border 모양을 변경해주기 위한 위젯
// BorderRadius.circular: border를 둥글게 만들어 주기위한 메소드 (안에 숫자가 커질수록 둥글어짐

}

// End the Class Profile
