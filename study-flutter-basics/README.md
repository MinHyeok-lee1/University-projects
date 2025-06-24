# study-flutter-basics

A series of beginner-to-intermediate Flutter tutorials.

## Topics

- Basic widgets
- Navigation
- Animations
- Snackbar, Drawer, Themes
- Networking, JSON parsing

## Folder Structure

- Each numbered `.dart` file is a tutorial step
- Includes image and font assets

## Study Flutter - Basic

If you look at the source code, the main function of the Flutter language is the starting point of the program.
The main function calls the runApp function to run the app, and the logic that will run is described directly inside the runApp function.
The Center function is a function that allows you to configure the center part of the screen. And it actually constructs the center of the screen using the child entry inside the Center function. It uses the Text function to add text to the child entry, and it describes the textDirection property that sets the description order of the text along with the text to be output as a parameter.
ltr is an abbreviation for left to right, which means that it is described from left to right.

1. main function  
   Start the app from the main function to the runApp function. To use the Material app using the Material UI provided by Flutter, call the MaterialApp function from the runApp function. You set "My App" as the title attribute, and use the home attribute to create and call the MyScaffold class.
2. MyScaffold Class  
   The MyScaffold class is a class called in the home property of the MaterialApp function of the main function.
   MyScaffold is a class that inherits StatelessWidget and returns the material through the build function. Matreal is the basic unit that makes up a matreal app.
   This matrix has a column as a single child. The column can vertically organize a UI. The column has two widgets again as children.
   MyAppBar, the first child, is implemented in a separate class as a component of what will appear at the top of this app.
   The second child, Expanded, has Center as a child, and Center has Text as a child again, so it is responsible for printing text to the center of the app.
3. MyAppBar Class  
   The MyAppBar class is called by the Build function of the MyScaffold class to decorate the top of the app.
   The MyAppBar class is also a class that inherits StatelessWidget, creating and returning a container through the build function. The container can comprise square-shaped elements.
   The MyAppBar class is created/called by the Build function of the MyScaffold class, which stores the Titles taken over in the internal field during the generator call.
   The height of the container, internal padding, and the color of the container are set through the height, padding, and decoration items.
   You have Row as a single child, and Row allows you to horizontally configure widgets. Row's children are IconButton, Expanded, and IconButton.
   The icon buttons, which are the first and third children, are set to menu icons and search icons, and are set to null in the onPressed item, so there is no logic that runs even if you click the icon.
   Because the second child is set to Expanded, all but the first and third icon buttons are assigned to Expanded's area, and Expanded is configured with the Title widget that was taken over when the MyAppBar class was created.
4. main function  
   Create and run MaterialApp through the runApp function. Assign a Tutorial Home class as a home widget in the MATRIAL App.
   Tutorial Home Class
   This class creates and returns a Scaffold widget corresponding to the home widget of the matreal app created by the main function. The sub-items of the Scaffold widget used in this app are as follows.
   appBar: bar-shaped widgets displayed at the top of the app
   body: Widgets output in the center of the app
   floatingActionButton: a circular widget floating above the content that makes up the app
   The appBar of this app is configured using the AppBar widget, and the sub-items of the AppBar widget used in this app are as follows.
   leading: Widgets that are output before the title widget
   Title: Key widgets displayed in the app bar
   actions: Widgets that are output after the title widget

- old code

```dart
final ScreenArguments args = routeSettings.arguments;

Scaffold.of(context)
..removeCurrentSnackBar()
..showSnackBar(SnackBar(content: Text('$result')));

Key key
@required this.todos
```

- new code

```dart
final args = routeSettings.arguments as ScreenArguments;

ScaffoldMessenger.of(context)
..removeCurrentSnackBar()
..showSnackBar(SnackBar(content: Text('$result')));

Key ? key
required this.todos
```
