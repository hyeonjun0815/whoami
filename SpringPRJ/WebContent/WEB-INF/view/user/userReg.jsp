<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>WEB!</title>
</head>
<body>
	<table style="height: 100%; width: 100%">
		<tr height="7%" bgcolor="#00D8FF">
			<td><%@include file="/WEB-INF/view/top.jsp" %></td>
		</tr>
		<tr bgcolor="">
			<td>
				<form action="/user/userRegProc.do" method="post">
					아이디: <input type="text" name="id"/> <br />
					비밀번호: <input type="text" name="password"/> <br />
					이름: <input type="text" name="name"/> <br />
					나이: <input type="text" name="age"/> <br />
					<input type="submit" value="SUBMIT!" />
				</form>
			</td>
		</tr>
		<tr height="7%" bgcolor="#00D8FF">
			<td><%@include file="/WEB-INF/view/bottom.jsp" %></td>
		</tr>
	</table>
</body>
</html>