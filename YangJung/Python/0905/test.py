def convertString(txt):
    text=""
    for i in txt:
        if i.isupper():
            text+=" "+i.lower()
        else:
            text+=str(i)
    return text



string='playTheBaseball'
show=convertString(string)
print(show)