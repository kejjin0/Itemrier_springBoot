<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 취소</title>
</head>
<script>
function refreshInfoAndClose() {
	window.opener.location.reload();
	window.close();
	return true;
}
</script>
<body>
	<center>
		<h7>${message}</h7>
		<button onclick="refreshInfoAndClose()">닫기</button>
	</center>
</body>
</html>