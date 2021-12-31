import random
solution=random.randint(0,99)
digit1=solution//10
digit2=solution%10

x=input("복권 번호를 입력하시오(0~99)")
print("당첨번호는",solution,"입니다.")
digit3=int(x)//10
digit4=int(x)%10

if digit1==digit3 and digit2==digit4:
    print("1등당첨 100만원 입니다.")
elif digit1==digit3 or digit2==digit4:
    print("2등당첨은 50만원 입니다.")
else:
    print("꽝 입니다.")

