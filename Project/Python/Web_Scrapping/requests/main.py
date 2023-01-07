from requests import get
from bs4 import BeautifulSoup  # HTML 태그를 쉽게 찾게 해줌 (https://www.crummy.com/software/BeautifulSoup/bs4/doc/)

base_url = "https://weworkremotely.com/remote-jobs/search?term="
keyword = input("What kind of work would you like to get information about? ")

response = get(f"{base_url}{keyword}")
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
        'title' : title.string,
        'company' : company.string,
        'kind' : kind.string,
        'region' : region.string,
        'link' : f"https://weworkremotely.com/{link}"
      }
      data_list.append(job_data)

  for data in data_list:
    print(data)
    print("====================")