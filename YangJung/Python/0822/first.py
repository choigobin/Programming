import re
pat =re.compile('CAT|OW')
m=pat.search('WHITECATBROWNCAT')
print(m.group())
m=pat.findall('WHITECATBROWNCAT')
print(m)

text='x\nx'
print(re.findall('x.x',text))
print(re.findall('x.x',text,re.S))
print(re.sub('mate','python','mate is fun'))

result = re.sub("(\d{3})-(\d{3})","(\\2)-\\1","111-222")
print(result)

day = "1977-07-25 1848-45-45"
result = re.sub("(\d{4})-(\d{1,2})-(\d{1,2})","Year:\\1 Month:\\2 Day:\\3",day)
print(result)
tel= "112-222-333\n4444-555-6666\n777-8888-9999"
result=re.sub("(\d{3,4})-(\d{3,4})-(\d{3,4})","(\\1) \\2 \\3",tel)
print(result)

data = """
park 010-4545-4841
kim  01054874444
lee  010 5545 4445
010AA
012ADW
011ADSd
http://www.pusan.ac.kr
http://www.naver.com
www.korea.org
a4548845b
a4548845S
D4548845b
010ab
asddsa@dsadas.com
dasg2@naver.com
"""

em=re.compile("^.+@.+[.com]$",re.M)
result=em.findall(data)
print(result)

http=re.compile("[http://|www].+[com|kr|org]$",re.M)
result=http.findall(data)
print(result)