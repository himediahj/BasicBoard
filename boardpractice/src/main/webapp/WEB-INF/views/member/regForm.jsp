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

    <style>
        .id_ok{
            color:dodgerblue;
            display: none;
        }

        .id_already{
            color: red;
            display: none;
        }
    </style>

</head>
<body class="bg-light">
<main role="main" class="container" style="margin-top: 100px; width:690px">

<form class="card p-2" method="post">
  <div class="col-md-7 col-lg-8">
    <h4 class="mb-3">회원가입</h4>
    <div class="col-sm-12">
      <label for="uid">아이디</label>
      <input type="text" class="form-control" id="uid" name="uid" oninput="checkId()" value="${regData.uid}">
      ${valid_uid}
        <span class="id_ok">사용 가능한 아이디입니다.</span>
        <span class="id_already">이미 가입되어있는 아이디입니다.</span>
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
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
    function checkId(){
        var uid = $('#uid').val()
        $.ajax({
            url:'idCheck',
            type:'post',
            data:{uid:uid}, // 보낼 데이터
            success:function(cnt){  // 컨트롤러에서 넘어온 cnt값을 받는다
                if(cnt == 0){
                    $('.id_ok').css("display", "inline-block")
                    $('.id_already').css("display", "none")
                } else{
                    $('.id_already').css("display", "inline-block")
                    $('.id_ok').css("display", "none")
                    alert("아이디를 다시 입력해주세요")
                    $('#uid').val('')
                }
            }, error:function (error){console.log(error)}
        })
    }
</script>
</body>
</html>
