<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-12-02
  Time: 오전 10:26
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
  <a class="navbar-brand mr-auto mr-lg-0">Board Read</a>
</nav>
<main role="main" class="container">
  <div class="my-3 p-3 bg-white rounded box-shadow" >
<div class="border-bottom border-gray pb-2 mb-0">
  <div>
    <label>Bno</label>
    <input type="text" name="bno" value="${board.bno}" readonly>
  </div>
  <div>
    <label>Title</label>
    <input type="text" name="title" value="${board.title}" readonly>
  </div>
  <div>
    <label>Writer</label>
    <input type="text" name="writer" value="${board.writer}" readonly>
  </div>
  <div>
    <label>Text area</label><br>
    <textarea name="content" rows="10" cols="60" readonly>${board.content}</textarea>
  </div >
  <div class="my-3">
    <button type="button" class="btn btn-outline-secondary" onclick="location.href='/board/list'">목록</button>
    <button type="button" class="btn btn-outline-primary" onclick="location.href='/board/modify?bno=${param.bno}'">수정</button>
      <button type="button" class="btn btn-outline-danger" onclick="deleteBoard(${param.bno})">삭제</button>
  </div>
</div>
  </div>

  <div class="my-3 p-3 bg-white rounded box-shadow">
    <h6 class="border-bottom border-gray pb-2 mb-0"><strong>댓글</strong></h6>
<div class="my-3">
<label>내용</label>
  <textarea id="reply" placeholder="댓글을 입력하세요." rows="1" cols="60"></textarea>
  &nbsp&nbsp&nbsp&nbsp&nbsp   <%--nonbreakingspace--%>
<label>작성자</label>
  <input type="text" id="replyer" placeholder="댓글 작성자 이름">&nbsp
  <input type="submit" value="등록" id="btn_reply">
</div>
<div>
  <table>
    <tbody id="replyList"></tbody>
  </table>
</div>

  </div>
</main>
<script>
  function deleteBoard(bno){
    if(confirm("삭제하시겠습니까?")){
      location.href='/board/remove?bno='+bno;
    }
  }
</script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
  let replyList;
  document.addEventListener('DOMContentLoaded', ()=>{
    replyList = document.querySelector('#replyList')

    // 비동기 통신 : 댓글 리스트 가져오기
    axios.get('/replies')
            .then(res=>{
              console.log('res', res.data)
              addReplyRow(res.data)
            }).catch(err => console.log(err))

    //////////////////////////
    btn_reply.addEventListener('click', ()=>{
      const payload = {
        bno : ${param.bno},
        reply : document.querySelector("#reply").value,
        replyer : document.querySelector("#replyer").value
      }
      console.log(payload)

      // 비동기 통신 : 댓글 등록
      axios.post('/replies', payload)
              .then(res => {
                console.log('res', res.data)
                const newReply = res.data

                const newTR = document.createElement('tr')
                let str=''
                str += '<td class="col-2">'+newReply.replyer+'</td>'
                str += '<td>'+newReply.reply+'</td>'
                str += '<td>'+newReply.replyDate+'</td>'
                newTR.innerHTML = str
                newTR.setAttribute('class', 'fs-6 text-center')
                newTR.setAttribute('tr-index', newReply.rno)
                replyList.appendChild(newTR)

                document.querySelector("#reply").value=''
                document.querySelector("#replyer").value=''
              }).catch(err => console.log(err))
    })
  })

  let i = 1
  function addReplyRow(list){
    console.log(list)
    list.forEach((reply, index) => {
      const newTR = document.createElement('tr')
      let str = '<td>'+ i++ +'</td>'
      /*let str = '<td>'+reply.rno+'</td>'*/
      str += '<td>'+reply.reply+'</td>'
      str += '<td class="col-2">'+reply.replyer+'</td>'
      str += '<td class="col-2">'+reply.replyDate+'</td>'
      str += '<td class="col-2">'+'<a href="javascript: delTR('+reply.rno+')">x</a>'+'</td>'
      newTR.innerHTML = str
      newTR.setAttribute('class', 'fs-6 text-center')
      newTR.setAttribute('tr-index', reply.rno)
      replyList.appendChild(newTR)

    })
  }

  function delTR(index){
    console.log('index', index)

    if(!confirm('댓글을 삭제하시겠습니까?')){
      return;
    }

    // 비동기 통신 : 데이터 삭제
    axios.delete('/replies/'+index)
            .then(res => {
              console.log('res', res.data)
              // 화면에서 행 삭제
              const delTR = document.querySelector('tr[tr-index="'+index+'"]')
              replyList.removeChild(delTR)
            })
            .catch(err => console.log(err))
  }
</script>
</body>
</html>
