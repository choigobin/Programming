from urllib.request import urlopen
from bs4 import BeautifulSoup

for i in range(35699,35757):
    url="http://www.inven.co.kr/board/overwatch/4676/"+str(i)
    try:
        html=urlopen(url)
        soup=BeautifulSoup(html,"lxml")
        contents=soup.find('div', {'class':'articleCategory'})
    except:
        pass
    
    if len(contents)!=0:
        if "시스템" in contents.getText():
            print(str(i)+"번째 게시물")
            contents=soup.find('div',{'id':'powerbbsContent'})
            print(contents.getText())

""" for i in range(35702,35753):
    url="http://www.inven.co.kr/board/overwatch/4676/"+str(i)
    try:
        html=urlopen(url)
        soup=BeautifulSoup(html, "lxml")
        contents=soup.find_all("div", {"class":"articleCategory"})
    except:
        pass

    print("기다려주세요. 시간이 걸립니다.")
    print("")

    if len(contents)!=0:
        if "시스템" in contents[0].get_text():
            print(str(i)+"번째 게시물입니다.")
            contents=soup.find_all("div", {"class":"contentBody"})
            print(contents[0].get_text()) """