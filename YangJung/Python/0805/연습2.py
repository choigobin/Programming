import random

counters=[0,0,0,0,0,0]

for i in range(500):
    value=random.randint(0,5)
    counters[value]=counters[value]+1

print("주사위가 1인 경우는 ",counters[0],"번")
print("주사위가 2인 경우는 ",counters[1],"번")
print("주사위가 3인 경우는 ",counters[2],"번")
print("주사위가 4인 경우는 ",counters[3],"번")
print("주사위가 5인 경우는 ",counters[4],"번")
print("주사위가 6인 경우는 ",counters[5],"번")


