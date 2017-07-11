<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
/* CSS영역 */
body {
	background-color: gold;
	color: red
}
</style>
<script type="text/javascript">
	/* JavaScript 영역 */
	function test() {
		window.alert("JavaScript 테스트!");
	}
</script>
</head>
<body onload="test()">
	<%
		/*jsp영역 */
		Class.forName("java.lang.Object");

		out.print("<h1>JSP 영역 #1</h1>");

		for (int i = 0; i <= 10; i++) {
			out.println("Hello" + i +"<br>");
		}
	%>
	<h1>HTML영역!!!!!!!!</h1>
	<%
		out.print("JSP 영역 #2");
	%>
	file:///C:/Users/cse/Downloads/빅데이터/workspace/Day11_0710_Web_월/WebContent/test.html

</body>
</html>