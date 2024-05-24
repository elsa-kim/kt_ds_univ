import { useRef } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate, useParams } from "react-router-dom";
import AddTodo from "./AddTodo";
import { doneSubTodo, loadTodo } from "../../stores/toolkit/store";

export default function SubTodo() {
  const { id } = useParams();

  // React Router의 Path를 이동시키는 Hook
  // Spring의 redirect와 유사
  const navigate = useNavigate();
  const onClickHandler = () => {
    navigate("/todo");
  };

  const todoDispatch = useDispatch();
  // firebase에서 모든 todo를 받아오는 코드
  // thunk 호출 필요
  todoDispatch(loadTodo());

  // Redux Toolkit의 state를 받아온다.
  const todo = useSelector((state) =>
    state.todo.find((item) => item.id === parseInt(id))
  );
  console.log(todo);

  const getSubTodoItems = () => {
    const todoArrays = [];
    for (let key in todo.sub) {
      todoArrays.push(todo.sub[key]);
    }
    return todoArrays;
  };

  const subItems = todo && todo.sub ? getSubTodoItems() : [];

  const onDoneHandler = (event, item) => {
    const checkbox = event.currentTarget;
    const checked = checkbox.checked;
    todoDispatch(
      doneSubTodo({
        parentTodoId: parseInt(id),
        id: item.id,
        isDone: checked,
        task: item.task,
        dueDate: item.dueDate,
      })
    );
  };

  const styles = {
    display: "flex",
    marginTop: "1rem",
    borderBottom: "1px solid #ccc",
    padding: "1rem",
  };

  return (
    <>
      <h3 style={{ padding: "1rem" }}>'{todo && todo.task}'의 하위 목록</h3>
      <h4 style={{ padding: "1rem" }}>
        완료: {subItems.filter((item) => item.isDone).length} / 미완료:{" "}
        {subItems.filter((item) => !item.isDone).length}
      </h4>
      <div className="button-area right-align">
        <button onClick={onClickHandler}>상위 목록으로 가기</button>
      </div>
      <ul>
        {subItems.map((subTodo) => (
          <li
            style={{
              ...styles,
              color: subTodo.isDone ? "#ccc" : "#333",
              textDecoration: subTodo.isDone ? "line-through" : "none",
            }}
            key={subTodo.id}
          >
            <div style={{ marginRight: "1rem" }}>
              <input
                type="checkbox"
                onChange={(event) => onDoneHandler(event, subTodo)}
                defaultValue={subTodo.defaultValue}
                checked={subTodo.isDone ? "checked" : ""}
                key={subTodo.id}
              />
            </div>
            <div style={{ flexGrow: 1 }}>{subTodo.task}</div>
            <div>{subTodo.dueDate}</div>
          </li>
        ))}
      </ul>
      <AddTodo
        parentTodoId={parseInt(id)}
        sub={true}
        style={{
          display: "flex",
          padding: "0.5rem",
          marginTop: "1rem",
        }}
      />
    </>
  );
}
