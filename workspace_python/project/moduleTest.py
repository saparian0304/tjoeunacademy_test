def plus(a, b):
    return a+b

# __name__ : __ 표현은 파이썬 내부에서 처리하는 변수임을 알려준다.
# 현재 파일에서 실행하면 '__main__'이 출력된다.
# import 한 곳에서는 'moduleTest'가 출력된다.
if __name__ == '__main__':  # 현재 파일에서 실행하면 실행, import시에는 실행 안됨
    print(__name__)
