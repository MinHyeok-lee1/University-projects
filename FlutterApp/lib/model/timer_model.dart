import 'dart:async';

class MilliTimer {
  late Timer _timer;
  late Timer _timer0;
  late Timer _timer1;
  late Timer _timer2;
  late Timer _timer3;
  late Timer _timer4;
  late Timer _timer5;
  late Timer _timer6;
  late Timer _timer7;
  late Timer _timer8;

  var _time = 0; // 실제 늘어날 시간

  // 1/1000초에 한 번씩 time 1씩 증가
  void start() {
      _timer = Timer.periodic(const Duration(milliseconds: 9), (timer) {
        _time++;
      });
      _timer0 = Timer.periodic(const Duration(milliseconds: 9), (timer) {
        _time++;
      });
      _timer1 = Timer.periodic(const Duration(milliseconds: 9), (timer) {
        _time++;
      });
      _timer2 = Timer.periodic(const Duration(milliseconds: 9), (timer) {
        _time++;
      });
      _timer3 = Timer.periodic(const Duration(milliseconds: 9), (timer) {
        _time++;
      });
      _timer4 = Timer.periodic(const Duration(milliseconds: 9), (timer) {
        _time++;
      });
      _timer5 = Timer.periodic(const Duration(milliseconds: 10), (timer) {
        _time++;
      });
      _timer6 = Timer.periodic(const Duration(milliseconds: 10), (timer) {
        _time++;
      });
      _timer7 = Timer.periodic(const Duration(milliseconds: 10), (timer) {
        _time++;
      });
      _timer8 = Timer.periodic(const Duration(milliseconds: 10), (timer) {
        _time++;
      });
  }

  // 초기화
  void reset() {
      cancel();
      _time = 0;
  }

  // 기록하기
  double saveTime() {
    var sec = _time / 1000; // 초

    return sec;
  }

  void cancel(){
    _timer.cancel();
    _timer0.cancel();
    _timer1.cancel();
    _timer2.cancel();
    _timer3.cancel();
    _timer4.cancel();
    _timer5.cancel();
    _timer6.cancel();
    _timer7.cancel();
    _timer8.cancel();
  }
}

class SecTimer{
  late Timer _timer;

  var _time = 0; // 실제 늘어날 시간
// 1/1000초에 한 번씩 time 1씩 증가
  void start() {
    _timer = Timer.periodic(const Duration(seconds: 1), (timer) {
      _time++;
    });
  }


  // 초기화
  void reset() {
    cancel();
    _time = 0;
  }

  // 기록하기
  int saveTime() {
    var sec = _time; // 초

    return sec;
  }

  void cancel(){
    _timer.cancel();
  }

}