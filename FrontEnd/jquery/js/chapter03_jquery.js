$().ready(function () {
  // children > "#destinations > li"
  var listItems = $("#destinations").children("li");
  console.log(listItems);
  console.log(listItems.text());

  console.log(listItems.first().text());
  console.log(listItems.first().next().text());
  console.log(listItems.first().next().next().text());

  listItems.each(function (idx, item) {
    console.log("each >", idx, $(item).text());
  });
});
