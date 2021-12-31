def exisitID(ID):
    print("ID중복검사를 수행합니다.")
    return 1

def save_money(name, how_much):
    print("결제할 종류를 선택하세요")
    type = input()
    if type =='card':
        print("카드로 결제합니다.")
    else:
        print("현금으로 결제합니다")
    print(name+'님의 마일리지에', how_much+'원 충전이 완료되었습니다.')

def start():
    print('아이디를 입력하세요')
    user=input()
    if exisitID(user)==1:
        print(user+'은 존재하는 아이디입니다.')
        print(user+'은 충전하실 금액을 입력하세요')
        money=input()
        save_money(user,money)
    else:
        print('충전을 종료합니다')