id="ilovef"
pswd="1234"
x=input("아이디를입력하시오:")
y=input("비밀번호를 입력하시오:")
if x==id and y==pswd:
    print("로그인성공")
elif x!=id:
    print("id가 없습니다")
else:
    print("비밀번호가 틀렸습니다")
