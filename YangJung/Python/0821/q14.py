text=input()

result = text[0] 
count  = 0   

for char in text:
    if char == result[-1]: 
        count += 1
    else:
        result += str(count) + char
        count = 1
result += str(count)

print (result)