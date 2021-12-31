import turtle

t=turtle.Turtle()
t.width(3)
t.shape("turtle")
t.shapesize(3,3)

while True:
    command=input("명령해")
    if command=="a":
        t.left(45)
    if command=="d":
        t.right(45)
    if command=="w":
        t.fd(100)
