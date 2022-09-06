class Member:
    def __init__(self, name):
        self.name = name
    def run(self, target):
        print('{}님은 {}(으)로 달려갑니다.'.format(self.name, target))

m = Member('홍길동')
m.run('집')

# 상속
class Admin(Member):
    def manage(self):
        print('관리자 이름은 {}입니다.'.format(self.name))
a = Admin('김길동')
a.run('회사')     # 부모(Member)클래스에 있던 메서드
a.manage()

# 메서드 재정의(override)
class Admin2(Member):
    def run(self, target):
        # super : 부모클래스
        super().run('집')
        print('{}님은 {}(으)로 열심히 달려갑니다.'.format(self.name, target))

a2 = Admin2('최길동')
a2.run('거래처')