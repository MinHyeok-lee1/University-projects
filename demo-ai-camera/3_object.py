from typing import SupportsBytes
import cv2
import numpy as np

cap = cv2.VideoCapture('fire.mp4') #영상을 웹캠으로 가져와 cap에 저장

subtractor = cv2.createBackgroundSubtractorMOG2(history=200, varThreshold=30, detectShadows=True)
thresh = 25
while True : 
    _, frame = cap.read()
    _, frame2 = cap.read()
    _, frame3  = cap.read()

    mask = subtractor.apply(frame)
    mask2  = subtractor.apply(frame2)
    mask3 = subtractor.apply(frame3)

    #mask = cv2.resize(mask, dsize=(0, 0), fx=0.02, fy=0.02)
    #mask = cv2.resize(mask, (640,480), interpolation=cv2.INTER_AREA)
    _, mask = cv2.threshold(mask, thresh, 255, cv2.THRESH_BINARY) #254이하 회색은 모두 날리고 나머지 색은 모두 255(흰색)
    _, mask2 = cv2.threshold(mask2, thresh, 255, cv2.THRESH_BINARY)
    _, mask3 = cv2.threshold(mask3, thresh, 255, cv2.THRESH_BINARY)
    diff1  = cv2.absdiff(mask,mask2)
    diff2 = cv2.absdiff(mask2,mask3)
    
    _, diff1_t = cv2.threshold(diff1, thresh, 255, cv2.THRESH_BINARY)
    _, diff2_t = cv2.threshold(diff2, thresh, 255, cv2.THRESH_BINARY)
    
    diff  = cv2.bitwise_and(diff1_t,diff2_t)
    diff = cv2.resize(diff, dsize=(0, 0), fx=0.02, fy=0.02)
    diff = cv2.resize(diff, (640,480), interpolation=cv2.INTER_AREA)
    diff = cv2.GaussianBlur(diff,(5,5), 0)
    k = cv2.getStructuringElement(cv2.MORPH_CROSS, (3, 3)) #구멍을 매워주는 함수
    diff = cv2.morphologyEx(diff, cv2.MORPH_OPEN, k) #커널을 통해 노이즈 제거
    contours, _ = cv2.findContours(diff, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    cnt = cv2.countNonZero(diff)
    if cnt > 5:
        nzero = np.nonzero(diff)
        cv2.rectangle(frame, (min(nzero[1]), min(nzero[0])),
                    (max(nzero[1]), max(nzero[0])), (0, 255, 0), 2)

    cv2.imshow("Frame", frame)
    cv2.imshow("mask", diff)

    key = cv2.waitKey(30)
    if key == 27: #키보드에 esc키를 누르면 정지하기
        break
    
cap.release()
cv2.destroyAllWindows #윈도우에 있는 cv2창 모두 끄기
