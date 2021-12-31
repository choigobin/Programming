class TV:
    def __init__(self):
        self.channel=1
        self.volume=0
        self.stat="OFF"
    def turnOn(self):
        self.stat="ON"
    def turnOff(self):
        self.stat="OFF"
    def volume(self,num):
        self.volume+=num
    def channel(self,num):
        self.channel+=num




TV1=TV()
print(TV1.channel,TV1.volume,TV1.stat)

TV1.turnOn()
print(TV1.channel,TV1.volume,TV1.stat)