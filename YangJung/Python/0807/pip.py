# PIL 모듈에서 몇 개의 클래스를 포함시킨다. 
from PIL import Image, ImageTk, ImageFilter

# tkinter 모듈을 포함시킨다. 
import tkinter as tk

# 윈도우를 생성하고 윈도우 안에 캔버스를 생성한다. 
window = tk.Tk()
canvas = tk.Canvas(window, width=500, height=500)
canvas.pack()

# 윈도우를 생성하고 윈도우 안에 캔버스를 생성한다. 
img = Image.open("lenna.png")

# 영상을 45도 회전한다. 
#out = img.rotate(45) 

# 영상을 흐리게 한다. 
out = img.filter(ImageFilter.BLUR)

# tk 형식으로 영상을 변환한다. 
tk_img = ImageTk.PhotoImage(out)

# tkinter의 캔버스에 영상을 표시한다. 
canvas.create_image(250, 250, image=tk_img)

window.mainloop()
