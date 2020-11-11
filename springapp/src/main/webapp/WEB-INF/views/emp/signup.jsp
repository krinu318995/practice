<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>User SignUp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>

	<form:form action="./signup" enctype="multipart/form-data"
		modelAttribute="emp" method="post">

		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userId" id="userId">&nbsp;&nbsp;
				<button onclick="idCheck">아이디 중복 검사</button></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>

			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="tel" name="tel"></td>
			</tr>

			<tr>
				<td>프로필 사진(5Mb)이하</td>
				<td><input type="file" name="file"></td>
			</tr>

		</table>
		<input type="submit" id="submit" value="저장" onsubmit="return confirm();">
		<input type="reset" value="취소">
	</form:form>
	<script type="text/javascript">
		$(function() {

			var confirm = false;
			$("#idCheck").on("click", function() {
				if ($("#userId").val()) {

					$.ajax({
						url : "idcheck",
						type : "post",
						data : {
							userId : $("#userId").val()
						},
						dataType : "text",
						success : function(confirm) {
							if (confirm) {
								alert("사용 가능한 아이디 입니다.");
								$("#idCheck").remove();
								$("#idCheck").val().attr("readonly", true);

								confirm =! confirm;
							} else {
								alert("이미 존재하는 아이디 입니다.");
							}
							return false;
						}
					});

				} else {
					alert("필수 입력란 입니다.");
					return false;

				}
			});
			$("#submit").on("click", function() {
				if (confirm) {

				} else {
					alert("아이디 중복 검사는 필수입니다.");
					return false;
				}

			});

		});
	</script>
</body>
</html>