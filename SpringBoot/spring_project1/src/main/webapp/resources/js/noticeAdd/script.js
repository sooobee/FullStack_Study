// noticeAdd 파일
// 버튼 클릭 시 동작
document.getElementById("buttonSubmit").addEventListener("click", function(){
	// 객체 연결
	const formData = {
		memID: document.getElementById("memID").value,
		title: document.getElementById("title").value,
		content: document.getElementById("content").value,
		writer: document.getElementById("writer").value,
	}

	//index.jsp에서 만든 메타 csrf태그 2개를 js파일로 가져옴
	// 토큰과 헤더 값을 가져옴
	const csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
	const csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");
	
	fetch("/menu/add", {
		method:"POST", 
		headers:{
			'Content-Type':'application/json',
			[csrfHeader]:csrfToken // CSRF 헤더, 토큰 동적 추가	
		},
		body: JSON.stringify(formData) //form데이터 값을 넘김
	}).then(response =>{
		
		if(!response.ok){
			throw new Error("공지사항 작성 실패")
		}
		return response.text(); // 게시글 잘 작성됨
	}).then(_=>{ // 그 다음 동작
		console.log("Success");
		window.location.href="/"; // localhost:8080으로 페이지 이
	}).catch(error => {
		console("에러가 발생", error);
	})
});
