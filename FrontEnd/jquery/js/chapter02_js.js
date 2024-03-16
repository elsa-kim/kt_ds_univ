window.onload = function () {
  // querySelectorAll : 해당 엘리먼트 다 가져와라 / querySelector : 해당 엘리먼트 중 처음꺼 가져와라
  var liElements = document.querySelectorAll("li");
  console.log(liElements);

  //   var liTexts = liElements.innerText;
  //   console.log(liTexts); //undefined

  liElements.forEach(function (li) {
    console.log(li.innerText);
    li.innerText = "Seoul";
  });
};
