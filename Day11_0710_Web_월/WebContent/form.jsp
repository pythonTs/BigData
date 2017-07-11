<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/** jsp영역
		getParameter("") 파라미터는 대소문자 구별, 띄어쓰기 구별
		*/
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");

		out.print(id + "<br>");
		out.print(name + "<br>");
		out.print(pwd + "<br>");
	%>
</body>
</html>