import { useRef, useState } from "react";
import { createPortal } from "react-dom";
import AlertModal from "./modal/AlertModal";
import Input from "./ui/Input";

export function RefComponent() {
  const textRef = useRef();
  const alertModalRef = useRef();
  const compleateModalRef = useRef();

  const [textArray, setTextArray] = useState([]);
  const onSaveHandler = () => {
    const textData = textRef.current.get();
    if (!textData) {
      //   alert("값을 입력하세요.");
      alertModalRef.current.open();
      textRef.current.select();
      return;
    }
    setTextArray((prev) => [...prev, textData]);
    textRef.current.set("");
    textRef.current.select();
    compleateModalRef.current.open();
  };

  const onCloseModalHandler = () => {
    alertModalRef.current.close();
  };

  const onCloseCompleteModalHander = () => {
    compleateModalRef.current.close();
  };

  return (
    <div className="main-container">
      <Input id="text" type="text" title="Text" ref={textRef} />
      <button onClick={onSaveHandler}>Save</button>
      <hr />
      <ul>
        {textArray.map((item, idx) => (
          <li key={idx}>{item}</li>
        ))}
      </ul>
      {createPortal(
        <AlertModal
          ref={compleateModalRef}
          onClose={onCloseCompleteModalHander}
        >
          <div>
            <h3>{textArray[textArray.length - 1]}을 입력했습니다.</h3>
          </div>
        </AlertModal>,
        document.querySelector("#modals")
      )}
      {createPortal(
        <AlertModal onClose={onCloseModalHandler} ref={alertModalRef}>
          <div>
            <h3>텍스트를 입력하세요!</h3>
          </div>
        </AlertModal>,
        document.querySelector("#modals")
      )}
    </div>
  );
}
