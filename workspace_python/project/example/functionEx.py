def minus(x,y): # 인수(argument)
    return x-y

r = minus(2,1)  # 파라미터
print(r)

# 매개변수를 직접 지정할 수 있음, 순서와 관계 없음
r = minus(y=1,x=2)
print(r)

# 매개변수 기본값 설정
def member(name, age=20, gender='남자'):
    # print('제 이름은 {}이고, 나이는 {}살이고, 성별은 {}입니다.'.format(name, age, gender))
    print(f'제 이름은 {name}이고, 나이는 {age}살이고, 성별은 {gender}입니다.')
member('홍길동', 30)

# 가변인수
# 파라미터 개수를 알 수 없을 때 사용
# *args : 파라미터들을 튜플로 전달
# **kwargs : 파라미터들을 딕셔너리(dict)로 전달

# 모든 파라미터의 합계를 리턴하는 함수
def total(*args):
    t = 0
    for v in args:
        t += v
    return t


print(total(1, 2, 3, 4, 5, 6, 7, 8, 9))


def member(**kwargs):
    for k, v in kwargs.items():
        print(k, v)


member(name="홍길동", id='hong', email="hong@gmail.com", age=23)

# lambda
# 단일문으로 된 익명함수(일회성)
print(type(minus))

minus2 = lambda x, y:x-y
print(minus(10, 5))
print((lambda a,b:a-b)(10,2))   # print 함수의 매개변수로 람다함수를 정의하고 실행


# callback
# 계산기 함수
def calc(func, a, b):   # func : 함수
    r = func(a, b)      # 함수 실행
    return r

result = calc(minus, 6, 4)
print(result)

# 스코프(Scope)
# 함수안에 있는 지역변수는 함수가 실행될 때 생성되고, 실행이 끝나면 소멸
# 함수에서 전역변수는 잘 사용하지 않음 -> 함수가 특정 전역변수에 종속되어버리기 때문
x = 50
def local_func(x):
    # global x
    x += 50
    return x
x = local_func(x)
print(x)


# 내부함수
def outer(a, b):
    def inner(c, d):
        return c+d
    return inner(a,b)

print(outer(1,2))
# print(inner(1,2)) 실행 안됨

def outer(a, b):
    def inner(c, d):
        return c+d
    return inner    # 함수를 리턴!

# 일급함수와 함수 클로저
# 일급함수 : 변수에 외부함수 또는 내부함수를 저장할 수 있음

# Closure(클로저)
# 독립적인 공간
# 내부함수 개념을 이용해서 별도 스코프 존재
# 함수 클로저는 외부함수가 종료되어도 내부함수에서 선언된 변수가 메모리에서 소멸되지 않은 상태로 내부함수를 사용할 수 있음

# 리턴된 내부함수를 변수에 담아서 사용
i = outer(1,2)
print(i(3,5))


def test():
    text = '안녕하세요'
    return lambda : text

print(test())       # 함수 자체가 출력 됨
print(test()())     # 함수 실행된 결과를 출력 됨


def test2(name):
    text = f'안녕하세요 저는 {name}입니다.'
    return lambda: text


t1 = test2('홍길동')
t2 = test2('김길동')
print(t1())     # 함수가 종료되어도 '홍길동'이 저장되어있는 상태로 메모리 어디엔가 저장되어있음
print(t2())     # 함수가 종료되어도 '김길동'이 저장되어있는 상태로 메모리 어디엔가 저장되어있음


# 데코레이터 (decorator, 함수장식자)
# 함수 내의 코드를 변경하지 않고, 기능을 추가(앞, 뒤)할때 사용
def plus(a,b):
    # print('로그인 체크')
    r = a+b
    # print('로그 출력')
    return r
def minus(a,b):
    # print('로그인 체크')
    r = a-b
    # print('로그출력')
    return r

# 데코레이터 사용하기
def deco(func):
    def wrap(*args, **keyword):
        print('로그인 체크')
        func(*args, **keyword)
        print('로그 출력')
    return wrap     # 클로저 함수 반환

@deco
def plus(a,b):
    print('함수 실행')
    return a + b

plus(1,2)

# 실행시간 구하는 데코레이터
def timer(func):
    def wrap(*args, **kwargs):
        import time
        start = time.time()
        func(*args, **kwargs)
        end = time.time()
        print('실행시간 : ', end-start)
    return wrap

@timer
def total(n1, n2):
    t = 0
    for v in range(n1, n2+1):
        t += v
    return t

@timer
def total2(n1, n2):
    return sum(range(n1, n2+1))

total(1, 100000)
total2(1, 100000)


def counter(n):
    if n == 0:
        return 0
    else :
        # print(n)
        counter(n-1)
    print(n)

print('n=0 : ', counter(0))
counter(5)





