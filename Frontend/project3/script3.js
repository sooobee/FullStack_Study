const quoteDisplayArea = document.querySelector("#quoteContainer");
const currentQuote = document.querySelector("#quote");
const loadingSpinner = document.getElementById("loader");
const favoriteQuoteList = document.getElementById("quotePickList");
const nextQuoteButton = document.getElementById("nextQuote");
const saveQuoteButton = document.getElementById("selectQuote");

let currentQuoteText = "";
let isQuoteSaved = false;

// 로딩 에니메이션 표시
function showLoadingSpinner(){
    // 로딩중 텍스트는 보이게, 명언 텍스트는 보이지 않게
    loadingSpinner.style.display = "block";
    currentQuote.style.display = "none";
}
// 로딩 애니메이션 숨기
function hideLoadingSpinner(){
    loadingSpinner.style.display = "none";
    currentQuote.style.display = "block";
}
// 한국어 명언 API 호출 및 명언 가져오는 함수(비동기화)
async function fetchKoreaQuotes(){

    console.log("fetch");

    showLoadingSpinner();

    const apiUrl = "https://korean-advice-open-api.vercel.app/api/advice";
    
    try{
        //명언을 가져옵니다. 
        const response = await fetch(apiUrl);
        const data = await response.json();
        currentQuoteText = data.message;

        //명언을 화면에 표시
        currentQuote.innerText = currentQuoteText;
        localStorage.setItem("currentQuote", currentQuoteText);
        // 즐겨찾기 여부 다시 초기화
        isQuoteSaved = false;

    } catch(error){
        console.error(`에러발생: ${error}`);
        currentQuote.innerText = "명언을 불러올 수 없습니다. 다시 시도해보세요.";
    }
    hideLoadingSpinner();
}

// 명언을 즐겨찾기 리스트에 추가
function saveFavoriteQuote(){
    const storedQuote = localStorage.getItem("currentQuote");

    if(isQuoteSaved == false && storedQuote !== null && isQuoteAlreadyInList(storedQuote) == false){
        const listItem = document.createElement("li");
        listItem.innerText = storedQuote;

        // 리스트에 하나씩 넣는 역할 <li> 안에
        favoriteQuoteList.appendChild(listItem);
        isQuoteSaved = true;

    } else if(isQuoteSaved){
        alert("이 명언은 이미 저장되었습니다.");
    } else {
        alert("이 명언은 이미 즐겨찾기에 추가되었습니다.");
    }
}

function isQuoteAlreadyInList(quote){
    const listItems = favoriteQuoteList.getElementsByTagName("li");

    for(item of listItems){
        if(item.innerText === quote){
            return true;
            // 데이터가 이미 존재하는 경우
        }
    }
    return false; 
}

// 다음 버튼 클릭시 새로운 명언 생성
nextQuoteButton.addEventListener("click", fetchKoreaQuotes);
// 선택 버튼 클릭시 명언을 즐겨찾기에 추가
saveQuoteButton.addEventListener("click", saveFavoriteQuote);

// 페이지 처음 로드 시 첫 명언 호출
fetchKoreaQuotes();