def gugu(n):
    result = []
    
    for i in range(1,10):
        result.append(n * i)
        
    return result

print(gugu(2))

sum=0

for i in range(1,1000):
    if i%3 ==0 or i%5==0:
        sum+=i

print(sum)

result = 0
for n in range(1, 1000):
    if n % 3 == 0:
        result += n
    if n % 5 == 0:
        result += n
print(result)

result = 0
for n in range(1, 1000):
    if n % 15 == 0:
        result += n
print(result)