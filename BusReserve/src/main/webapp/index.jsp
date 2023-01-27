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
	<div style="display: inline-block; background: <%= color1 %>; padding: 3px 10px; color: #ffffff;"><strong>既存</strong></div>
	<div style="padding: 10px; border: 2px solid <%= color1 %>;">
		<form action="LoginServlet" method="post">
			姓*:<input class="text" name="fName" placeholder="小山田"><br>
			名*:<input class="text" name="lName" placeholder="拓実"><br>
			電話番号*:<input class="text" placeholder="09045119636"><br>
			<input type="submit" value="確認">
		</form>
	</div>
	<br>
	<div style="display: inline-block; background: <%= color2 %>; padding: 3px 10px; color: #ffffff;"><strong>新規</strong></div>
	<div style="padding: 10px; border: 2px solid <%= color2 %>;">
		<form action="SigninServlet" method="post">
			姓*:<input class="text" name="fName" placeholder="小山田"><br>
			名*:<input class="text" name="lName" placeholder="拓実"><br>
			電話番号*:<input class="text" name="tel" placeholder="09045119636"><br>
			<input type="submit" value="登録">
		</form>
	</div>
	
</body>
</html>