<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-12-02
  Time: 오후 3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <!-- Bootstrap core CSS -->
  <link href="/css/bootstrap/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">
<main role="main" class="container" style="margin-top: 100px; width:690px">

  <form class="card p-2" method="post">
    <div class="col-md-7 col-lg-8">
      <h4 class="mb-3">로그인</h4>
      <div class="col-sm-12">
        <label for="uid">아이디</label>
        <input type="text" class="form-control" id="uid" name="uid" value="${cookie.reId.value}">
      </div><br>
      <div>
        아이디 저장하기 <input type="checkbox" name="idremember" ${cookie.reId.value ne null? 'checked':''}>
      </div>
      <br>
      <div class="col-sm-12">
        <label for="pw">비밀번호</label>
        <input type="password" class="form-control" id="pw" name="pw">
      </div>
      <br>
      <div>
        로그인 상태 유지하기 <input type="checkbox" name="rememberme">
      </div>
      <br>


    </div>
    <hr class="my-4">
    <input type="submit" value="로그인">
    <br>
  </form>
</main>

</body>
</html>
