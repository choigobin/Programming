def cal_fare(person,isTrans):
    no_trans=[900,1200]
    trans=[300,500]
    if person == '학생':
        s=0
    if person == '어른':
        s=1
    if isTrans == 0:
        print(person,"입니다.")
        print("요금은",no_trans[s],"원 입니다.") 
    if isTrans == 1:
        print(person,"입니다.")
        print("요금은",trans[s],"원 입니다.") 

