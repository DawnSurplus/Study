### Import 및 추가설정 ==================================================
from requests import get
from bs4 import BeautifulSoup
### Import 및 추가설정 ==================================================





### Variable ==================================================
BASE_URL = "https://weworkremotely.com/remote-jobs"
### Variable ==================================================





### Function ==================================================
def extract_wwr_jobs(keyword):
  url = f"{BASE_URL}/search?term={keyword}"
  
  response = get(url)
  if (response.status_code != 200):
    print ("Can't request website")
  else:
    data_list = []
    
    soup = BeautifulSoup(response.text, "html.parser")
    jobs = soup.find_all('section', class_="jobs")  # find <section class="jobs" ~>
  
    for job_section in jobs:
      job_post = job_section.find_all('li')
      job_post.pop(-1)  # 마지막 class="view-all" 제거
      
      for post in job_post:
        anchors = post.find_all('a')
        anchor = anchors[1]
        
        link = anchor['href']  # 두번째 링크값만 추출
        company, kind, region = anchor.find_all('span', class_="company")
        title = anchor.find('span', class_="title")
        
        job_data = {
          'title' : title.string.replace(",","_"),
          'company' : company.string.replace(",","_"),
          'location' : region.string.replace(",","_"),
          'link' : f"https://weworkremotely.com/{link}"
        }
        data_list.append(job_data)

  return data_list