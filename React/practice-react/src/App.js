import { useState } from "react";
import { Input } from "./components/Input";
import { Data } from "./components/Data";

function App() {
  // text 관리하는 state => 기본값 undefined 괜찮음
  // 배열 관리하는 state => 기본값 []
  const [textArray, setTextArray] = useState([]);

  return (
    <>
      <Input setTextArray={setTextArray} />
      <Data textArray={textArray} />
    </>
  );
}

export default App;
