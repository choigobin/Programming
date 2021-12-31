import turtle
import random
t=turtle


def draw_or():
    whe = ["blue","purple","red","yellow","green"]
    for i in range(5):
        x=random.choice(whe)
        r=random.randint(-200,200)
        t.penup()
        t.goto(r,r)
        t.pendown()
        t.color(x)
        t.begin_fill()
        for i in range(4):
            t.fd(100)
            t.left(90)
        t.end_fill()
    

draw_or()
