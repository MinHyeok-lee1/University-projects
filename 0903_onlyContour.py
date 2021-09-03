import cv2
import time

cap = cv2.VideoCapture("./FireV2.mp4")

while cap.isOpened:
    ret, frame1 = cap.read()  # 이거 앞에 프레임 가져오는 애인데 while 문 밖에 나가면 영상재생 안됨)
    time.sleep(0.01)
    ret, frame2 = cap.read()
    diff = cv2.absdiff(frame1, frame2)  # 앞에 프레임에서 뒤에 프레임을 빼고 diff에 저장
    gray = cv2.cvtColor(diff, cv2.COLOR_RGB2GRAY)
    ret, binary = cv2.threshold(gray, 127, 255, cv2.THRESH_BINARY)
    binary = cv2.bitwise_not(binary)
    contours, hierarchy = cv2.findContours(
        binary, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)

    for i in range(len(contours)):
        cv2.drawContours(diff, [contours[i]], 0, (0, 0, 255), 2)
        cv2.putText(diff, str(i), tuple(
            contours[i][0][0]), cv2.FONT_HERSHEY_COMPLEX, 0.8, (0, 255, 0), 1)
        print(i, hierarchy[0][i])
        cv2.imshow("src", diff)

    cv2.imshow("frame", frame2)
    if cv2.waitKey(2) == 27:  # 키보드에 esc키를 누르면 정지하기
        break

cv2.destroyAllWindows()
