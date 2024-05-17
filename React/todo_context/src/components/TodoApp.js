import { useContext } from "react";
import AddTodo from "./AddTodo";
import Todo from "./Todo";
import TodoContext from "../contexts/TodoContext";

export default function TodoApp() {
  const { todo } = useContext(TodoContext);
  // content = {todo, add, done}

  const styles = {
    backgroundColor: "#FFF",
    margin: "1rem auto 0",
    width: "50rem",
  };

  return (
    <div style={styles}>
      <h4 style={{ padding: "1rem" }}>
        {/* filter: 해당하는 항목만 return */}
        완료: {todo.filter((item) => item.isDone).length} / 미완료:{" "}
        {todo.filter((item) => !item.isDone).length}
      </h4>
      <ul>
        {/* map: 요소들의 형태 변경 */}
        {todo.map((todo) => (
          <Todo key={todo.id} todo={todo} />
        ))}
      </ul>
      <AddTodo />
    </div>
  );
}
