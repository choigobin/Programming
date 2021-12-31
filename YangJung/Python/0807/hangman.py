import random

guesses=''
turns=10

infile=open("word.txt","r")
lines = infile.read().split()
word = random.choice(lines)
print(word)

while turns > 0:
    failed=0
    guess=input("단어를 추측하시오:")
    guesses+=guess
    for char in word:
        if char in guesses:
            print(char, end=" ")
        else:
            print("_",end=" ")
            failed+=1
    if failed==0:
        print("사용자 승리")
        break
    print("")
    if guess not in word:
        turns -=1
        print("틀렸음!")
        print(str(turns)+'기회 남았음!')
        if turns ==0:
            print("사용자 패배 정답은 "+word)
    
infile.close