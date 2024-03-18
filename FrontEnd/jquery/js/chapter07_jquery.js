$().ready(function () {
  // change : 증가 감소버튼 사용헤 값 바뀔때, 직접 입력 후 포커스아웃 됐을 때 적용
  $("#package-ticket-count").on("change", function () {
    $(this).keyup();
  });
  //   $("#package-ticket-count").on("keyup", function () {
  $("#package-ticket-count").on("keyup", function () {
    // 1. #package-ticket-count의 값을 받아온다
    var ticketCount = parseInt($(this).val());
    // parseInt > 문자를 숫자로 변경하는 함수 : space와 숫자 있으면 숫자 반환, 다른 문자 넣을경우 & space만 있으면 NaN
    // isNaN() : NaN 여부 확인해주는 함수
    if (isNaN(ticketCount) || ticketCount < 0) {
      ticketCount = 0;
      $(this).val(ticketCount);
    }

    // 일반 JS
    // document.querySelector("#package-ticket-count").value;

    // 2. data-price의 변수의 값을 받아온다
    // var ticketPrice = $(".package").data("price");
    var ticketPrice = $(this).closest(".package").data("price");

    console.log("ticketPrice", ticketPrice);
    console.log("ticketCount", ticketCount);

    console.log("ticketCount type: ", typeof ticketCount); // string
    console.log("ticketPrice type: ", typeof ticketPrice); // number

    // 3. 입력값과 price 값을 곱해서
    var amount = ticketCount * ticketPrice;
    console.log("amount", amount);
    console.log("amount type: ", typeof amount);

    // 4. #amount의 텍스트 변경한다
    $("#amount").text(amount);
  });
});
