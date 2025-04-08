// noticeModify

// 공지사항 수정 버튼 
document.getElementById("buttonUpdate").addEventListener('click',function(){
	const idx = document.getElementById("idx").value;
	
	const formData = {
		// json 형태로 변경	
		title: document.getElementById("title").value,
		content: document.getElementById("content").value,
		writer: document.getElementById("writer").value,
	}
	
	const csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
	const csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");
		
		fetch(`/menu/update/${idx}`, {
			method: "PUT",
			headers:{
				'Content-type':'application/json',
				[csrfHeader]:csrfToken
			},
			body: JSON.stringify(formData)
		}).then(response => {
			if(!response.ok){
				throw new Error("서버 응답 에러");
			} else {
				return response.text();
			}
		}).then(_ => {
			alert("수정이 성공적으로 진행되었습니다.");
			window.location.href= '/'; // 메인페이지로 리다이렉팅
		}).catch(error => {
			console.log(`에러 발생: ${error}`);
		})
})
