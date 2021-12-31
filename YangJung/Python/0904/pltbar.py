import matplotlib.pyplot as plt

me=[1950,2350,1850,2200,3800,2800,2000]
you=[1750, 2150, 2550, 2300, 2400, 1900, 1600]
x=[1,2,3,4,5,6,7]
day=["Mon","Tue","Wed","Thr","Fri","Sat","Sun"]

plt.bar(day,me,label="me", color="g")
plt.bar(day,you,label='you', color='b',bottom=me)

plt.xlabel("day")
plt.ylabel("Kcal")
#plt.xticks(x,day,rotation="vertical")
plt.legend()
plt.show()