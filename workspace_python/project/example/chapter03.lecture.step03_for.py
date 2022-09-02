string = '홍길동'
print(len(string))
for s in string :
    print(s)

lstset = [1, 2, 3, 4, 5]
for e in lstset :
    print('원소 :', e)

# 인덱스가 필요한 경우
for idx, val in enumerate(lstset):
    print(idx, val)     # index와 값을 같이 출력해줌

# help(enumerate)

# (1) range 객체 생성
num1 = range(10)        # range(start)
print('num1 : ', num1)
num2 = range(1, 10)     # range(start, stop)
print('num2 : ', num2)
num3 = range(1, 10, 2)  # range(start, stop, step)
print('num3 : ', num3)

# (2) range 객체 활용
for n in num1:
    print(n, end=' ')
print()
for n in num2:
    print(n, end=' ')
print()
for n in num3:
    print(n, end=' ')
print()
for n in range(0, 50) :
    print(n, end=' ')
    print()
print(list(num1))

string = """나는 홍길동 입니다.
주소는 서울시 입니다.
나이는 35세 입니다."""

sents = [] # 문장 저장
words = [] # 단어 저장

# (1) 문단 -> 문장
for sen in string.split(sep = "\n") :
    sents.append(sen)
    # (2) 문장 -> 단어
    for word in sen.split() :
        words.append(word)

print('문장 :', sents)
print('문장수 :', len(sents))
print('단어 :', words)
print('단어 수 :', len(words))

# List Comprehension (내포된 for문)
# - 리스트를 간편하게 만들어주는 방법
# - 일반 for문보다 속도가 빠름
lst = [0, 1, 2, 3]
# result 변수에 lst의 각 요소를 제곱

# 일반 for문
result = []
for v in lst:
    result.append(v**2)
print(result)

# 내포된 for문
result2 = [v**2 for v in lst]
print(result2)

# result3라는 변수에 리스트로 '홀수', '짝수'...
# 일반for문
result3 = []
for a in lst :
    result3.append('홀수' if a % 2 == 1 else  '짝수')
print(result3)

# 내포된 for문
result4 = [
    '홀수' if a % 2 == 1 else '짝수'
    for a in lst
]
print(result4)

# 3장 연습문제 A형
weight = int(input('짐의 무게는 얼마입니까? '))
print('수수료는 없습니다.' if weight < 10 else '수수료는 10,000원입니다.')

# 3장 연습문제 B형
weight = int(input('짐의 무게는 얼마입니까? '))
if weight < 10 :
    print('수수료는 없습니다.')
else :
    fee = weight // 10
    print('수수료는 {}0,000원 입니다.'.format(fee))

# 3장 연습문제 2
import random

print('>>숫자 맞추기 게임<<')
com = random.randint(1, 10)

while True :
    my = int(input('예상 숫자를 입력하시오 : '))
    if com < my :
        print('더 작은 수 입력')
    elif com > my :
        print('더 큰 수 입력')
    else :
        break

# 문제 3
arr = []
sum = 0;
for i in range(1,101) :
    if i%3 == 0 and i%2 != 0 :
        arr.append(i)
        sum += i
print('수열 =',end=' ')
for v in arr:
    print(v, end=' ')
print()
print('누적합 =', sum)

# 문제 4
multiline = """안녕하세요. 파이썬 세계로 오신걸
환영합니다.
파이썬은 비단뱀 처럼 매력적인 언어입니다."""

sents = multiline.split()
cnt = 0;
for i in sents:
    print(i)
    cnt += 1
print("단어 개수 :", cnt)