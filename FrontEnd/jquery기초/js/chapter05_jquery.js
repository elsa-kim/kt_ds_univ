$().ready(function () {
  // .package-green-button에게 클릭 이벤트 할당
  $(".package-green-button").on("click", function () {
    // p 태그 만들기
    var price = $("<p>#399.99</p>"); //단순한 형태가 들어갈 때

    // .package 내 가장 아래쪽으로 붙이기
    // $(".package").append(price);
    // 클릭한 버튼 밑에 p 태그 추가하기
    // $(this).parent().after(price); -> parent 안쓰는게 좋음(HTML 구조 바꼈을 때 대비)
    // 클릭한 버튼에서 가장 가까운 .package 부모를 찾아 가장 아래쪽에 붙이기
    $(this).closest(".package").append(price);

    // .package-button-area 지우기
    // $(".package-button-area").remove();
    // 클릭한 버튼만 지우기
    $(this).closest(".package-button-area").remove();
    // $(this).parent().remove();
  }); // <-- 버튼을 클릭하면 function을 수행해라(setter)
});
