import 'package:flutter/material.dart';

// Todo 리스트의 아이템을 저장할 자료 구조
class Todo{
  // final로 정의된 필드는 선언단계나 생성자를 통해 초기화해야함
  final String title;
  final String description;

  Todo(this.title, this.description); // 생성자로 필드 초기화
}

void main() {
  runApp(
    MaterialApp(
      title: 'Passing Data',
      debugShowCheckedModeBanner: false,
      home: TodosScreen(
        // TodosScreen 스크린을 홈으로 설정
        // Todo 타입의 아이템을 20개 List로 생성하여 전달
        todos: List.generate(
        20, // 생성할 아이템 갯수
          (i) => Todo(
            'Todo $i',
              'A description of what needs to be done for Todo $i'),
          ),
      ), // HomeScreen을 홈으로 설정
    ));
}

// 초기 스크린
class TodosScreen extends StatelessWidget{
  final List<Todo> todos; // Todo 아이템 리스트

  TodosScreen({Key ? key, required this.todos}) : super(key: key);

  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(
        title: Text('Todos'),
      ),
      // body에 리스트뷰 등록
      body: ListView.builder(
          itemCount: todos.length,
          itemBuilder: (context, index){
            // ListTitle을 반환
            return ListTile(
              title: Text(todos[index].title),
              // ListTitle은 onTap과 onLongPress를 저원함
              onTap:(){
                // ListTitle이 탭되면 DetailScreen 스크린을 적재
                Navigator.push(
                  context,
                  MaterialPageRoute(
                      builder: (context) => DetailScreen(todo: todos[index]),
                  ),
                );
              },
            );
          },
      ),

    );
  }
}

// 리스트뷰를 탭했을 때 출력되는 스크린 위젯 클래스
class DetailScreen extends StatelessWidget {
  final Todo todo;

  // 생성자로 아이템을 수신하여 필드에 저장
  const DetailScreen({Key ? key, required this.todo}): super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(todo.title)), // 아이템의 title로 title 구성
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Text(todo.description), // 아이템의 설명으로 body 구성
      ),
    );
  }
}
