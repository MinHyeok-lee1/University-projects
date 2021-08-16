import cv2
import numpy as np
from numpy.lib import type_check
import tensorflow.keras
from PIL import Image, ImageOps

#cap = cv2.VideoCapture('rtsp://sss:sssss@192.168.137.247:554/stream_ch00_0') #영상을 웹캠으로 가져와 cap에 저장
cap = cv2.VideoCapture(0)
cap.set(cv2.CAP_PROP_FRAME_WIDTH, 1280)
cap.set(cv2.CAP_PROP_FRAME_HEIGHT, 720)

subtractor = cv2.createBackgroundSubtractorMOG2(history=10, varThreshold=40, detectShadows=False)

size = (224, 224)

# Load the model
model = tensorflow.keras.models.load_model('keras_model.h5') # 모델 가져오기(소방차, 사이렌도 학습시켜야 할듯)
classes = ['Fire', 'none', 'none', 'none', 'none', 'none', 'none'] 

while True : 
    _, frame = cap.read()
    
    mask = subtractor.apply(frame)

    mask = cv2.resize(mask, dsize=(0, 0), fx=0.05, fy=0.05)
    mask = cv2.resize(mask, (1280,720), interpolation=cv2.INTER_AREA)
    dilated = cv2.dilate(mask, None, iterations=3)
    #mask = cv2.GaussianBlur(mask,(5,5), 0)
    _, mask = cv2.threshold(mask, 254, 255, cv2.THRESH_BINARY) #254이하 회색은 모두 날리고 나머지 색은 모두 255(흰색)
    
    k = cv2.getStructuringElement(cv2.MORPH_CROSS, (5, 5)) #구멍을 매워주는 함수
    diff = cv2.morphologyEx(mask, cv2.MORPH_OPEN, k) #커널을 통해 노이즈 제거
    contours, _ = cv2.findContours(mask, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    cnt = cv2.countNonZero(diff)
    if cnt > 5:
        nzero = np.nonzero(diff)
        cv2.rectangle(frame, (min(nzero[1]), min(nzero[0])),
                    (max(nzero[1]), max(nzero[0])), (0, 255, 0), 2)
        ROI = frame[min(nzero[0]):max(nzero[0]), min(nzero[1]): max(nzero[1])]

    #ROI = cv2.resize(ROI, dsize=(0,0), fx=1.28, fy=0.72, interpolation=cv2.INTER_AREA)
    
    # x좌표 차이
    mtX = int(max(nzero[1]) - min(nzero[1]))
    # y좌표 차이
    mtY = int(max(nzero[0]) - min(nzero[0]))
    # 해상도 설정 contV
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
    ROI = cv2.resize(ROI,(constV-(xpad*2),constV-(ypad*2)))
    image_array = np.asarray(ROI)
    constraint = cv2.copyMakeBorder(ROI,ypad,ypad,xpad,xpad,cv2.BORDER_CONSTANT,value=[0,0,0])
    img_input = cv2.resize(ROI, size)
    img_input = cv2.cvtColor(img_input, cv2.COLOR_BGR2RGB)
    img_input = (img_input.astype(np.float32) / 127.0) - 1
    img_input = np.expand_dims(img_input, axis=0)

    prediction = model.predict(img_input)
    idx = np.argmax(prediction)

    cv2.putText(constraint, text=classes[idx], org=(10, 30), fontFace=cv2.FONT_HERSHEY_SIMPLEX, fontScale=0.8, color=(255, 255, 255), thickness=2)
    cv2.imshow('ROI', constraint)
    #cv2.imshow("Frame", frame)
    #cv2.imshow("mask", mask)

    key = cv2.waitKey(30)
    if key == 27: #키보드에 esc키를 누르면 정지하기
        break
    
cap.release()
cv2.destroyAllWindows #윈도우에 있는 cv2창 모두 끄기
