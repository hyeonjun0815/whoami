<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	double bmi = (double) request.getAttribute("bmi"); // bmi라는 데이터를 받아와서 bmi변수에 저장합니다.
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	this is b<br />
	<form action="c.do">
		
		몸무게: <input type="text" name="kg" />
		신장 :<input type="text" name="cm" />
		<input type="submit" value="SUBMIT" />
		
	</form>

</body>
</html>