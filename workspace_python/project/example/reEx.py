'''
정규표현식 (Regular Expression)
- 특정 패턴과 일치하는 문자열을 검색, 치환, 삭제하는 기능을 위해 사용
- 정규식을 안쓰고 Rule(규칙)기반으로 하면 거의 불가능하거나 높은 Cost(시간, 인력, 비용)를 지불해야함

'''

# raw string
a = r'abc\ndef'
print(a)
'''
기본 패턴
- 'a', 'A', 1, ... 등등 문자(숫자)와 정확히 일치
. : 한개의 문자
\w : 한개의 문자 [a-zA-z0-9_]
\d : 숫자

escape문자 + 대문자를 사용하면 기존의미에 반대의 뜻이 된다
\s : 공백문자
\S : 공백이 아닌 문자
\d : 숫자
\D : 숫자가 아닌 문자
\W : [^a-zA-Z0-9_]
'''

# search 메서드
# 첫번째로 일치하는 패턴을 찾으면 Match 객체로 리턴 (못찾으면 None 리턴)
import re
m = re.search(r'a', '1234abcdef')       # 일치하는 패턴이 있으면 위치, 패턴 정보 리턴(Match 객체)
print(m)
print(re.search(r'z', '1234abcdef'))    # 일치하는 패턴이 없으면 None

if re.search(r'z', '1234abcdef'):
    print('패턴 일치')
else:
    print('패턴 불일치')

print(re.search(r'\d\d\d', '1234abcdef'))   # 첫번째 매칭 리턴
print(re.search(r'...', '!@#1234abcdef'))   # 특수문자포함 문자
print(re.search(r'\w\w\w', '!@#1234abcdef'))    # 특수문자 제외 문자('_', 숫자 포함)
'''
메타문자
- 대괄호 [] 안에 
[abc] : a 또는 b 또는 c
[a-z] : 모든 소문자
[A-Z] : 모든 대문자
[0-9] : 숫자
[a-zA-Z0-9] : 모든 알파벳과 숫자
[^0-9] : 숫자가 아닌
'''
print(re.search(r'[cbm]at', 'i love cat'))
print(re.search(r'[cbm]at', 'i love eat'))  # None
print(re.search(r'[^abc]def', 'bdef'))      # None
print(re.search(r'[^abc]def', '훗def'))

'''
반복패턴
* : 0번 이상 반복
+ : 1번 이상
? : 0번 또는 1번
'''
print(re.search(r'a[bcd]*b', 'ab')) # 0번
print(re.search(r'a[bcd]*b', 'abcbcbcb')) # 0번 이상
print(re.search(r'b+a', 'banananana'))      # ba
print(re.search(r'b\w+a', 'banananana'))    # 1번 이상, banananana
print(re.search(r'https?', 'https://naver.com'))    # 0 또는 1번, https
print(re.search(r'https?', 'http://naver.com'))     # 0 또는 1번, http

'''
그룹핑
()를 사용해서 그룹핑
매칭 결과를 그룹별로 분리 가능
'''
m = re.search(r'(\w+)@(.+)', 'hello hong@gmail.com')
print(m)
print(m.group(0))   # 전체
print(m.group(1))   # 첫번째 묶은 그룹
print(m.group(2))   # 두번째 묶은 그룹

'''
반복횟수
+, *, ? 도 반복이지만 횟수 제한 불가
{4} -> 4번 반복
{3, 4} -> 3~4번 반복
{3,} -> 3번 이상 반복
'''
print(re.search(r'do{1,3}g', 'dog'))    # o가 1~3번 반복
print(re.search(r'do{1,3}g', 'dooog'))    # o가 1~3번 반복
print(re.search(r'do{1,3}g', 'doooog'))    # o가 1~3번 반복
print(re.search(r'\d{3}', 'asl;daefgag2234adsf'))

'''
반복패턴이 greedy(최대한 매칭되는 것을 찾음)
{} 뒤에 ?
greedy하지 않게 찾기 : +, * 뒤에 ?를 붙여서 지정
'''
print(re.search(r'<.+>', '<html><body>adfgaweg</body></html>'))     # greedy, match='<html><body>adfgaweg</body></html>'
print(re.search(r'<.+?>', '<html><body>adfgaweg</body></html>'))    # greedy하지 않도록... match='<html>'
print(re.search(r'a{3,5}', 'aaaaaaaaaaaaa'))    # match='aaaaa', greedy
print(re.search(r'a{3,5}?', 'aaaaaaaaaaaaa'))   # match='aaa', 최소조건으로 찾음

'''
match()
문자열 시작부터 패턴 비교(시작이 패턴과 일치하지 않으면 None 리턴)
search()에 비해서 잘 사용하지 않음
'''
print(re.search(r'\d\d\d', 'my number is 999')) # search()
print(re.match(r'\d\d\d', 'my number is 999'))  # match(), None : 첫시작이 패턴과 일치하지 않아서 None 리턴
print(re.match(r'\d\d\d', '999 is my number'))  # match()

'''
findall()
- 매칭되는 전체 패턴의 문자열을 리스트로 리턴
'''
print(re.findall(r'\w+@[\w.]+', 'hello test@gmail.com asdg awelkt hong@gmail.com awefawe kime@gmail.com'))
for email in re.findall(r'\w+@[\w.]+', 'hello test@gmail.com asdg awelkt hong@gmail.com awefawe kime@gmail.com'):
    print(email)


'''
sub()
- 매칭되는 문자열을 치환(replace)
- 치환된 결과를 리턴
- count 매개변수 : 치환횟수 (0은 전체/기본값)
'''
print(re.sub(r'\w+@[\w.]+', 'EMAIL', 'hello test@gmail.com asdg awelkt hong@gmail.com awefawe kime@gmail.com', count=0))

'''
compile()
- 정규식 패턴을 미리 컴파일
- 패턴을 컴파일 해두고 반복을 돌리는 속도가 훨씬 빠르다
'''
email_re = re.compile(r'\w+@[\w.]+')
email_re.sub('EMAIL', 'hello test@gmail.com asdg awelkt hong@gmail.com awefawe kime@gmail.com')


# 전화번호 뒷자리를 ####으로 바꾸기
text = '''
홍길동, 010-2352-6442
김길동, 015-2593-3253
최길동, 043-3933-3511
'''
tel_reg = re.compile(r'(\d{3}-\d{3,4}-)(\d{4})')
print(tel_reg.findall(text))

print(tel_reg.sub('\g<1>####', text))   # \g<1> : 첫번째 그룹을 의미

