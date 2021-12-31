class Circle:
    pie=3.141592
    def __init__(self,radius):
        self.radius=radius

    def calcPerimeter(self):
        self.csize=(Circle.pie*self.radius*self.radius)
    
    def calcArea(self):
        self.cline=(2*Circle.pie*self.radius)

        
one=Circle(100)

one.calcPerimeter()

print(one.csize)