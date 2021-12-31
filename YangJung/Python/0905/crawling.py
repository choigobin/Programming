from urllib.request import urlopen
from bs4 import BeautifulSoup

url="https://finance.naver.com/item/sise.nhn?code=000660"
html=urlopen(url).read().decode('cp949','ignore')
soup=BeautifulSoup(html,'lxml')
ranks=soup.find_all('dl',{'class':'blind'})
for rank in ranks:
    print(rank.get_text())