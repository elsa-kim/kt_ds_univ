/* Rendering이 끝나기 전 */
var h1Element = document.querySelector("h1");
console.log("Before Render > ", h1Element); //Before Render >  null
// alert("Before Render > " + h1Element.innerText); //Uncaught TypeError: Cannot read properties of null (reading 'innerText')

/*
브라우저가 tag를 모두 분석한 뒤
화면에 노출시키는 rendering 과정이 끝나고 나면
onload 이벤트를 호출한다.

rendering이 끝난 후 부터 DOM을 Handling 할 수 있다.
*/
window.onload = function () {
  // Rendering이 끝난 후
  var h1Element = document.querySelector("h1");
  console.log("After Render > ", h1Element); //After Render >  <h1>​Where do you want to go?​</h1>​
  alert("After Render > " + h1Element.innerText);
};
