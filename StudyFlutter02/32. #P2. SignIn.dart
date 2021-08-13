import 'package:cached_network_image/cached_network_image.dart';
import 'package:flutter/material.dart';
import 'package:untitled/profile.dart';

// Start the SignIn class

class SignIn extends StatefulWidget{
  @override
  _SignInPageState createState() => _SignInPageState();
}

class _SignInPageState extends State<SignIn>{
  @override
  Widget build(BuildContext context){
    return SafeArea(
      child: Stack(
        children: <Widget>[
          SignInForm(),
          _goToSignUpPageBtn(context),
          //_scrollImage(),
        ],
      ),
    );
  }
}

Positioned _goToSignUpPageBtn(BuildContext context){
  return Positioned(
    left: 0,
    right: 0,
    bottom: 0,
    height: 40,
    child: TextButton(
      style: TextButton.styleFrom(
        side: BorderSide(
            color: Colors.grey,
          ),
      ),
      onPressed: null,
      child: RichText(
        textAlign: TextAlign.center,
          text: TextSpan(style: TextStyle(), children: <TextSpan>[
            TextSpan(
              text: 'Don\'t have an account?',
              style: TextStyle(
                fontWeight: FontWeight.w300,
                color: Colors.black54,
              ),
            ),
            TextSpan(
              text: ' Sign Up',
                style: TextStyle(
                fontWeight: FontWeight.bold,
                color: Colors.blue[600],
              )
            )
          ]),
      ),
    )
  );
  // Positioned: Stack의 위치를 조정하는 위젯
  // 'Dont\'t have an account?' 에서 \는 문자라는 것을 명시 ('표현)
}


class SignInForm extends StatefulWidget{
  @override
  _SignInFormState createState() => _SignInFormState();
}

class _SignInFormState extends State<SignInForm>{
  GlobalKey<FormState> _formKey = GlobalKey<FormState>();
  TextEditingController _emailController = TextEditingController();
  TextEditingController _pwController = TextEditingController();

  @override
  void dispose(){
    _emailController.dispose();
    _pwController.dispose();
    super.dispose();
  }

  @override
  Widget Build(BuildContext context){
    return Scaffold(

    );
  }
}
// End the SignIn class