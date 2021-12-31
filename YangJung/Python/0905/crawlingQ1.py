from urllib.request import urlopen
from bs4 import BeautifulSoup

html=urlopen("http://news.naver.com/main/read.nhn?mode\
=LSD&mid=shm&sid1=105&oid=001&aid=0009371396")
soup=BeautifulSoup(html,"lxml")
namelist=soup.find_all('div', {'id':'articleBodyContents'})
text=""

f = open("data.txt", 'w')
for name in namelist:
    text = text+name.get_text()
    f.write(text)
f.close()