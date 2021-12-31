from urllib.request import urlopen
from bs4 import BeautifulSoup

""" html=urlopen("file:0904/songsong.html")
soup=BeautifulSoup(html,"lxml")
namelist=soup.find_all(title="유튜브")
for name in namelist:
    print(name.get_text())
    print(name['href'])
    print(name['title']) """

html=urlopen("http://news.naver.com/main/read.nhn?mode\
=LSD&mid=shm&sid1=105&oid=001&aid=0009371396")
soup=BeautifulSoup(html,"lxml")
namelist=soup.find_all('div', {'id':'articleBodyContents'})

for name in namelist:
    print(name.get_text())
