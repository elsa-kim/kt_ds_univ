import { useState } from "react";

export function Input({ setContentArray }) {
  const [name, setName] = useState();
  const [age, setAge] = useState(0);

  const onKeyUpHandlerForName = (e) => {
    setName(e.currentTarget.value);
  };
  const onKeyUpHandlerForAge = (e) => {
    setAge(e.currentTarget.value);
  };

  const onClickHandler = () => {
    if (name && age) {
      setContentArray((prev) => [...prev, { name, age }]);
      document.querySelectorAll("input").forEach((inp) => {
        inp.value = "";
      });
      setAge();
      setName();
    } else {
      alert("값을 입력해주세요.");
    }
  };
  const deleteOnClickHandler = () => {
    setContentArray([]);
  };

  return (
    <div className="inputbox">
      <div>
        <label htmlFor="name">Name: </label>
        <input
          type="text"
          id="name"
          placeholder="이름을 입력해주세요."
          onKeyUp={onKeyUpHandlerForName}
        />
      </div>

      <label htmlFor="age">Age: </label>
      <input
        type="number"
        id="age"
        placeholder="나이를 입력해주세요."
        onKeyUp={onKeyUpHandlerForAge}
        min={0}
      />

      <button onClick={onClickHandler}>저장</button>
      <button onClick={deleteOnClickHandler}>초기화</button>
    </div>
  );
}
