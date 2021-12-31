from urllib.request import urlopen
from bs4 import BeautifulSoup

""" url="https://finance.naver.com/item/board.nhn?code=000660"
html=urlopen(url).read().decode('cp949','ignore')
soup=BeautifulSoup(html,'lxml')
ranks=soup.find_all('td',{'class':'title'})
list=[]
for rank in ranks:
    list.append(rank.get_text())

for i in range(5):
    print(list[i]) """

url="https://finance.naver.com/item/main.nhn?code=000660"
html=urlopen(url).read().decode('cp949','ignore')
soup=BeautifulSoup(html,'lxml')

for i in range(1,6):
    contents=soup.find_all("a",{"onclick":"clickcr(this, 'dle.3', '', '"+str(i)+"', event);"})
    print(contents[0].get_text())