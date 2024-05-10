<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<jsp:include page="../commonheader.jsp"></jsp:include>
<style type="text/css">
    div.grid{
        display: grid;
        grid-template-columns: 120px 1fr;
        grid-template-rows: 28px 28px 1fr;
        row-gap: 10px;
    }

    .error{
        grid-column: 1/-1;
        color: #f00;
        padding-left: 1rem;
        margin: 0;
    }
    .login{
        cursor: pointer;
        border-radius: 5px;
        text-align: center;
        padding: 5px 10px;
        font-weight: bold;
        margin: 5px;
        font-size: 16px;
        border: 1px solid rgb(192, 175, 230);
        background-color: rgb(192, 175, 230);
        color: white;
    }
    .login:hover{
        background-color: rgb(168, 154, 202);
    }
    .naver{
        border: 1px solid #03c75a;
        background-color: #03c75a;
    }
    .naver:hover{
        background-color: #17b75e;
    }
    .google{
        border: 1px solid #90a9fc;
        background-color: #90a9fc;
    }
    .google:hover{
        background-color: #7d93db;
    }
    .github{
        border: 1px solid #1f883d;
        background-color: #1f883d;
    }
    .github:hover{
        background-color: #1b7535;
    }
</style>
<script type="text/javascript" src="/js/memberregist.js"></script>
</head>
<body>
    <h1>로그인</h1>

    <div>${message}</div>
    
    <form id="loginForm">
        <sec:csrfInput />
        <input type="hidden" name="next" id="next" value="${nextUrl}" />
        <div class="grid">
            <label for="email">이메일</label>
            <input type="email" name="email" id="email">
           
            <label for="password">비밀번호</label>
            <input type="password" name="password" id="password">
            
            <div class="btn-group">
                <div class="right-align">
                    <a class="naver login" href="/oauth2/authorization/naver" style="color: white;">NAVER <span style="font-size: 12px;">로그인</span></a>
                    <a class="github login" href="/oauth2/authorization/github" style="color: white;">Github <span style="font-size: 12px;">로그인</span></a>
                    <a class="google login" href="/oauth2/authorization/google" style="color: white;">Google <span style="font-size: 12px;">로그인</span></a>
                    <button class="login" type="button" id="btn-login">로그인</button>
                </div>
            </div>
        </div>
    </form>
</body>
</html>