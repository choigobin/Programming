# from PC_bang.member import join
# from PC_bang.PC import change
# from PC_bang.payment import saving
# from PC_bang.payment import order

from PC_bang.member import join
from PC_bang.PC import change
from PC_bang.payment import saving
from PC_bang.payment import order
def start_game():
    while True:
        print('1. 음식주문 2. 자리이동 3. 충전')
        select=input()
        if select == "1":
            order.show()
        elif select == '2':
            change.move()
        else:
            saving.start()

def main_window():
    while True:
        print('1.회원가입 2.로그인')
        choice=input()
        print(choice)
        if choice =="1":
            join.makeID("pythonKiller","secret","python","010-1234-5678")
        else:
            print('로그인을 시작합니다')
            start_game()

main_window()