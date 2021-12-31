'''for i in[1,2,3,4,5,6,7,8,9]:
    print("9*",i,"=",9*i)
for i in[5,4,3,4,5]:
    print("i=",i)
for i in[2,3]:
    for j in[1,2,3,4,5,6,7,8,9]:
        print(i,"*",j,"=",i*j)
    print("")

#for i in range(1, 6, 1):
#	print(i, end=" ")
#for i in range(1, 6, 2):
#	print(i)

import turtle
t = turtle.Turtle()
for i in range(6):
	t.circle(100)
	t.left(360/6)

import turtle
t = turtle.Turtle()
t.shape("turtle")

s=turtle.textinput("","몇각형을 원하시나요?")
n=int(s)
for i in range(n):
    t.forward(100)
    t.left(360/n)
import turtle
import random
t=turtle.Turtle()
t.shape("turtle")
guri=random.randint(1,100)
for i in range(30):
    t.fd(guri)
    t.right(random.randint(-180,180))

n = int(input("정수를 입력하시오: "))

fact = 1
for i in range(1, n+1):
	fact = fact * i
print(n, "!은", fact, "이다.")
password=""
while password != "pythonisfun":
	password = input("암호를 입력하시오: ")
print("로그인 성공")'''

'''response = "아니"
while response == "아니":
	response = input("엄마, 다됐어?");
print("먹자")'''

'''
sum=0
for i in range(11):
    sum=sum+i
print("1-10까지의 합은 : ",sum)

sum=0
i=0
while i<11:
    sum=sum+i
    i=i+1
print("1-10까지의 합은 : ",sum)
'''
'''
i=int(input("원하는 단은:"))
j=1
while j<=i:
    print(i,"*",j,"=",i*j)
    #print("%s*%s=%s"%(i,j,i*j))
    j=j+1
    
import turtle
t = turtle.Turtle()
t.shape("turtle")
i = 0
while i < 5:
    t.forward(200)
    t.right(144)
    i = i + 1

while True:
    light=input('신호등 색상을 입력하시오 ')
    if light == '파란색':
        break
print('전진')

sum=0
while True:
    i=int(input("숫자를 입력하세요:"))
    sum=sum+i
    j=input("계속(yes/no)")
    if j == "no":
        break   
print("합계는 :",sum)

'''
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



































    
