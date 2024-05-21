import { useEffect, useState } from "react";
import BoardView from "./BoardView";
import WriteBoardForm from "./WriteBoardForm";

export default function BoardApp({ token, user }) {
  const [boards, setBoards] = useState([]);
  const [selectedBoardId, setSelectedBoardId] = useState();
  const [isWriteMode, setIsWriteMode] = useState(false);
  const [isModifyMode, setIsModifyMode] = useState(false);
  const [needReload, setNeedReload] = useState();
  const isSelect = selectedBoardId !== undefined;

  const onRowClickHandler = (rowId) => {
    // tr 반복되므로 ref 줄 수 없음
    setSelectedBoardId(rowId);
  };

  const onWriteModeClickHandler = () => {
    setIsWriteMode(true);
  };

  useEffect(() => {
    // 게시글 불러오기
    const loadBoards = async () => {
      if (!token) {
        setBoards([]);
        return;
      }
      const response = await fetch("http://localhost:8080/api/v1/boards", {
        method: "GET",
        // get방식은 body없고, json 보낼거없음 => header 사용이유 : 인증
        headers: {
          Authorization: token,
        },
      });

      const json = await response.json();
      console.log(json);

      setBoards(json.body);
    };
    loadBoards();
  }, [token, needReload]);

  return (
    <>
      {token && !isSelect && !isWriteMode && (
        <table>
          <thead>
            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>조회수</th>
              <th>작성일</th>
            </tr>
          </thead>
          <tbody>
            {boards.map((boardItem) => (
              <tr
                key={boardItem.id}
                onClick={() => onRowClickHandler(boardItem.id)}
              >
                <td>{boardItem.id}</td>
                <td>{boardItem.subject}</td>
                <td>{boardItem.memberVO.name}</td>
                <td>{boardItem.viewCnt}</td>
                <td>{boardItem.crtDt}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
      {token && isSelect && !isWriteMode && (
        <BoardView
          selectedBoardId={selectedBoardId}
          setSelectedBoardId={setSelectedBoardId}
          token={token}
          setNeedReload={setNeedReload}
          user={user}
          isModifyMode={isModifyMode}
          setIsModifyMode={setIsModifyMode}
          needReload={needReload}
        />
      )}
      {isWriteMode && (
        <WriteBoardForm
          setIsWriteMode={setIsWriteMode}
          token={token}
          setNeedReload={setNeedReload}
          create
        />
      )}
      {!token && <div>로그인이 필요합니다.</div>}
      {token && !isWriteMode && !isModifyMode && (
        <div className="button-area right-align">
          <button onClick={onWriteModeClickHandler}>게시글 등록</button>
        </div>
      )}
    </>
  );
}
