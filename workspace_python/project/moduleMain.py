# 모듈(파일) import
import moduleTest

s = moduleTest.plus(5, 10)
print(s)
# print(__name__)

# 특정 함수/클래스 import
from moduleTest import plus
print(plus(10, 20))

# alias
import moduleTest as m
print(m.plus(10,30))


# 패키지 포함 import
import packageTest.moduleTest as m2
print(m2.plus(20,30))