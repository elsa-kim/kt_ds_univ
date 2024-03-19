// single line comment
/*
multi line comment
*/

// 변수 만들기
var number = 10;
var name = "이름";
var isJava = true;
var isJava2 = false;

console.log(number);
console.log(name);
console.log(isJava);
console.log(isJava2);

// 변수 값 변경
number = 20;
name = "이름2";
isJava = false;
isJava2 = true;

console.log(number);
console.log(name);
console.log(isJava);
console.log(isJava2);

// JS 타입 존재하지 않는다
number = "10";
name = 10;
isJava = 10.2333;

console.log(number);
console.log(name);
console.log(isJava);
console.log(isJava2);

var undefinedValue;
console.log(undefinedValue); //undefined : 값 할당하지 않은 상태

var nullValue = null;
console.log(nullValue); //null : 의도적으로 null 할당한 상태

alert("alert()은 함수입니다.");
alert("alert()은 경고창을 만드는 함수입니다.");
