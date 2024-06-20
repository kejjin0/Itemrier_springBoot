<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 완료</title>
<script>
	function refreshInfoAndClose() {
		window.opener.location.reload();
		window.close();
		return true;
	}
</script>
</head>
<body>
	<center>
		<h5>${message}</h5>
		<button onclick="refreshInfoAndClose()">닫기</button>
	</center>
</body>
</html>