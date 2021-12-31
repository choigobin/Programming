import cv2
img = cv2.imread("image\map.jpg")
#img=cv2.line(img,(0,0),(20,20),(255,0,0),2)
#img=cv2.rectangle(img,(100,100),(200,200),(255,0,0),2)
img=cv2.circle(img,(150,150),100,(255,0,0),2)
cv2.imshow('pnu map',img)
cv2.waitKey(0)
cv2.destroyAllWindows()
