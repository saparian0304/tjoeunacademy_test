print('----------------------------------------------------')
print('1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5. 종료')
print('----------------------------------------------------')
sel = int(input('선택> '))


class Account:

    def __init__(self, balance, holder, accNo):
        '''balance : 초기 입금액
        holder : 계좌주 성명
        accNo : 계좌번호
        '''
        self.balance = balance
        self.holder = holder
        self.accNo = accNo

    def getBalance(self):
        return self.balance
    def getHolder(self):
        return self.holder
    def getAccNo(self):
        return self.accNo

    def setBalance(self, bal):
        self.balance = bal
    def setHolder(self, name):
        self.holder = name
    def setAccNo(self, no):
        self.accNo = no



if __name__ == '__main__' :
    a = Account(100, '홍길동', 123-123)
    print(a.holder)
    print(a.balance)