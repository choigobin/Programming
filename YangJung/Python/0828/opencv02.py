import cv2
img = cv2.imread("image\monarisa.jpg")
cv2.imshow('original',img)
cv2.waitKey(0)

filte = cv2.blur(img,(5,5))
cv2.imshow('filtering',filte)
cv2.waitKey(0)

gray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
cv2.imshow('gray',gray)
cv2.waitKey(0)

edges = cv2.Canny(gray,50,150,apertureSize= 3)
cv2.imshow('edge detection',edges)
cv2.waitKey(0)

cv2.destroyAllWindows()
