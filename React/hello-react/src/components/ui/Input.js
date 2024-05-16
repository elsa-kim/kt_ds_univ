import { forwardRef, useRef, useImperativeHandle } from "react";

const Input = forwardRef(({ id, type, title }, ref) => {
  const textRef = useRef();

  useImperativeHandle(ref, () => {
    return {
      get() {
        return textRef.current.value;
      },
      set(val) {
        textRef.current.value = val;
      },
      select() {
        textRef.current.focus();
      },
    };
  });
  return (
    <>
      <label htmlFor={id}>{title}</label>
      <input type={type} id={id} ref={textRef} />
    </>
  );
});
export default Input;
