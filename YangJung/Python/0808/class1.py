class Car:
    color=""
    moderl=""
    def drive(self):
        self.speed = 60

myCar1=Car()
myCar1.color="blue"
myCar1.model="E-Class"

myCar1.drive()
print(myCar1.speed)
print(myCar1.color)

myCar = Car()
myCar.speed = 0
myCar.model = "E-Class"
myCar.color = "blue"
myCar.year = "2017"

print("자동차 객체를 생성하였습니다.")
print("자동차의 속도는", myCar.speed)
print("자동차의 색상은", myCar.color)

print("자동차의 모델은", myCar.model)
print("자동차를 주행합니다.")
myCar.drive()
print("자동차의 속도는", myCar.speed)
