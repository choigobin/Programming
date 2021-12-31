def sort_item(list):
    t1,t2=[],[]

    for i in list:
        if i < 0:
            t1.append(i)
        else:
            t2.append(i)
    return t1+t2

list = [1,5,4,6,-1,-3]
print(sort_item(list))
list.sort()
print(list)