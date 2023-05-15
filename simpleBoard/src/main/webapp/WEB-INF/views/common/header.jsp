<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@include file="_include.jsp" %>
    
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="${contextPath}">Simple Board</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
    <ul class="nav navbar-nav">
      <li><a href="${contextPath}">홈</a></li>
      <li><a href="${contextPath}/boardList.do">게시판</a></li>
      <li>${prevContextPath }</li>
    </ul>
  
    <c:if test="${empty member}">
	      <ul class="nav navbar-nav navbar-right">
	            <li><a href="${contextPath}/memberLoginForm.do"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
	            <li><a href="${contextPath}/memberRegisterForm.do"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>            
	      </ul>
      </c:if>
      <c:if test="${!empty member}">
	      <ul class="nav navbar-nav navbar-right">
	            <li><a style="pointer-events: none;">${member.member_id}님 환영합니다!</a></li>
	            <li><a href="${contextPath}/memberUpdateForm.do"><span class="glyphicon glyphicon-user"></span> 회원정보</a></li>
	            <li><a href="${contextPath}/memberLogout.do"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>            
	      </ul>
      </c:if>
      </div>
  </div>
</nav>