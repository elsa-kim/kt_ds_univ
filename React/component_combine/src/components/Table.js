export default function Grid({ cols, bodys }) {
  return (
    <Table>
      <Table.Header>
        {cols.map((title, idx) => (
          <th key={idx}>{title}</th>
        ))}
      </Table.Header>
      <Table.Body>
        {bodys.map((row, idx) => (
          <tr key={idx}>
            {row.map((cell, index) => (
              <td key={index}>{cell}</td>
            ))}
          </tr>
        ))}
      </Table.Body>
    </Table>
  );
}

function Table({ children }) {
  return <table>{children}</table>;
}

Table.Header = THead;
Table.Body = TBody;

function THead({ children }) {
  return (
    <thead>
      <tr>{children}</tr>
    </thead>
  );
}

function TBody({ children }) {
  return <tbody>{children}</tbody>;
}
