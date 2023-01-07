### Import 및 추가설정 ==================================================
from bs4 import BeautifulSoup  # HTML 태그를 쉽게 찾게 해줌 (https://www.crummy.com/software/BeautifulSoup/bs4/doc/)

from selenium import webdriver
from selenium.webdriver.chrome.options import Options

# replit에서 셀레니움 설정하기 위한 옵션설정 
options = Options()
options.add_argument("--no-sandbox")
options.add_argument("--disable-dev-shm-usage")
### Import 및 추가설정 ==================================================





### Variable ==================================================
BASE_URL = "https://kr.indeed.com/jobs"
### Variable ==================================================





### Function ==================================================
def get_page_count(keyword):
  page_count = 0
  
  url = f"{BASE_URL}?q={keyword}"
  
  browser = webdriver.Chrome(options=options)
  browser.get(url)
  
  soup = BeautifulSoup(browser.page_source, "html.parser")
  pagination = soup.find("nav", role="navigation")
  if (pagination == None):
    page_count = 1
  else:
    pages = pagination.find_all("div")
    page_count = len(pages)
    if (page_count == 0):
      page_count = 1
    elif (page_count >= 5):
      page_count = 5    
      
  return page_count

def extract_indeed_jobs(keyword):
  data_list = []

  page_count = get_page_count(keyword)
  #print(f"Found {page_count} pages.")
  
  for page in range(page_count):
    url = f"{BASE_URL}?q={keyword}&start={page*10}"
    #print(url)
    
    browser = webdriver.Chrome(options=options)
    browser.get(url)
    
    soup = BeautifulSoup(browser.page_source, "html.parser")
    job_list = soup.find("ul", class_="jobsearch-ResultsList css-0")
    jobs = job_list.find_all("li", recursive=False)
    for job in jobs:
      zone = job.find("div", class_="mosaic-zone")
      if (zone == None):  # mosaic-zone이 아닌 경우만 job으로 판단
        anchor = job.select_one("h2 a")
        
        title = anchor['aria-label']
        link = anchor['href']
        company = job.find("span", class_="companyName")
        location = job.find("div", class_="companyLocation")
    
        job_data = {
              'title' : title.replace(",","_"),
              'company' : company.string.replace(",","_"),
              'location' : location.string.replace(",","_"),
              'link' : f"https://kr.indeed.com{link}"
            }
        data_list.append(job_data)
    
  return data_list
### Function ==================================================