// Dom 객체 연결(html,jsp파일에 있는 태그들(객체))을 
// 자바스크립트와 연결하는 과정

const container = document.getElementById("container");
const menuAdmin = documnet.getElementById("menuAdmin");
const menuList = document.getElementById("menuList");

// csrf 토큰과 헤더이름 가져오기
const csrfToken = document.querySelector("meta[name='_csrf']").getAttribute('content');
const csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute('content');