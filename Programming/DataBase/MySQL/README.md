# mySQL(mariaDB)
- SQL (Structured Query Language)

</br>



## 0. 개요
---
- 1994년, 스웨덴에서 MySQL 개발되기 시작
- 무료, 오픈소스
- 관계형 데이터베이스의 주요한 기능을 대부분 갖추고 있는 준수한 관계형 데이터베이스 시스템
- 웹이 폭발적인 성장을 하면서 MySQL은 웹 개발자들에게 매우 좋은 대안
- MySQL은 웹과 함께 폭발적인 동반 성장
- 오늘날 MySQL은 데이터베이스 시장 안에서 세 손가락 안에 드는 시장의 지배자

</br>



## 1. mySQL 구조
---
- ### `표 (Table)` ⊂ `데이터베이스(스키마)` ⊂ `데이터베이스 서버`
  - `표`: 데이터를 기록하는 최종적인 곳
  - `데이터베이스` : 표의 그룹
  - `스키마` : 표를 서로 그루핑할 때 사용하는 일종의 폴더로, 서로 연관된 데이터를 그루핑함. 스키마가 많아지면 데이터베이스 서버안에 저장.

</br>

- ### `표 (Table)`
  - `x축` : Row, record, 행 (데이터 하나하나, 데이터 자체)
  - `y축` : Column, 열, (데이터 타입, 데이터 구조)

</br>



## 2. Query (데이터베이스에 보내는 요청)
---
- ### 시작
    > `mysql -u`아이디 `-p`비밀번호</br>
    > `mysql -h`호스트주소 `-p`포트번호 `-u`아이디 `-p`비밀번호

- ### 비밀번호 재설정
    > `SET PASSWORD = PASSWORD('`new password`');`

</br>

- ### 데이터베이스 리스트 보기
    > `SHOW DATABASES;`

- ### 데이터베이스 생성
    > `CREATE DATABASE` 데이터베이스명 ;

- ### 데이터베이스 삭제
    > `DROP DATABASE` 데이터베이스명 ;

- ### 데이터베이스 선택
    > `USE` 데이터베이스명 ;

</br>

- ### 테이블 리스트 보기
    > `SHOW TABLES;`

- ### 테이블 생성
    > `CREATE TABLE` 테이블명 (</br>
    > column1 `datatype(length) NOT NULL`, `AUTO_INCREMENT`,</br>
    > column2 `datatype(length) NOT NULL`,</br>
    > column3 `datatype(length) NOT NULL`,</br>
    > ...</br>
    > `PRIMARY KEY(coloum1)`</br>
    > ) ;
    - `datatype` : INT, VARCHAR, DATETIME, TEXT...
    - `length` : 크기
    - `NOT NULL` : 값을 무조건 넣도록 설정
    - `AUTO_INCREMENT` : 값 자동 증가
    - `PRIMARY KEY(column)` : column의 값을 고유값으로 설정

- ### 테이블 정보 보기
    > `DESC` 테이블명 ;

- ### 테이블에 데이터 추가
    > ```
    > INSERT INTO 테이블명 (`column1`, `column2`, `column3`, ...) values ('value1', 'value2', 'value3', ...)
    > ```

- ### 테이블 이름 변경
    > `RENAME` 기존 테이블명 `TO` 새로운 테이블명;

</br>

- ### 입력된 테이블 데이터 조회
    > `SELECT `Column1, Column2, Column3, ...` FROM` 테이블명 </br>
    > --> 테이블에 있는 Column1, Column2, Column3, ...의 내역을 가져옴
    - 전체 조회 : Column명 = *

- ### 데이터 부분 조회
    > `SELECT `Column1, Column2, Column3, ...` FROM` 테이블명 `WHERE` Colmn1=value </br>
    > --> 테이블에 있는 Column1, Column2, Column3, ...의 내역 중 Column1이 value인 내역을 가져옴

- ### 데이터 정렬
    > `SELECT `Column1, Column2, Column3, ...` FROM` 테이블명 `ORDER BY` Column1 `DESC|ASC` </br>
    > --> 테이블에 있는 Column1, Column2, Column3, ...의 내역 중 Column1의 내역을 (DESC/ASC) 정렬하여 가져옴

- ### 데이터 제한
    > `SELECT `Column1, Column2, Column3, ...` FROM` 테이블명 `LIMIT` n </br>
    > --> 테이블에 있는 Column1, Column2, Column3, ...의 내역을 n개만 가져옴

</br>

- ### 데이터 업데이트
    > `UPDATE` 테이블명 `SET` Column3='...', Column2='...', ... `WHERE` Column1=1</br>
    > --> 테이블에 있는 Column1=1에 해당하는 Column3, Column2의 데이터를 변경
    - `주의` : 만약 WHERE를 없이 실행 시, 모든 데이터의 내역이 변경

</br>

- ### 데이터 삭제
    > `DELETE FROM` 테이블명 `WHERE` Column1=1</br>
    > --> 테이블에 있는 Column1=1에 해당하는 ROW를 삭제
    - `주의` : 만약 WHERE를 없이 실행 시, 해당 테이블이 삭제

</br>

- ### 관계형 데이터베이스 (JOIN)
    > `SELECT` Table1.Column1, Column2, ... `FROM` Table1 `LEFT` `JOIN` Table2 `ON` table1.Column3 = Table2.Column1;</br>
    > --> Table1에 있는 Column3과 Table2의 Column1을 매칭시켜, 하나의 테이블로 보이게 함

</br>