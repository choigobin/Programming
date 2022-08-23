""" 
Q1 문자열 바꾸기
다음과 같은 문자열이 있다.

a:b:c:d
문자열의 split와 join 함수를 사용하여 위 문자열을 다음과 같이 고치시오.

a#b#c#d

Split 예시
>>> a = "Life is too short"
>>> a.split()
['Life', 'is', 'too', 'short']
>>> b = "a:b:c:d"
>>> b.split(':')
['a', 'b', 'c', 'd']

join 예시
문자열 삽입(join)
>>> ",".join('abcd')
'a,b,c,d'

""" 

test1 = "a:b:c:d"
test2 = "a:b:c:d".split(":")
test3 = "#".join(test2)

print(test2)
print(test3)