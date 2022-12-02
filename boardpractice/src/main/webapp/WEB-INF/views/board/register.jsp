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
</head>
<body>
<form method="post">
  <table>

    <tr>
      <td><label>Title</label></td>
      <td><input type="text" name="title"></td>
    </tr>
    <tr>
      <td><label>Text area</label></td>
      <td><textarea name="content"></textarea></td>
    </tr>
    <tr>
      <td><label>Writer</label></td>
      <td><input type="text" name="writer"></td>
    </tr>
    <tr>
      <td><input type="reset" value="초기화"></td>
      <td><input type="submit" value="등록"></td>
    </tr>
  </table>
</form>
</body>
</html>
