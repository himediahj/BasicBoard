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

</head>
<body>
<table>
  <tr>
    <th>#번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>작성일</th>
    <th>수정일</th>
  </tr>
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
<ul class="pagination">
  <c:forEach var="num" begin="1" end="${page.totalCountOfPage}">
    <li><a class="page-link" href="?pageNum=${num}">${num}</a></li>
  </c:forEach>
</ul>
</body>
</html>
