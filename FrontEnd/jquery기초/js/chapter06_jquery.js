$().ready(function () {
  $("img")
    .on("mouseenter", function () {
      //   $(".ticket").show();
      //   $(".ticket").slideDown(200);
      $(".ticket").fadeIn();
      $(".ticket").fadeIn();
    })
    .on("mouseleave", function () {
      //   $(".ticket").hide();
      // $(".ticket").slideUp(50); // 0.05s동안 해라
      $(".ticket").fadeOut();
    })
    .on("click", function () {
      console.log("이미지를 클릭함");
    })
    .on("contextmenu", function (e) {
      e.preventDefault(); // os의 기본 동작 무시(폼 전송시 필수 사용)
      console.log("오른쪽 버튼을 클릭했습니다.");
    });
});
