<%-- <%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String email = CmmUtil.nvl((String)session.getAttribute("email")); //세션에 저장된 id값을 새 변수에 저장
	String nick = CmmUtil.nvl((String)session.getAttribute("nick")); //세션에 저장된 name값을 새 변수에 저장
%>
<script type="text/javascript">
	function logout() {
		location.href="/user/logout.do";
	}
</script>
<div align="right">
	<%if(!"".equals(id)) {%>
		<!-- 로그인 된 상태 -->
		<b><%=id + "님 환영합니다." %></b>
		<b><button onclick="logout();">로그아웃</button></b>
	<%}
	else
	{%>
		<!-- 로그인 안 된 상태 -->
		<form action="/user/loginProc.do" method="post">
			<b>ID</b> 
			<input type="text" name="id" /> 
			<b>Password</b>
			<input type="password" name="password" /> 
			<input type="submit" value="로그인" />
		</form>
	<%} %>
</div>

 --%>