def existID(ID):
    print("ID중복검사를 수행합니다")
    return 0

def makeID(ID, pw, name, phone):
    check = existID(ID)
    if check==0:
        print("사용가능 ID")
        info = {'ID':ID, 'PW':pw, 'Name':name, 'PH':phone}
        return info
    else:
        print("이미 존재하는 ID입니다")
    