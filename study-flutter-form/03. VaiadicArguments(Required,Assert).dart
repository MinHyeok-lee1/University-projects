import 'package:flutter/material.dart';

void main() {
  String my_name = 'MinHyeok';
  int my_age = 25;
  String my_location = "Daejeon";

  // 기존의 함수 호출방법법
  // 메인함수에서 Class_A의 생성자를 호출할 때, 생성자의 아규먼트 타입과 순서에 맞게 파라미터를 설정
  Class_A class_A = Class_A(my_name, my_age);
  class_A.printInfo();

  // Class_B의 생성자를 보면 생성자의 구현부분은 없고, 아규먼트 설정부분에서 줄괄호 안에 this 키워드를 통해 바로 필드값을 채움
  Class_B class_B = Class_B(age: my_age, name: my_name);
  class_B.printInfo();

  // 첫번째 생성자 호출에서는 3개의 파리미터를 모두 전달했지만 두번째와 세번째에서는 일부만을 전달
  Class_C class_c1 = Class_C(name: my_name, age: my_age, location: my_location);
  class_c1.printInfo();
  Class_C class_c2 = Class_C(age: my_age, location: my_location);
  class_c2.printInfo();
  Class_C class_c3 = Class_C(name: my_name);
  class_c3.printInfo();

  //  기본의 방식과 가변인자 방식을 혼용하거나 특정 아규먼트는 꼭 채우도록 함(my_location)
  Class_D class_d1 = Class_D(my_name, age: my_age, location: my_location);
  class_d1.printInfo();
  Class_D class_d2 = Class_D(my_name, location: my_location);
  class_d2.printInfo();
}

class Class_A {
  var name;
  var age;

  Class_A(String name, int age) {
    this.name = name;
    this.age = age;
  }

  void printInfo() {
    print('<Class_A> name: $name, age: $age');
  }
}

class Class_B {
  var name;
  var age;

  Class_B({this.name, this.age});

  void printInfo() {
    print('<Class_B> name: $name, age: $age');
  }
}

class Class_C {
  var name;
  var age;
  var location;

  Class_C({this.name, this.age, this.location});

  void printInfo() {
    print('<Class_C> name: $name, age: $age, location: $location');
  }
}

class Class_D {
  var name;
  var age;
  var location;

  Class_D(String name, {this.age, @required this.location})
  /* assert없이 @required로만 하면 null로 채워짐 -> 에러를 띄워서 강제하려면 assert를 사용해야 한다. */
      : assert(location != null) {
    this.name = name;
  }

  void printInfo() {
    print('<Class_D> name: $name, age: $age, location: $location');
  }
}
