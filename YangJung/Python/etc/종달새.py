import random
time=random.randint(1,24)
print("좋아.지금 시각은"+str(time)+"시입니다.")

sunny=random.choice([True,False])
if sunny:
    print("현재날씨가 화창합니다.")
else:
    print("현재날씨가 화창하지 않습니다.")

if time>=6 and time<9 and sunny:
    print("종달새가 노래합니다.")
else:
    print('종달새가 노래하지 않습니다.')
