$().ready(function () {
  // id가 desrinations인 엘리먼트 하위의 모든 li를 찾아온다
  // CSS : "#destinations li"
  // $("#destinationa li") <-- 이 방법은 사용 x
  var liInDestinations = $("#destinations").find("li"); // <-- 더 빠르다

  console.log(liInDestinations);
  console.log(liInDestinations.text());
  console.log(liInDestinations.html());

  // liInDestinations.html("<div>Change!</div>");
  // console.log(liInDestinations.html());

  // CSS : "#destinations li:first-child"
  // $("#destinations li:first-child"); <-- 느리다
  var firstLiElement = $("#destinations").find("li").first(); // <-- 빠르다
  console.log("first li: ", firstLiElement.text());

  // CSS : "#destinations li:last-child"
  // $("#destinations li:last-child"); <-- 느리다
  var lastLiElement = $("#destinations").find("li").last(); // <-- 빠르다
  console.log("last li: ", lastLiElement.text());

  // CSS : "#destinations li:nth-child(2)"
  // $("#destinations li:nth-child(2)")
  var secondLiElment = $("#destinations").find("li").first().next();
  console.log("second li: ", secondLiElment.text());

  // CSS : "#destinations li:nth-child(2)"
  // $("#destinations li:nth-child(2)")
  var secondLiElment2 = $("#destinations").find("li").last().prev();
  console.log("second li: ", secondLiElment2.text());

  // $("#destinations").find("li").first();
  var firstLiElement2 = $("#destinations").find("li").eq(0);
  console.log("first li: ", firstLiElement2.text());

  // $("#destinations").find("li").first().next();
  // $("#destinations").find("li").last().prev();
  var secondLiElment3 = $("#destinations").find("li").eq(1);
  console.log("second li: ", secondLiElment3.text());

  // $("#destinations").find("li").last();
  // 요소 몇개인지 모를때는 last 쓰는게 좋음
  var lastLiElement2 = $("#destinations").find("li").eq(2);
  console.log("last li: ", lastLiElement2.text());

  var parentElement = $("li").parent(); // 사용 x (DOM의 구조가 상시로 바뀌기 때문)
  console.log(parentElement);
});
