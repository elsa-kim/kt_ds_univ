import { useCallback, useEffect, useMemo, useState } from "react";
import WriteBoardForm from "./WriteBoardForm";
import { deleteOneBoard, getOneBoard } from "../../http/http";
import { useFetch } from "../../hooks/useFetch";

export default function BoardView({
  setSelectedBoardId,
  selectedBoardId,
  token,
  setNeedReload,
  user,
  isModifyMode,
  setIsModifyMode,
  needReload,
}) {
  const onModifyClickHandler = () => {
    setIsModifyMode(true);
  };
  const onDeleteClickHandler = async () => {
    const json = await deleteOneBoard(selectedBoardId, token);
    if (json.body) {
      // 삭제 성공!
      // 목록 컴포넌트 노출
      setSelectedBoardId(undefined);
      setNeedReload(Math.random());
    } else {
      // 삭제 실패!
      // 실패한 사유를 알려줘야한다.
      console.log(json);
      alert(json.errors);
    }
  };

  const onBackListClickHandler = () => {
    setSelectedBoardId(undefined);
  };

  const fetchGetOneBoard = useCallback(getOneBoard, []);
  const fetchParam = useMemo(() => {
    return { selectedBoardId, token };
  }, [selectedBoardId, token]);

  const { data, isLoading } = useFetch(undefined, fetchGetOneBoard, fetchParam);
  const { body: board } = data || {};

  return (
    <>
      {!isModifyMode ? (
        <>
          {board && (
            <div>
              <div>게시글 번호: {board.id}</div>
              <div>게시글 제목: {board.subject}</div>
              <div>작성자: {board.memberVO.name}</div>
              {board.originFileName && (
                <div>첨부파일: {board.originFileName}</div>
              )}
              <div>조회수: {board.viewCnt}</div>
              <div>등록일: {board.crtDt}</div>
              {board.mdfyDt && <div>수정일: {board.mdfyDt}</div>}
              <div>게시글 내용: {board.content}</div>
            </div>
          )}
          {isLoading && <div>데이터를 불러오는 중입니다..</div>}
          <div className="button-area right-align">
            {user &&
              board &&
              (user.email === board.email || user.adminYn === "Y") && (
                <>
                  <button onClick={onModifyClickHandler}>수정</button>
                  <button onClick={onDeleteClickHandler}>삭제</button>
                </>
              )}
            <button onClick={onBackListClickHandler}>목록보기</button>
          </div>
        </>
      ) : (
        <>
          <WriteBoardForm
            setIsModifyMode={setIsModifyMode}
            token={token}
            board={board}
            setNeedReload={setNeedReload}
          />
        </>
      )}
    </>
  );
}
