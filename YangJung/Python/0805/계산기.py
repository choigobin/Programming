from tkinter import *

window = Tk()
window.title("My Calculator")
display = Entry(window, width=33, bg="yellow")
display.grid(row=0, column=0, columnspan=5)
button= [
'7', '8', '9', '/', 'C',
'4', '5', '6', '*', 'AC',
'1', '2', '3', '-', ' ',
'0', '.', '=', '+', ' ' ]

x = 1
y = 0
def click(key):
    gil = display.get()
    z=len(gil)-1
    if key == "=":
        result = eval(display.get())
        s=str(result)
        display.insert(END,"="+s)
    elif key == "AC":
        display.delete(0,END)
    elif key == "C":
        display.delete(z)
    else:
        display.insert(END, key)

for i in button:
    def process(t=i):
        click(t)
    Button(window, text=i, width=5,command=process).grid(row=x, column=y)
    y+= 1
    if y > 4:
        x+= 1
        y=0
window.mainloop()