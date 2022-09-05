# (1) 함수 정의
def calc_func(a, b):    # 외부함수
    # 변수 선언 : 자료 저장
    x = a
    y = b

    def plus():     # 내부함수
        p = x + y
        return p

    def minus():    # 내부함수
        m = x - y
        return m
    return plus, minus

# (2) 함수 호출
p, m = calc_func(10, 20)
print('plus =', p())        # plus = 30
print('minus =', m())       # minus = -10

# (3) 클래스 정의
class calc_class:
    # 클래스 변수 : 자료 저장
    x = y = 0

    # 생성자 : 객체 생성 + 멤버변수 초기화
    # self : this (객체 자기 자신)
    def __init__(self, a, b):
        self.x = a  
        self.y = b

    # 클래스 함수
    def plus(self):
        p = self.x + self.y     # 변수 연산
        return p

    # 클래스 함수
    def minus(self):
        m = self.x - self.y     # 변수 연산
        return m

# (4) 객체 생성
obj = calc_class(10, 20)

# (5) 멤버 호출
print('plus =', obj.plus())
print('minus =', obj.minus())


# Docstring
# 함수의 설명
def test():
    '''test 함수에 대한 설명중...
    (1) ABCDEF
    (2) 가나다라마바사
    '''
    return 1

test()


class Car:
    # (1) 멤버변수
    # 변수를 선언하지 않고 생성자에서 정의를 해도 기능상에 문제는 없다.
    # cc = 0      # 엔진 cc
    # door = 0    # 문짝 개수
    # carType = None  # null

    # (2) 생성자
    def __init__(self, cc, door, carType):
        # 멤버 변수 초기화
        self.cc = cc
        self.door = door
        self.carType = carType      # 승용차, SUV

    # (3) 메서드
    def display(self):
        print('자동차는 %d cc이고, 문짝은 %d개, 타입은 %s' % (self.cc, self.door, self.carType))

# (4) 객체 생성
car1 = Car(2000, 4, "승용차")
car2 = Car(3000, 5, "SUV")

# (5) 멤버 호출 : object.member()
car1.display()
car2.display()
