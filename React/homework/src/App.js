import { useState } from "react";
import { Input } from "./components/Input";
import { Table } from "./components/Table";

function App() {
  const [contentArray, setContentArray] = useState([]);
  return (
    <div className="container">
      <Input setContentArray={setContentArray} />
      <Table contentArray={contentArray} />
    </div>
  );
}

export default App;
