# 여기는 주석
print('안녕하세요')

# 자료형
# 정수(int)
# 실수(float)
# 문자열(string)
# 논리(bool)

# 파이썬에서는 기본자료형이라는 말을 사용하지 않음 -> 모든 것이 객체임

a = 10
print(type(a))
a = 3.14
print(type(a))  # dynamic type : 동적 자료형

print(1,2,3,4,5)   # 매개변수 여러개 출력 (기본값이 공백)
print(1,2,3,4,5, sep='-')   # 구분값 지정
# print함수는 end 속성 기본값이 출력 후 줄바꿈을 함 (end='\n')
print(1, end='')
print(2)
print(3)

# None Type
c = None    # 아직 값이 없지만 변수를 선언하고 싶을때 None를 사용, 초기화 용도
print(type(c))

# 변수 선언 방법
a,b = 1,2
print(a,b)

# 같은 변수를 다시 선언해도 에러가 나지 않는다
a = b = 3
print(a,b)

# 두 변수의 값을 교체
a = 1
b = 2
a, b = b, a     # 두 변수의 값을 간단하게 교체할 수 있음
print(a, b)

# 자료형 변환 -> 함수 이름이 자료형 이름임
a = '3.14'
print(type(a))
b = float(a)
print(type(b))

a = False    # boolean은 첫 글자가 대문자
b = int(a)
print(b)

# 값이 있으면 True, 없으면 False (0도 False)
print(bool(''))     # False
print(bool('a'))    # True
print(bool(1))      # True
print(bool(0))      # False
print(bool(31))     # True

# 연산
# 대입연산
# 산술연산
#  - // : 몫, ** : 제곱
# 비교연산 ( <, >, !=, ==, <=, >=)
# 논리연산
#  - and, or, not   (&&, ||, ! 사용X)
# 삼항연산 없음
# 증감연산 없음
print(10/4)
print(10//3)    # // : 몫
print(10%3)     # % : 나머지
print(2**8)     # ** : 제곱

a = 10
b = 5
# print(a==10 && b == 5)    # python에서는 &&, ||는 사용이 안됨
print(a==10 and b == 5)

# 이진수 연산에 &가 사용됨
a = 2
b = 3
print(a & b)
#   10
# & 11
# True, False (10) -> 2가 됨

# bin() 이진수로 표현하는 함수
print(bin(a))   # 0b10 (a가 2)
print(bin(b))   # 0b11 (b가 3)
print(bin(a&b)) # 0b10

# input() : 값 입력 (문자열로 리턴함)
# number = input('숫자를 입력하세요')
# print(number + 1)     # string이기 때문에 typeError 발생
# print(int(number) + 10)

number1 = 10
print('number1에 들어있는 숫자는 ' + str(number1) + '입니다.')

# help() : 함수의 관련 정보를 보여주는 함수
help(print)

# 포맷팅
# 전체 문자열은 고정, 특정값만 변경되는 경우
speed = 50
msg = "당신의 속도는 {}입니다.".format(speed)
print(msg)

name = '홍길동'
age = 30
tel = '010'
introduce = '이름은 {}이고, 나이는 {}살이며, 전화번호는 {}입니다'.format(name, age, tel)
print(introduce)
introduce = '이름은 %s이고, 나이는 %d살이며, 전화번호는 %s입니다'%(name, age, tel)
print(introduce)
introduce = f'이름은 {name}이고, 나이는 {age}살이며, 전화번호는 {tel}입니다'
print(introduce)

# 파이썬에서는 \(역슬래시)를 사용하면 줄바꿈이 안된 것으로 인식한다.
print(\
   introduce)
print('$$$$$$$$$$$$$$$$')
introduce = '이름:{}, 나이: {}, 전화번호 : {}'.format(name, age, tel)
print(introduce)
introduce = '이름:{1}, 나이: {2}, 전화번호 : {0}'.format(name, age, tel)
print(introduce)
introduce = '이름:{name}, 나이: {age}, 전화번호 : {tel}'.format(name='010', age='홍', tel='50')
print(introduce)
print('##################')

# 실수 포맷팅 (전체자리수.소수점자리수)
print('원주율:%10.3f' % 3.141592)

# 문자열
# '', "" 둘 다 사용 가능
# ''', """ 는 여러줄 표현이 가능함
introduce = """안녕하세요
나는 홍길동입니다
반갑습니다"""
print(introduce)
# 눈에 보이지 않지만 개행문자(\n)가 포함되어있음
introduce = """안녕하세요\n나는 홍길동입니다\n반갑습니다"""
print(introduce)

# 문자열 인덱싱
# 맨끝 인덱스 -1
string = '안녕하세요'
print(string[4], string[-1])

# 문자열 * 연산
print('-' * 10)
print('-' +'-' +'-' +'-' +'-' +'-' +'-' +'-' +'-' +'-')

# 문자열 슬라이싱
# 문자열[시작인덱스 : 끝인덱스 전 : 증감값]
print(string[0:2])
print(string[:2])   # 0은 생략이 가능함
print(string[2:])
print(string[::2])

# string은 immutable! : 변경되지 않는 자료형!
# string[0] = '간' # immutable하기 때문에 변경할 수 없음
sitrng = '간' + string[1:]
print(string)

# 문자열 처리 함수
# 형식 : 문자열객체.함수([인수])

# 함수
def test() :
    return 1

class Test :
    # 메서드
    def test(self):
        return 2

print(test())





