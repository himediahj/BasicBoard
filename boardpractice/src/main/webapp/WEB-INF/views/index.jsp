<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-12-01
  Time: 오후 7:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="card">
    <div class="card-header">
        Home
    </div>
    <div class="card-body">
        <h5 class="card-title">게시판 보기</h5>
        <p class="card-text">로그인 회원만 볼 수 있습니다.</p>
        <a href="/board/list" class="btn btn-primary">Go</a>
    </div>

    <div class="card-body">
        <h5 class="card-title">ㅡ 간단한 게시판 만들기 ㅡ</h5>
        <p class="card-text">기능</p>
        <p class="card-text"><li>회원 가입 / 로그인 </li></p>
        <button type="button" class="btn btn-secondary btn-lg" onclick="location.href='/member/register'">회원가입</button>
        <p class="card-text"><li>Mysql 연동 - 게시판 CRUD </li></p>
        <p class="card-text"><li>게시판 페이지 표시</li></p>
        <p class="card-text"><li>REST 방식 - 댓글 등록 / 삭제</li></p>

    </div>
</div>
</body>
</html>
