num=[]

for i in range(5):
    num.append(int(input("정수를 입력하시오:")))

sum=0
for x in num:
    sum=sum+x

avg=sum/len(num)
print("평균 = ",avg)
