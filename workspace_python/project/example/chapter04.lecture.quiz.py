# 문제 1
# 단계1
import random

lst = [10, 1, 5, 2]
result = lst * 2
print(result)

# 단계 2
lst = [10, 1, 5, 2]
result = lst * 2
result.append(lst[0]*2)
print(result)

# 단계 3
result2 = []
for i in range(len(result)) :
    if i % 2 == 1:
        result2.append(result[i])
print(result2)

# 문제 2
# A형
# vector = int(input('vector 수 : '))
# lst = []
# for a in range(vector):
#     num = random.randint(1, 10)
#     lst.append(num)
#     print(num)
# print("vector 크기 :", len(lst))

# B형
# vector = int(input('vector 수 : '))
# lst = []
# for i in range(vector):
#     num = random.randint(1,10)
#     lst.append(num)
#     print(num)
#
# answer = int(input('찍기 : '))
# if answer in lst:
#     print('YES')
# else :
#     print('NO')

# 문제 3
# A형
message = ['spam', 'ham', 'spam', 'ham', 'spam']
dummy =[]
for a in message:
    if a == 'spam':
        dummy.append(1)
    elif a == 'ham':
        dummy.append(0)
print(dummy)

# B형
spam_list = []
for a in message:
    if a == 'spam':
        spam_list.append(a)

print(spam_list)

# 문제 4
position = ['과장', '부장', '대리', '사장', '대리', '과장']
cnt = {}
print('중복되지 않은 직위 :',set(position))
for a in set(position) :
    cnt[a] = position.count(a)
print('각 직위별 빈도수 :', cnt)


# 1.1 Task 1
# Write function remove_zero(x), the argument x is a list of numbers.
# You should return a list such that, all the zeros in x are removed.
# For example,
#   remove_zero([0, 1, 2, 3, 0, 4])
# should return [1,2,3,4]
def remove_zero(lst):
    for i in lst:
        if lst.count(0) > 0:
            lst.remove(0)
    return lst
print(remove_zero([0,1,2,3,0,4]))

# 1.2
# 정수형 리스트를 반환, n까지의 소수
# n = 10
# lst = list(range(2,n+1))
# t = list(range(2, n+1))
# cnt = 0;
# print(lst)
# for num in t:
#     print('lst : ', lst)
#     print('cnt : ', cnt)
#     print('num : ',num)
#     print('lst[cnt]', lst[cnt])
#     for a in range(2,lst[cnt]):
#         print('a : ', a)
#         # print('num : ', num, ', a : ', a)
#         if num != a and num % a == 0 :
#             print('for문 성공한 숫자 num, a: ', num, a)
#             for b in list(range(num, n, num)):
#                 lst.remove(b)
#                 print('현재 lst : ', lst)
#                 print('지울 숫자 : ', b)
#                 print('##########')
#             break
#     cnt += 1
# print(lst)



def prime_list(n) :
    lst = list(range(2, n + 1))
    t = list(range(2, n + 1))
    # print(lst)
    for num in t:
        # print(num)
        for a in list(range(2, num + 1)):
            # print('num : ', num, ', a : ', a)
            if num != a and num % a == 0:
                # print('지울 숫자 : ', num)
                lst.remove(num)
                break
    return lst

# print(prime_list(5))


n = 10
lst = list(range(1,n+1))
print(list(range(0,n)))
for a in range(0,n):
    print(lst[a])

    for num in lst:
        print('lst : ', lst)
        print('cnt : ', cnt)
        print('num : ',num)
    print('lst[cnt]', lst[cnt])
    for a in range(2,lst[cnt]):
        print('a : ', a)
        # print('num : ', num, ', a : ', a)
        if num != a and num % a == 0 :
            print('for문 성공한 숫자 num, a: ', num, a)
            for b in list(range(num, n, num)):
                lst.remove(b)
                print('현재 lst : ', lst)
                print('지울 숫자 : ', b)
                print('##########')
            break
    cnt += 1