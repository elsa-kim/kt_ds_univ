// querySelectorAll 하면 배열 => forEach 돌려줘야 함
window.onload = function () {
  var buttonArray = document.querySelectorAll(".package-green-button");

  buttonArray.forEach(function (button) {
    // 클릭 이벤트 할당
    button.addEventListener("click", function () {
      // Element 생성
      var price = document.createElement("p");
      price.innerText = "$399.99";
      console.log(price);

      // Element 추가
      var package = button.parentElement.parentElement;
      package.append(price);

      // 버튼 제거
      var buttonArea = button.parentElement;
      buttonArea.remove();
    });
  });
};
