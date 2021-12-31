def positive(l): 
    result = [] 
    for i in l: 
        if i > 0: 
            result.append(i) 
    return result

print(positive([1,-3,2,0,-5,6]))

def multiple(l):
    result = []
    for i in l:
        if(i % 2==0):
            result.append(i)
    return result

print(multiple([1,-3,2,0,-5,6]))

print(list(filter(lambda x: x > 0, [1, -3, 2, 0, -5, 6])))

print(hex(16))

print(id(3))