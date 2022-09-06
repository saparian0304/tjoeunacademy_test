# f = open('test.txt', 'w', encoding='utf-8')
# f.write('안녕하세요')
# f.close()

# f = open('test2.txt', 'a', encoding='utf-8')
# txt = ''
# for i in range(10):
#     txt += str(i) + '안녕하세요\n'
# f.write(txt)
# f.close()

'''
파일 읽기
readline() : 한줄 읽기
readlines() : 여러 줄 읽기(리스트로 리턴)
read() : 전체를 하나의 문자열로 읽기


'''
f = open('test2.txt', 'r', encoding='utf-8')
# 한줄 읽기
# txt = f.readline()
# print(txt)
# while True:
#     txt = f.readline()
#     if txt:
#         print(txt, end='')
#     else: break
# f.close()


# 여러줄 읽기
# txt = f.readlines() # 리스트 형태로 변환
# for line in txt:
#     print(line, end='')
# f.close()

# print(f.read())
# f.close()

'''
JSON
[] : 배열(JSON) -> 리스트(python)
{} : 객체(JSON) -> 딕셔너리(python)
'''

f = open('test.json', 'r', encoding='utf-8')
# print(f.read())
import json
text = json.loads(f.read())
print(type(text[0]))
for v in text:
    print(v.get('name'))
    print(v['name'])
f.close()

'''
외부 라이브러리 설치
pip install 라이브러리명

파이참에서 설치
File > settings > Project:workspace > Python Interpreter > + 버튼 > 검색 > install

외부 json 읽기
 - url 접속해서 읽어오기
 - requests 모듈(패키지, 라이브러리) 설치
'''
import requests     # requests 모듈
# url을 get방식으로 호출
res = requests.get('http://localhost:8080/controller/sample/ex06')
print(res)  # response 객체 출력
# print(res.text)
# print(res.url)
# print(dir(res))
# user = json.loads(res.text)
user = res.json()
for u in user:
    print(u['name'], u['age'])

'''
Pickle
- 객체를 바이너리 형태의 파일로 저장(직렬화)
- 단순 파일 저장보다 속도가 빠름
'''
class Member:
    def __init__(self, name):
        self.name = name

m = Member('홍길동')
print(m.name)

# 피클로 저장
import pickle
with open('member.pkl', 'wb') as f:
    pickle.dump(m, f)


# 피클파일 로드
import pickle
with open('member.pkl', 'rb') as f:
    m2 = pickle.load(f)
print(m2)
print(m2.name)
