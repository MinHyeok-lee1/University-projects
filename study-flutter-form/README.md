# StudyFlutter02

Intermediate Flutter exercises with focus on state, navigation, and architecture.

## Topics

- Provider pattern
- Infinite scrolling lists
- Layout builder
- Bottom navigation
- Simple apps: Quiz, Business Card, Instagram UI

## Folder Structure

- Numbered Dart files for each lesson
- Includes zipped and image/font assets

## StudyFlutter - Diff

In Flutter, the app is executed by handing over instances of classes (more precisely widgets) to configure the screen with parameters of the runApp function.

If you look at MyApps created/called by runApp functions, they inherit the StatelessWidget class. Widget and StatefulWidget exist as widgets that can be used to configure the screen in Flutter.

In this course, let's just understand that Stateless Widget is used to compose a screen that does not need to be changed once it is decorated, and Stateful Widget is used when the screen can be reconstructed if necessary.

In this course, you only need to print the phrase Hello World, so use StatelessWidget. If you inherit the StatelessWidget class, you must re-implement the build method. First, let's look at the declaration form of the build method.

Since the type of the half patient is Widget, it can be inferred that the build method configures and returns the widget and that the returned widget is scattered on the screen. Understand that the instance context of the Build Context that is taken over as an assembly is an instance of that widget.

Looking at the internal configuration, instances of MaterialApp are created and returned through the creator of the MaterialApp class. If you look inside the creator, you are calling the creator of the Scaffold class again. This method would feel unfamiliar to existing Java developers. In my case, yes. These patterns are used a lot in Flutter. Or, most of them feel like they are used this way.

Still, if you solve it step by step, you can understand it.

In the build method, I want to create an instance of the MaterialApp class and return it.

The creator of the MaterialApp is called to create an instance of the MaterialApp, and at this time, two parameters (titles, home) are handed over. In the existing language, a pattern of handing over parameters according to the form and order of the sub-element of the function or method (generator) to be called has been used. In the Flutter (More accurately, Dart) language, the order of sub-elements can be ignored by describing the property of the parameters to be handed over, and only the necessary property can be handed over. It is quite similar to how JSON objects are handled.

Returning to the source code, the class MaterialApp will have fields (properties) called Title and home, and the value of Title and home can be taken over through the creator.

Here, Title can store a one-line text phrase describing the MaterialApp, which in the case of Android is used as an indicator for the app. It is used as a text phrase displayed when checking a list of running apps.

The home item is an item that sets the widget that constitutes the screen of the app. In the source, an instance of a class called Scaffold is included in the creator. That is, it is drawn with instances and screens of the Scaffold class.

This time, let's learn about the Scaffold class. We are adding text through a Text function to a property called body to the creator of Scaffold.

Text is a widget in Flutter that outputs text on the screen. Set this text widget to body entry in Scaffold instance

The creator of the AppBar class (Widget) is substituted in Scaffold's appBar item. Meaning that you create an instance of the AppBar widget and add it to the appBar entry in Scaffold
The AppBar widget is located at the top of the app screen and provides various functions, but in this course, only the Title items are used. Use the Text widget to add text to the Title item

Understand the hierarchy well The AppBar widget was added to the inside of the Scaffold that makes up the screen with the appBar decorating the top of the Scaffold, and the Text widget was added as the title to this AppBar widget



In the case of the method method, it has a simple structure in which the method is called directly and the widget is returned directly. However, the class method is a method of calling the class creator, and the creator is a method with no return value. Therefore, the build method must be redefined to implement the widget to be returned


+ How to prevent screen rotation
Adding a screen package to a pubspec.yaml file
screen: ^0.0.5 #screen

Add Permission to AndroidManifest.xml File on Android
<usues-permission android:name="android.permission.WAKE_LOCK" />

Add Package
import 'package:flutter/services.dart';

Add the following code in the step before calling the runApp() function inside the main function
SystemChrome.setPreferredOrientations([DeviceOrientation.portraitUp]);

If you want to develop an app dedicated to landscape mode, you can use it exclusively for landscape mode if you set landscapeLeft or landscapeRight or both

15 to 19 Infinite Scroll View App + Save Favorites
