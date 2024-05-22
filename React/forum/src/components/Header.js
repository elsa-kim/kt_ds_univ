import { useEffect, useRef } from "react";
import { login } from "../http/http";

export default function Header({ token, setToken, user }) {
  const emailRef = useRef();
  const passwordRef = useRef();

  // 이 컴포넌트가 실행되자마자 Local Storage에 token 값이 있는지 확인한다.
  // Token 값이 있다면 token state에 값을 할당
  useEffect(() => {
    const storedToken = localStorage.getItem("token");
    if (storedToken) {
      setToken(storedToken);
    }
  }, [setToken]);

  const onLoginClickHandler = async () => {
    const email = emailRef.current.value;
    const password = passwordRef.current.value;

    if (!email) {
      alert("Email을 입력하세요.");
      emailRef.current.focus();
      return;
    }
    if (!password) {
      alert("비밀번호를 입력하세요.");
      passwordRef.current.focus();
      return;
    }

    const json = await login(email, password);
    if (json.message) {
      alert(json.message);
      return;
    } else if (json.token) {
      setToken(json.token);
    }

    // token의 값을 브라우저의 로컬스토리지에 작성한다.
    localStorage.setItem("token", json.token);

    // token의 값을 브라우저의 세션스토리지에 작성한다.
    // sessionStorage.setItem("token", json.token);
  };

  const onLogoutClickHandler = () => {
    localStorage.removeItem("token");
    setToken(undefined);
  };

  return (
    <header>
      {token && user && (
        <div>
          <div>
            {user.name} <span>({user.email})</span>
          </div>
          <span onClick={onLogoutClickHandler}>로그아웃</span>
        </div>
      )}
      {!token && (
        <div>
          <label htmlFor="email">EMAIL</label>
          <input ref={emailRef} type="email" id="email" placeholder="Email" />
          <label htmlFor="password">PASSWORD</label>
          <input
            ref={passwordRef}
            type="password"
            id="password"
            placeholder="Password"
          />
          <button onClick={onLoginClickHandler}>로그인</button>
        </div>
      )}
    </header>
  );
}
