import Stand from "./Stand";

export default function Grid() {
  const styles = {
    display: "grid",
    gridTemplateColumns: "repeat(6, 131.3px)",
    gridTemplateRows: "repeat(4, 56px)",
  };
  let standArray = [];
  for (let i = 0; i < 24; i++) {
    standArray[i] = `/assets/${i + 1}.png`;
  }
  return (
    <div style={styles}>
      {standArray.map((item, idx) => (
        <Stand item={item} key={idx}></Stand>
      ))}
    </div>
  );
}
