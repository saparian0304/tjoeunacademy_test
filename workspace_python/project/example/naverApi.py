'''
네이버 API 사용
영화 제목, 링크 출력

네이버 API 샘플소스 사용
clientid, secret 작성
url을 movie로 변경
문서를 참고해서 응답결과 확인
응답 결과를 JSON으로 변환
응답받은 데이터의 제목, 링크 출력
'''
import os
import sys
import urllib.request
import json
import re
client_id = "아이디"
client_secret = "시크릿키"
searchWord = input('검색할 영화를 입력해주세요 : ')
encText = urllib.parse.quote(searchWord)
url = "https://openapi.naver.com/v1/search/movie.json?query=" + encText # json 결과
request = urllib.request.Request(url)
request.add_header("X-Naver-Client-Id", client_id)
request.add_header("X-Naver-Client-Secret", client_secret)
response = urllib.request.urlopen(request)
rescode = response.getcode()
if(rescode==200):
    response_body = response.read()
    res = response_body.decode('utf-8')
    a = json.loads(res)
    for i in a['items']:
        title = re.sub(r'<.+?>', '', i['title'])
        print('제목:', title, '/ 링크:', i['link'])
else:
    print("Error Code:" + rescode)