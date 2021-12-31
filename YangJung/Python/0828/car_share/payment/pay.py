car_price={'스파크':1000,'쏘나타':2000}

def car_money(car_name, time):
    price = car_price.get(car_name)
    total = price*time
    return total