from tkinter import *
import random
answer=random.randint(1,100)
message="숫자게임 시작"

def go():
    global message
    x=int(number.get())
    if x==answer:
        l1=Label(window, text ="                      ").grid(row=0,column=0,columnspan=2)
        message="축하합니다"
        l1=Label(window, text = "축하합니다").grid(row=0,column=0,columnspan=2)
    elif x>answer:
        l1=Label(window, text ="                      ").grid(row=0,column=0,columnspan=2)
        message="높음"
        l1=Label(window, text = message).grid(row=0,column=0,columnspan=2)
    else:
        l1=Label(window, text ="                      ").grid(row=0,column=0,columnspan=2)
        message="낮음"
        l1=Label(window, text = message).grid(row=0,column=0,columnspan=2)
    
def reset():
    global answer
    answer=random.randint(1,100)
    l1=Label(window, text ="                      ").grid(row=0,column=0,columnspan=2)
    message="다시 시작"
    l1=Label(window, text = message).grid(row=0,column=0,columnspan=2)

window = Tk()
number = Entry(window)
l1=Label(window, text = message).grid(row=0,column=0,columnspan=2)
number.grid(row=1, column=0, columnspan=2)
b1=Button(window,text="숫자를 입력",command=go).grid(row=2,column=0)
b2=Button(window,text="게임을 다시 실행",command=reset).grid(row=2,column=1)
