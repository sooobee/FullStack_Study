// Dom 객체 연결(html,jsp파일에 있는 태그들(객체))을 
// 자바스크립트와 연결하는 과정
const container = document.getElementById("container");
const menuAdmin = document.getElementById("menuAdmin");
const menuList = document.getElementById("menuList");

// csrf 토큰과 헤더이름 가져오기
const csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
const csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

// 데이터 조회
// 백 -> 프론트 통신은 csrf추가할 필요없음
function fetchMenus(){
	// response를 json형식으로 변환
	// method: 'GET' 생략 가능
	fetch("/menu/all").then(response => response.json())
	.then(menus => { 
		menuList.innerHTML = ''; // 기존 메뉴 목록을 초기화
		menus.forEach(menu => {
			
			// div 추가
			const menuItem = document.createElement('div');
			menuItem.className='menu-item';
			
			// div안에 링크 추가
			menuItem.innerHTML=`
			<a href="#" class="menu-link" style="text-decoration:none;color:black;">
				<h3>${menu.title}</h3>
				<p>${menu.content}</p>
				<small>작성자:${menu.writer}, 작성일:${menu.indate}, 조회수:${menu.count}</small>
			</a>
			<br/>
			<br/>
			`
			
			// menuItem(게시글) 클릭 시 조회수 증가
			// noticeCheckPage로 이동
			menuItem.querySelector(".menu-link").addEventListener('click',(event)=>{
				event.preventDefault();
				console.log("event: ${event}");
				
				incrementCount(menu.idx).then(()=> window.location.href=`/noticeCheckPage?idx=${menu.idx}`)
			});
			
			menuList.appendChild(menuItem); // menuList에 삽입
		})
	})
}

// 조회수+1 기능
// 프론트 -> 백:csrf 추가해줘야함
function incrementCount(idx){
	return fetch(`/menu/count/${idx}`, {
		method: 'PUT',
		headers:{
			[csrfHeader]:csrfToken
		}
	}).then(response=>{
		if(!response.ok){
			console.log('데이터가 프론트서버에서 백 서버로 안넘어감');
		}
	}).catch(error=>{
		console.log('Error: ${error}');
	})
}

// 메인페이지가 열리면 자동실행
window.addEventListener('load', fetchMenus);