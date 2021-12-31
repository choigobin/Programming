from tkinter import*
root=Tk()

def click(event):
    print("클릭위치",event.x,event.y)
    
def keyPressed(ax):
    print(ax.char)

frame = Frame(root,width=300,height=300)

frame.bind('<Key>',keyPressed)
frame.place(x=0,y=0)
frame.focus_set()
frame.bind("<Button-1>",click)
frame.pack()
root.mainloop()
