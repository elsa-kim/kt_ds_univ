export function Data({ textArray }) {
  return (
    <>
      {/* map 사용 시 key 필수 */}
      {textArray.map((item, idx) => (
        <div key={idx}>{item}</div>
      ))}
    </>
  );
}
