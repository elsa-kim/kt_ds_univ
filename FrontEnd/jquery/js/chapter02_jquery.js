$().ready(function () {
  //   var liElements = $("li");
  //   console.log(liElements);
  //   console.log(liElements.text()); //RomeParisRio //붙어나옴
  //   liElements.text("Seoul");
  //   var destinationsElenments = $("#destinations");
  //   console.log(destinationsElenments);
  //   console.log(destinationsElenments.text());
  //   console.log(destinationsElenments.html()); //  <li>Rome</li>⮐<li>Paris</li>⮐<li class="promo">Rio</li>// 내부 태그들 그대로 가져옴 => 다른 태그로 변경 가능
  //   destinationsElenments.html("<li>None</li>");
  //   //   destinationsElenments.text("<li>None</li>");

  var promoElement = $(".promo");
  console.log(promoElement);
  console.log(promoElement.text());
  console.log(promoElement.html());
});
