$().ready(function () {
  // $(".package-green-button").on("click", function () {
  $(".package-button-area").on("click", function () {
    var package = $(this).closest(".package");
    var amount = package.data("price");
    var currency = package.data("currency");

    // console.log("amount>", amount);
    // console.log("currency>", currency);

    var price = $("<p>From " + currency + amount + "</p>");
    price.on("click", function () {
      var text = $(this).text();
      alert(text);
    });
    // $(this).closest(".package-button-area").after(price);
    package.append(price);
    // $(this).closest(".package-button-area").remove();
    $(this).remove();
  });
});
