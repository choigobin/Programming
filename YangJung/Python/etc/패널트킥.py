import random
options=["왼쪽","중앙","오른쪽"]
computer_choice = random.choice(options)
user_choice=input("어디를 수비하시곘어요?(왼쪽,중앙,오른쪽)")
if computer_choice==user_choice:
    print("수비성공")
else:
    print("수비실패")
