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


obj = WebDriverWait(br, 5).until(ec.presence_of_element_located((By.CSS_SELECTOR, '#browse-root-main-content > div.Layout-sc-nxg1ff-0.hEbiVi > div > div.Layout-sc-nxg1ff-0 > div:nth-child(1) > div.Layout-sc-nxg1ff-0.kMghud > h4 > button > strong')))
br.find_element(By.CSS_SELECTOR, '#browse-root-main-content > div.Layout-sc-nxg1ff-0.hEbiVi > div > div.Layout-sc-nxg1ff-0 > div:nth-child(1) > div.Layout-sc-nxg1ff-0.kMghud > h4 > button > strong').click()
br.get(url)
time.sleep(2)
br.find_element(By.CSS_SELECTOR, '#browse-root-main-content > div.Layout-sc-nxg1ff-0.jPhzSy > div > div > ul').click()
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
        title = soup.select_one(f'#browse-root-main-content > div.Layout-sc-nxg1ff-0.hEbiVi > div > div.ScTower-sc-1dei8tr-0.dcmlaV.tw-tower > div:nth-child({i}) article > div.Layout-sc-nxg1ff-0 div.ScTextWrapper-sc-14f6evl-1 > div.ScTextMargin-sc-14f6evl-2 > a > h3').string
        streamer = soup.select_one(f'#browse-root-main-content > div.Layout-sc-nxg1ff-0.hEbiVi > div > div.ScTower-sc-1dei8tr-0.dcmlaV.tw-tower > div:nth-child({i}) article > div.Layout-sc-nxg1ff-0.ggozbG div.ScTextWrapper-sc-14f6evl-1 > div.ScTextMargin-sc-14f6evl-2 > a > p').string
        viewer = soup.select_one(f'#browse-root-main-content > div.Layout-sc-nxg1ff-0.hEbiVi > div > div.ScTower-sc-1dei8tr-0.dcmlaV.tw-tower > div:nth-child({i}) article > div.ScWrapper-sc-uo2e2v-0 > div.ScTransformWrapper-sc-uo2e2v-1 > a > div > div.ScPositionCorner-sc-1iiybo2-1.eHqCXd > div').string
        cate = soup.select_one(f'#browse-root-main-content > div.Layout-sc-nxg1ff-0.hEbiVi > div > div.ScTower-sc-1dei8tr-0.dcmlaV.tw-tower > div:nth-child({i}) article > div.Layout-sc-nxg1ff-0 > div > div.ScTextWrapper-sc-14f6evl-1 > div.ScTextMargin-sc-14f6evl-2 > p > a').string
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




