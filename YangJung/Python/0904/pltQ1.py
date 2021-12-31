import matplotlib.pyplot as plt
from matplotlib import font_manager, rc
font_name = font_manager.FontProperties(fname="c:/Windows/Fonts/malgun.ttf").get_name()
rc('font', family=font_name)

temp = [29,29,28,30,31,31,32]
day = ['월','화','수','목','금','토','일']

plt.plot(day,temp,c="r",lw="4")
plt.suptitle('이번 주 부산의 최고 낮 기온')
plt.xlabel("요일")
plt.ylabel("기온")
plt.show() 
