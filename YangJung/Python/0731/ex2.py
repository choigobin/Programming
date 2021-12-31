import random
x=random.randint(1,100)
y=random.randint(1,100)
print(x,"-",y,"=")
answer=input("답을 적으시오:")
if x-y==int(answer):
    print("정답")
else:
    print("오답")
