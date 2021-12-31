import turtle
t=turtle.Turtle()

def draw_shape(radius, color1):
	t.right(90)
	t.width(3)
	t.color("black", color1)
	t.begin_fill()
	t.circle(radius/2.0, -180)
	t.circle(radius, 180)
	t.left(180)
	t.circle(-radius/2.0, -180)
	t.end_fill()

draw_shape(200, "red")
t.right(90)
draw_shape(200, "blue")
