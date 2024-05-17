import { useContext, useRef } from "react";
import TodoContext from "../contexts/TodoContext";

/**
 * TODO 아이템을 등록하는 Component
 */
export default function AddTodo() {
  const styles = {
    display: "flex",
    padding: "0.5rem",
    marginTop: "1rem",
  };

  const labelStyles = { flexShrink: 1, margin: "0.5rem 1rem" };
  const inputStyles = { flexGrow: 1 };
  const buttonStyles = { flexShrink: 1, margin: "0 0 0 1rem" };

  const taskRef = useRef();
  const dueDateRef = useRef();

  const { add } = useContext(TodoContext);
  const onClickHandler = () => {
    add(taskRef.current.value, dueDateRef.current.value);
  };

  return (
    <div style={styles}>
      <label style={labelStyles} htmlFor="task">
        TASK
      </label>
      <input
        style={inputStyles}
        type="text"
        id="task"
        placeholder="Input Task"
        ref={taskRef}
      />

      <label style={labelStyles} htmlFor="due-date">
        Due date
      </label>
      <input style={inputStyles} type="date" id="due-date" ref={dueDateRef} />
      <button style={buttonStyles} onClick={onClickHandler}>
        등록
      </button>
    </div>
  );
}
