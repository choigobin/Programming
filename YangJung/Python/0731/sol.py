"""숫자 맞추기 게임

import random
answer=random.randint(1,100)
tra=0
print("1부터 100사이의 숫자를 맞추시오")
while True:
    i=int(input("숫자를 입력하시오: "))
    tra=tra+1
    if answer==i:
        break
    if answer>=i:
        print("낮음")
    if answer<=i:
        print("높음")
print("축하합니다. 시도횟수=",tra)
print("정답은",answer)
"""
'''초등학교 수
import random
while True:
    i=random.randint(1,99)
    j=random.randint(1,99)
    print(i,"+",j,"=",end=" ")
    a=int(input("정답은?"))
    if a==i+j:
        print("잘했어요")
    if a!=i+j:
        print("다음번에는 잘할 수 있죠?")
'''
'''
while True:
    print("무한루프!CTRL+C로빠져나오세요")
'''
import turtle
t = turtle.Turtle()
t.shape("turtle")
t.color("red")
i=0
while i<=11:
    t.right((30*i)-60)
    t.penup()	
    t.forward(100)
    t.pendown()	
    t.forward(25)
    t.penup()
    t.forward(15)
    t.stamp()
    t.fd(20)
    t.write(i+1)
    t.home()
    i=i+1
