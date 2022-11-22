#!/usr/bin/env python
# coding: utf-8

# In[105]:


from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as ec
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from datetime import datetime
from bs4 import BeautifulSoup
import time


# In[106]:


url = 'https://www.twitch.tv/directory/all?sort=VIEWER_COUNT'

options = webdriver.ChromeOptions()
options.add_argument('headless') # 크롬창 안보이게 띄우기
options.add_argument('window-size=1920x1080')
options.add_argument("disable-gpu") # 드라이버 가속 사용 X
options.add_experimental_option('excludeSwitches', ['enable-logging']) # 로그가 안보이도록

br = webdriver.Chrome('chromedriver', chrome_options=options)
br.get(url)
now = datetime.now()


# In[107]:


obj = WebDriverWait(br, 5).until(ec.presence_of_element_located((By.CSS_SELECTOR, '#browse-root-main-content > div.Layout-sc-1xcs6mc-0.lgdxlP > div > div.Layout-sc-1xcs6mc-0 > div:nth-child(1) > div.Layout-sc-1xcs6mc-0.iPAXTU > h4 > button > strong')))
br.find_element(By.CSS_SELECTOR, '#browse-root-main-content > div.Layout-sc-1xcs6mc-0.lgdxlP > div > div.Layout-sc-1xcs6mc-0 > div:nth-child(1) > div.Layout-sc-1xcs6mc-0.iPAXTU > h4 > button > strong').click()
br.get(url)
time.sleep(2)
br.find_element(By.CSS_SELECTOR, '#browse-root-main-content > div.Layout-sc-1xcs6mc-0.coBOrf > div > div > ul').click()
for i in range(0, 10):
    br.find_element(By.TAG_NAME, 'body').send_keys(Keys.PAGE_DOWN)
    time.sleep(1)


# In[108]:


from bs4 import BeautifulSoup
html = br.page_source
soup = BeautifulSoup(html, 'html.parser')


# In[109]:


f = open("twitch_log.tsv", "a", encoding="UTF-8")
for i in range(2, 52):
    try : 
        title = soup.select_one(f'#browse-root-main-content > div.Layout-sc-1xcs6mc-0.lgdxlP > div > div.ScTower-sc-1sjzzes-0.czzjEE.tw-tower > div:nth-child({i}) article > div.Layout-sc-1xcs6mc-0.gUnRUD div.ScTextWrapper-sc-10mto54-1.fwZpSK > div.ScTextMargin-sc-10mto54-2.bcdHdk > a > h3').string
        streamer = soup.select_one(f'#browse-root-main-content > div.Layout-sc-1xcs6mc-0.lgdxlP > div > div.ScTower-sc-1sjzzes-0.czzjEE.tw-tower > div:nth-child({i}) article > div.Layout-sc-1xcs6mc-0.gUnRUD div.ScTextWrapper-sc-10mto54-1.fwZpSK > div.ScTextMargin-sc-10mto54-2.bcdHdk > a > p').string
        viewer = soup.select_one(f'#browse-root-main-content > div.Layout-sc-1xcs6mc-0.lgdxlP > div > div.ScTower-sc-1sjzzes-0.czzjEE.tw-tower > div:nth-child({i}) article > div.ScWrapper-sc-1wvuch4-0 > div.ScTransformWrapper-sc-1wvuch4-1.gMwbGx > a > div > div.ScPositionCorner-sc-1shjvnv-1.gUtzBI > div').string
        cate = soup.select_one(f'#browse-root-main-content > div.Layout-sc-1xcs6mc-0.lgdxlP > div > div.ScTower-sc-1sjzzes-0.czzjEE.tw-tower > div:nth-child({i}) article > div.Layout-sc-1xcs6mc-0.gUnRUD div.ScTextWrapper-sc-10mto54-1.fwZpSK > div.ScTextMargin-sc-10mto54-2.bcdHdk > p > a').string
        f.write(f'{streamer}\t{title}\t{viewer}\t{cate}\t{now}'+ '\n')
    except Exception as e1:
        e = open("error.tsv", "a", encoding="UTF-8")
        e.write(f"{i-1}번째에서 오류\t{e1}\t\t\t {now}"+ '\n')
        e.close()
f.close()

br.quit()
# In[ ]:





# In[ ]:





# In[ ]:




