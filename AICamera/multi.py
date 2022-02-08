from datetime import time
from threading import _DummyThread
import pandas as pd 
import pyautogui
from bs4 import BeautifulSoup
from selenium import webdriver
import selenium
from selenium.webdriver import chrome
from selenium.webdriver.chrome import options
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.alert import Alert
from selenium.webdriver.chrome.options import Options
import requests
from openpyxl import load_workbook
import openpyxl
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db
import time

URL = 'http://multi.hannam.ac.kr/sub5/menu_1.html'
DRIVER_PATH = './chromedriver.exe'
 
chrome_options = Options()
chrome_options.add_argument( '--headless' )
chrome_options.add_argument( '--log-level=3' )
chrome_options.add_argument( '--disable-logging' )
chrome_options.add_argument( '--no-sandbox' )
chrome_options.add_argument( '--disable-gpu' )
 
driver = webdriver.Chrome( executable_path=DRIVER_PATH, chrome_options=chrome_options )

def CloseMutiAd():
    driver.find_element_by_xpath("/html/body/div[6]/div/div/a").click()
    driver.find_element_by_xpath("/html/body/div[5]/div/div/a").click()
    driver.find_element_by_xpath("/html/body/div[7]/div/div/a").click()

def CrawlingMuti(add):
    elements = driver.find_element_by_css_selector('body > form > div > table > tbody')
    for index , value in enumerate(elements):
        print("멀티크롤링",value)
        # Title = value.text
        # Url = value.find_element_by_tag_name("a").get_attribute('href')
        # Time = value.find_element_by_tag_name("span")
        # add.append([Title , Url])
        
driver.get( URL )
time.sleep(10)
# driver.get('../sub5/menu_1.html')#멀티미디어공학
# time.sleep(10)
# CloseMutiAd()
Multi = []
CrawlingMuti(Multi)
print("멀티크롤링",Multi)
