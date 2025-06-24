#include <SoftwareSerial.h> //시리얼 통신 라이브러리 호출
#include <Adafruit_NeoPixel.h> // 네오픽셀 라이브러리 호출
#include <DFPlayer_Mini_Mp3.h> // DFPlayer Mp3_Mini 라이브러리 호출
// define mp3 module
SoftwareSerial mp3Serial(10, 11); // RX, TX

//define NeoPixel
#define PIN 6
#define NUM_LEDS 17
//create a NeoPixel strip
Adafruit_NeoPixel strip = Adafruit_NeoPixel(NUM_LEDS, PIN, NEO_GRB + NEO_KHZ800);
Adafruit_NeoPixel strip2 = Adafruit_NeoPixel(50, 7, NEO_GRB + NEO_KHZ800);

//define MoterPin(Er Bar) 한바퀴에 0.8cm
#define ENA_PIN 2
#define DIR_PIN 3
#define STP_PIN 4
#define sw_u 5
#define sw_d 6
char cmd;


//define Bluetooth Modlue
int blueTx = 2; //Tx (보내는핀 설정)
int blueRx = 3; //Rx (받는핀 설정)

String myString = ""; //받는 문자열
String input = "g"; //받은 문자와 비교해서 기능을 작동하는 열
SoftwareSerial mySerial(blueTx, blueRx);  //시리얼 통신을 위한 객체선언
String save = ""; // 블루투스로부터 수신받은 값

void setup() {
  //네오픽셀
  // for(int i=0;i<Pixels;i++)strip.setPixelColor(i,255,255,255); // 색 정보 저장 -> (A,R,G,B) A번째 RGB (0~255)만큼의 밝기.
  strip.begin();
  strip.show();

  strip2.begin();
  strip2.show();

  Serial.begin(9600); // 시리얼 모니터 개방
  while (!Serial) {
    ; // wait for serial port to connect. Needed for native USB port only
  }
  mp3_set_serial(mp3Serial);      // DFPlayer-mini mp3 module 시리얼 세팅
  delay(1);                     // 볼륨값 적용을 위한 delay
  mp3_set_volume(30);          // 볼륨조절 값 0~30

  //모터
  pinMode(ENA_PIN, OUTPUT);
  pinMode(DIR_PIN, OUTPUT);
  pinMode(STP_PIN, OUTPUT);
  pinMode(sw_u, INPUT_PULLUP);
  pinMode(sw_d, INPUT_PULLUP);

  digitalWrite(ENA_PIN, LOW);
  digitalWrite(DIR_PIN, LOW);
}

void loop() {
  mySerial.begin(9600); //블루투스 시리얼 개방
  
  //블루투스 통신 코드
  while (mySerial.available()) //mySerial 값이 있으면
  {
    char myChar = (char)mySerial.read();  //mySerial int형식의 값을 char형식으로 변환
    myString += myChar; //수신되는 문자열을 myString에 모두 붙임 (1바이트씩 전송되는 것을 모두 붙임)
    delay(5);           //수신 문자열 끊김 방지
  }


  // 기본적으로 마지막으로 초기화 된 포트는 수신 대기합니다.
  // 포트에서 수신하려면 명시 적으로 선택합니다.
  mySerial.listen ();
  Serial.println ( "1 번 포트의 데이터 :");
  // 들어오는 데이터가있는 동안 읽습니다.
  // 하드웨어 직렬 포트로 보냅니다.
  while (mySerial.available () > 0) {
    char inByte = mySerial.read ();
    Serial.write (inByte);
  }

  // 두 포트의 데이터를 구분하는 빈 줄 :
  Serial.println ();

  // 이제 두 번째 포트에서 수신
  mp3Serial.listen ();
  // 들어오는 데이터가있는 동안 읽습니다.
  // 하드웨어 직렬 포트로 보냅니다.
  Serial.println ( "포트 2의 데이터 :");
  while (mp3Serial.available () > 0) {
    char inByte = mp3Serial.read ();
    Serial.write (inByte);
  }
  // 두 포트의 데이터를 구분하는 빈 줄 :
  Serial.println ();

  mp3_play(1);    //0001 파일 플레이, 다음 정류장에 좌석이 예약되었습니다. 교통약자분들을 위해 자리를 비워주세요.
  delay(6000);
  mp3_play(2);    //0002 파일 플레이, 이번 정류장에 좌석이 예약되었습니다. 교통약자분들을 위해 자리를 비워주세요.
  delay(6000);

      mp3_stop();
      mp3_pause();
  
      mp3_next ();    //0002 파일 플레이 , next
      delay (6000);
      mp3_prev ();    //0001 파일 플레이 , prev
      delay (6000);
  int x = 0, y = 0, z = 0;
  if (save == "a") {
    x = 254;
    y = 141;
    z = 197;
  } else if (save == "b") {
    x = 254;
    y = 0;
    z = 0;
  }
  //네오픽셀 코드
  for (int i = 0; i < 50; i++) strip.setPixelColor(i, x, y, z); // R B G
  strip.show();

  for (int i = 0; i < 50; i++) strip2.setPixelColor(i, x, y, z); // R B G
  strip2.show();
  // Red Color(i, 0, 255, 50) Blue Color(i, 0, 255, 0) Pink Color(R,G,B:254,141,197)

  //모터 - 스위치로 전자석 위치 조절 코드
  int sw1 = digitalRead(sw_u);
  int sw2 = digitalRead(sw_d);

  if (Serial.available() > 0) {
    char c = Serial.read();

    cmd = c;

  }


  else if ( sw1 == 0)
  {
    cmd = '1';
  }
  else if (sw2 == 0)
  {
    cmd = '2';
  }

  Serial.println(cmd);

  if (cmd == '1')
  {
    up();
    Serial.print("up");
    cmd = 0;
  }

  else if (cmd == '2')

  {
    down();
    Serial.print("down");
    cmd = 0;
  }

  if (!myString.equals("")) { //myString 값이 있다면
    // input1 = "";
    // input2 = "";

    save = myString;
    myString = "";
  }

}



void up()
{
  digitalWrite(DIR_PIN, LOW);

  for (int i = 0; i < 200; i++)

  {
    digitalWrite(STP_PIN, HIGH);
    delayMicroseconds(500);
    digitalWrite(STP_PIN, LOW);
    delayMicroseconds(500);
  }

}


void down()
{
  digitalWrite(DIR_PIN, HIGH);

  for (int i = 0; i < 200; i++)
  {
    digitalWrite(STP_PIN, HIGH);
    delayMicroseconds(500);
    digitalWrite(STP_PIN, LOW);
    delayMicroseconds(500);
  }

}
