import { useCallback, useMemo, useState } from "react";
import Header from "./components/Header";
import BoardApp from "./components/BoardApp";
import { loadMyData } from "./http/http";
import { useFetch } from "./hooks/useFetch";
// import { useFetch } from "./hooks/useFetch";

export default function App() {
  const [token, setToken] = useState();
  const fetchLoadMyData = useCallback(() => {
    if (token) {
      return loadMyData;
    } else {
      return () => {
        return undefined;
      };
    }
  }, [token]);
  const fetchToken = useMemo(() => {
    return { token };
  }, [token]);

  const { data } = useFetch(undefined, fetchLoadMyData(), fetchToken);
  const { body: user } = data || {};

  return (
    <div className="main-container">
      <Header token={token} setToken={setToken} user={user} />
      <main>
        <BoardApp token={token} user={user} />
      </main>
    </div>
  );
}

// function App() {
//   // 서버가 발행해준 토큰을 기억하기 위한 state 생성
//   const [token, setToken] = useState();

//   // React에서 Spring Server로 데이터를 요청.
//   // API로만 통신. 요청 JSON --> JSON 응답.
//   // AJAX : iframe + From Request
//   //      form 요청 --> JSON / HTML 응답
//   // API : Browser --> Server
//   //      JSON 요청 --> JSON

//   // fetch()
//   // Javascript 내장 함수(API 요청)
//   // 비동기 통신
//   // const promise = fetch("URL", Header ==> {});
//   // promise.then(response=> {... todo ...}).then()
//   // await 동작하기 위해서는 상위 함수가 async 함수여야 한다.
//   // const response = await fetch("URL", Header ==> {});

//   // Spring Server에 접근하기 위한 JWT 발급.
//   useEffect(() => {
//     const loadToken = async () => {
//       const response = await fetch("http://localhost:8080/auth/token", {
//         // 서버로 데이터 보낼 때 body로 보내야함(약속)
//         body: JSON.stringify({
//           email: "test2@naver.com",
//           password: "qweqwe123123",
//         }),
//         method: "POST",
//         headers: {
//           "Content-Type": "application/json",
//         },
//       });
//       console.log(response);

//       // response에서 body의 값을 알고 싶을 때, response.json()을 호출.
//       // response.json() 함수 또한 비동기 함수.
//       // await response.json();
//       const body = await response.json();
//       console.log(body);
//       setToken(body.token + Math.random());
//     };

//     loadToken();
//   }, []);

//   // 이 컴포넌트가 실행될 때, 아이디와 패스워드를 통해 서버에게 로그인을 시도한다.
//   // 로그인 결과인 token을 가져와서 브라우저가 기억하도록 한다.

//   return <>{token}</>;
// }

// export default App;
