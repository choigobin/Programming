from urllib.request import urlopen
from bs4 import BeautifulSoup

html=urlopen("http://comic.naver.com/webtoon/weekday.nhn")
soup=BeautifulSoup(html,"lxml")
namelist=soup.find_all('a', {'class':'title'})

for name in namelist:
    print(name.get_text())