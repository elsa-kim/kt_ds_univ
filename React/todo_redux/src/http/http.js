export const loadMyData = async ({ token }) => {
  const response = await fetch("http://localhost:8080/api/v1/member", {
    method: "GET",
    headers: { Authorization: token },
  });

  const json = await response.json();
  return json;
};

export const login = async (email, password) => {
  const response = await fetch("http://localhost:8080/auth/token", {
    method: "POST",
    body: JSON.stringify({ email, password }),
    headers: { "Content-Type": "application/json" },
  });

  const json = await response.json();
  return json;
};

export const getBoards = async ({ token, pageNo = 0 }) => {
  if (!token) {
    return undefined;
  }
  const response = await fetch(
    `http://localhost:8080/api/v1/boards?pageNo=${pageNo}`,
    {
      method: "GET",
      // get방식은 body없고, json 보낼거없음 => header 사용이유 : 인증
      headers: {
        Authorization: token,
      },
    }
  );

  const json = await response.json();
  return json;
};

export const createBoard = async (token, subject, content, file) => {
  // 파일 업로드를 위해 formData 생성
  const formData = new FormData(); // JavaScript built-in 객체
  formData.append("subject", subject);
  formData.append("content", content);
  formData.append("file", file);

  const response = await fetch("http://localhost:8080/api/v1/boards", {
    method: "POST",
    headers: {
      Authorization: token,
    },
    body: formData,
  });
  const json = await response.json();
  return json;
};

export const modifyBoard = async (board, token, subject, content, file) => {
  const formData = new FormData();
  formData.append("subject", subject);
  formData.append("content", content);
  formData.append("file", file);

  const response = await fetch(
    `http://localhost:8080/api/v1/boards/${board.id}`,
    {
      method: "PUT",
      headers: {
        Authorization: token,
      },
      body: formData,
    }
  );

  const json = await response.json();
  return json;
};

export const getOneBoard = async ({ selectedBoardId, token }) => {
  const response = await fetch(
    `http://localhost:8080/api/v1/boards/${selectedBoardId}`,
    { method: "GET", headers: { Authorization: token } }
  );
  const json = await response.json();
  return json;
};

export const deleteOneBoard = async (selectedBoardId, token) => {
  const response = await fetch(
    `http://localhost:8080/api/v1/boards/${selectedBoardId}`,
    {
      method: "DELETE",
      headers: { Authorization: token },
    }
  );

  const json = await response.json();
  return json;
};
