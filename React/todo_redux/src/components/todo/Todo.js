import { useRef } from "react";
import { useDispatch } from "react-redux";
import { doneTodo } from "../../stores/toolkit/store";
import { Link } from "react-router-dom";

/**
 * Todo Item을 관리하는 컴포넌트
 *
 * props: todo = { id: "", task: "", dueDate: "", isDone:false }
 */
export default function Todo({ todo, style }) {
  console.log("Run Todo");

  const { id, task, dueDate, isDone } = todo;

  const checkboxRef = useRef();
  const todoDispatch = useDispatch();
  const onDoneHandler = () => {
    const checkbox = checkboxRef.current;
    const checked = checkbox.checked;

    // thunk dispatch 코드
    todoDispatch(doneTodo({ id, task, dueDate, isDone: checked }));

    // toolkit dispatch 코드
    // todoDispatch(todoActions.done({ id, isDone: checked }));

    // react-redux dispatch 코드
    // const payload = { id, isDone: checked };
    // todoDispatch({ type: "DONE", payload });
  };

  const styles = {
    ...style,
    borderBottom: "1px solid #ccc",
    padding: "1rem",
    color: isDone ? "#ccc" : "#333",
    textDecoration: isDone ? "line-through" : "none",
  };

  return (
    <li style={styles}>
      <div style={{ marginRight: "1rem" }}>
        <input
          type="checkbox"
          key={id}
          defaultValue={id}
          checked={isDone ? "checked" : ""}
          onChange={onDoneHandler}
          ref={checkboxRef}
        />
      </div>
      <div style={{ flexGrow: 1 }}>
        <Link to={`/todo/${id}`} style={{ color: isDone ? "#ccc" : "#333" }}>
          {task}
        </Link>
      </div>
      <div>{dueDate}</div>
    </li>
  );
}
