import { useCallback, useMemo, useState } from "react";
import BoardView from "./BoardView";
import WriteBoardForm from "./WriteBoardForm";
import { getBoards } from "../../http/http";
import { useFetch } from "../../hooks/useFetch";

let pageNo = 0;

export default function BoardApp({ token, user }) {
  const [selectedBoardId, setSelectedBoardId] = useState();
  const [isWriteMode, setIsWriteMode] = useState(false);
  const [isModifyMode, setIsModifyMode] = useState(false);
  const [needReload, setNeedReload] = useState();
  const isSelect = selectedBoardId !== undefined;

  const onRowClickHandler = (rowId) => {
    // tr 반복되므로 ref 줄 수 없음
    setSelectedBoardId(rowId);
  };

  const onLoadMoreClickHandler = async () => {
    const json = await getBoards({ token, pageNo: ++pageNo });
    setData((prev) => ({
      ...prev,
      next: json.next,
      pages: json.pages,
      errors: json.errors,
      count: json.count,
      body: [...prev.body, ...json.body],
    }));
  };

  const onWriteModeClickHandler = () => {
    setIsWriteMode(true);
  };

  const getFetchBoards = useCallback(getBoards, []);
  const fetchParam = useMemo(() => {
    return { token, needReload };
  }, [token, needReload]);

  // const [boards, setBoards] = useState([]);
  const { data, setData } = useFetch(undefined, getFetchBoards, fetchParam);
  const { count, pages, next } = data || {};
  const { body: boards } = data || {};

  return (
    <>
      {token && !isSelect && !isWriteMode && (
        <>
          <div>총 {count}개의 게시글이 검색되었습니다.</div>
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
              {boards &&
                boards.map((boardItem) => (
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
        </>
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
          {next && <button onClick={onLoadMoreClickHandler}>더보기</button>}
          <button onClick={onWriteModeClickHandler}>게시글 등록</button>
        </div>
      )}
    </>
  );
}
