contacts={}
contacts["홍길동"] = "010-1234-5678"

while 1:
    name = input("(입력모드)이름을 입력하시오 : ")
    if not name:
        x=input("(검색모드)이름을 입력하시오 : ")
        print(contacts[x])
        break;
    tel = input("전화번호를 입력하시오: ")
    contacts[name] = tel
    break;


x=input("(검색모드)이름을 입력하시오 : ")
print(contacts[x])
