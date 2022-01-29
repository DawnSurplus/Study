# Markdown
</br>


## 1. 제목 (Header)
---
- ### '#' 개수(1~6)로 설정가능
    > ```
    > # DawnSurplus
    > ## DawnSurplus
    > ### DawnSurplus
    > #### DawnSurplus
    > ##### DawnSurplus
    > ###### DawnSurplus
    > ```
    > # DawnSurplus
    > ## DawnSurplus
    > ### DawnSurplus
    > #### DawnSurplus
    > ##### DawnSurplus
    > ###### DawnSurplus
</br></br></br>



## 2. 폰트 (Font)
---
- ### 기울이기 (Italic)
    >```
    >*DawnSurplus*
    >_DawnSurplus_
    >```
    > *DawnSurplus* </br>
    > _DawnSurplus_

<br/>

- ### 굵게 (Bold)
    >```
    >**DawnSurplus**
    >```
    > **DawnSurplus** </br>
    > __DawnSurplus__

<br/>

- ### 기울이기 + 굵게 (Italic + Bold)
    >```
    >**_DawnSurplus_**
    >```
    > **_DawnSurplus_**

<br/>

- ### 취소선 (strikethrough)
    >```
    >~~DawnSurplus~~
    >```
    > ~~DawnSurplus~~

<br/>

- ### 밑줄 (underscore)
    >```
    ><u>DawnSurplus</u>
    >```
    > <u>DawnSurplus</u>

<br/>

- ### 형광
    > ```
    > <mark>DawnSurplus</mark>
    > ```
    > <mark>DawnSurplus</mark>

<br/>

- ### 글자 강조
    > ```
    > `DawnSurplus`
    > ```
    > `DawnSurplus`

<br/>

- ### 글자색 변경
    > ```
    > <span style="color:Lime"> **_DawnSurplus_** </span>  
    > ```
    > <span style="color:Lime"> **_DawnSurplus_** </span>  

</br></br></br>



## 3. 목록
---
- ### 순서 있는 목록 (번호)
    > ```
    > 1. DawnSurplus
    >       1. DawnSurplus
    >       2. DawnSurplus
    >       3. DawnSurplus
    > 2. DawnSurplus
    > ```
    > 1. DawnSurplus
    >       1. DawnSurplus
    >       2. DawnSurplus
    >       3. DawnSurplus
    > 2. DawnSurplus

<br/>

- ### 순서 없는 목록 (*, -, +)
    >```
    >- DawnSurplus
    >  * DawnSurplus
    >    + DawnSurplus
    >```
    > - DawnSurplus
    >   * DawnSurplus
    >       + DawnSurplus

</br></br></br>



## 3. 코드
---
- ### 3.1 들여쓰기
    > ```
    >       DawnSurplus
    > ```
    >       DawnSurplus

<br/>

- ### 3.2 코드 블럭
    1. `<pre><code></code></pre>`
        > ```
        > <pre><code>
        > DawnSurplus
        ></code></pre>
        > ```
        > <pre><code> DawnSurplus </code></pre>

    2. *```* 방식
        - No Language
            > *```* <br/>
            >
            > DawnSurplus
            >
            > *```* <br/>
            > ```
            > DawnSurplus
            > ```

        - HTML
            > *``` html* <br/>
            >
            > {code}
            >
            > *```* <br/>
            > ```html
            > <a href="https://www.google.co.kr/" target="_blank">GOOGLE</a>
            > ```
            
        - CSS
            > *``` css* <br/>
            >
            > {code}
            >
            > *```* <br/>
            > ```css
            > .list > li {
            >   position: absolute;
            >   top: 40px;
            > }
            > ```

        - Java Script
            > *``` javascript* <br/>
            >
            > {code}
            >
            > *```* <br/>
            > ```javascript
            > function func() {
            >   var a = 'AAA';
            >   return a;
            > }
            > ```

        - Bash
            > *``` bash* <br/>
            >
            > {code}
            >
            > *```* <br/>
            > ```bash
            > $ vim ./~zshrc
            > ```

        - Python
            > *``` python* <br/>
            >
            > {code}
            >
            > *```* <br/>
            > ```python
            > s = "Python syntax highlighting"
            > print s
            > ```

</br></br></br>



## 4. 블럭
---
### '>' 기호 사용
```
> DawnSurplus
>> DawnSurplus
>>> DawnSurplus
```
> DawnSurplus
>> DawnSurplus
>>> DawnSurplus

</br></br></br>



## 5. 수평선
---
> ```
> ---
> * * *
> ***
> *****
> - - -
> ---------------------------------------
> <hr/>
> ```
> ---
> * * *
> ***
> *****
> - - -
> ---------------------------------------
> <hr/>

</br></br></br>



## 6. 링크
---
> ```
> [DawnSurplus](https://github.com/DawnSurplus/Study)
> ```
> [DawnSurplus](https://github.com/DawnSurplus/Study)

</br></br></br>



## 7. 표만들기
---
- 헤더 셀을 구분할 때 3개 이상의 -(dash) 기호가 필요
- 헤더 셀을 구분하면서 :(Colons) 기호로 셀(열/칸) 안에 내용을 정렬
- 가장 좌측과 가장 우측에 있는 |(vertical bar) 기호는 생략 가능
> ```
> a | b | c
> ---|:---:|---:
> `static` | 유형(기준) 없음 / 배치 불가능 | `static`
> `relative` | 요소 **자신**을 기준으로 배치 |
> `absolute` | 위치 상 **_부모_(조상)요소**를 기준으로 배치 |
> `fixed` | **브라우저 창**을 기준으로 배치 |
> ```
> a | b | c
> ---|:---:|---:
> `static` | 유형(기준) 없음 / 배치 불가능 | `static`
> `relative` | 요소 **자신**을 기준으로 배치 |
> `absolute` | 위치 상 **_부모_(조상)요소**를 기준으로 배치 |
> `fixed` | **브라우저 창**을 기준으로 배치 |

</br></br></br>



## 8. 이미지
---
- ### 8.1 삽입
    > ```
    > ![DawnSurplus](/Image/cat.jpg "DawnSurplus")<br/>
    > ```
    > ![DawnSurplus](/Image/cat.jpg "DawnSurplus")

<br/>

- ### 8.2 링크
    > ```
    > ![DawnSurplus](/Image/cat.jpg "DawnSurplus")<br/>
    > ```
    > [![DawnSurplus](/Image/cat.jpg)](https://github.com/DawnSurplus/Study)