window.onload = function () {
  var liItems = document.querySelectorAll("#destinations > li");

  console.log(liItems);

  liItems.forEach(function (li) {
    console.log(li);
  });

  var destinations = document.querySelector("#destinations");
  console.log(destinations);
  console.dir(destinations); // 속성 정보 나옴

  var listItem = destinations.children;
  console.log(listItem);

  for (var i in listItem) {
    if (typeof listItem[i] !== "function") {
      console.log(listItem[i]);
      console.log(listItem[i].innerText);
    }
  }
};
