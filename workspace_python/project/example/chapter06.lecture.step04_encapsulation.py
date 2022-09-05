class Account:
    # (1) 은닉 멤버 변수
    __balance = 0       # 잔액
    __accName = None    # 예금주
    __accNo = None      # 계좌번호

    # (2) 생성자 : 멤버변수 초기화
    def __init__(self, bal, name, no):
         self.__balance = bal   # 잔액 초기화
         self.__accName = name  # 예금주
         self.__accNo = no      # 계좌번호

    # (3) 계좌 정보 확인 : Getter
    def getBalance(self):
        return self.__balance, self.__accName, self.__accNo

    # (4) 입금하기 : Setter
    def deposit(self, money):
        if money < 0 :
            print('금액 확인')
            return  # 종료(exit)
        self.__balance += money

    # (5) 출금하기 : Setter
    def withdraw(self, money):
        if self.__balance < money:
            print('잔액 부족')
            return  # 종료(exit)
        self.__balance -= money

# (6) object 생성
acc = Account(1000, '홍길동', '125-152-4125-41')   # 생성자

# (7) Getter 호출
# acc.__balance     # 접근을 막는게 아니라 변수 이름을 바꿔버림, dir() 함수로 필드이름 확인 가능 (_Account__balance)
bal = acc.getBalance()
print('계좌정보 : ', bal)

# (8) Setter 호출
acc.deposit(10000)
bal = acc.getBalance()
print('계좌정보 : ', bal)   # 입금 확인

print(dir(acc))
print(acc._Account__balance)



# 게터, 세터
class Member:
    def __init__(self, name):
        self.name = name
    def getName(self):
        return self.name + '님'
    def setName(self, name):
        if len(name) < 3:
            print('이름은 3글자 이상 가능합니다.')
        else:
            self.name = name
    # 게터 세터 적용
    fname = property(getName, setName)
m = Member('홍길동')
# 게터
print(m.fname)
# 세터
m.fname = '이이'

# property() 내장함수 : 첫번째 인수에 getter, 두번째 인수에 setter메서드를 넘겨주면
# 일반 필드에 접근하는 것처럼 보이나, getter, setter 메서드를 호출하여 사용할수 있게됨