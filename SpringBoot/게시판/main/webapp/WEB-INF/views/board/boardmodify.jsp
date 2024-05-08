<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<jsp:include page="../commonheader.jsp"></jsp:include>
<style type="text/css">
    /* div인데 클래스가 grid인 것(띄어쓰기 없음) */
    div.grid{
        display: grid;
        grid-template-columns: 110px 1fr;
        grid-template-rows: 28px 28px 320px 1fr;
        row-gap: 10px;
    }

</style>
<script type="text/javascript" src="/js/boardmodify.js"></script>
</head>
<body>
	<!-- dialog 원래 숨어있음 => 나오게 해야 나옴 -->
	<c:if test="${not empty errorMassage}">
	    <dialog class="alert-dialog">
	        <h1>${errorMassage}</h1>
	    </dialog>
    </c:if>

    <jsp:include page="../layout/layout.jsp" />
    <h1>게시글 수정</h1>
    <form action="/board/modify/${boardVO.id}" method="post" enctype="multipart/form-data">
        <div class="grid">
            <label for="subject">제목</label>
            <input id="subject" type="text" name="subject" value="${boardVO.subject}"/>

            <label for="file">첨부파일</label>
            <!-- input type="file"의 value는 지정할 수 없다. -->
            <div>
                <input type="file" name="file" id="file">
                현재 업로드 된 파일: ${boardVO.originFileName}
            </div>

            <label for="content">내용</label>
            <textarea name="content" id="content" style="height: 300px;">${boardVO.content}</textarea>

            <div class="btn-group">
                <div class="right-align">
                    <input type="submit" value="저장">
                </div>
            </div>
        </div>
    </form>
    <jsp:include page="../layout/layout_close.jsp" />
</body>
</html>