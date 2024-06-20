<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 리뷰</title>
<style>
table {
	width: 200px;
	height: 80px;
}
</style>
<script>
	function refreshInfoAndClose() {
		window.close();
		return true;
	}
</script>
</head>
<body>
	<center>
		<br>
		<table>
			<tr>
				<c:choose>
					<c:when test="${promise eq 0.0}">
						<p>작성된 리뷰가 없습니다.</p>
					</c:when>
					<c:otherwise>
						<tr>
							<th>만족도</th>
							<td>${review.satisfactionRate}</td>
						</tr>
						<tr>
							<th>답장 속도</th>
							<td>${review.speedOfAnswer}</td>
						</tr>
						<tr>
							<th>약속</th>
							<td>${review.promise}</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td rowspan="2"><center>
						<br>
						<button onclick="refreshInfoAndClose()">닫기</button>
					</center></td>
			</tr>
		</table>
	</center>
</body>
</html>