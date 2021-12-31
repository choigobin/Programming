from urllib.request import urlopen
from bs4 import BeautifulSoup

for i in range(35701,35760):
    url="http://www.inven.co.kr/board/overwatch/4676/"+str(i)
    try:
        html=urlopen(url)
        soup=BeautifulSoup(html,'lxml')
        contents=soup.find('div', {'class':'articleCategory'})
    except:
        pass
    if len(contents)!=0:
        if "영웅" in contents.getText():
            print(str(i)+"번째 게시물")
            contents=soup.find('div',{'class':'articleTitle'})
            print(contents.getText())
