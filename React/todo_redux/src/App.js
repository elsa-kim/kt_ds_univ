// import TodoApp from "./components/todo/TodoApp.js";
import RouterAppProvider from "./routers/router.js";
// import ReduxProvider from "./stores/redux/store";
// import ToolkitProvider from "./stores/toolkit/store.js";

function App() {
  console.log("Run App");

  // return (
  //   <ReduxProvider>
  //     <TodoApp />
  //   </ReduxProvider>
  // );

  // return (
  //   <ToolkitProvider>
  //     <TodoApp />
  //   </ToolkitProvider>
  // );

  return <RouterAppProvider />;
}

export default App;
