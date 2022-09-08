class Account:
    __accountNum = ''
    __name = ''
    __balance = 0

    def __init__(self, accountNum, name, balance):
        self.__name = name
        self.__accountNum = accountNum
        self.__balance = balance

    def getAccountNum(self):
        return self.__accountNum
    def setAccountNum(self, accountNum):
        self.__accountNum = accountNum
    def getName(self):
        return self.__name
    def setName(self, name):
        self.__name = name
    def getBalance(self):
        return self.__balance
    def setBalance(self, balance):
        self.__balance = balance

    accountNum = property(getAccountNum, setAccountNum)
    name = property(getName, setName)
    balance = property(getBalance, setBalance)

# 계좌 조회
def findAccount(accountNum):
    for account in accountList:
        if accountNum == account.accountNum:
            return account


accountList = []
while True:
    print('-' * 40)
    print('1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료')
    print('-' * 40)
    num = int(input('선택 > '))
    if num == 1:
        print('-'*10)
        print('계좌생성')
        print('-'*10)
        accountNum= input('계좌번호:')
        name = input('계좌주:')
        balance= int(input('초기입금액:'))
        if findAccount(accountNum) :
            print('이미 등록된 계좌입니다.')
        else:
            accountList.append(Account(accountNum, name, balance))
            print('계좌가 생성되었습니다.')
    elif num == 2:
        print('-'*10)
        print('계좌목록')
        print('-' * 10)
        for a in accountList:
            print(f'{a.accountNum}\t{a.name}\t{a.balance}')
    elif num == 3:
        print('-' * 10)
        print('예금')
        print('-' * 10)
        accountNum = input('계좌번호')
        price = int(input('입금액'))
        acc = findAccount(accountNum)
        if acc :
            acc.balance += price
        else :
            print('계좌가 존재하지 않습니다.')

    elif num == 4:
        print('-' * 10)
        print('출금')
        print('-' * 10)
        accountNum = input('계좌번호')
        price = int(input('출금액'))
        acc = findAccount(accountNum)
        if acc:
            if acc.balance >= price:
                acc.balance -= price
            else:
                print('잔액이 부족합니다.')
        else :
            print('계좌가 존재하지 않습니다.')
    elif num == 5:
        break
