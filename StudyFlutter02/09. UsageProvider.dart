import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() => runApp(MyApp());

class BankAccount with ChangeNotifier{
  int _balance = 0;

  int getBalance() => _balance;

  void increment(int value){
    _balance += value;
    notifyListeners();
  }

  void decrement(int value){
    _balance -= value;
    notifyListeners();
  }
}

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return MultiProvider(providers: [
      ChangeNotifierProvider<BankAccount>(create: (_) => BankAccount()),
      Provider<String>.value(value: "MinHyeok")
    ],
      child: MaterialApp(
        title: "Provider Test",
        home: HomePage(),
      ),
    );
  }
}

class HomePage extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    BankAccount bankAccount = Provider.of<BankAccount>(context);
    String name = Provider.of<String>(context);

    return Scaffold(
      appBar: AppBar(title: Text("Provider Test")),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text("Your Name is '$name'"),
            Text("Your balance is ${bankAccount.getBalance()}"),
            Text('\n'),
            ElevatedButton(
                onPressed: (){
                  Navigator.push(context,
                      MaterialPageRoute(builder: (context) => TestSFW()));
                },
                child: Text("Test with StatefulWidget")
            ),
            Text('\n'),
            ElevatedButton(
                onPressed: (){
                  Navigator.push(context,
                      MaterialPageRoute(builder: (context) => TestSLW()));
                },
                child: Text("Test with StatelessWidget")
            ),
          ],
        ),
      ),
    );
  }
}

class TestSFW extends StatefulWidget{
  @override
  TestSFWState createState() => TestSFWState();
}

class TestSFWState extends State<TestSFW>{
  @override
  Widget build(BuildContext context){
    BankAccount bankAccount = Provider.of<BankAccount>(context);
    String name = Provider.of<String>(context);
    
    print("build method of TestSFW");

    return Scaffold(
      appBar: AppBar(title: Text("SFW with Provider")),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Text("Your Name is '$name'"),
              Text("Your balance is ${bankAccount.getBalance()}"),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  ElevatedButton(
                    onPressed: (){
                      bankAccount.increment(1);
                    },
                    child: Text("+1"),
                  ),

                  ElevatedButton(
                    onPressed: (){
                      bankAccount.increment(10);
                    },
                    child: Text("+10"),
                  ),

                  ElevatedButton(
                    onPressed: (){
                      bankAccount.increment(100);
                    },
                    child: Text("+100"),
                  ),

                  ElevatedButton(
                    onPressed: (){
                      bankAccount.decrement(1);
                    },
                    child: Text("-1"),
                  ),

                  ElevatedButton(
                    onPressed: (){
                      bankAccount.decrement(10);
                    },
                    child: Text("-10"),
                  ),

                  ElevatedButton(
                    onPressed: (){
                      bankAccount.decrement(100);
                    },
                    child: Text("-100"),
                  ),
                ].map((child) {
                  return Container(
                    margin: const EdgeInsets.symmetric(horizontal: 5),
                    width: 50,
                    child: child,
                  );
                }).toList(),
              )
            ],
          ),
        )
      ),
    );
  }
}

class TestSLW extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    BankAccount bankAccount = Provider.of<BankAccount>(context);
    String name = Provider.of<String>(context);

    print("build method of TestSLW");

    return Scaffold(
      appBar: AppBar(title: Text("SLW with Provider")),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text("Your Name is '$name'"),
            Text("Your balance is ${bankAccount.getBalance()}"),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                ElevatedButton(
                  onPressed: (){
                    bankAccount.increment(1);
                  },
                  child: Text("+1"),
                ),

                ElevatedButton(
                  onPressed: (){
                    bankAccount.increment(10);
                  },
                  child: Text("+10"),
                ),

                ElevatedButton(
                  onPressed: (){
                    bankAccount.increment(100);
                  },
                  child: Text("+100"),
                ),

                ElevatedButton(
                  onPressed: (){
                    bankAccount.decrement(1);
                  },
                  child: Text("-1"),
                ),

                ElevatedButton(
                  onPressed: (){
                    bankAccount.decrement(10);
                  },
                  child: Text("-10"),
                ),

                ElevatedButton(
                  onPressed: (){
                    bankAccount.decrement(100);
                  },
                  child: Text("-100"),
                ),
              ].map((child) {
                return Container(
                  margin: const EdgeInsets.symmetric(horizontal: 5),
                  width: 50,
                  child: child,
                );
              }).toList(),
            )
          ],
        ),
      ),
    );
  }
}
