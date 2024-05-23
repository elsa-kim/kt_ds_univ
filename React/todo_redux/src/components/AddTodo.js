import { useRef, memo } from "react";
import { useDispatch } from "react-redux";
import { addTodo, todoActions } from "../stores/toolkit/store";

/**
 * TODO 아이템을 등록하는 Component
 */
export default memo(function AddTodo({ style }) {
  console.log("Run AddTodo");

  const labelStyles = { flexShrink: 1, margin: "0.5rem 1rem" };
  const inputStyles = { flexGrow: 1 };
  const buttonStyles = { flexShrink: 1, margin: "0 0 0 1rem" };

  const taskRef = useRef();
  const dueDateRef = useRef();

  const todoDispatch = useDispatch();
  /**
   * 등록버튼을 클릭했을때의 핸들러
   * setTodo를 이용해서 TODO 아이템을 등록해야 한다.
   */
  const onClickHandler = () => {
    // onAdd(taskRef.csurrent.value, dueDateRef.current.value);

    const task = taskRef.current.value;
    const dueDate = dueDateRef.current.value;
    if (!task || !dueDate) {
      alert("값을 입력해주세요");
      return;
    }

    // thunk dispatch 코드
    todoDispatch(
      addTodo({
        id: parseInt(Math.random() * 100_000_000),
        isDone: false,
        task: taskRef.current.value,
        dueDate: dueDateRef.current.value,
      })
    );

    // toolkit dispatch 코드
    // todoDispatch(
    //   todoActions.add({
    //     task,
    //     dueDate,
    //   })
    // );

    // redux dispatch 코드
    // todoDispatch({
    //   type: "ADD-TODO",
    //   payload: {
    //     task: taskRef.current.value,
    //     dueDate: dueDateRef.current.value,
    //   },
    // });

    taskRef.current.value = "";
    dueDateRef.current.value = "";
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
