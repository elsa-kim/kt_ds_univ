<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
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
<script type="text/javascript" src="/js/boardwrite.js"></script>
</head>
<body>
	<!-- dialog 원래 숨어있음 => 나오게 해야 나옴 -->
	<c:if test="${not empty errorMassage}">
	    <dialog class="alert-dialog">
	        <h1>${errorMassage}</h1>
	    </dialog>
    </c:if>

    <jsp:include page="../layout/layout.jsp" />
    
    <h1>게시글 작성</h1>
    <form action="/board/write" method="post" enctype="multipart/form-data">
    	<sec:csrfInput/>
        <div class="grid">
            <label for="subject">제목</label>
            <input id="subject" type="text" name="subject" value="${boardVO.subject}"/>

            <label for="file">첨부파일</label>
            <input type="file" name="file" id="file">

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