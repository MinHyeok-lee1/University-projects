#include <SoftwareSerial.h> //시리얼 통신 라이브러리 호출
#include <Adafruit_NeoPixel.h> // 네오픽셀 라이브러리 호출

//define NeoPixel
#define PIN 2
#define PINN 3 // 앞
#define NUM_LEDS 50
//create a NeoPixel strip
Adafruit_NeoPixel strip = Adafruit_NeoPixel(NUM_LEDS, PIN, NEO_GRB + NEO_KHZ800);
Adafruit_NeoPixel strip2 = Adafruit_NeoPixel(NUM_LEDS, PINN, NEO_GRB + NEO_KHZ800); // 앞

String msg = ""; // 시리얼로부터 입력받는 String
String flag = ""; // 입력받는 String 초기화를 위한 String
int save = 0;

void setup() {
  Serial.begin(9600);

  // start the strip and blank it out
  strip.begin();
  strip2.begin();
  strip.show();
  strip2.show();
}

void loop() {
  while (Serial.available()) {
    char data = (char)Serial.read();
    //    Serial.println(msg);
    msg += data;
    delay(5);           //수신 문자열 끊김 방지
  }


  if (!msg.equals("")) {
    msg.trim();
    Serial.println(msg);
    if (msg == "a1" || msg == "a2") {
      pink();
    }

    if (msg == "b1" || msg == "b2") {
      save = 1;
      blue();
    }

    if (msg == "g2") {
      if (save == 1) {
        red();
      }
      blue();
      if(save == 1) save = 2;
    }
    if (msg == "c" || msg == "f") {

      if (save == 2) {
        red();
      }

      off();
      save = 0;
    }
    if (msg == "x") {
      red();
      off();
      save = 0;
    }
    if (msg == "q") {
      off();
      save = 0;
    }
    msg = "";
  }





}
void pink() {
  for (int i = 0; i < NUM_LEDS; i++) {
    strip.setPixelColor(i, 255, 51, 153); // R B G
    strip.show();
    delay(10);
  }
  for (int i = 0; i < NUM_LEDS; i++) {
    strip2.setPixelColor(i, 255, 51, 153); // R B G
    strip2.show();
    delay(10);
  }
}

void blue() {
  for (int i = 0; i < NUM_LEDS; i++) {
    strip.setPixelColor(i, 0, 0, 254); // R G B
    strip.show();
    delay(10);
  }
  for (int i = 0; i < NUM_LEDS; i++) {
    strip2.setPixelColor(i, 0, 0, 254); // R G B
    strip2.show();
    delay(10);
  }

}

void red() {
  int ten = 0;
  while (ten <= 53) {

    for (int i = 0; i < NUM_LEDS; i++) {
      strip.setPixelColor(i, 254, 0, 0); // R B G
    }
    for (int i = 0; i < NUM_LEDS; i++) {
      strip2.setPixelColor(i, 254, 0, 0); // R B G
    }
    strip.show();
    strip2.show();
    delay(200);
    for (int i = 0; i < NUM_LEDS; i++) {
      strip.setPixelColor(i, 0, 0, 0); // R B G
    }
    for (int i = 0; i < NUM_LEDS; i++) {
      strip2.setPixelColor(i, 0, 0, 0); // R B G
    }
    strip.show();
    strip2.show();
    ten += 1;
    delay(200);
  }

}

void off() {
  strip.clear();
  strip2.clear();
  strip.show();
  strip2.show();
}
