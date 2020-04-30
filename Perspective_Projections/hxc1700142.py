import cv2
import numpy as np
import os
import sys

def pointProject(src,f = 1,u0 = 0,v0 = 0,a = 0,b = 0,c = 1):
    #f,u0,v0,a,b,c = 1,0,0,0,0.001,1
    x = src[0]-u0
    y = src[1]-v0
    X = c*x/(f-a*x-b*y)
    Y = c*y/(f-a*x-b*y)
    return (X,Y)

# points1 = np.float32([ [30,30], [10,40], [40,10], [5,15] ])
# points2 = np.float32([ [0,0], [400,0], [0,400], [400,400] ])

# M = cv2.getPerspectiveTransform(points1, points2)
# print(M)
if len(sys.argv) != 3:
  print(sys.argv[0], "takes 2 arguments. Not ", len(sys.argv)-1)
  sys.argv = [0 for i in range(2)]
  sys.exit(0)
c = float(sys.argv[2])

# M1 = np.float32([[c,0,0],[0,c,0],[-0.001,0,1.5]])
# M2 = np.float32([[c,0,0],[0,c,0],[0,0.001,1]])

M1 = np.float32([[1,0,0],[0,1,0],[0.001,0,c]])
M2 = np.float32([[1,0,0],[0,1,0],[0,-0.001,c]])

img = cv2.imread(sys.argv[1])
result1 = cv2.warpPerspective(img,M1, (img.shape[1], img.shape[0]))
result2 = cv2.warpPerspective(img,M2, (round(img.shape[1]*2), round(img.shape[0]*2)))
cv2.namedWindow('img', cv2.WINDOW_AUTOSIZE)
cv2.imshow('img', img)
cv2.namedWindow('vertical', cv2.WINDOW_FREERATIO)
cv2.imshow('vertical', result1)
cv2.namedWindow('horizontal', cv2.WINDOW_FREERATIO)
cv2.imshow('horizontal', result2)
#[0, 0], [149, 0], [149, 149], [0, 149]
cv2.waitKey(0)
cv2.destroyAllWindows()
