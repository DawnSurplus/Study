### Import 및 추가설정 ==================================================
from extractors.indeed import extract_indeed_jobs
from extractors.wwr import extract_wwr_jobs
from file import save_to_file
### Import 및 추가설정 ==================================================





### Variable ==================================================

### Variable ==================================================





### Function ==================================================

### Function ==================================================





### Main ==================================================
keyword = input("What do you want to search for? ")

indeed = extract_indeed_jobs(keyword)
wwr = extract_wwr_jobs(keyword)

jobs = indeed + wwr

print(f"indeed found {len(indeed)} jobs")
print(f"wwr found {len(wwr)} jobs")

save_to_file(keyword, jobs)
### Main ==================================================