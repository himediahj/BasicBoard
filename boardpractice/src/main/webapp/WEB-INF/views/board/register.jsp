<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-12-02
  Time: 오전 10:39
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
  <a class="navbar-brand mr-auto mr-lg-0">Board Register</a>
</nav>
<main role="main" class="container">
  <div class="my-3 p-3 bg-white rounded box-shadow" >
<form method="post">
  <table class="table-striped">

    <tr>
      <td><label>Title</label></td>
      <td><input type="text" name="title"></td>
    </tr>
    <tr>
      <td><label>Text area</label></td>
      <td><textarea name="content" cols="70" rows="10"></textarea></td>
    </tr>
    <tr>
      <td><label>Writer</label></td>
      <td><input type="text" name="writer"></td>
    </tr>
    <div class="p-3">
    <tr>
      <td><input type="reset" value="초기화"></td>
      <td><input type="submit" value="등록"></td>
    </tr>
    </div>
  </table>
</form>
  </div>
</main>
</body>
</html>
