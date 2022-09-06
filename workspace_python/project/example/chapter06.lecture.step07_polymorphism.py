# (1) 부모 클래스
class Flight:

    # 부모 원형 함수
    def fly(self):
        print('날다, fly 원형 메서드')

# (2) 자식 클래스 : 비행기
class Airplane(Flight):

    # 함수 재정의
    def fly(self):
        print('비행기가 날다.')

# (2) 자식 클래스 : 새
class Bird(Flight):

    # 함수 재정의
    def fly(self):
        print('새가 날다')

# (2) 함수 재정의 : 종이비행기
class PaperAirplane(Flight):

    # 함수 재정의
    def fly(self):
        print('종이 비행기가 날다')

class Car():

    def fly(self):
        print('차가 날아다닌다고?')

# (3) 객체 생성
# 부모 객체 = 자식객체(자식1, 자식2)
flight = Flight()   # 부모 클래스 객체
air = Airplane()    # 자식1 클래스 객체
bird = Bird()       # 자식2 클래스 객체
paper = PaperAirplane() # 자식 3 클래스 객체
car = Car()         # 상속관계가 아닌 객체

# (4) 다형성
flight.fly()

flight = air
flight.fly()

flight = bird
flight.fly()

flight = paper
flight.fly()

flight = car
flight.fly()

# 파이썬은 동적자료형이 특징이기때문에 상속받지 않더라도 똑같이 작용한다


flight_list = []
flight_list.append(Flight())
flight_list.append(Airplane())
flight_list.append(Bird())
flight_list.append(PaperAirplane())
flight_list.append(Car())

for f in flight_list:
    f.fly()

# 추상메서드
class Test:
    def amethod(self):
        raise NotImplementedError   # 강제 예외 발생 : 추상메서드 개념을 추가하기 위해서

class Test2(Test):
    pass
t2 = Test2()
# t2.amethod()      # override하지 않기 때문에 예외발생

