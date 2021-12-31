import re

p=re.compile('[a-z]+')
m=p.match('3abc')
n=p.match('아하 piece of cake is 몰라')
print(n)
n=p.search('아하 piece of cake is 몰라')
print(n)
n=p.findall('아하 piece of cake is 몰라')
print(n)