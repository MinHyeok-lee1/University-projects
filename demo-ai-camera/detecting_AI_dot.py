import cv2
from matplotlib import animation
from matplotlib.animation import FuncAnimation
import numpy as np
from numpy.core.arrayprint import DatetimeFormat
from numpy.lib import type_check
import tensorflow.keras
from PIL import Image, ImageOps
import time
import datetime
import os
import winsound
import threading
import pandas as pd 
import numpy as np 
import matplotlib.pyplot as plt

def PlaySiran():
    
    winsound.PlaySound("alarm.wav",winsound.SND_NOSTOP)#경보음 재생함수
           
    time.sleep(3)
    evt.wait()
cap = cv2.VideoCapture(0)
playSiranaaa = 0 
size = (224, 224)
v1 = 0.1

def on_trackbar(x): # 더미 만들기 (비어있는 함수 <- 트랙바 사용에 필요함) 
    pass

cv2.namedWindow('ROI') # ROI 창을 일단 열어줌
cv2.createTrackbar('prob', 'ROI', 0, 100, on_trackbar) # ROI 창에 있는 prob이라는 변수에 최소 0 에서 최대 100까지 on_trackbar 함수를 콜백함수로 불러와 실행함
cv2.createTrackbar('area', 'ROI', 0, 1000, on_trackbar) # ROI 창에 있는 prob이라는 변수에 최소 0 에서 최대 100까지 on_trackbar 함수를 콜백함수로 불러와 실행함
cv2.setTrackbarPos('prob', 'ROI', 97) # 초기 설정된 화재 확률 97% 역치
cv2.setTrackbarPos('area', 'ROI', 60) # 초기 설정된 화재 최소 감지 영역 픽셀

model = tensorflow.keras.models.load_model('keras_model.h5') # 모델 가져오기(소방차, 사이렌도 학습시켜야 할듯)
labels = ['Fire', 'Siren', 'Cooking', 'Fire_man', 'Person', 'Fire_truck', 
'Red_light', 'Car', 'Hand', 'Lights', 'Welding', 'Robots', 'Gas', 'Smoke', 
'Night_car', 'Reflect', 'Tree', 'Bulb', 'Cat', 'Dog', 'Candle', 'Fountain']
evt = threading.Event()
lock = threading.Lock()
result = 0
# arrayForFps = []
times = 0

while cap.isOpened:
    x = []
    y = []
    pre = 0
    percent = 0
    data = 0

    start_frame = time.time() # Start time
    v2 = int(1/v1)
    prob = float(cv2.getTrackbarPos('prob', 'ROI') / 100) # 위에서 만든 트랙바 변수를 불러와 100으로 나누고 실수형 자료로 prob 변수에 집어 넣음
    surface = int(cv2.getTrackbarPos('area', 'ROI'))
    ret, frame1 = cap.read() #이거 앞에 프레임 가져오는 애인데 while 문 밖에 나가면 영상재생 안됨
    ret, frame2 = cap.read() 
    diff = cv2.absdiff(frame1, frame2) # 앞에 프레임에서 뒤에 프레임을 빼고 diff에 저장
    small = cv2.resize(diff, dsize=(0, 0), fx=v1, fy=v1, interpolation=cv2.INTER_AREA)
    gray = cv2.cvtColor(small, cv2.COLOR_BGR2GRAY) # 움직임 감지 프레임을 BGR 변수에서 각각 행렬 ([숫자1, 숫자2, 숫자3])을 ([숫자1])로 줄여줬기 때문에 연산량과 메모리를 줄임
    blur = cv2.GaussianBlur(gray, (5,5), 0) # 화면내 블러 효과를 줌으로써 움직일 때 플리커링(깜빡임)이 줄어듦, (5,5)는 커널 크기
    _, thresh = cv2.threshold(blur, 20, 255, cv2.THRESH_BINARY) # 역치 20(어두운 회색)을 넘어가는 애들만 255(화이트)로 표현
    dilated = cv2.dilate(thresh, None, iterations=3) #잡힌 움직임 영역을 조금 더 키워줌(팽창기법) 그래서 인식되는 부위보다 살짝 더 여유있게 만들어줌(구멍도 매꿈)
    result = cv2.morphologyEx(dilated, cv2.MORPH_CLOSE, (11, 11))
    contours, _ = cv2.findContours(result, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE) 
    ROI = cv2.imread('black.jpg')
    for contour in contours:
        area =cv2.contourArea(contour)
        c = np.nonzero(result)

        if area > surface:
            cv2.rectangle(frame1, (min(c[1])*v2, min(c[0])*v2),(max(c[1])*v2, max(c[0])*v2), (0,255,0),2)
            ROI = frame1[min(c[0])*v2:max(c[0])*v2, min(c[1])*v2: max(c[1])*v2]
            # x좌표 차이
            mtX = (max(c[1])-min(c[1]))*v2
            # y좌표 차이
            mtY = (max(c[0])-min(c[0]))*v2
            # 해상도 설정 contVS
            constV = 224

            # 바운딩박스 x좌표 vs y좌표 길이 검사 -> 둘중에 긴 값이 constV = 254보다 크고, 작고, 같을 때 별로 padding 값 설정
            if mtX > mtY:
                long = mtX
                short = mtY
                if long > constV:
                    short = int(short*constV/long)
                    long = constV
                    xpad = 0
                elif long < constV:
                    xpad = int((constV-long)/2)

                ypad = int((constV - (constV * short) / long) / 2)
            elif mtX < mtY: 
                long = mtY
                short = mtX
                if long > constV:
                    short = int(short*constV/long)
                    long = constV
                    ypad = 0
                elif long < constV:
                    ypad = int((constV-long)/2)

                xpad = int((constV - (constV * short) / long) / 2)
            else: 
                xpad = 0
                ypad = 0
            
            # padding 값 적용하여 원하는 contV를 유지하며 해상도 설정
            # ROI = cv2.resize(ROI,(constV-(xpad*2),constV-(ypad*2)))
            ROI = cv2.copyMakeBorder(ROI,ypad,ypad,xpad,xpad,cv2.BORDER_CONSTANT,value=[0,0,0])
            ROI = cv2.resize(ROI, size)
            img_input = cv2.cvtColor(ROI, cv2.COLOR_BGR2RGB)
            img_input = (img_input.astype(np.float32) / 127.0) - 1
            img_input = np.expand_dims(img_input, axis=0)

            prediction = model.predict(img_input)
            # idx = np.argmax(prediction)

            percent = round(prediction[0][0]*100, 3)
            print(percent, times)
            #x.append(times)
            #y.append(percent)
            times+=1
            # ani = FuncAnimation(plt.show(), animation, interval=100)

            if prediction[0][0] > prob:
                cv2.putText(ROI, str('Fire'), org=(10, 30), fontFace=cv2.FONT_HERSHEY_SIMPLEX, fontScale=1.4, color=(255, 255, 255), thickness=2)
               
                #cv2.imwrite(os.path.join(FireImageAdress,"fire"+str(num)+".jpg"),ROI)
                playSiranaaa += 1
               
                if playSiranaaa == 12 :
                    subTread = threading.Thread(target=PlaySiran) # 서브 스레드 선언 #타겟은 상단의 def PlaySiran
                    subTread.daemon = True # 서브스레드 daemon 화(메인 스레드가 끝날시 같이 스레드를 종료한다,)
                    subTread.start()#스레드 시작
                    break
                elif playSiranaaa > 25: #대략 30프레임마다 소리 재생을 위해 선언 
                    playSiranaaa =playSiranaaa - 25
                       
        else:
            ROI = cv2.imread('black.jpg')

    finish_frame = time.time()
    calc = finish_frame - start_frame
    FPS = int(1.0/calc)
    # arrayForFps.append(FPS)#배열로 프레임 넣기
    cv2.putText(frame1, str(FPS), org=(10, 50), fontFace=cv2.FONT_HERSHEY_SIMPLEX, fontScale=1.6, color=(0, 255, 0), thickness=3)
    cv2.imshow('frame', frame1)
    cv2.imshow('ROI', ROI)
    cv2.imshow('mask', dilated)
    # print(playSiranaaa)
    
    result+=1
    

    plt.scatter(times,percent)
    plt.xlabel('Time')
    plt.ylabel('Percent(%)')
    plt.title('Probability of Fire')
    plt.pause(0.001)
    if cv2.waitKey(1) == 27: #키보드에 esc키를 누르면 정지하기
        
        break


# df = pd.DataFrame(arrayForFps)#arryForFps 데이터프레임화
# df.to_csv('daum_real_time_keyword.csv', index=False, encoding='cp949')#csv에 저장
cap.release()
cv2.destroyAllWindows #윈도우에 있는 cv2창 모두 끄기

plt.xlabel('Time')
plt.ylabel('Percent(%)')
plt.title('Probability of Fire')
plt.show()