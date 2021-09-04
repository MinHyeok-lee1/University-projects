import cv2
import numpy as np
import tensorflow.keras
import time

cap = cv2.VideoCapture('kitchen_fire.mp4')
# cap = cv2.VideoCapture(0)

v1 = 0.1
v2 = int(1/v1)
size = (224,224)
ROI = np.zeros((224,224), np.uint8)

def 전처리(screen1,screen2):
    diff = cv2.absdiff(screen1,screen2)
    gray = cv2.cvtColor(diff, cv2.COLOR_BGR2GRAY)
    small = cv2.resize(gray, dsize=(0,0), fx = v1, fy = v1, interpolation=cv2.INTER_AREA)
    _, thresh = cv2.threshold(small, 20, 255, cv2.THRESH_BINARY)
    return thresh

def 패딩하고_인공지능_돌리기(ROI,X_padding,Y_padding):
    ROI = cv2.copyMakeBorder(ROI,Y_padding,Y_padding,X_padding,X_padding,cv2.BORDER_CONSTANT,value=[0,0,0])
    ROI = cv2.resize(ROI, dsize=size, interpolation=cv2.INTER_CUBIC)
    img_input = cv2.cvtColor(ROI, cv2.COLOR_BGR2RGB)
    img_input = (img_input.astype(np.float32) / 127.0) - 1
    img_input = np.expand_dims(img_input, axis=0)
    prediction = model.predict(img_input)
    idx = np.argmax(prediction)
    print(idx)
    cv2.putText(ROI, text=labels[idx], org=(10, 30), fontFace=cv2.FONT_HERSHEY_SIMPLEX, fontScale=1.4, color=(255, 255, 255), thickness=2)
    cv2.imshow('ROI',ROI)

model = tensorflow.keras.models.load_model('keras_model.h5') # 모델 가져오기
labels = ['Fire', 'Siren', 'Cooking', 'Fire_man', 'Person', 'Fire_truck', 
'Red_light', 'Car', 'Hand', 'Lights', 'Welding', 'Robots', 'Gas', 'Smoke', 
'Night_car', 'Reflect', 'Tree', 'Bulb', 'Cat', 'Dog', 'Candle', 'Fountain']

while cap.isOpened:
    first = time.time()
    ret, frame1 = cap.read()
    ret, frame2 = cap.read()
    c = np.nonzero(전처리(frame1,frame2))
    if len(c[0]) > 50:
        cv2.rectangle(frame2, (min(c[1])*v2, min(c[0])*v2),(max(c[1])*v2, max(c[0])*v2), (0,255,0),2)
        ROI = frame1[min(c[0])*v2:max(c[0])*v2, min(c[1])*v2: max(c[1])*v2]
        h, w, _ = ROI.shape
        if w > h:
            y_패딩 = int((w - h)/2)
            패딩하고_인공지능_돌리기(ROI,0,y_패딩)
        elif w < h:
            x_패딩 = int((h - w)/2)
            패딩하고_인공지능_돌리기(ROI,x_패딩,0)
        else:
            ROI = np.zeros((224,224), np.uint8)
            cv2.imshow('ROI',ROI)
        second = time.time()
        calc = second - first
        FPS = int(1.0/calc)
        cv2.putText(frame2, str(FPS), org=(10, 50), fontFace=cv2.FONT_HERSHEY_SIMPLEX, fontScale=1.6, color=(0, 255, 0), thickness=3)
    if cv2.waitKey(1) == 27:
        break
    cv2.imshow('CCTV Screen', frame2)


cap.release()
cv2.destroyAllWindows #윈도우에 있는 cv2창 모두 끄기