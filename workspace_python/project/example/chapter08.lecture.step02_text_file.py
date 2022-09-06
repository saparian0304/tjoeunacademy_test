import os
print('현재 경로:', os.getcwd())

try:
    ftest1 = open('ftest.txt', 'r')
    print(ftest1.read())

    ftest2 = open('ftest2.txt', 'w')
    ftest2.write('my first text ~~~')

    ftest3 = open('ftest2.txt', 'a')
    ftest3.write('\nmy second text ~~~')

    print('두번째 읽기')
    print(ftest1.read()+'끝')

except Exception as e:
    print('Error 발생 :', e)

finally:
    ftest1.close()
    ftest2.close()
    ftest3.close()