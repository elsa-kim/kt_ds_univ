export function Table({ contentArray }) {
  return (
    <table>
      <thead>
        <tr>
          <th style={{ width: "60%" }}>Name</th>
          <th>Age</th>
        </tr>
      </thead>
      <tbody>
        {contentArray.map((item, idx) => (
          <tr key={idx}>
            <td>{item.name}</td>
            <td>{item.age}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}
