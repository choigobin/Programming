A=int(input("아메리카노 판매 개수:"))
B=int(input("카페라떼 판매 개수:"))
C=int(input("카푸치노 판매 개수:"))
Ap=2000
Bp=3000
Cp=3500
sales=A*Ap
sales=sales+B*Bp
sales=sales+C*Cp
print("총매출은",sales,"입니다.")
