import turtle
t=turtle


def draw_or():
    whe = []
    whe.append([-200,50,"blue"])
    whe.append([-100,-50,"purple"])
    whe.append([0,50,"red"])
    whe.append([100,-50,"yellow"])
    whe.append([200,50,"green"])
    for x,y,c in whe:
        t.penup()
        t.goto(x,y)
        t.pendown()
        t.color(c)
        t.begin_fill()
        t.circle(30)
        t.end_fill()
    

draw_or()