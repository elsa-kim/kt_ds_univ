import { useRef } from "react";

export function Input({ setContentArray }) {
  console.log("Run Input");
  const nameRef = useRef();
  const ageRef = useRef();

  const onClickHandler = () => {
    console.log("nameRef ========= ");
    console.log("nameRef: ", nameRef);
    console.log("nameRef.current: ", nameRef.current);
    console.log("nameRef.current.value: ", nameRef.current.value);
    console.log("ageRef ========= ");
    console.log("ageRef: ", ageRef);
    console.log("ageRef.current: ", ageRef.current);
    console.log("ageRef.current.value: ", ageRef.current.value);

    // 값 초기화 시킬때 contentArray에 빈값 들어가는 현상 해결법
    // setTimeout 함수 사용하는 방법
    // if (nameRef.current.value && ageRef.current.value) {
    //   setContentArray((prev) => [
    //     ...prev,
    //     { name: nameRef.current.value, age: ageRef.current.value },
    //   ]);

    //   // () => {} 이 함수를 100ms 이후에 실행해라.
    //   setTimeout(() => {
    //     nameRef.current.value = "";
    //     ageRef.current.value = "";
    //   }, 100);
    // }

    // 메모리 주소값 참조하게 만드는 방법
    const name = nameRef.current.value;
    const age = ageRef.current.value;

    if (!name) {
      alert("이름을 입력하세요.");
      nameRef.current.focus();
      return;
    }
    if (!age) {
      alert("나이을 입력하세요.");
      ageRef.current.focus();
      return;
    }

    setContentArray((prev) => [...prev, { name, age }]);

    nameRef.current.value = "";
    ageRef.current.value = "";

    nameRef.current.focus();
  };
  const deleteOnClickHandler = () => {
    setContentArray([]);
  };

  return (
    <div className="inputbox">
      <div>
        <label htmlFor="name">Name: </label>
        {/* nameRef.current = <input type="text" id="name" ... /> */}
        <input
          type="text"
          id="name"
          placeholder="이름을 입력해주세요."
          ref={nameRef}
        />
      </div>

      <label htmlFor="age">Age: </label>
      {/* ageRef.current = <input type="number" id="age" ... /> */}
      <input
        type="number"
        id="age"
        placeholder="나이를 입력해주세요."
        min={0}
        ref={ageRef}
      />

      <button onClick={onClickHandler}>저장</button>
      <button onClick={deleteOnClickHandler}>초기화</button>
    </div>
  );
}
