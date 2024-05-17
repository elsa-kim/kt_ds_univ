import AddTodo from "./AddTodo";
import Todo from "./Todo";

export default function TodoApp({ todo, setTodo }) {
  const styles = {
    backgroundColor: "#FFF",
    margin: "1rem auto 0",
    width: "50rem",
  };

  // Todo 컴포넌트가 한개라면 ref로 주는게 맞지만 아이템 수만큼 Todo 만들어야하므로 event 사용
  const onDoneHandler = (e) => {
    const checkbox = e.currentTarget;
    const id = parseInt(checkbox.value);

    // state [] 항목 중 하나만 바뀌면 메모리 주소는 동일해서 react가 모름 => 레퍼런스 타입은 메모리 주소를 바꿔줘야 함(성능상 이유)
    setTodo((prev) =>
      prev.map((todo) => {
        if (todo.id === id) {
          todo.isDone = checkbox.checked;
        }
        // 새로운 메모리에 들어있는 객체 리터럴로 반환
        return { ...todo };
      })
    );
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
          <Todo key={todo.id} todo={todo} onDone={onDoneHandler} />
        ))}
      </ul>
      <AddTodo setTodo={setTodo} />
    </div>
  );
}
