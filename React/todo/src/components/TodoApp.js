import { useCallback, useMemo } from "react";
import AddTodo from "./AddTodo";
import Todo from "./Todo";

export default function TodoApp({ todo, setTodo }) {
  console.log("Run TodoApp");

  // const obj = useMemo(() => {
  //   // 개체 내에서 todo 포함되어있다면
  //   return { A: 1, B: 2, todo };
  //   // 의존배열에 todo 포함되어야함 => 변경 여부 감지해 다시 obj에게 할당
  // }, [todo]);

  const flexStyles = useMemo(() => {
    return {
      display: "flex",
      padding: "0.5rem",
      marginTop: "1rem",
    };
  }, []);

  const styles = {
    backgroundColor: "#FFF",
    margin: "1rem auto 0",
    width: "50rem",
  };

  // [] <== Component가 처음 실행될 때에만 동작(의존 배열)
  // const fn = useCallback(() => {}, []);
  // [todo] <== todo가 변경되었다면, 함수를 재생성하는 의존 배열
  //            todo가 변경되었을 때 동작
  // const fn = useCallback(() => {}, [todo]);

  const onTodoHandler = useCallback(
    (task, dueDate) => {
      setTodo((prevTodos) => [
        ...prevTodos,
        {
          id: prevTodos.length,
          task,
          dueDate,
          isDone: false,
        },
      ]);
    },
    [setTodo]
  );

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
          <Todo
            key={todo.id}
            todo={todo}
            onDone={onDoneHandler}
            style={flexStyles}
          />
        ))}
      </ul>
      <AddTodo onAdd={onTodoHandler} style={flexStyles} />
    </div>
  );
}
