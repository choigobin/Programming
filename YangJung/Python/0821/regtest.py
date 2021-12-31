import re 

data = """
park 010-4545-4841
kim  01054874444
lee  010 5545 4445
010AA
012ADW
011ADSd
a4548845b
a4548845S
D4548845b
010ab
"""

num1 = re.compile("\d{3}[-]\d{4}[-]\d{4}|\d{3}\s\d{4}\s\d{4}|\d{11}")
num1 = re.compile("01\d[-\s]?\d{3,4}[-\s]?\d{4}")
n1=num1.findall(data)

print(n1)

mon2 = re.compile("01[0~2][A-Z]{2,4}")
m2=mon2.findall(data)

mon3 = re.compile("^[aA]\w{3,}[bB]?$",re.M)
m3=mon3.findall(data)

print(m2)
print(m3)

print(re.sub('mate','python','mate is fun'))
