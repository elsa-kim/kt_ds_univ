export default function Stand({ item }) {
  const styles = {
    backgroundImage: `url( ${item} )`,
    width: "130px",
    height: "56px",
    backgroundSize: "auto 20px",
    backgroundPosition: "center",
    backgroundRepeat: "no-repeat",
  };
  return (
    <div style={styles} className="stand">
      <div className="inner">
        <ul className="stand-list">
          <li>구독</li>
          <li>기사보기</li>
        </ul>
      </div>
    </div>
  );
}
