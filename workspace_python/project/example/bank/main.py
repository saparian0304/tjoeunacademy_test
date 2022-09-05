from project.example.bank import bank


bank = bank.Bank("종각")
print(f'{bank.name}에 오신 여러분 환영합니다.')
while True :
    print('----------------------------------------------------')
    print('1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5. 종료')
    print('----------------------------------------------------')
    sel = input('선택> ')

    if sel == '1':
        bank.createAccount()
    elif sel == '2':
        bank.getAccountList()
    elif sel == '3':
        bank.deposit()
    elif sel == '4':
        bank.withdraw()
    elif sel == '5':
        break
    else:
        print("다시 입력해주세요")

print(f'{bank.name}을 이용해주셔서 감사합니다.')