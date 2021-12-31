from tkinter import *

sum=0

def plus():
    global sum
    x=int(total.get())
    sum=sum+x
    l2['text']=sum
    
def minus():
    global sum
    x=int(total.get())
    sum=sum-x
    l2['text']=sum
    
def reset():
    global sum
    sum=0
    l2['text']=sum

window = Tk()
total = Entry(window)
l1=Label(window,text="현재 합계: ").grid(row=0,column=0)
l2=Label(window,text=sum)
l2.grid(row=0,column=1)
total.grid(row=1, column=0, columnspan=3)
b1=Button(window,text="더하기(+)",command=plus).grid(row=2,column=0)
b2=Button(window,text="빼기(-)",command=minus).grid(row=2,column=1)
b3=Button(window,text="초기화",command=reset).grid(row=2,column=2)
