<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-12-02
  Time: 오전 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/bootstrap/offcanvas.css" rel="stylesheet">
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
    <a class="navbar-brand mr-auto mr-lg-0">Board Modify</a>
</nav>
<main role="main" class="container">
    <div>
<form method="post">
    <div class="my-3 p-3 bg-white rounded box-shadow">
<label>Bno</label>
<input type="text" name="bno" value="${board.bno}" readonly></div>

<div class="my-3 p-3 bg-white rounded box-shadow">
<label>Title</label>
<input type="text" name="title" value="${board.title}"></div>
<div class="my-3 p-3 bg-white rounded box-shadow">
            <label>Text area</label><br>
            <textarea name="content" rows="10" cols="60">${board.content}</textarea></div>

     <div class="my-3 p-3 bg-white rounded box-shadow">      <label>Writer</label>
    <input type="text" name="writer" value="${board.writer}"></div>
<div class="my-3 p-3 bg-white rounded box-shadow">
    <input type="submit" value="수정">
<button type="button" onclick="location.href='/board/read?bno=${param.bno}'">취소</button></div>
</form>
    </div>
</main>
</body>
</html>
