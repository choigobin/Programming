import turtle
import random

t1=turtle.Turtle()
t2=turtle.Turtle()
screen=turtle.Screen()

image2="C:\kangmin\Python\image\car.gif"

screen.addshape(image2)

t1.color("pink")
t1.shape(image2)
t1.shapesize(5)
t1.pensize(5)

t2.color("blue")
t2.shape(image2)
t2.shapesize(5)
t2.pensize(5)

t1.penup()
t1.goto(-300, 0)

t2.penup()
t2.goto(-300, -100)

for i in range(100):		 
  d1 = random.randint(1,10)	 
  t1.forward(d1)		    
  d2 = random.randint(1,10)
  t2.forward(d2)
