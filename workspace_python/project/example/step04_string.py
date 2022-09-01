# (1) 특정 글자 수 반환
oneLine = "this is one line string"
print('t 글자 수 : ', oneLine.count('t'))

# (2) 접두어 문자 비교 판단
print(oneLine.startswith('this'))
print(oneLine.startswith('that'))

# (3) 문자열 교체
print(oneLine.replace("this", "that"))  # oneLine이라는 변수 자체가 바뀌는 것이 아니다
print(oneLine)

# (4) 문자열 분리(split) : 문단 -> 문장
multiLine = """this is
multi line
string"""
sent = multiLine.split('\n')    # 리스트로 리턴
print('문장 : ', sent)

# (5) 문자열 분리(split) 2: 문장 -> 단어
words = oneLine.split(' ') # sep = ' ' : default
print('단어 : ' , words)

# (6) 문자열 결합(join) : 단어 -> 문장
sent2 = ','.join(words)     # '구분자'.join(string)
print(sent2) # this, is, one, line, string

# 길이 - len()
print(len(oneLine))

# 위치(포함여부) - index(), find()
# print(oneLine.index('oxne'))  # 존재하지 않으면 에러
print(oneLine.find('oxne'))     # 존재하지 않으면 -1 리턴

# 에러가 안난다고 좋은 것은 아님, 오류 확인하기가 더 어려울 수 있음
if oneLine.count('oxne') > 0:
    print(oneLine.index('oxne'))

# raw string
string = r"안녕하세요\n반갑습니다."   # 출력시 개행문자 그대로 나옴
print(string)



