from tkinter import *

window = Tk()
l1 = Label(window, text="간단한 GUI 프로그램!",width=100)
l1.pack()
b1=button = Button(window, text="환영합니다.")
b2=button = Button(window, text="종료")
b1.pack()
b2.pack()

window.mainloop()
