'''
def print_address():
    print("서울특별시 종로구 1번지")
    print("파이썬 빌딩 7층")
    print("홍길동")

for i in range(3):
    print_address()

i=1
while 1:
    print_address()
    i+=1
    if i>3:
        break
        
def get_sum(start,end):
    sum=0
    for i in range(start,end+1):
        sum+=i
    return sum

print(get_sum(1,10))

import turtle
t=turtle.Turtle()
t.shape("turtle")

def square(length):
    for i in range(4):
        t.fd(length)
        t.left(90)

t.up()
t.goto(-200,0)
t.down()
square(100)
t.up()
t.goto(0,0)
t.down()
square(100)
t.up()
t.goto(200,0)
t.down()
square(100)

import turtle
t=turtle.Turtle()
t.shape("turtle")

def n_polygon(n,length):
    for i in range(n):
        t.fd(length)
        t.left(360//n)
for i in range(18):
    t.left(20)
    n_polygon(6,100)

def calculate_area (radius):
    global result
    result = 3.14 * radius**2
    return result
result=0
r = float(input("원의 반지름: "))
calculate_area(r)
print(result)

def greet(name, msg="별일없죠?"):
   print("안녕 ", name + ', ' + msg)

greet("영희","뭐해")

def calculate_area (r):
    global area
    area = 3.14 * r**2
area=0
r=6
calculate_area (10)
print(area)

def calc(x, y, z):
	return x+y*z
print(calc(y=20,x=10,z=30))

import turtle 
t=turtle
def square(length):
	for i in range(4):
		t.forward(length)
		t.left(90)
def drawit(x, y):
	t.penup()
	t.goto(x, y)
	t.pendown()
	t.begin_fill()
	t.color("green")
	square(50)
	t.end_fill()

s = turtle.Screen() 
s.onscreenclick(drawit) 


def draw(x, y):
	t.goto(x, y)

t = turtle.Turtle()
t.shape("turtle")
t.pensize(10)
s = turtle.Screen() # 그림이 그려지는 화면을 얻는다.
s.onscreenclick(draw) 

import turtle
t=turtle

def drawBar(h):
    t.begin_fill()
    t.left(90)
    t.fd(h)
    t.write(str(h),font=('TimesNewRoman',16,'bold'))
    t.right(90)
    t.fd(40)
    t.right(90)
    t.fd(h)
    t.left(90)
    t.end_fill()

data = [120,50,309,220,156,22]

t.color("blue")
t.fillcolor("red")
t.pensize(3)
for i in data:
    drawBar(i)
'''
import turtle
t = turtle.Turtle()

def go():
    t.fd(10)
    
def turn_left():
    t.left(10)
    

def turn_right():
    t.right(10)
    

def draw_maze(x, y):
	for i in range(2):
		t.penup()
		if i==1 :
			t.goto(x+100, y+100)
		else:
			t.goto(x, y)
		t.pendown()
		t.forward(300)
		t.right(90)
		t.forward(300)
		t.left(90)
		t.forward(300)

draw_maze(-300, 200)

screen = turtle.Screen()
t.shape("turtle")
t.speed(0)
screen.onkeypress(go, "Up")
screen.onkeypress(turn_left, "Left")
screen.onkeypress(turn_right, "Right")

t.penup();
t.goto(-300, 250)
t.pendown();
screen.listen()
screen.mainloop()


