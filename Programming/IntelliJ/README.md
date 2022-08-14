# Intelli J 개발환경 구축

<br/>



## 설치 URL
---   
1. JDK (https://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. Maven (https://maven.apache.org/download.cgi)
3. Intelli J IDEA (https://www.jetbrains.com/idea)
4. Tomcat Server (https://tomcat.apache.org/download-80.cgi)

    <br/>
    <br/>
    <br/>



## JDK 설치 및 환경변수 설정
---
> JDK (Java Development Kit)
>* Java로 소프트웨어를 개발할 수 있도록 여러 기능들을 제공하는 패키지(키트)

<br/>

0. Download URL
   - https://www.oracle.com/technetwork/java/javase/downloads/index.html

    <br/>

1. JDK 설치
   - 기본경로 : `C:\Program Files\Java\jdk-'version'`
   - 위 설치 경로를 `<Java Path>`라고 칭하겠음
   
    <br/>

2. 환경변수 추가
   - [시작] - [계정의 환경 변수 편집] 또는 [시작] - [시스템 환경 변수 편집] - [환경 변수]로 접근
   - [새로 만들기]에서 설정할 [변수 이름]과 변수 값 설정 후 확인
     - 변수 이름 : 보통은 `'JAVA_HOME'`으로 설정
     - 변수 값 : 설치경로 지정 `<Java Path>`
   - 환경 변수 `Path`를 선택 후 [편집]
   - [새로만들기]하여 `%'(변수이름)'%\bin`으로 추가
     - ex) `%JAVA_HOME%\bin`
     - 만약 변수 값을 bin까지 포함시켰다면 bin경로를 제외한 `%JAVA_HOME`~~`%\bin`~~ 으로 추가
   
    <br/>

3. Version 확인
   - cmd창을 열어 아래 명령어로 확인 가능
        > `java --version`

   
    <br/>
    <br/>
    <br/>



## Maven 설치 및 환경변수 설정
---
> Maven
>* Apache Software Foundation에서 개발한 JAVA 기반 프로젝트 관리 도구
>* 프로젝트의 컴파일, 빌드, Run 및 Test
>* 서버 측에 배포(Deploy)하거나 라이브러리 관리

<br/>

0. Download URL
   - https://maven.apache.org/download.cgi

    <br/>

1. Maven Binary zip파일 Download 및 압축 해제
    - 압축 해제한 경로를 `<Maven Path>`라고 칭하겠음

    <br/>

2. 환경변수 추가
   - [시작] - [계정의 환경 변수 편집] 또는 [시작] - [시스템 환경 변수 편집] - [환경 변수]로 접근
   - [새로 만들기]에서 설정할 [변수 이름]과 변수 값 설정 후 확인
     - 변수 이름 : 보통은 `'MAVEN_HOME'`으로 설정
     - 변수 값 : 설치경로 지정 `<Maven Path>`
   - 환경 변수 `Path`를 선택 후 [편집]
   - [새로만들기]하여 `%'(변수이름)'%\bin`으로 추가
     - ex) `%MAVEN_HOME%\bin`
     - 만약 변수 값을 bin까지 포함시켰다면 bin경로를 제외한 `%MAVEN_HOME`~~`%\bin`~~ 으로 추가
    <br/>

3. Version 확인
   - cmd창을 열어 아래 명령어로 확인 가능
        > `mvn --version`

    <br/>
    <br/>
    <br/>



## Tomcat Server 설치
---
> Tomcat Server
>* Web Application Server 중 하나<br/>
>   * Apache Tomcat / JBoss / Jetty / Netty<br/><br/>
>* Web Application과 서버 환경을 만들어 동작시키는 SW

<br/>

0. Download URL
   - https://tomcat.apache.org/download-80.cgi

    <br/>

1. Tomcat Server zip파일 Download 및 압축 해제
    - 압축 해제한 경로를 `<Tomcat Server Path>`라고 칭하겠음

    <br/>

2. 환경변수 추가
   - [시작] - [계정의 환경 변수 편집] 또는 [시작] - [시스템 환경 변수 편집] - [환경 변수]로 접근
   - [새로 만들기]에서 설정할 [변수 이름]과 변수 값 설정 후 확인
     - 변수 이름 : 보통은 `'CATALINA_HOME'`으로 설정 (Catalina : Tomcat 서버의 프로젝트 명칭)
     - 변수 값 : 설치경로 지정 `<Tomcat Server Path>`
   - 환경 변수 `Path`를 선택 후 [편집]
   - [새로만들기]하여 `%'(변수이름)'%\bin`으로 추가
     - ex) `%CATALINA_HOME%\bin`
     - 만약 변수 값을 bin까지 포함시켰다면 bin경로를 제외한 `%CATALINA_HOME`~~`%\bin`~~ 으로 추가
  
    <br/>

3. 서버 실행
   - `<Tomcat Server Path>\bin` 폴더의 `startup.bat`파일을 실행 (윈도우)
   - 터미널 창이 실행되며 `["http-nio-xxxx"]`의 xxxx부분이 port로 할당
   - 웹브라우저에서 `'localhost:xxxx'`로 접속하면 Tomcat 메인페이지로 이동

    <br/>
    <br/>
    <br/>
    

    
## Intelli J IDEA 설치
---
> Intelli J IDEA
>* JAVA 개발 환경(IDE, Integrated Development Environment) 중 하나<br/>
>   * Eclipse / Intelli J / Net Beans<br/><br/>
>* Eclipse가 많이 사용되어 왔으나 빠른 검색 기능, 코드 완성 기능, 다양한 플러그인 제공으로 인해 Intelli J로 넘어가는 추세

<br/>

0. Download URL
   - https://www.jetbrains.com/idea

    <br/>

1. 설치파일 실행
   - 설치경로 확인
   - 옵션 선택
     - PATH 설정, Context 등 아무것도 체크 안해도 무관

    <br/>

2. Maven 설정
   - `[File] - [Settings] - [Build, Execution, Deployment] - [Build Tools] - [Maven] - [Maven home path]`를 위에서 설치한 `<PATH>` 경로로 설정 후 `'Apply'`