""" import os
print(os.getcwd())
print(os.system("dir"))

import calendar
print(calendar.calendar(2019))

import random
print(random.random())

import time
for i in range(5):
    print(i)
    time.sleep(5) """

import random
""" def random_pop(data):
    number = random.randint(0, len(data)-1)
    return data.pop(number)

if __name__ == "__main__":
    data = [1, 2, 3, 4, 5]
    while data: 
        print(random_pop(data)) """

data = [1, 2, 3, 4, 5]
random.shuffle(data)
print(data)

import webbrowser
webbrowser.open_new("http://google.com")