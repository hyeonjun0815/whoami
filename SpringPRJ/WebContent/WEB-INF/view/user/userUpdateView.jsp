<%@page import="poly.dto.UserDTO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	UserDTO uDTO = (UserDTO)request.getAttribute("uDTO");
%>
<html>
<head>
<title>WEB!</title>
</head>
<body>
	<table style="height: 100%; width: 100%">
		<tr height="7%" bgcolor="#00D8FF">
			<td><%@include file="/WEB-INF/view/top.jsp" %></td>
		</tr>
		<tr>
			<td>
				<div align="center" style="width:50%;">
					<form action="/user/userUpdateProc.do" method="post">
						<!-- 회원번호를 전송하기 위해 hidden 폼 사용 -->
						<input type="hidden" name="userNo" value="<%=uDTO.getUser_no() %>" />
						아이디: <input type="text" name="id" value="<%=uDTO.getId()%>"/> <br />
						비밀번호: <input type="text" name="password" value="<%=uDTO.getPassword()%>"/> <br />
						이름: <input type="text" name="name" value="<%=uDTO.getName()%>"/> <br />
						나이: <input type="text" name="age" value="<%=uDTO.getAge()%>"/> <br />
						<input type="submit" value="SUBMIT!" />
					</form>
				</div>
			</td>
		</tr>
		<tr height="7%" bgcolor="#00D8FF">
			<td><%@include file="/WEB-INF/view/bottom.jsp" %></td>
		</tr>
	</table>
</body>
</html>

