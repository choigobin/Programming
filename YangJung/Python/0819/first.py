try:
    a=[1,2]
    print(a[3])
    4 / 0
except ZeroDivisionError as e:
    print(e)
except IndexError:
    print("index out of range")
finally:
    print("The End")

try:
    a=[1,2]
    print(a[3])
    4/0
except (ZeroDivisionError, IndexError) as e:
    print(e)
