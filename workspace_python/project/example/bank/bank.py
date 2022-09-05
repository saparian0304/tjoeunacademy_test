from project.example.bank.account import Account


class Bank:
    accountList = []
    def __init__(self, name):
        self.name = name + "은행"

    def createAccount(self):
        self.printMenu('계좌생성')
        try :
            no = int(input("계좌번호:"))
            name = input("계좌주: ")
            bal = int(input('초기입금액: '))
        except:
            print('형식에 맞춰서 입력해주세요')
            return

        for v in self.accountList:
            if v.holder == name:
                print("결과 이미 등록된 계좌입니다.")
                return
        newAccount = Account(bal, name, no)
        self.accountList.append(newAccount)

    def getAccountList(self):
        self.printMenu('계좌목록')
        for v in self.accountList:
            print(f'{v.accNo}\t{v.holder}\t{v.balance}')

    def deposit(self):
        self.printMenu('예금')
        try:
            no = int(input('계좌번호: '))
            depo = int(input('예금액: '))
        except:
            print('형식에 맞춰서 입력해주세요')
            return

        customer = self.findAccount(no)
        if customer != None:
            customer.balance += depo
            result = '예금이 성공적으로 이루어졌습니다.'
        else:
            result = '해당 계좌를 찾을 수 없습니다.'
        return print('결과:', result)

    def withdraw(self):
        self.printMenu('출금')
        try:
            no = int(input('계좌번호: '))
            amount = int(input('출금액: '))
        except:
            print('형식에 맞춰서 입력해주세요')
            return

        flag = False
        customer = self.findAccount(no)
        if customer != None :
            if amount > customer.balance:
                result = '계좌 잔액이 부족합니다. 계좌 잔액 : {}원'.format(customer.balance)
            else:
                customer.balance -= amount
                result = f'출금 성공! 계좌 잔액 {customer.balance}'
            flag = True
        if flag == False:
            result = '해당 계좌를 찾을 수 없습니다.'
        return print('결과:', result)

    def findAccount(self, no):
        for v in self.accountList:
            if no == v.accNo:
                return v
        return None

    def printMenu(self, menu):
        print('----------------')
        print(menu)
        print('----------------')
