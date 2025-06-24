import 'package:flutter/material.dart';


void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: Center(
          child: MySecondButtons(),
        ),
      ),
    );
  }
}

class MySecondButtons extends StatefulWidget {
  @override
  _MySecondButtonsState createState() => _MySecondButtonsState();
}

enum MenuType { first, second, third }

extension ParseToString on MenuType {
  String toShortString() {
    return this.toString().split('.').last;
  }
}

class _MySecondButtonsState extends State<MySecondButtons> {
  List<bool> _selections1 = List.generate(3, (index) => false);
  List<bool> _selections2 = List.generate(3, (index) => false);

  late MenuType _dropdownValue;
  late MenuType _selection;

  @override
  void initState() {
    super.initState();
    _dropdownValue = MenuType.first;
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        Labeled(
          title: "ToggleButtons",
          child: ToggleButtons(
            children: <Widget>[
              Icon(Icons.ac_unit),
              Icon(Icons.call),
              Text("WIFI"),
            ],
            onPressed: (int index) {
              setState(() {
                _selections1[index] = !_selections1[index];
              });
            },
            isSelected: _selections1,
          ),
        ),
        Labeled(
          title: "ToggleButtons",
          child: RotatedBox(
            quarterTurns: 1,
            child: ToggleButtons(
              children: <Widget>[
                RotatedBox(quarterTurns: 3, child: Icon(Icons.circle)),
                RotatedBox(quarterTurns: 3, child: Icon(Icons.error_outline)),
                RotatedBox(quarterTurns: 3, child: Icon(Icons.wifi)),
              ],
              onPressed: (int index) {
                setState(() {
                  _selections2[index] = !_selections2[index];
                });
              },
              isSelected: _selections2,
            ),
          ),
        ),
        Labeled(
          title: "DropdownButton",
          child: DropdownButton(
            value: _dropdownValue,
            items: MenuType.values
                .map((value) => DropdownMenuItem(
              value: value,
              child: Text(value.toShortString()),
            ))
                .toList(),
            onChanged: (e){
              setState(() {
                _dropdownValue = e as MenuType;
              });
            },
            elevation: 4,
          ),
        ),
        Labeled(
          title: "PopupMenuButton",
          child: PopupMenuButton<MenuType>(
            icon: Icon(Icons.settings),
            onSelected: (MenuType result) {
              setState(() {
                _selection = result;
              });
            },
            itemBuilder: (BuildContext context) => MenuType.values
                .map((value) => PopupMenuItem(
              value: value,
              child: Text(value.toShortString()),
            ))
                .toList(),
          ),
        )
      ],
    );
  }
}

class Labeled extends StatelessWidget {
  final String title;
  final Widget child;
  Labeled({required this.title, required this.child});

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          title,
          style: Theme.of(context).textTheme.bodyText1,
        ),
        SizedBox(width: 30),
        child,
      ],
    );
  }
}
