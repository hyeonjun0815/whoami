<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	double bmi = (double) request.getAttribute("bmi");
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	this is c <br />
	<a href="a.do">Head to a</a> <!-- 컨트롤러에 a페이지를 요청합니다. -->
	<%= bmi%>
</body>
</html>