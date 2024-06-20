<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성</title>
<style>
table {
	border: 1px solid gray;
}
</style>
</head>
<body>
	<center>
		<h6>리뷰 작성</h6>
		<form action=<c:url value='/wrtie/review' /> "
		method="post">
			<table>
				<tr>
					<th>만족도</th>
					<td><label><input type="radio" name="satisfactionRate"
							value="1" checked>★</label> <label><input type="radio"
							name="satisfactionRate" value="2">★★</label> <label><input
							type="radio" name="satisfactionRate" value="3">★★★</label> <label><input
							type="radio" name="satisfactionRate" value="4">★★★★</label> <label><input
							type="radio" name="satisfactionRate" value="5">★★★★★</label></td>
				</tr>
				<tr>
					<th>답장 속도</th>
					<td><label><input type="radio" name="speedOfAnswer"
							value="1" checked>★</label> <label><input type="radio"
							name="speedOfAnswer" value="2">★★</label> <label><input
							type="radio" name="speedOfAnswer" value="3">★★★</label> <label><input
							type="radio" name="speedOfAnswer" value="4">★★★★</label> <label><input
							type="radio" name="speedOfAnswer" value="5">★★★★★</label></td>
				</tr>
				<tr>
					<th>약속</th>
					<td><label><input type="radio" name="promise"
							value="1" checked>★</label> <label><input type="radio"
							name="promise" value="2">★★</label> <label><input
							type="radio" name="promise" value="3">★★★</label> <label><input
							type="radio" name="promise" value="4">★★★★</label> <label><input
							type="radio" name="promise" value="5">★★★★★</label></td>
				</tr>
				<input type="hidden" name="userId" value='${userId}'>
				<input type="hidden" name="itemId" value='${itemId}'>
				<input type="hidden" name="reviewerId" value='${reviewerId}'>
			</table>
			<input type="submit" value="작성">
			</button>
		</form>
	</center>
</body>
</html>