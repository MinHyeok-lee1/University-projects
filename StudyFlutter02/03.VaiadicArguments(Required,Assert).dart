import 'package:flutter/material.dart';

void main() {
  String my_name = 'Park';
  int my_age = 39;
  String my_location = "Daejeon";

  Class_A class_A = Class_A(my_name, my_age);
  class_A.printInfo();

  Class_B class_B = Class_B(age: my_age, name: my_name);
  class_B.printInfo();

  Class_C class_c1 = Class_C(name: my_name, age: my_age, location: my_location);
  class_c1.printInfo();
  Class_C class_c2 = Class_C(age: my_age, location: my_location);
  class_c2.printInfo();
  Class_C class_c3 = Class_C(name: my_name);
  class_c3.printInfo();

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
      : assert(location != null) {
    this.name = name;
  }

  void printInfo() {
    print('<Class_C> name: $name, age: $age, location: $location');
  }
}