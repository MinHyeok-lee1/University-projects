import cv2 
import numpy as np
import os
import time
import datetime
import getpass


cap = cv2.VideoCapture('rtsp://sonny8569:sonny8569@192.168.137.9:554/stream_ch00_0')

UserName = getpass.getuser()





  
if __name__ == '__main__':
    cap1time=0.0
    cap2time=0.0
    cap3time=0.0
    cap4time=0.0
    #cap을 4개를 받는다 (다 다르게)
    #화질도 설정 파일용량 작아지게
    #개를 다 따로 타이머 돌려서 cap1번은 1초마다 cap2번은 2초마다 cap3번은 3초마다 cap4번은 4초마다
    #sleep문 주면 안댐
    #sleep 주면 전부다 멈춰버리잖아
    #계속 받는 타이머 따로 두고
    #
    cap = cv2.VideoCapture('rtsp://sonny8569:sonny8569@192.168.137.9:554/stream_ch00_0')
    
    UserName = getpass.getuser()
    try:
        #DesktopAdress = os.path.join("C:\\Users",UserName,"Desktop","JinsLab")
        DesktopAdress = os.path.join("C:\\","test")
        if not(os.path.isdir(DesktopAdress)):
            os.makedirs((os.path.join(DesktopAdress)))                  
    except OSError:
        print("파일 생성에 실패했습니다.")  
    #현재시간
    start=time.time()
    CaptureTime = time.time()

    ret,frame=cap.read()
    while(True):

        #현재시간에서 조금전에 받았던 과거시간
        deltatime=time.time()-start
        start=time.time()
        cap1time+=deltatime
        cap2time+=deltatime
        cap3time+=deltatime
        cap4time+=deltatime

        ret,frame=cap.read()
        if ret==True:
            cv2.imshow('frame',frame)
            

            
        #0.000000342341235
        if(cap1time>=1):
            if ret==True:
                cap1time-=1
                period =datetime.datetime.now()
                nowDatetime = period.strftime('%Y_%m_%d_%H_%M_%S')
                cv2.imwrite(os.path.join( DesktopAdress ,nowDatetime+'.jpg'),frame)
        #period =datetime.datetime.now()
        #nowDatetime = period.strftime('%Y_%m_%d_%H_%M_%S')
        #ret,frame=cap.read()
        #cv2.imshow('frame',frame)
        #cv2.imwrite(os.path.join( DesktopAdress ,nowDatetime+'.jpg'),frame)
      

        if cv2.waitKey(1) & 0xFF == ord('q'):
            cv2.destroyAllWindows()
            break
