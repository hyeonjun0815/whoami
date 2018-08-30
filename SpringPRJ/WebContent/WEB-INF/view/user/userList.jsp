<%@page import="poly.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<UserDTO> uList = (List<UserDTO>)request.getAttribute("uList"); /* uList라는 변수를 가져옵니다. List<UserDTO>형식으로 캐스팅 후 저장합니다. */
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
		<tr bgcolor="">
			<td>
				<!-- 회원 목록 테이블  -->
				<div align="center" style="text-align:center;">
					 <table border="1" style="width:88%; ">
					 	<tr style="bgcolor:SlateBlue;">
					 		<td>회원번호 </td>
					 		<td>아이디</td>
					 		<td>이름</td>
					 		<td>나이</td>
					 		<td>회원삭제</td>
					 	</tr>
					 	<% for(int i = 0; i < uList.size(); i++) { %> <!-- 전달받은 변수의 사이즈에 맞게 반복문 실행 -->
					 	<tr> <!-- 아이디 클릭시 회원상세정보로 이동 -->
					 		<td><a href="userDetail.do?userNo=<%=uList.get(i).getUser_no()%>">
					 			<%=uList.get(i).getUser_no() %></a></td> <!-- getUser_no메소드를 이용해 값 출력  -->
					 		<td><%=uList.get(i).getId() %></td> <!-- getId()메소드를 이용해 값 출력  -->
					 		<td><%=uList.get(i).getName() %></td> <!-- getName()메소드를 이용해 이름 출력 -->
					 		<td><%=uList.get(i).getAge() %></td> <!-- getAge()메소드를 통해 나이 출력 -->
					 		<td><a href="userDelete.do?userNo=<%=uList.get(i).getUser_no()%>">회원삭제</a> 
					 			<!-- 회원을 삭제하기 위해 회원번호를 get방식으로 같이 보내어 컨트롤러로 이동합니다.-->
					 	</tr>
					 	<%} %>
					 </table>
				</div>
				<!-- 회원 목록 테이블 끝 -->
			</td>
		</tr>
		<tr height="7%" bgcolor="#00D8FF">
			<td><%@include file="/WEB-INF/view/bottom.jsp" %></td>
		</tr>
	</table>
</body>
</html>