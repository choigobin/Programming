cars={'스파크':2,'쏘나타':1}

def show_cars():
    for i in cars:
        print(i,'는',cars[i],'대 남아있습니다')

def rent(car_name):
    if car_name not in cars.keys():
        print("선택하신 차량은 지원하지 않습니다")            
    if cars.get(car_name) >= 1:
        print("렌탈 가능합니다")
        cars[car_name]-=1
        print("렌탈이 성공하였습니다")   
    else:
        print("선택하신 차량은 렌탈이 안됩니다")

def back(car_name):
    cars[car_name]+=1