var = 10
if var >= 5:
    print('var=', var)
    print('var는 5보다 크다')
    print('조건이 참인 경우 실행')

print('항상 실행')

# 100~85 : '우수', 84 ~70: '보통', 69 이하 : '저조'
score= int(input('점수 입력 : '))
if score >= 85 and score <=100 :
    print('우수')
else :
    if score >= 70 :
        print('보통')
    else :
        print('저조')

# score가 60점 이상이면 합격, 미만이면 불합격
print('합격' if score >= 60 else '불합격')

num = 9
result = num * 2 if num >= 5 else num + 2
print('result =', result)

# in 연산자
lan = ['java', 'javascript', 'python', 'r']
print('python' in lan)  # lan에 있으면 True
print('python2' in lan) # lan에 없으면 False
print('python' not in lan) # lan에 있지 않으면 False

if 'python' in lan:
    print('배우자')

# if문, else문 사이에 아무것도 없으면 에러가 남 -> pass 예약어 사용
if 'go' in lan:
    pass    # 아무 실행이 안됨
else:
    print('배우자')

# if문의 조건이 bool이 아닌 경우
# 값이 있으면 True, 없으면 False
# None, 0, 0.0, '', []: 빈 리스트, {}: 빈 딕셔너리, (): 빈 튜플 -> False
# 각 타입의 기본값은 False
a = {}
if a :
    print('참')
else : print('거짓')