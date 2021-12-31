import random
solution=random.randint(0,999)
digit1=solution//100
digit2=(solution%100)//10
digit3=solution%10

x=input("복권 번호를 입력하시오(0~999)")
print("당첨번호는",solution,"입니다.")
digit4=int(x)//100
digit5=(int(x)%100)//10
digit6=int(x)%10

if digit1==digit4 and digit2==digit5 and digit3==digit6:
    print("1등당첨 1000만원 입니다.")
elif digit1!=digit4 and digit2!=digit5 and digit3!=digit6:
    print("꽝")
elif digit1==digit4 and digit2!=digit5 and digit3!=digit6:
    print("3등당첨은 100만원 입니다.")
elif digit1!=digit4 and digit2==digit5 and digit3!=digit6:
    print("3등당첨은 100만원 입니다.")
elif digit1!=digit4 and digit2!=digit5 and digit3==digit6:
    print("3등당첨은 100만원 입니다.")
else:
    print("2등당첨은 300만원 입니다.")
