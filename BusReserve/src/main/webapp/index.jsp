<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
// String colorCode = "#ff69b4";
String color1 = "#FFAFCC";
String color2 = "#A2D2FF";
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>バス予約システム</title>
</head>
<body>
	<h1>バス予約システム</h1>
	<%--バス予約画面 --%>
	<div
		style="display: inline-block; background: <%=color1%>; padding: 3px 10px; color: #ffffff;">
		<strong>既存</strong>
	</div>
	<div style="padding: 10px; border: 2px solid <%=color1%>;">
		<form action="LoginServlet" method="post">
			姓*:<input class="text" name="fName" placeholder="バス"><br>
			名*:<input class="text" name="lName" placeholder="太郎"><br>
			電話番号*:<input class="text" name="telNo" placeholder="XXXYYYYZZZZ"><br>
			<input type="submit" value="確認">
		</form>
	</div>
	<br>
	<div
		style="display: inline-block; background: <%=color2%>; padding: 3px 10px; color: #ffffff;">
		<strong>新規</strong>
	</div>
	<div style="padding: 10px; border: 2px solid <%=color2%>;">
		<form action="LoginServlet" method="post">
			姓*:<input class="text" name="fNameR" placeholder="バス"><br>
			名*:<input class="text" name="lNameR" placeholder="太郎"><br>
			電話番号*:<input class="text" name="telNoR" placeholder="XXXYYYYZZZZ"><br>
			<input type="submit" value="登録">
		</form>
	</div>

	<%-- エラーメッセージをポップアップで表示 --%>
	<% if (request.getAttribute("error_msg") != null) {
		String error_msg = (String) request.getAttribute("error_msg"); %>
	<script type="text/javascript">
    	var msg = "<%=error_msg%>";
		alert(msg);
	</script>
	<% } %>

</body>
</html>