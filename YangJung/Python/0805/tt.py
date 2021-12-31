import turtle
import random

a1 = turtle.Turtle()

asteroids = []				# 공백 리스트를 생성한다. 
for i in range(10):			# 10개의 터틀을 생성한다. 
        a1 = turtle.Turtle()
        a1.color("red")
        a1.shape("circle")
        a1.penup()
        a1.speed(0)
        a1.goto(random.randint(-300, 300), random.randint(-300, 300))
        asteroids.append(a1)	
