<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/_include.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <title>회원정보</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
	  $(document).ready(function(){
	  	if(${!empty msgType}){
	   		$("#messageType").attr("class", "modal-content panel-warning");    
	  		$("#myMessage").modal("show");
	  	}
	  });
	  
	  function setUpdate(){
		  if(confirm("수정하시겠습니까?")){
			  document.frm.submit();
		  }
	  }
	  
	  function setDelete(){
		  if(confirm("삭제하시겠습니까?")){
			  location.href="${contextPath}/memberDelete.do";
		  }
	  }
	  
    
  </script>
</head>
<body>
<div class="container">
  <jsp:include page="../common/header.jsp"/>
  <div class="panel panel-default">
    <div class="panel-heading">회원가입</div>
    <div class="panel-body">
    
    <!-- 	회원가입 폼 		-->
    
      <form name="frm" action="${contextPath}/memberUpdate.do" method="post">
        
         <table class="table table-bordered" style="text-align: center; border: 1px solid #eeeeee;">
           <tr>
             <td style="width: 110px; vertical-align: middle;">아이디</td>
             <td><input id="member_id" name="member_id" value="${memberDTO.member_id}"class="form-control" type="text" maxlength="20" placeholder="" readonly/></td>
           </tr>
           <tr>
             <td style="width: 110px; vertical-align: middle;">이름</td>
             <td ><input id="member_name" name="member_name" class="form-control" type="text" maxlength="20" value="${memberDTO.member_name }" placeholder="이름을 입력하세요."/></td>            
           </tr>
           <tr>
             <td style="width: 110px; vertical-align: middle;">이메일</td>
             <td><input id="member_email" name="member_email" class="form-control" type="text" maxlength="50" value="${memberDTO.member_email}" placeholder="이메일을 입력하세요."/></td>            
           </tr>
           <tr>
             <td colspan="2" style="text-align: left;">
                </span><button type="button" class="btn btn-primary btn-sm pull-right" onclick="setDelete()">탈퇴</button>
             	</span><button type="button" class="btn btn-primary btn-sm pull-right" onclick="setUpdate()">수정</button>
             </td>             
           </tr>
         </table>   
      </form>    
    </div>
    
    <!-- 실패 메세지를 출력(modal) -->
	<div id="myMessage" class="modal fade" role="dialog" >
	  <div class="modal-dialog">	
	    <!-- Modal content-->
	    <div id="messageType" class="modal-content panel-info">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">${msgType}</h4>
	      </div>
	      <div class="modal-body">
	        <p>${msg}</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>	
	  </div>
	</div>  
    
    <div class="panel-footer"></div>
  </div>
</div>
</body>
</html>