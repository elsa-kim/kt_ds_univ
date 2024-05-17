export default function Header() {
  const styles = {
    display: "flex",
    gap: "10px",
  };
  return (
    <div style={styles} className="header-container">
      <p>뉴스스탠드</p>
      <p>언론사편집</p>
      <p>엔터</p>
      <p>스포츠</p>
      <p>경제</p>
      <p>쇼핑투데이</p>
    </div>
  );
}
