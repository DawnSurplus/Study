from flask import Flask, render_template, request, redirect, send_file
from extractors.indeed import extract_indeed_jobs
from extractors.wwr import extract_wwr_jobs
from file import save_to_file

app = Flask("JobScrapper")

db = {}

@app.route("/")  # 함수 위에 @(decorator)를 쓰면 Flask는 user가 이 주소의 page를 방문했을 때 이 함수를 호출해야 하는 것을 알게 됨
def home():
  # 변수를 html 파일로 보낼 수 있음
  # render_template() : Flask가 templates 폴더를 들여다보게 함
  return render_template("home.html", name="Dawn")  

@app.route("/search")
def search():
  # 검색한 키가 없으면 search
  keyword = request.args.get("keyword")
  if (keyword == None):
    return redirect("/")
  if (keyword in db):
    jobs=db[keyword]
  else:    
    indeed = extract_indeed_jobs(keyword)
    wwr = extract_wwr_jobs(keyword)
    jobs = indeed + wwr

    db[keyword] = jobs
  
  return render_template("search.html", keyword=keyword, jobs=jobs)  

@app.route("/export")
def export():
  keyword = request.args.get("keyword")
  if (keyword == None):
    return redirect("/")
  if (keyword not in db):
    return redirect(f"/search?keyword={keyword}")
  
  save_to_file(keyword, db[keyword])
  # 사용자에게 파일을 보내고, 다운로드 실행
  return send_file(f"{keyword}.csv", as_attachment=True)

app.run("0.0.0.0")  # replit이 웹 서버를 실행하려고 하는 걸 감지하여 브라우저 창 및 콘솔을 실행시킴