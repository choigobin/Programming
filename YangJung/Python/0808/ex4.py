from turtle import *  

class MyTurtle(Turtle):
    def drawSquare(self):
        for i in range(4):
            self.right(90)
            self.fd(100)
        

TT = MyTurtle()
TT.shape("turtle")
TT.drawSquare()

mainloop()