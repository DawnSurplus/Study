def save_to_file(file_name, jobs):
  # 파일 생성
  file = open(f"{file_name}.csv", "w")
  
  # 기록
  file.write("Title,Company,Location,URL\n")
  for job in jobs:
    file.write(f"{job['title']},{job['company']},{job['location']},{job['link']}\n")
    
  # 파일 닫기
  file.close()