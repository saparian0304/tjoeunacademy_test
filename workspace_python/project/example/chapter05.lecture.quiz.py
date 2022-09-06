# 문제 1
def starCount(height):
    for v in range(1,height+1):
        print('*' * v)


height = int(input('height : '))
starCount(height)
num = 0
for v in range(1,height+1):
    num += v
print('star 개수 : ', num)

# 문제 2

def bank_account(bal):
    balance = bal   # 잔액 초기화

    def getBalance():
        return balance

    def deposit(money):     # 입금하기(setter)
        result = getBalance() + money
        print(f'{money}원 입금 후 잔액은 {getBalance() + money}입니다')
        return result
        # return bank_account(getBalance() + money)
    # def withdraw(money):    # 출금하기(setter)
    #     if money > balance:
    #         print('잔액이 부족합니다.')
    #         return
    #     else:
    #         balance -= money
    #         print('출금 후 잔액은 {}원입니다.')
    #         return balance

    return getBalance, deposit

acc= bank_account(1000)
print(acc[0]())

print(acc[1](200))
print(acc[0]())

# 문제 3
def factorial(n):
    if n == 1:
        return 1
    else:
        return n * factorial(n-1)

result_fact = factorial(5)
print('팩토리얼 결과 :', result_fact)

