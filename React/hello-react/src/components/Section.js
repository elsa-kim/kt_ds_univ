/**
 * props: {title:"", color:"", onClick:function(){}}
 */
export function Section({ title, color, onClick }) {
  const sectionStyle = {
    backgroundColor: "#ccc",
    color,
  };

  /**
   * Tag 혹은 Component의 Attribute를 작성할 때엔, 아래 규칙을 지켜야 한다.
   *1. Attribute의 값이 문자열이라면 "값"로 작성한다.
    2. Attribute의 값이 문자열이 아니라면 {값} 작성
    2. Attribute의 값이 변수/상수/객체/함수 등 이라면 {변수/상수/객체/함수}로 작성한다.
   */
  return (
    <section style={sectionStyle} onClick={onClick}>
      This is {title} Component.
    </section>
  );
}
