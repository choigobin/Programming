import sys
a=sys.argv[1:] #리스트 1번부터 읽기 시작 0번 제외~

sum = 0
for i in a:
   sum+=int(i)
print(sum)