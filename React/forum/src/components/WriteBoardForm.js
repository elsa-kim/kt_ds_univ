import { useRef } from "react";
import { createBoard, modifyBoard } from "../http/http";

export default function WriteBoardForm({
  setIsWriteMode,
  token,
  setNeedReload,
  create,
  setIsModifyMode,
  board,
}) {
  const subjectRef = useRef();
  const fileRef = useRef();
  const contentRef = useRef();

  //   if (!create && board) {
  //     subjectRef.current.value = ;
  //   }

  const onCancelClickHandler = () => {
    create ? setIsWriteMode(false) : setIsModifyMode(false);
  };

  const onSaveClickHandler = async () => {
    const subject = subjectRef.current.value;
    const content = contentRef.current.value;
    const file = fileRef.current.files[0];

    const json = await createBoard(token, subject, content, file);
    console.log(json);

    if (json.errors) {
      json.errors.forEach((error) => {
        alert(error);
      });
    } else if (json.body) {
      setIsWriteMode(false);
      setNeedReload(Math.random());
    }
  };
  const onModifySaveClickHandler = async () => {
    const subject = subjectRef.current.value;
    const content = contentRef.current.value;
    const file = fileRef.current.files[0];

    const json = await modifyBoard(board, token, subject, content, file);
    console.log(json);
    if (json.errors) {
      json.errors.forEach((error) => {
        alert(error);
      });
    } else if (json.body) {
      setIsModifyMode(false);
      setNeedReload(Math.random());
    }
  };

  return (
    <div>
      <div>
        <label htmlFor="subject">제목</label>
        <input
          type="text"
          id="subject"
          ref={subjectRef}
          defaultValue={!create ? board.subject : ""}
        />
      </div>
      <div>
        <label htmlFor="file">첨부파일</label>
        <input type="file" id="file" ref={fileRef} />
        {!create && <span> 현재 업로드 된 파일 : {board.originFileName}</span>}
      </div>
      <div>
        <label htmlFor="content">내용</label>
        <textarea
          id="content"
          ref={contentRef}
          defaultValue={!create ? board.content : ""}
        ></textarea>
      </div>
      <div className="button-area right-align">
        <button onClick={onCancelClickHandler}>취소</button>
        {create ? (
          <button onClick={onSaveClickHandler}>등록</button>
        ) : (
          <button onClick={onModifySaveClickHandler}>수정</button>
        )}
      </div>
    </div>
  );
}
