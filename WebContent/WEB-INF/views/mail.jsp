<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.servletContext.contextPath }/">


<title>Send mail</title>
</head>
<body>
	${message }
	<form action="guimail.htm" method="post">
		<p>
			<input class="form-control" name="from" placeholder="From">
		</p>
		<p>
			<input class="form-control" name ="to" placeholder="To">
		</p>
		<p>
			<input class="form-control" name="subject" placeholder="Subject">
		</p>
		<p>
			<textarea name="body" placeholder="Body" rows="3" cols="30"></textarea> </p>
		<button style="border-radius: 5px; background-color: gray; color: red;"	>Send</button>
	</form>
	<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>