import { useRef, memo } from "react";

/**
 * TODO 아이템을 등록하는 Component
 */
export default memo(function AddTodo({ onAdd, style }) {
  console.log("Run AddTodo");

  const labelStyles = { flexShrink: 1, margin: "0.5rem 1rem" };
  const inputStyles = { flexGrow: 1 };
  const buttonStyles = { flexShrink: 1, margin: "0 0 0 1rem" };

  const taskRef = useRef();
  const dueDateRef = useRef();

  /**
   * 등록버튼을 클릭했을때의 핸들러
   * setTodo를 이용해서 TODO 아이템을 등록해야 한다.
   */
  const onClickHandler = () => {
    onAdd(taskRef.current.value, dueDateRef.current.value);
  };

  return (
    <div style={style}>
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
});
