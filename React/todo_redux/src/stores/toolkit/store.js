import { configureStore, createSlice } from "@reduxjs/toolkit";
import { Provider } from "react-redux";

// 1. Slice Store 생성
//      "todo" Slice store 생성
const todoSliceStore = createSlice({
  // slice store의 이름
  name: "todo slice", // target: "todo slice"
  // slice store의 초기 state 값
  initialState: [],
  // slice store reducer 생성
  reducers: {
    load(state, action) {
      if (state.length === 0) {
        state.push(...action.payload);
      }
    },
    add(state, action) {
      console.log("todo > add: ", action);
      const payload = action.payload;
      state.push({
        id: payload.id,
        isDone: false,
        task: payload.task,
        dueDate: payload.dueDate,
      });
    },
    done(state, action) {
      const payload = action.payload;
      // payload: {id:2, isDone:true}
      /* state: [
       *    {id:0, isDone:false, task:"ABC1", dueDate: "2024-05-23"},
       *    {id:1, isDone:false, task:"ABC2", dueDate: "2024-05-24"},
       *    {id:2, isDone:false, task:"ABC3", dueDate: "2024-05-25"},
       *    {id:3, isDone:false, task:"ABC4", dueDate: "2024-05-26"},
       * ]
       */

      // state에서 id가 2인 객체 리터럴의 인덱스값을 알아야한다.
      //    const index = state.findIndex(조건함수);
      //    const index = state.findIndex(아이템 => 아이템.id === payload.id);
      // 만약, 인덱스값이 2라면,
      // state[2].isDone = payload.isDone;

      const { id, isDone } = payload;
      const index = state.findIndex((item) => item.id === id);
      state[index].isDone = isDone;
    },
    addSubTodo(state, action) {
      // todo state의 구조
      /**
       * todo: [
       *  {id, task, dueDate, isDone, sub: [
       *      {id, task, dueDate, isDone},
       *      {id, task, dueDate, isDone},
       *      {id, task, dueDate, isDone},
       *  ]}, // sub 있을 경우
       *  {id, task, dueDate, isDone},  // sub 없을 경우
       *  {id, task, dueDate, isDone},
       *  {id, task, dueDate, isDone},
       * ]
       */
      const { parentTodoId, id, task, dueDate } = action.payload;
      // 1. parentTodoId와 todo의 id가 같은 객체 리터럴의 인덱스를 찾는다.
      const index = state.findIndex((todo) => todo.id === parentTodoId);

      // 2. parentTodo Index에 sub 항목이 존재하는지 확인한다.
      if (!state[index].sub) {
        //      sub항목이 존재하지 않는다면, sub 배열을 생성.(firebase는 객체 리터럴로 관리하기 때문에 객체로 생성)
        state[index].sub = {};
      }
      //      sub항목이 존재한다면 sub 항목에 새로운 todo를 추가한다.
      state[index].sub[id] = { id, isDone: false, task, dueDate };
    },
    doneSubTodo(state, action) {
      const { parentTodoId, id, isDone } = action.payload;
      const index = state.findIndex((todo) => todo.id === parentTodoId);
      // const subTodoIndex = state[index].sub.findIndex((todo) => todo.id === id);
      // state[index].sub[subTodoIndex].isDone = isDone;
      state[index].sub[id].isDone = isDone;
    },
  },
});

// 액션 생성자를 이용한 액션 정의
// Thunk => 액션 생성자
export const loadTodo = () => {
  // Firebase에서 Todo 목록을 가져와
  return async (dispatch) => {
    const url = "https://react-todo-d00e1-default-rtdb.firebaseio.com";
    const response = await fetch(`${url}/todo.json`, {
      method: "GET",
    });
    const json = await response.json();

    const todoList = [];
    for (let key in json) {
      todoList.push(json[key]);
    }
    // todoSliceStore에 저장한다.
    dispatch(todoActions.load(todoList));
  };
};
export const addTodo = (newTodoItem) => {
  // 사용자가 생성한 새로운 todo 항목을
  return async (dispatch) => {
    // // dispatch? addTodo에서 사용되는 todoDispatch가 전달됨
    // todoSliceStore에 저장하고
    dispatch(todoActions.add(newTodoItem));
    // firebase에도 저장한다.
    const url = "https://react-todo-d00e1-default-rtdb.firebaseio.com";
    await fetch(`${url}/todo/${newTodoItem.id}.json`, {
      method: "PUT",
      body: JSON.stringify(newTodoItem),
    });
    // const json = await response.json();
  };
};
export const doneTodo = (doneTodoItem) => {
  // 사용자가 완료한 todo 항목을
  return async (dispatch) => {
    // todoSliceStore에 저장하고
    dispatch(todoActions.done(doneTodoItem));
    // firebase에도 저장한다.
    const url = "https://react-todo-d00e1-default-rtdb.firebaseio.com";
    await fetch(`${url}/todo/${doneTodoItem.id}.json`, {
      method: "PUT",
      body: JSON.stringify(doneTodoItem),
    });
    // const json = await response.json();
  };
};

export const addSubTodo = (addSubTodoItem) => {
  return async (dispatch) => {
    dispatch(todoActions.addSubTodo(addSubTodoItem));

    // firebase에도 저장한다.
    const url = "https://react-todo-d00e1-default-rtdb.firebaseio.com";
    await fetch(
      `${url}/todo/${addSubTodoItem.parentTodoId}/sub/${addSubTodoItem.id}.json`,
      {
        method: "PUT",
        body: JSON.stringify(addSubTodoItem),
      }
    );
  };
};
export const doneSubTodo = (doneSubTodoItem) => {
  return async (dispatch) => {
    dispatch(todoActions.doneSubTodo(doneSubTodoItem));
    // firebase에도 저장한다.
    const url = "https://react-todo-d00e1-default-rtdb.firebaseio.com";
    await fetch(
      `${url}/todo/${doneSubTodoItem.parentTodoId}/sub/${doneSubTodoItem.id}.json`,
      {
        method: "PUT",
        body: JSON.stringify(doneSubTodoItem),
      }
    );
  };
};

// 2. Redux Store 생성
const toolkitStore = configureStore({
  reducer: {
    todo: todoSliceStore.reducer,
  },
});

// 3. Slice Store Actions 공유
export const todoActions = todoSliceStore.actions;

// 4. Provider Component 생성
export default function ToolkitProvider({ children }) {
  return <Provider store={toolkitStore}>{children}</Provider>;
}
