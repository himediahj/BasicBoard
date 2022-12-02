<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-12-02
  Time: 오후 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h4 class="mb-3">회원가입</h4>
    <div class="col-sm-12">
      <label for="uid">아이디</label>
      <input type="text" class="form-control" id="uid" name="uid" value="${regData.uid}">
      ${valid_uid}
    </div>
<br>
    <div class="col-sm-12">
      <label for="pw">비밀번호</label>
      <input type="password" class="form-control" id="pw" name="pw" value="${regData.pw}">
      ${valid_pw}
    </div>
<br>
    <div class="col-sm-6">
      <label>이름</label>
      <input type="text" class="form-control" name="uname" value="${regData.uname}">
      ${valid_uname}
    </div>


  </div>
  <hr class="my-4">
      <input type="submit" value="회원가입">
<br>
</form>
</main>
</body>
</html>
