def control():
    while 1:
        button=input()
        if button =='u':
            print("볼륨을 증가시켰습니다.")
        if button == 'd':
            print("볼륨을 감소시켰습니다.")
        else:
            print("채널을 이동하였습니다.")
