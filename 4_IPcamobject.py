import cv2
import numpy as np

cap = cv2.VideoCapture('rtsp://sss:sssss@192.168.137.247:554/stream_ch00_0') #영상을 웹캠으로 가져와 cap에 저장

subtractor = cv2.createBackgroundSubtractorMOG2(history=200, varThreshold=40, detectShadows=False)

while True : 
    _, frame = cap.read()
    
    mask = subtractor.apply(frame)

    mask = cv2.resize(mask, dsize=(0, 0), fx=0.03, fy=0.03)
    mask = cv2.resize(mask, (1280,720), interpolation=cv2.INTER_AREA)
    mask = cv2.GaussianBlur(mask,(5,5), 0)
    _, mask = cv2.threshold(mask, 254, 255, cv2.THRESH_BINARY) #254이하 회색은 모두 날리고 나머지 색은 모두 255(흰색)
    
    
    k = cv2.getStructuringElement(cv2.MORPH_CROSS, (5, 5)) #구멍을 매워주는 함수
    diff = cv2.morphologyEx(mask, cv2.MORPH_OPEN, k) #커널을 통해 노이즈 제거
    contours, _ = cv2.findContours(mask, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    cnt = cv2.countNonZero(diff)
    if cnt > 5:
        nzero = np.nonzero(diff)
        cv2.rectangle(frame, (min(nzero[1]), min(nzero[0])),
                    (max(nzero[1]), max(nzero[0])), (0, 255, 0), 2)

    cv2.imshow("Frame", frame)
    cv2.imshow("mask", mask)

    key = cv2.waitKey(30)
    if key == 27: #키보드에 esc키를 누르면 정지하기
        break
    
cap.release()
cv2.destroyAllWindows #윈도우에 있는 cv2창 모두 끄기
