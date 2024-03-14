// 객체 만들기
// 첫번째 객체 (비어있는 객체)
var emptyObject = {};
console.log(emptyObject); //{}
console.dir(emptyObject); //Object

// 두번째 객체 (값이 있는 객체)
var movieObject = {
  id: "mv-20230314-123456",
  title: "테스트 영화",
  minAge: 7,
  genre: ["액션", "판타지", "SF", "스릴러"],
  actors: [
    {
      name: "조인성",
      role: "주연",
      characterName: "인성",
    },
    {
      name: "차태현",
      role: "조연",
      characterName: "태현",
    },
  ],
};
console.log(movieObject); //{id: 'mv-20230314-123456', title: '테스트 영화', minAge: 7, genre: Array(4), actors: Array(2)}
console.dir(movieObject); //Object

// 영화의 이름만 출력
var title = movieObject.title;
console.log(title); //테스트 영화

// 영화의 아이디만 출력
var movieId = movieObject.id;
console.log(movieId); //mv-20230314-123456

// 영화의 출연진들을 출력
var actors = movieObject.actors;
console.log(actors); //(2) [{…}, {…}]

// 영화의 출연진 중 첫번째 배우만 출력
var actor = movieObject.actors[0];
console.log(actor); //{name: '조인성', role: '주연', characterName: '인성'}

// 영화의 촬영 국가를 출력
var locationInfo = movieObject.location;
console.log(locationInfo); //undefined

movieObject.location = "한국";
locationInfo = movieObject.location;
console.log(locationInfo); //한국
