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

cred = credentials.Certificate("databaseforpythonproject-firebase-adminsdk-qtpst-ea5aec601e.json")
firebase_admin.initialize_app(cred,{
    'databaseURL':'https://databaseforpythonproject-default-rtdb.firebaseio.com/'
})
dir = db.reference()
options = webdriver.ChromeOptions()
options.add_argument("--start-maximized")
driver = webdriver.Chrome(chrome_options=options)

AcadeNotice = []
Scholarship=[]

dir = db.reference()

notice = []
url =[]
driver.get('http://www.hannam.ac.kr/kor/main/')
time.sleep(5)
def CloseAdv():#광고삭제
    driver.find_element_by_xpath("//*[@id='page-top']/div[1]/div/div[2]/button[2]").click()

def back():#뒤로가기버튼
    driver.back()

def Crawling(add):#크롤링기능
    table = driver.find_element_by_class_name("simple-type")#Table 반복문을 위해서
    tbody = table.find_element_by_tag_name("tbody")
    rows = tbody.find_elements_by_tag_name("tr")
 
    for index, value in enumerate(rows):
      
        Title=value.find_elements_by_tag_name("td")[1]
        Writer =value.find_elements_by_tag_name("td")[3]
        Time = value.find_elements_by_tag_name("td")[4]
        baseurl=Title.find_element_by_css_selector('a').get_attribute('href')
        add.append([Title.text,baseurl,Time.text])
 
    
    return add 


def CrawlingMuti(add):
    table=driver.find_element_by_class_name("notice_box")
    uiClass = table.find_elements_by_class_name("bbs_list hnu_board_list")
    Li = table.find_elements_by_tag_name("li")
    for index , value in enumerate(Li):
        Title = value.text
        Url = value.find_element_by_tag_name("a").get_attribute('href')
        
        add.append([Title , Url])

def CrawlingChem(add):
    table = driver.find_element_by_class_name("kboard-list")
    tbody = table.find_element_by_tag_name("tbody")
    rows = tbody.find_elements_by_tag_name("tr")     
    for index, value in enumerate(rows):
      
        Title=value.find_elements_by_tag_name("td")[1]
        Writer =value.find_elements_by_tag_name("td")[3]
        
        baseurl=Title.find_element_by_css_selector('a').get_attribute('href')
       
       
        add.append([Title.text,baseurl])
 
    
    return add 
def CrawlingMangement(add):
    listT = driver.find_element_by_class_name("list")
    ui = listT.find_element_by_class_name("gallery-type")
    li = ui.find_elements_by_tag_name("li")
    for index,value in enumerate(li):
        Title = value.text
        ah = value.find_elements_by_class_name("regi-info")
        Url = value.find_element_by_tag_name("a").get_attribute('href') 
        add.append([Title,Url])
    return add
def CrawlingKorea(add):
    Table = driver.find_element_by_class_name("tb_brdTmp")
    tbody = Table.find_element_by_tag_name("tbody")
    rows = tbody.find_elements_by_tag_name("tr")
    for index,value in enumerate(rows):
        Title=value.find_elements_by_tag_name("td")[3]
        Writer =value.find_elements_by_tag_name("td")[6]
        Time = value.find_elements_by_tag_name("td")[5]
        baseurl=Title.find_element_by_css_selector('a').get_attribute('href')
        add.append([Title.text,baseurl])
    return add


def CloseMutiAd():
    driver.find_element_by_xpath("/html/body/div[6]/div/div/a").click()
    driver.find_element_by_xpath("/html/body/div[5]/div/div/a").click()
    driver.find_element_by_xpath("/html/body/div[7]/div/div/a").click()

def crawilngMedia(add):#멀티미디어학과
    FirstClass = driver.find_element_by_xpath("//*[@id='fboardlist']/div[2]")
    table = FirstClass.find_element_by_tag_name("table")
    tbody = table.find_element_by_tag_name("tbody")
    rows = tbody.find_elements_by_tag_name("tr")
    for index,value in enumerate(rows):
        td=value.find_elements_by_tag_name("td")[1]
        ul = td.find_element_by_tag_name("div")
        Title = ul.find_element_by_tag_name("a")
        Url = ul.find_element_by_tag_name("a").get_attribute('href')
        add.append([Title.text , Url])
    return add    
CloseAdv()
time.sleep(2)


driver.find_element_by_xpath("//*[@id='tab']/li[1]/div/a").click()#공지사항버튼
time.sleep(10)
baseurl = driver.current_url
time.sleep(2)
notice = Crawling(notice)
dir.child("HNU").update({'Notice':notice})##새로운코드

time.sleep(2)
back()
CloseAdv()

driver.find_element_by_xpath("//*[@id='tab']/li[3]").click()#학사공지 두번 눌러야함

driver.find_element_by_xpath("//*[@id='tab']/li[3]").click()
time.sleep(10)
baseurl1 = driver.current_url
time.sleep(2)
AcadeNotice = Crawling(AcadeNotice)
dir.child("HNU").update({'AcadeNotcie':AcadeNotice})

time.sleep(2)
back()
CloseAdv()
time.sleep(2)
driver.find_element_by_xpath("//*[@id='tab']/li[5]").click()#장학공지
driver.find_element_by_xpath("//*[@id='tab']/li[5]").click()
time.sleep(10)
time.sleep(2)
Scholarship = Crawling(Scholarship)
dir.child("HNU").update({'ScholarShipNotice':Scholarship}) 
back()
CloseAdv()
time.sleep(2)


#공과대학
driver.get('http://me.hannam.ac.kr/sub3/menu_1.html')#기계공학과
time.sleep(10)
time.sleep(2)
me =[]
me = Crawling(me)
dir.child("HNU").update({"MechabicalNotice":me})




driver.get('http://ice.hannam.ac.kr/main/')#정보통신공학과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[5]/div/div/a").click()
driver.find_element_by_xpath("//*[@id='contents']/div/div[3]/div/div[1]/dl/dt/h2/a").click()
time.sleep(2)
ComputerMajor  = []
ComputerMajor = Crawling(ComputerMajor)
dir.child("HNU").update({"ComputerMajor":ComputerMajor})

driver.get('http://ee.hannam.ac.kr/main/')#전기전자공학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='notice']/div[1]/div/a").click()
time.sleep(2)
electric=[]
electric = Crawling(electric)
dir.child("HNU").update({"electric":electric})

driver.get('http://multi.hannam.ac.kr/main/')#멀티미디어공학
time.sleep(10)
CloseMutiAd()
Multi = []
CrawlingMuti(Multi)
dir.child("HNU").update({'Multi':Multi})

driver.get("http://archi.hannam.ac.kr/main/")#건축학과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[1]/main/section/div/div[2]/div/div[1]/h2/a").click()
time.sleep(2)
architectural = []
architectural = Crawling(architectural)
dir.child("HNU").update({"architectural":architectural})

driver.get("http://arch.hannam.ac.kr/main/")#건축공학전공
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[7]/div/div/a").click()
driver.find_element_by_xpath("/html/body/div[5]/div/div/a").click()
driver.find_element_by_xpath("/html/body/div[6]/div/div/a").click()
driver.find_element_by_xpath("//*[@id='contents']/div/div[2]/div[1]/dl/dt/a").click()
time.sleep(2)
architecturalEn= []
architecturalEn=Crawling(architecturalEn)
dir.child("HNU").update({"architecturalEn":architecturalEn})

driver.get("http://civil.hannam.ac.kr/main/")#토목환경공학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='contents']/div/div[2]/div[1]/dl/dt/a").click()
time.sleep(2)
civil= []
civil = Crawling(civil)
dir.child("HNU").update({"civil":civil})

driver.get("http://chem-eng.hannam.ac.kr/")#화공
time.sleep(10)
driver.find_element_by_xpath("//*[@id='menu-item-324']/a").click()
driver.find_element_by_xpath("//*[@id='menu-item-324']/a").click()
time.sleep(2)
chem =[]
chem = CrawlingChem(chem)
dir.child("HNU").update({"chem":chem})

driver.get("http://polymer.hannam.ac.kr/")#신소제공학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='menu-item-84248']/a").click()
time.sleep(2)
polymer = []
polymer = CrawlingChem(polymer)
dir.child("HNU").update({"polmer":polymer})


##경상대학
driver.get("http://business.hannam.ac.kr/sub5/menu_1.html")#경영학과
time.sleep(10)
Business = []
Business = Crawling(Business)
dir.child("HNU").update({"Business":Business})

driver.get("http://management.hannam.ac.kr/kor/main/")#통계학과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[4]/main/div[2]/div[1]/div[1]/div/a").click()
time.sleep(2)
managment = []
managment = CrawlingMangement(managment)
dir.child("HNU").update({"managment":managment})

driver.get("http://trade.hannam.ac.kr/main/")#무역학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='main_body']/div/div[2]/div[2]/div[1]/dl/dt/div/a").click()
time.sleep(2)
trade = []
trade = Crawling(trade)
dir.child("HNU").update({"trade":trade})

driver.get("http://enc.hannam.ac.kr/main/")#경제학과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[6]/div/div/a").click()
driver.find_element_by_xpath("/html/body/div[5]/div/div/a").click()
driver.find_element_by_xpath("/html/body/div[4]/section/div/div[3]/div/div[1]/h2/a").click()
time.sleep(2)
enc = [] 
enc = Crawling(enc)
dir.child("HNU").update({"enc":enc})

driver.get("http://china.hannam.ac.kr/main/")#중국경제통상학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='contents']/div/div[2]/div[1]/dl/dt/a").click()
time.sleep(2)
china = []
china = Crawling(china)
dir.child("HNU").update({"china":china})

driver.get("http://hotel.hannam.ac.kr/main/")#호텔컨벤션학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='contents']/div/div[3]/div/div[1]/dl/dt/h2/a").click()
time.sleep(2)
hotel = []
hotel = Crawling(hotel)
dir.child("HNU").update({"hotle":hotel})

driver.get("http://gitb.hannam.ac.kr/main/")#글로벌it학과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[4]/main/section/div/div[2]/div/div[1]/h2/a/img").click()
time.sleep(2)
gitb =[]
gitb = Crawling(gitb)
dir.child("HNU").update({"gitb":gitb})

#스마트융합대학 
driver.get("http://ce.hannam.ac.kr/main/")#컴퓨터공학과 
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[5]/div/div/a").click()
driver.find_element_by_xpath("//*[@id='contents']/div/div[3]/div/div[1]/dl/dt/h2/a").click()
time.sleep(2)
Computer = [] 
Computer = Crawling(Computer)
dir.child("HNU").update({"Computer":Computer})

driver.get("http://ime.hannam.ac.kr/main/")#산업경영공학과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[5]/div/div/a").click()
driver.find_element_by_xpath("//*[@id='contents']/div/div[3]/div/div[1]/dl/dt/h2/a").click()
time.sleep(2)
ime = []
ime = Crawling(ime)
dir.child("HNU").update({"ime":ime})

driver.get("http://smart.hannam.ac.kr/")#AI융합학부
time.sleep(10)
driver.find_element_by_xpath("//*[@id='btn-popup-2020-119']").click()
driver.find_element_by_xpath("//*[@id='post-225']/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/a/i").click()
time.sleep(2)
smart = []
smart = CrawlingChem(smart)
dir.child("HNU").update({"smart":smart})

driver.get("http://math.hannam.ac.kr/main/index.php")#수학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='notice']/a").click()
time.sleep(2)
math = [] 
math = Crawling(math)
dir.child("HNU").update({"math":math})

driver.get("http://bigdata.hannam.ac.kr/")#빅데이터학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='post-26']/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/a/i").click()
time.sleep(2)
bigdate = [] 
bigdate = CrawlingChem(bigdate)
dir.child("HNU").update({"bigdata":bigdate})

driver.get('http://test1.pagei.gethompy.com/bbs/board.php?bo_table=notice')#미디어영상
time.sleep(10)
Media = []
Media = crawilngMedia(Media)
dir.child("HNU").update({"Media":Media})

#사범대학
driver.get("http://kukkyo.hannam.ac.kr/main/")#국어교욱과
time.sleep(10)
korea = [] 
korea  = CrawlingMuti(korea)
dir.child("HNU").update({"koreaEd":korea})

driver.get("http://eng-edu.hannam.ac.kr/main/")#영어교육과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='faq']/a").click()
time.sleep(2)
EnglishEd = [] 
EnglishEd = Crawling(EnglishEd)
dir.child("HNU").update({"EnglishEd":EnglishEd})

driver.get("http://edu.hannam.ac.kr/main/")#교욱학과 
time.sleep(10)
driver.find_element_by_xpath("//*[@id='contents']/div/div[3]/div[1]/div/dl/dd[1]/a").click()
time.sleep(2)
edu = [] 
edu = Crawling(edu)
dir.child("HNU").update({"edu":edu})

driver.get("http://e-history.hannam.ac.kr/main/")#역사교욱과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[4]/main/section/div[2]/div/div[1]/h2/a").click()
time.sleep(2)
e_history = []
e_history = Crawling(e_history)
dir.child("HNU").update({"e-history":e_history})

driver.get("http://eduart.hannam.ac.kr/kor/main/")#미술교육과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[4]/section/div/div[4]/div/div[1]/h2/a").click()
time.sleep(2)
Eart = [] 
Eart = Crawling(Eart)
dir.child("HNU").update({"Eart":Eart})

driver.get("http://mathedu.hannam.ac.kr/main/")#수학교육과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='contents']/div/div[2]/div[1]/dl/dt/a").click()
time.sleep(2)
metedu =[]
metedu = Crawling(metedu)
dir.child("HNU").update({"metedu":metedu})

#문과대학 
driver.get("http://korean.hannam.ac.kr/main/")#국어국문학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='contents']/div/div[3]/div/div[1]/dl/dt/h2/a").click()
time.sleep(2)
korean = [] 
korean = Crawling(korean)
dir.child("HNU").update({"korean":korean})

driver.get("http://english.hannam.ac.kr/main/")#영어영문학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='contents']/div/div[3]/div/div[1]/dl/dt/h2/a").click()
time.sleep(2)
english = []
english = Crawling(english)
dir.child("HNU").update({"english":english})

driver.get("http://japan.hannam.ac.kr/main/")#일어일문학과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[4]/section/div/div[3]/div/div[1]/h2/a").click()
time.sleep(2)
japanes= []
japanes = Crawling(japanes)
dir.child("HNU").update({"japanese":japanes})

driver.get("http://fr.hnu.kr/main/")#프랑스어문학과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[4]/main/section/div/div[2]/div/div[1]/h2/a").click()
time.sleep(2)
France = [] 
France = Crawling(France)
dir.child("HNU").update({"France":France})

driver.get("http://lis.hannam.ac.kr/main/")#문헌정보학과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[4]/section/div/div[3]/div/div[1]/h2/a").click()
time.sleep(2)
lis = []
lis = Crawling(lis)
dir.child("HNU").update({"lis":lis})

driver.get("http://history.hannam.ac.kr/main/")#사학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='contents']/div/div[3]/div[1]/div[1]/dl/dd[1]/a").click()
time.sleep(2)
history = [] 
history = Crawling(history)
dir.child("HNU").update({"history":history})

driver.get("http://christian.hannam.ac.kr/main/")#기독교학과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[5]/div/div/a").click()
driver.find_element_by_xpath("//*[@id='contents']/div/div[3]/div[1]/div[1]/dl/dd[1]/a").click()
time.sleep(2)
christian = []
christian = Crawling(christian)
dir.child("HNU").update({"chrisitian":christian})

#법정대학
driver.get("http://law.hannam.ac.kr/main/")#법학전공
time.sleep(10)
driver.find_element_by_xpath("//*[@id='notice']/div[1]/a").click()
time.sleep(2)
law = [] 
law = Crawling(law)
dir.child("HNU").update({"law":law})

driver.get("http://vision.hannam.ac.kr/main/")#행정학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='contents']/div/div[3]/div[1]/div/dl/dd[1]/a").click()
time.sleep(2)
vision =[] 
vision = Crawling(vision)
dir.child("HNU").update({"vision":vision})

driver.get("http://police.hannam.ac.kr/kor/main/")#경찰학과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[7]/div/div/a").click()#광고제가
driver.find_element_by_xpath("/html/body/div[8]/div/div/a").click()#광고제가
driver.find_element_by_xpath("/html/body/div[6]/div/div/a").click()#광고제거
driver.find_element_by_xpath("/html/body/div[4]/section/div/div[2]/div[1]/div[2]/h2/a").click()
time.sleep(2)
police = [] 
police = Crawling(police)
dir.child("HNU").update({"police":police})

driver.get("http://pcis.hannam.ac.kr/main/")#정치언론학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='contents']/div/div[3]/div[1]/div[1]/dl/dd[1]/a").click()
time.sleep(2)
pcis = [] 
pcis = Crawling(pcis)
dir.child("HNU").update({"pcis":pcis})

##생명.나노과학대학 
driver.get("http://biosystem.hnu.ac.kr/main/")#생명시스템과학과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[5]/div/div/a").click()
driver.find_element_by_xpath("//*[@id='contents']/div/div[2]/div[1]/dl/dt/a").click()
time.sleep(2)
biosystem = [] 
biosystem = Crawling(biosystem)
dir.child("HNU").update({"biosystem":biosystem})
time.sleep(2)

driver.get("http://nutri.hannam.ac.kr/main/index.php")#식품영양학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='notice']/a").click()
time.sleep(2)
nutri = []
nutri = Crawling(nutri)
dir.child("HNU").update({"nutri":nutri})
time.sleep(2)

driver.get("http://chem.hannam.ac.kr/kor/main/")#화학과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[7]/div/div/a").click()#광고제거
driver.find_element_by_xpath("/html/body/div[5]/div/div/a").click()#
driver.find_element_by_xpath("/html/body/div[6]/div/div/a").click()#
driver.find_element_by_xpath("/html/body/div[4]/main/div[2]/div[1]/div[1]/div/a").click()
time.sleep(2)
chemKorea = [] 
chemKorea = Crawling(chemKorea)
dir.child("HNU").update({"chemKorea":chemKorea})
time.sleep(2)

driver.get("http://nursing.hannam.ac.kr/main/")#간호학과^^
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[4]/main/section/div/div[2]/div/div[1]/h2/a").click()
time.sleep(2)
nursing =[]
nursing = Crawling(nursing)
dir.child("HNU").update({"nursing":nursing})
time.sleep(2)

driver.get("http://sports.hannam.ac.kr/main/")#스포츠학과ㅡ.ㅡ
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[4]/section/div/div[3]/div/div[1]/h2/a").click()
time.sleep(2)
sport=[]
sport = Crawling(sport)
dir.child("HNU").update({"sport":sport})
time.sleep(2)

driver.get("http://biopharm.hannam.ac.kr/")#바이오제약공학과
time.sleep(10)
driver.execute_script("window.scrollTo(0, 1000)")
time.sleep(10)
driver.find_element_by_xpath("//*[@id='row-unique-3']/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/a/i").click()
time.sleep(2)
biopharm = []
biopharm =CrawlingChem(biopharm)
dir.child("HNU").update({"biopharm":biopharm})

#사회적경제융합대학 
driver.get("http://welfare.hannam.ac.kr/sub5/menu_1.html")#사회복지학과
time.sleep(10)
welfare = []
welfare=Crawling(welfare)
dir.child("HNU").update({"welfare":welfare})

driver.get("http://child.hannam.ac.kr/main/")#아동복지학과
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[4]/section/div/div[3]/div/div[1]/h2/a").click()
time.sleep(2)
child =[]
child = Crawling(child)
dir.child("HNU").update({"child":child})

driver.get("http://counselpsy.hannam.ac.kr/")#상담심리학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='post-225']/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/a/i").click()
time.sleep(2)
counselpsy=[]
counselpsy = CrawlingChem(counselpsy)
dir.child("HNU").update({"counselpsy":counselpsy})

driver.get("http://seb.hannam.ac.kr/")#사회경제기업학과
time.sleep(10)
driver.find_element_by_xpath("//*[@id='post-225']/div/div/div/div[4]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/a/i").click()
time.sleep(2)
seb = []
seb = CrawlingChem(seb)
dir.child("HNU").update({"seb":seb})

##린튼글로벌스쿨
driver.get("http://gb.hannam.ac.kr/main/")
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[7]/div/div/a").click()
driver.find_element_by_xpath("/html/body/div[6]/div/div/a").click()
driver.find_element_by_xpath("/html/body/div[5]/div/div/a").click()
driver.find_element_by_xpath("//*[@id='contents']/div/div[2]/div[1]/dl/dt/a").click()
time.sleep(2)
gb = []
gb = Crawling(gb)
dir.child("HNU").update({"gb":gb})

##아트&디자인테크놀로지대학
driver.get("http://design.hannam.ac.kr/main/")##융합디자인^^
time.sleep(10)
driver.find_element_by_xpath("//*[@id='contents']/div/div[3]/div[1]/div[1]/dl/dd[1]/a").click()
time.sleep(2)
design = []
design = Crawling(design)
dir.child("HNU").update({"design":design})

driver.get("http://painting.hannam.ac.kr/kor/main/")#회화전공
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[4]/section/div/div[3]/div/div[1]/h2/a").click()
time.sleep(2)
painting =[]
painting = Crawling(painting)
dir.child("HNU").update({"painting":painting})

driver.get("http://clothing.hannam.ac.kr/main/")##의류학전공
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[4]/main/section/div/div[2]/div/div[1]/h2/a").click()
time.sleep(2)
clothing =[]
clothing = Crawling(clothing)
dir.child("HNU").update({"clothing":clothing})

##미디어영상전공은 testpage임으로 보류

driver.get("http://openmajor.hannam.ac.kr/kor/main/")
time.sleep(10)
driver.find_element_by_xpath("/html/body/div[4]/section/div/div[2]/div[1]/div[1]/h2/a").click()
time.sleep(2)
openmajor=[]
openmajor=Crawling(openmajor)
dir.child("HNU").update({"openmajor":openmajor})

driver.close()

print("크롤링 끝`")
print("helloworld!")