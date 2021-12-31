from tkinter import *

def show():
    x=e1.get()
    y=e1.get()
    z=e1.get()
    print("이름 :",x)
    print("직업 :",y)
    print("국적 :",z)
    


window  = Tk()

l1 = Label(window , text="이름").grid(row=0, column=0)
l2 = Label(window, text="직업").grid(row=1, column=0)
l3 = Label(window, text="국적").grid(row=2, column=0)



e1 = Entry(window)
e2 = Entry(window)
e3 = Entry(window)
e1.grid(row=0, column=1,columnspan=2)
e2.grid(row=1, column=1,columnspan=2)
e3.grid(row=2, column=1,columnspan=2)

b1 = Button(window, text="Show", command=show).grid(row=3, column=0)
b2 = Button(window, text="Quit").grid(row=3, column=1)


window.mainloop()
