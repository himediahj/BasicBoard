# BasicBoard
## 기본 기획
CRUD 기능이 있는 간단한 게시판을 만들어봅니다
## 기술 스택
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"> <img src="https://img.shields.io/badge/Axios-5A29E4?style=for-the-badge&logo=Axios&logoColor=white"> <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white"> <img src="https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=Bootstrapt&logoColor=white"> <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">

## 기능
1. 회원가입 시 유효성 검사
2. 로그인 유무에 따른 게시판 접근 / 자동로그인 처리
3. 페이징 처리
4. 댓글 등록 삭제
## ERD
![board](https://user-images.githubusercontent.com/113006963/205523870-1bfb0f5d-d38d-4da6-b95e-e6fa6684134f.JPG)
## 기능 및 화면 설명
#### - AJAX를 사용하여 비동기 방식으로 가입 ID를 중복체크합니다
![c](https://user-images.githubusercontent.com/113006963/205578943-c38a9ee9-e74c-481a-944a-0f32c0d4af25.jpg) 
#### - Validation을 사용하여 화면에 메세지를 출력합니다

![가입](https://user-images.githubusercontent.com/113006963/205580395-d63903fb-5920-4d8a-8fa3-2a0b049de172.JPG)

#### - 쿠키와 세션을 사용하여 아이디 저장을 하거나 인터넷 창을 끄고 다시 켜도 **자동로그인**이 되게합니다<br>
Interceptor를 사용하여 로그인 상태가 아니면 /board/로 접근 불가능하게 합니다

![login](https://user-images.githubusercontent.com/113006963/205580984-75a8ed02-2eb8-4d1b-a99f-9e0fcf2fabaf.JPG)

#### - 웹 계층 구현

|Task|URL|Method|Parameter|Form|URL 이동
|------|---|---|---|---|---|
|전체목록|/board/list|GET|
|등록 처리|/board/register|POST|모든 항목|입력화면 필요|이동
|조회|/board/read|GET|bno=123|
|삭제 처리|/board/remove|POST|bno||이동
|수정 처리|/board/modify|POST|모든 항목|입력화면 필요|이동
<br>

#### - 한 화면에 10개씩 출력되도록 페이지 처리를 합니다

![list](https://user-images.githubusercontent.com/113006963/205585611-b0db7d8d-f117-4e90-a441-9c006755e8d1.JPG)
<br>

#### - Axios를 사용하여 비동기 통신으로 댓글을 등록하고 삭제합니다

![cc](https://user-images.githubusercontent.com/113006963/205587759-9c6e2082-83bd-4e38-8d7b-3c76c74d7f7c.jpg)
