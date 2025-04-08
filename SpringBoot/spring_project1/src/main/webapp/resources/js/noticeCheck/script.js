/* noticeCheck */
document.getElementById("buttonUpdate").addEventListener('click',function(){
	const idx = document.getElementById("idx").value;
	
	// 수정페이지로 이동
	window.location.href=`/noticeModifyPage?idx=${idx}`;
})


// 프론트 -> 백 삭제 명령(csrf 필요)
document.getElementById("buttonDelete").addEventListener('click', function(){
	const idx = document.getElementById("idx").value;
	
	const csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
	const csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");
	
	fetch(`/menu/delete/${idx}`, {
		method: "DELETE",
		headers:{
			[csrfHeader]:csrfToken
		}
	}).then(response => {
		if(!response.ok){
			throw new Error("서버 응답 에러");
		} else {
			return response.text();
		}
	}).then(_ => {
		alert("삭제가 성공적으로 진행되었습니다.");
		window.location.href= '/'; // 메인페이지로 리다이렉팅
	}).catch(error => {
		console.log(`에러 발생: ${error}`);
	})
})