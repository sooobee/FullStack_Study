# FullStack_Study
이 프로젝트는 인프런 [카네스 블랙의 무료 풀스택 웹개발 강의](https://www.inflearn.com/course/이거하나로종결-풀스택-웹개발)를 기반으로 학습하며 구현한 풀스택 웹 애플리케이션입니다.

> 📚 강의명: **이거 하나로 종결! 스프링 기반 풀스택 웹개발 무료강의**  
> 👨‍🏫 강사: **카네스 블랙 (Canus Black)**  
> 🎓 플랫폼: [인프런](https://www.inflearn.com/)

---
SpringBoot 폴더 내 최종 프로젝트 내용입니다. 

## 🛠 기술 스택

| 구분             | 기술                                       |
|------------------|--------------------------------------------|
| **OS**           | macOS                                      |
| **Server**       | AWS EC2, Apache Tomcat                     |
| **Frontend**     | HTML5, CSS3, JavaScript        |
| **Backend**      | Spring Framework, Spring Boot, Java        |
| **Database**     | Oracle DB                                  |
| **IDE / Editor** | VSCode, Eclipse                            |
| **Testing / Docs** | Swagger                                  |



## 🧩 주요 기능

- ✅ 회원가입 및 로그인
- ✅ 관리자 기능 (공지 작성 및 삭제, 수정)
- ✅ 게시판 (CRUD)



## 📂 프로젝트 구조

```
src
└── main
    ├── java
    │   └── com.canesblack.spring_project1
    │       ├── config
    │       ├── controller
    │       ├── entity
    │       ├── mapper
    │       ├── service
    │       └── SpringProject1Application.java
    ├── resources
    └── webapp
        ├── resources
        │   ├── css
        │   │   ├── common
        │   │   ├── login
        │   │   ├── noticeAdd
        │   │   ├── noticeCheck
        │   │   ├── noticeModify
        │   │   └── register
        │   └── js
        │       ├── noticeAdd
        │       ├── noticeCheck
        │       └── noticeModify
        └── WEB-INF
            └── views
                ├── common
                ├── login
                ├── noticeAdd
                ├── noticeCheck
                ├── noticeModify
                ├── register
                └── index
test
└── java

기타 루트 파일들
├── build.gradle
├── gradlew
├── gradlew.bat
├── HELP.md
└── settings.gradle

```



## 📜 데이터 베이스 구조
<img width="420" alt="image" src="https://github.com/user-attachments/assets/501b2d37-9dc8-4af8-9f26-a0684c2376bb" />




## 📟 API 명세서

| 메서드 | 엔드포인트             | 설명                  |
|--------|------------------------|-----------------------|
| GET    | `/menu/all`            | 전체 공지사항 조회         |
| GET    | `/menu/{idx}`          | 특정 공지사항 조회         |
| POST   | `/menu/add`            | 공지사항 추가              |
| PUT    | `/menu/update/{idx}`   | 공지사항 수정              |
| PUT    | `/menu/count/{idx}`    | 공지사항 조회수 증가       |
| DELETE | `/menu/delete/{idx}`   | 공지사항 삭제              |

---


## 📜 라이선스

본 프로젝트는 교육 목적의 개인 포트폴리오용으로 제작되었습니다.
