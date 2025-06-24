import cv2 

url = 'rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov'

cap = cv2.VideoCapture(url)
while True : ret, frame = cap.read()
cv2.imshow("video", frame) cv2.waitKey(1)
