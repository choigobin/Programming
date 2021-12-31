import random
def random_pop(data):
    number = random.choice(data)
    data.remove(number)
    return number

a=[]
for i in range(1,46):
    a.append(i)

b=[]   
for i in range(6):
    b.append(random_pop(a))

print(b)