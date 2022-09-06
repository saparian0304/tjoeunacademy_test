import datetime
from datetime import date, time

help(date)

today = date(2022, 9, 6)
print(today)


print(today.year)
print(today.month)
print(today.day)

w = today.weekday()
print('요일 정보 :', w)

help(time)

currTime = time(10, 19, 9)
print(currTime)

print(currTime.hour)
print(currTime.minute)
print(currTime.second)

isoTime = currTime.isoformat()
print(isoTime)

# 다중상속
class Iphone:
    def camera(self):
        print('카메라')
    def message(self):
        print('아이메시지')

class Galaxy:
    def samsungPay(self):
        print('삼성페이')
    def message(self):
        print('삼성메시지')

class NewPhone(Galaxy, Iphone):
    def internet(self):
        print('인터넷')


np = NewPhone()
np.camera()
np.samsungPay()
np.message()    # 동일한 메서드인 경우 상속할 때 앞에 써놓은 클래스의 메서드가 우선순위를 가짐


'''
magic method
비교
    __eq__ -> == 
    __ne__ -> !=
    __lt__ -> <
    __gt__ -> >
    ...
연산
    __add__ -> +
    __sub__ -> -
출력
    __repr__
    __str__

'''
print(dir(np))
print('test' == 'test')
print('test'.__eq__('test'))

class Text:
    def __init__(self, text):
        self.text = text
    def __eq__(self, target):
        return self.text.lower() == target.text.lower()     # 대소문자없이 구분없이 비교가 가능해짐
    def __str__(self):
        return self.text    # java에서 toString()와 유사함

t1 = Text('python')
t2 = Text('Python')
print(t1 == t2)
print(t1)