text = input()
mos = list(text)
result=""
for i in mos:
    if i == " ":
        result+=str("  ");
    elif i == "A" or "a":
        result+= str(".- ");
    elif i == "B" or "b":
        result+= str("-... ");
    elif i == "C" or "c":
        result+= str("-.-. ");
    elif i == "D" or "d":
        result+= str("-.. ");
    elif i == "E" or "e":
        result+= str(". ");
    elif i == "F" or "f":
        result+= str("..-. ");
    elif i == "G" or "g":
        result+= str("--. ");
    elif i == "H" or "h":
        result+= str(".... ");
    elif i == "I" or "i":
        result+= str(".. ");
    elif i == "J" or "j":
        result+= str(".--- ");
    elif i == "K" or "k":
        result+= str("-.- ");
    elif i == "L" or "l":
        result+= str(".-.. ");
    elif i == "M" or "m":
        result+= str("-- ");
    elif i == "N" or "n":
        result+= str("-. ");
    elif i == "O" or "o":
        result+= str("--- ");
    elif i == "P" or "p":
        result+= str(".--. ");
    elif i == "Q" or "q":
        result+= str("--.- ");
    elif i == "R" or "r":
        result+= str(".-. ");
    elif i == "S" or "s":
        result+= str("... ");
    elif i == "T" or "t":
        result+= str("- ");
    elif i == "U" or "u":
        result+= str("..- ");
    elif i == "V" or "v":
        result+= str("...- ");
    elif i == "W" or "w":
        result+= str(".-- ");
    elif i == "X" or "x":
        result+= str("-..- ");
    elif i == "Y" or "y":
        result+= str("-.-- ");
    elif i == "Z" or "z":
        result+= str("--.. ");      

print (result)
print (mos)