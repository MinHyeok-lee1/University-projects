import 'package:flutter/material.dart';

void main() => runApp(new MyApp());


class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    // 본 앱의 테마 대표색상 필드에 저장
    Color color = Theme.of(context).primaryColor;
    // 버튼 로우 구성을 위한 컨테이너 위젯
    Widget buttonSection = Container(
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly, // 자식들이 여유 공간을 공평하게 나눔
        children: <Widget>[
          _buildButtonColumn(color, Icons.call, 'CALL'),
          _buildButtonColumn(color, Icons.near_me, 'ROUTH'),
          _buildButtonColumn(color, Icons.share, 'SHARE'),
        ],
      ),
    );

    return MaterialApp(
        debugShowCheckedModeBanner: false,
        title: 'StatefullWidget',
        theme: ThemeData(primarySwatch: Colors.red),
        home: Scaffold(
          appBar: AppBar(
            title: Text('Layout Demo'),
          ),
          body: Column(
            children: <Widget>[
              Image.asset(
                'images/lake.jpg',
                width: 600,
                height: 240,
                fit: BoxFit.cover,
              ),
              titleSection,
              buttonSection,
              textSection,
            ],
          ),
        )
    );
  }

  // 컨테이너 위젯
  Widget titleSection = Container(
    // 컨테이너 내부 상하좌우 32px 패딩
    padding: const EdgeInsets.all(32),
    child: Row(
      children: <Widget>[
        //컬럼의 첫번째 자식 컨테이너
        Expanded(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start, // 자식들을 왼쪽정렬
            // 컬럼의 자식들로 컨테이너와 텍스트 추가
            children: <Widget>[
              Container(
                padding: const EdgeInsets.only(bottom: 8),
                child: Text(
                  "Oeschinen Lake Campground",
                  style: TextStyle(
                      fontWeight: FontWeight.bold
                  ),
                ),
              ),
              Text(
                'Kandersteg,Switzerland',
                style: TextStyle(
                    color: Colors.grey[500]
                ),
              ),
            ],
          ),
        ),

        /*Icon(
          Icons.star,
          color: Colors.red[500],
        ),
        // 세번째 자식
        Text('43')*/

        FavoriteWidget()
      ],
    ),
  );

  Column _buildButtonColumn(Color color, IconData icon, String label) {
    return Column(
      mainAxisSize: MainAxisSize.min, // 여유공간 최소로 할당
      mainAxisAlignment: MainAxisAlignment.center, // 가운데 정렬
      // 컬럼의 자식들로 아이콘과 컨테이너 등록
      children: <Widget>[
        Icon(
          icon,
          color: color,
        ),
        Container(
          margin: const EdgeInsets.only(top: 8),
          child: Text(
            label,
            style: TextStyle(
                fontSize: 12,
                fontWeight: FontWeight.w400,
                color: color
            ),
          ),
        )
      ],
    );
  }

  // 텍스트로 구성된 컨테이너를 구현하는 위젯
  Widget textSection = Container(
    padding: const EdgeInsets.all(32),
    child: Text(
      'Lake Oeschinen lies at the foot of the Blüemlisalp in the Bernese '
          'Alps. Situated 1,578 meters above sea level, it is one of the '
          'larger Alpine Lakes. A gondola ride from Kandersteg, followed by a '
          'half-hour walk through pastures and pine forest, leads you to the '
          'lake, which warms to 20 degrees Celsius in the summer. Activities '
          'enjoyed here include rowing, and riding the summer toboggan run.',
      softWrap: true, // 텍스트가 영역을 넘어갈 경우 줄바꿈 여부
    ),
  );
}
  class FavoriteWidget extends StatefulWidget{
    @override
    _FavoriteWidgetState createState() => _FavoriteWidgetState();
  }

  class _FavoriteWidgetState extends State<FavoriteWidget>{
    bool _isFavorited = true;
    int _favoriteCount = 41;

    @override
    Widget build(BuildContext context){
      return Row(
        mainAxisSize: MainAxisSize.min,
        children: <Widget>[
          // 컨테이너 생성
            Container(
              padding: EdgeInsets.all(0),
              child: IconButton(
                icon: (_isFavorited ? Icon(Icons.star) : Icon(Icons.star_border)),
                color: Colors.red[500],
                onPressed: _toggleFavorite,
              ),
            ),
          // 텍스트를 출력하는 SizedBox 추가
          SizedBox(
            width: 18,
            child: Container(
              child: Text('$_favoriteCount'),
            ),
          )
         ],
      );
    }

    // 아이콘 버튼 클릭시
    void _toggleFavorite(){
      setState((){
        if(_isFavorited){
          _favoriteCount--;
          _isFavorited = false;
        }else{
          _favoriteCount++;
          _isFavorited = true;
        }
      });
    }
}
