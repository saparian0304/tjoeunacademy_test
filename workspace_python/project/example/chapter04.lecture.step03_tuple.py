# 튜플 선언
t = (10, )  # 원소가 하나일때는 int 선언과 구분을 위해서 ','를 함께 넣어준다
print(type(t))

t = (1, 2, 3, 4, 5)
print(type(t))
t = 1, 2, 3, 4, 5   # 괄호 생략 가능
print(type(t))

# 함수가 리턴을 여러개 할 수 있는게 아니라 튜플형태로 리턴
def calc(a, b):
    add = a+b
    minus = a-b
    multi = a*b
    divide = a/b
    return add, minus, multi, divide

print(calc(3,5))
print(type(calc(3,5)))
a, b, c, d = calc(3,5)
print(a,b,c,d)

# set
a = [1,2,3,4,5,1,2,]
b = set(a)
print(b)

# dictionary
person = {'name':'홍길동', 'age':35, 'address':'서울시'}
print(type(person))
print(person['name'])
print(person.get('name2', '없음'))
print(person)
# 추가(없는 키로 대입)
person['tel'] = '010-1111-2222'
print(person)
# 수정(존재하는 키로 대입)
person['address'] = '제주시'
print(person)
# 삭제
del person['tel']   # dict에만 쓰이는 게 아님, del : 지정 요소 삭제 (함수가 아닌 예약어임)
print(person)

# del person  # 변수 자체가 삭제
# print(person)

# 딕셔너리를 추가
person['school'] = {'first':'00초등학교', 'second':'OO중학교', 'third':'DD고등학교'}
print(person['school'])
print(person)
# 중학교 출력
print(person['school']['second'])

# 키만 반복
print(person.keys())    # 리턴타입이 리스트는 아니나 리스트와 유사하게 동작함
for v in person.keys():
    print(v)

for v in person.values():
    print(v)

print(person.items())
for k,v in person.items():
    print(k,v)

# 참조자료형
lst1 = [1,2,3]
lst2 = lst1 # 주소가 대입
print(id(lst1))     # id() : 변수가 저장된 주소를 확인할 수 있음
print(id(lst2))
lst1[0] = 4
print(lst2)

import copy
lst3 = copy.deepcopy(lst1)
print(id(lst3))
