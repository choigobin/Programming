import turtle
t=turtle
'''
t.fillcolor("red")
def draw_hexa(length):
    t.begin_fill()
    for i in range(6):
        t.fd(length)
        t.left(60)
    t.end_fill()

for i in range(6):
    draw_hexa(100)
    t.fd(100)
    t.right(60)
'''
def draw_line():
    t.forward(100)
    t.backward(100)
t.shape("turtle")
t.stamp()
for i in range(12):
    draw_line()
    t.left(30)
