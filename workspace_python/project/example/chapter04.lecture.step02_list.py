x = list(range(1, 11))

print(x)
print(x[:5])
print(x[-5:])
print('index 2씩 증가')
print(x[::2])
print(x[1::2])

# 정렬
a = [3,2,1]
a.sort() # 실제 a를 바꿔버림
print(a)

a.reverse() # 내림차순을 하는것이 아니라 그냥 있는 순서를 바꾸는 것
print(a)

# 역순정렬
a = [2, 8, 3, 6]
a.sort()
a.reverse()
print(a)

# 해당 요소의 인덱스값 리턴
print(a.index(8))   # find() 없음

# 마지막 값을 리턴하고 삭제
print(a.pop())
print(a)

# 요소 개수
print(a.count(3))

if 9 in a :     # 9가 있는지 확인
    print(a.index(9))