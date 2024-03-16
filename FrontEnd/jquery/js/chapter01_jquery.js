// .ready ==> rendering 끝난 후의 이벤트 (window.onload 와 같다)

// jQuery(document).ready();
// $ = jQuery 객체

// shorthand 표현식
// $(document).ready();
// $().ready();

$().ready(function () {
  // Rendering 끝나면 파라미터로 전달된 함수가 실행됨
  // Rendering이 언제 끝날 지 알 수 없다
  // alert(); 을 실행해서 정상적으로 경고창이 뜨는지를 항상 먼저 확인
  //   alert("jQuery Loading and Rendering 완료");

  // js : document.querySelector("h1");
  var h1Element = $("h1");
  console.log(h1Element); //ce.fn.init {0: h1, length: 1, prevObject: ce.fn.init} //jQuery객체가 나옴

  // js : console.log(h1Element.innerText);
  console.log(h1Element.text());

  // h1 DOM의 내용을 변경
  h1Element.text("Where to?");

  // jQuery 함수의 특징
  // .함수명(); <-- Getter
  // .함수명(데이터); <-- Setter
});
