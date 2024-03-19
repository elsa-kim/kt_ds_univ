$().ready(function () {
  // .package-green-button에게 클릭 이벤트 할당
  //   $(".package-green-button").click(); // <-- 버튼을 클릭해라(getter)

  // $(selector).click(callbackFunction); <-- Deprecated
  //   $(".package-green-button").click(function () {
  $(".package-green-button").on("click", function () {
    // p 태그 만들기
    var price = $("<p>#399.99</p>"); //단순한 형태가 들어갈 때

    //   var price = $("<p></p>"); // 복잡하거나 동적인 형태 들어갈 때
    //   price.text("$399.99");

    // .package 내 가장 아래쪽으로 붙이기
    $(".package").append(price);

    // .package-button-area 지우기
    $(".package-button-area").remove();
  }); // <-- 버튼을 클릭하면 function을 수행해라(setter)
});
