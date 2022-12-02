<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-12-01
  Time: 오후 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <a class="navbar-brand mr-auto mr-lg-0" href="/index">Board List</a>
</nav>
<main role="main" class="container">
  <div class="my-3 p-3" style="float: right"><button type="button" class="btn btn-primary" onclick="location.href='/board/register'">게시물 등록</button> </div>
<table class="table table-striped">
  <thead class="thead-dark">
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>작성일</th>
    <th>수정일</th>
  </tr>
  </thead>
  <c:forEach var="board" items="${page.list}" varStatus="status">
    <tr>
      <th>${(page.totalCountOfArticle - (page.pageNum-1)*10) - status.index}</th>
      <td><a href="/board/read?bno=${board.bno}">${board.title}</a></td>
      <td>${board.writer}</td>
      <td>${board.regdate}</td>
      <td>${board.updatedate}</td>
    </tr>
  </c:forEach>
</table>

<!-- 페이지 처리 -->
<ul class="pagination"> <!-- 부트스트랩 기능 -->
  <c:forEach var="num" begin="1" end="${page.totalCountOfPage}">
    <li><a class="page-link" href="?pageNum=${num}">${num}</a></li> <!-- page-link하니까 네모상자 생김 -->
  </c:forEach>
</ul>
</main>
</body>
</html>
