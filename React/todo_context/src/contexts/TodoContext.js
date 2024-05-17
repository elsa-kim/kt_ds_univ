import { createContext, useReducer } from "react";
import { todoReducers } from "../reducers/todoReducers";

/**
 * Context Store 생성
 * TodoContext를 이용할 때, 자동완성(Content Assist)을 이용하기 위해서
 * Store의 원형을 작성
 */
const TodoContext = createContext({
  todo: [],
  done: (event) => {},
  add: (task, dueDate) => {},
});

export default TodoContext;

/**
 * Context Store의 내용을 제공하기 위해서
 * ContextProvider Component를 생성
 */
export function TodoContextProvider({ children }) {
  // const [todo, setTodo] = useState([]);
  const [todoState, todoDispatcher] = useReducer(todoReducers, []);

  // Provider가 관리할 State와 함수들을 작성
  const contextValue = {
    todo: todoState,
    done(event) {
      const checkbox = event.currentTarget;
      const id = parseInt(checkbox.value);

      // state [] 항목 중 하나만 바뀌면 메모리 주소는 동일해서 react가 모름 => 레퍼런스 타입은 메모리 주소를 바꿔줘야 함(성능상 이유)
      // setTodo((prev) =>
      //   prev.map((todo) => {
      //     if (todo.id === id) {
      //       todo.isDone = checkbox.checked;
      //     }
      //     // 새로운 메모리에 들어있는 객체 리터럴로 반환
      //     return { ...todo };
      //   })
      // );
      todoDispatcher({
        type: "DONE",
        payload: { id, isDone: checkbox.checked },
      });
    },
    add: (task, dueDate) => {
      todoDispatcher({ type: "ADD", payload: { task, dueDate } });
      // setTodo((prevTodos) => [
      //   ...prevTodos,
      //   {
      //     id: prevTodos.length,
      //     task,
      //     dueDate,
      //     isDone: false,
      //   },
      // ]);
    },
  };

  return (
    <TodoContext.Provider value={contextValue}>{children}</TodoContext.Provider>
  );
}
