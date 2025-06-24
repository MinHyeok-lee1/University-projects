#include <SoftwareSerial.h> //시리얼 통신 라이브러리 호출
//Bluetooth 모듈 HC-06 Test Program
// Android APP is BT Chat App
#include <DFPlayer_Mini_Mp3.h> // DFPlayer Mp3_Mini 라이브러리 호출

// define mp3 module
SoftwareSerial mp3Serial(17, 16); // RX, TX

//define MoterPin(Er Bar) 한바퀴에 0.8cm
#define ENA_PIN 4
#define DIR_PIN 3
#define STP_PIN 2
#define sw_s 5 // 전자석 위치 Default sw
#define default_h 38

#define tact_1 28 // 전자석 탈부착 : 평상시 1 / 눌림 0
#define tact_2 26 // 하차
#define tact_3 24 // 벨트

// 실린더 정의
int sil = 52;
int sil2 = 50;

int magnet = 48;

int save = 0;
int height; // 높이

int chairstate = 0; // 의자 상태
int mag = 0; // 전자석 탈부착
//define Bluetooth Modlue

int blueTx = 18; //Tx (보내는핀 설정)
int blueRx = 19; //Rx (받는핀 설정)
String myString = ""; //받는 문자열
String input = "";
int sp = 0;
int number = 0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  Serial1.begin(9600);
  mp3Serial.begin (9600);

  pinMode(magnet, OUTPUT);
  digitalWrite(magnet, HIGH);

  pinMode(ENA_PIN, OUTPUT);
  pinMode(DIR_PIN, OUTPUT);
  pinMode(STP_PIN, OUTPUT);
  pinMode(sw_s, INPUT_PULLUP);

  pinMode(sil, OUTPUT);
  pinMode(sil2, OUTPUT);
  digitalWrite(sil, HIGH);
  digitalWrite(sil2, HIGH);

  digitalWrite(ENA_PIN, LOW);
  digitalWrite(DIR_PIN, LOW);

  //set softwareSerial for DFPlayer-mini mp3 module
  mp3_set_serial (mp3Serial);
  delay(1); // delay 1ms to set volume
  mp3_set_volume (28); // value 0~30

  // 전자석 탈부착 1, 하차 2, 벨트 인식 스위치들 3
  pinMode(tact_1, INPUT);
  pinMode(tact_2, INPUT);
  pinMode(tact_3, INPUT);

  Serial.write("q");
  // set magnetic pos : "0"
  chairstate = 0; // 의자 상태

  reset();
  resetC();
}

void loop() {
  // put your main code here, to run repeatedly:
  while (Serial1.available()) {
    char myChar = (char)Serial1.read();  //mySerial int형식의 값을 char형식으로 변환
    myString += myChar; //수신되는 문자열을 myString에 모두 붙임 (1바이트씩 전송되는 것을 모두 붙임)
    delay(5);           //수신 문자열 끊김 방지
    //    Serial.write(Serial1.read());
  }
  //  // Serial –> Data –> BT
  //  if (Serial.available()) {
  //    Serial1.write(Serial.read());
  //  }

  //  if (mySerial.available()) {
  //    Serial.write(mySerial.read());
  //  }
  //  if (Serial.available()) {
  //    mySerial.write(Serial.read());
  //  }
  //
  // 1) Android Input(a1, a2, b1, b2, g1, g2, c, "nn")

  if (!myString.equals("")) { // 값이 있다면
    input = myString;
    Serial.println(input); //시리얼모니터에 myStlring값 출력

    if (input == "a1") {
      save = 0; // 임산부석 A1
    }
    else if (input == "a2") {
      save = 0; // 임산부석 A2
    }
    else if (input == "b1") {
      save = 1; // 일반 휠체어
    }
    else if (input == "b2") {
      save = 1; // 전자석 휠체어
    }
    else if (input == "g1") {
      mp3_play(1);   //0001 파일 플레이, 다음 정류장에 좌석이 예약되었습니다. 교통약자분들을 위해 자리를 비워주세요.
      delay(7000);
      // mp3_stop();
    } else if (input == "g2") {
      // g2 신호 시에 save == 1이면 전자석 휠체어이다.
      if (save == 1) {
        chairstate = 1; // 의자 상태
        mp3_play(2);    //0002 파일 플레이, 이번 정류장에 좌석이 예약되었습니다. 좌석이 곧 올라가니 주의하여 주세요.
        delay(6000);

        //

        digitalWrite(sil, HIGH);
        digitalWrite(sil2, HIGH);
        delay(100);
        digitalWrite(sil, HIGH);
        digitalWrite(sil2, LOW);
        // 실린더를 제어해서 좌석 올라가는 코드
        mag = 0;
      } else {
        mp3_play(3);//0003 파일 플레이, 이번 정류장에 좌석이 예약되었습니다. 교통약자분들을 위해 자리를 비워주세요.
        Serial.write("a1");
        delay(7000);

        //    mp3_stop();
      }
      //    mp3_stop();
    } else if (input == "c") {
      if (save == 1 && chairstate == 1) { //-> save == 1이면 전자석 휠체어임
        chairstate = 0; // 의자 상태

        // Serial.write("x");
        mp3_play(5);    //0005 곧 좌석이 내려갑니다. 주변에 계신분들은 주의해주시기 바랍니다.
        delay(6000);

        reset();
        resetC();
        //    mp3_stop();
      } else {
        // Serial.write("q");

        chairstate = 0; // 의자 상태
        reset();
        resetC();
      }
      save = 0;
    } else {
      number = myString.toInt();
      int h = height - number; // height가 기준이면 음수가 증가 number가 기준이면 양수가 증가이기 떄문에 음수가 up();
      int t = 0;

      //nR : 차이
      if (h < 0) {
        h = h * (-1);

        while (t <= h) {
          up();
          t++;
        }

      } else if (h > 0) {
        while (t <= h) {
          down();
          t++;
        }
      }

      height = number;
    }
    myString = ""; //myString 변수값 초기화
  }

  // 전자석 탈부착 = 1, 하차 = 2, 벨트 인식 스위치들 = 3
  int n1 = digitalRead(tact_1);
  int n2 = digitalRead(tact_2);
  int n3 = digitalRead(tact_3);

  // Default: 101
  if ((n1 == 0 || n3 == 0) && chairstate == 1 && mag == 0 && n2 == 0) {
    mag = 1;
    Serial.write("q");
    Serial1.write("f");
    // Serial –> Data –> BT
    //    if (Serial.available()) {
    //      Serial1.write("f");
    //      Serial.write("f");
    //    }

    //    Serial1.write("f");
  }
  // && n1 == 0 //  // 전자석 탈부착 1 = n1 , 하차 = 2, 벨트 인식 스위치들 3          // 하차 ON 전자석 ON
  if (mag == 1 && n2 == 1 && chairstate == 1) {
    Serial.write("x");
    digitalWrite(magnet, LOW);
    mp3_play(5);    //0005 -> 원래는 6초
    delay(10000);
    chairstate = 0; // 의자 상태
    mag = 0;

    reset();
    resetC();
    digitalWrite(magnet, HIGH);
  } else if (n2 == 1  && mag ==  0 && chairstate == 0) {
    sp = 1;
    mag = 1;
    chairstate = 1; // 의자 상태
    Serial.write("x");
    mp3_play(6);    //0006 곧 좌석이 올라갑니다. 주변에 계신분들은 주의해주시기 바랍니다.
    delay(6000);
    digitalWrite(sil, HIGH);
    digitalWrite(sil2, HIGH);
    delay(100);
    digitalWrite(sil, HIGH);
    digitalWrite(sil2, LOW);
    // 실린더를 제어해서 좌석 올라가는 코드
  } else if (n2 == 1  && mag ==  0 && chairstate == 1 && sp == 1) {
    Serial.write("x");
    mp3_play(5);    //0005 -> 원래는 6초
    delay(10000);
    chairstate = 0; // 의자 상태
    mag = 0;
    sp = 0;

    reset();
    resetC();
  }

//  if(chairstate == 1 && n3 == 0)

  //  if(sp == 1 &&  n2 == 1){
  //
  //  }


  // if() => 벨트가 붙었을 때, 전자석이 붙었을 때 -> Ok Signal Arduino to Android : mySerial.write("ok");
  // if() => 벨트가 붙었을 때, 전자석이 떼졌을 때 ->  Led가 꺼지기만 하면되구요 mp3_play(4);    //0004 파일 플레이, 좌석 예약이 취소되었습니다. 좌석이 곧 내려가니 주의하여 주세요. delay(6000); + 추가) 실린더를 제어해서 좌석 내려가는 코드


  // 2) Neopiexel ON, OFF(a1, a2 = PinkColor, b1, b2 = BlueColor)
  // on(save); off();

  // 3) Mp3 Module ON -> 1) Android Input(a1, a2, b1, b2, g1, g2)
  // mp3_play();

  // 4) Ok Signal, Cancel Signal Android to Arduino : Input ("ok" or "c")
  // Input "ok" or "C"

  // 5) Ok Signal Arduino to Android : mySerial.write("ok");
}


void up()
{
  if (height < (default_h + 28)) {

    height += 1;
    //
    //    Serial.print("상승 / 현재 높이 : ");
    //    Serial.println(height);


    digitalWrite(DIR_PIN, LOW);

    for (int i = 0; i < 248; i++)
    {
      digitalWrite(STP_PIN, HIGH);
      delayMicroseconds(500);
      digitalWrite(STP_PIN, LOW);
      delayMicroseconds(500);
    }
  }

  //  else
  //  {
  //    Serial.print("상승 불가! / 현재 높이 : ");
  //    Serial.println(height);
  //  }

}


void down()
{
  if (height > default_h) {

    height -= 1;
    //
    //    Serial.print("하강 / 현재 높이 : ");
    //    Serial.println(height);


    digitalWrite(DIR_PIN, HIGH);

    for (int i = 0; i < 248; i++)
    {
      digitalWrite(STP_PIN, HIGH);
      delayMicroseconds(500);
      digitalWrite(STP_PIN, LOW);
      delayMicroseconds(500);
    }
  }
  //
  //  else
  //  {
  //    Serial.print("하강 불가! / 현재 높이 : ");
  //    Serial.println(height);
  //  }



}


void reset()
{
  int sw = digitalRead(sw_s);

  while (1) {

    sw = digitalRead(sw_s);

    if (sw == 0) {
      height = default_h;

      break;
    }

    digitalWrite(DIR_PIN, HIGH);

    digitalWrite(STP_PIN, HIGH);
    delayMicroseconds(500);
    digitalWrite(STP_PIN, LOW);
    delayMicroseconds(500);
  }
}

void resetC()  // 의자 위치 초기화(내려가는 함수)
{
  digitalWrite(sil, HIGH);
  digitalWrite(sil2, HIGH);
  delay(100);
  digitalWrite(sil, LOW);
  digitalWrite(sil2, HIGH);
}
