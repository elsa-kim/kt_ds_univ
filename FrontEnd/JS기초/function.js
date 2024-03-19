function sayHello() {
  console.log("반갑습니다.");
}

function sayHelloWithName(name) {
  console.log("안녕하세요, " + name + "님!");
}

function calcNumbers(num1, num2) {
  var result = num1 + num2;
  return result;
}

// 정상케이스
sayHello();
sayHelloWithName("소현");
var calcResult = calcNumbers(50, 40);
console.log(calcResult);

// 이상케이스
sayHello(1, 2, 3, 4, 5);
sayHelloWithName();
var calcResult = calcNumbers(50, 40, 4, 5);
console.log(calcResult);

// 파라미터 전달 시 arguments로 들어감, 인덱스 생김 => 함수가 파라미터 받으면 arguments의 인덱스 순서대로 할당됨
// => 코드는 직관적인게 좋기때문에 파라미터 수 맞춰 작성해주는게 좋음
function addAllNumbers(n1, n2, n3, n4) {
  console.log(arguments, n1, n2, n3, n4);
  var sum = 0;
  for (var i in arguments) {
    sum += arguments[i];
  }
  return sum;
}

var addResult = addAllNumbers(1, 2, 3, 4, 54, 65, 7, 48, 8, 90);
console.log(addResult);

// 중첩함수
function getCalcNumbers(numberOne, numberTwo) {
  var result = calcPlus();

  // 숨기고 싶은 함수
  // 파라미터 영역 안이라 파라미터 적을 필요 없음
  function calcPlus() {
    return numberOne + numberTwo;
  }

  return result;
}

// 함수안에 있는 중첩 함수는 호출할 수 없다.
// getCalcNumbers() 함수 통해서만 실행할 수 있다.
// calcPlus(); //Uncaught ReferenceError: calcPlus is not defined

var result = getCalcNumbers(1, 2);
console.log(result);

// 콜백함수 ( 함수가 파라미터로 전달되는 함수)
function getCalcResult(num1, num2, beginFn, endFn) {
  beginFn(num1, num2);
  var result = num1 + num2;
  endFn(num1, num2, result);
  return result;
}

var calcResult = getCalcResult(
  110,
  220,
  function (num1, num2) {
    console.log("계산을 시작합니다.");
  },
  function (num1, num2, result) {
    console.log("계산이 끝났습니다.");
    console.log("결과는 " + result + "입니다,");
  }
);
console.log(calcResult);

var calcResult2 = getCalcResult(
  110,
  220,
  function (num1, num2) {
    console.log("============================");
  },
  function (num1, num2, result) {
    console.log(num1 + "+" + num2 + "=" + result);
    console.log("============================");
  }
);
console.log(calcResult);

// 함수를 반환시키는 함수
function counter() {
  var count = 0;
  return function () {
    return ++count;
  };
}

function counter2() {
  var count = 0;
  // 익명함수
  function count2() {
    return ++count;
  }
  return count2; // 함수반환
  //  return count2(); // 함수 결과 반환
}

var counter1 = counter();
console.log(counter1);
var count = counter1();
console.log(count);

var counter2 = counter2();
console.log(counter2);

var count2 = counter2();
console.log(count2);
var count2 = counter2();
console.log(count2);
var count2 = counter2();
console.log(count2);

// 즉시 실행 함수(함수명 생략 가능)
(function (message) {
  console.log(message + " 실행됨.");
})("즉시 실행 함수");

function foo() {
  var count = 0;
  if (true) {
    var bar = 10;
  }
  console.log(bar);
  console.log(count);
}
foo();
