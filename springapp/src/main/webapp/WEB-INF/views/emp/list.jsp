<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>EmpList</title>
</head>
<body>
	<h2>사원 정보 목록</h2>
	<br>
	<a href="">사원 정보 입력</a> &nbsp;&nbsp;
	<a href="../emp">메인 페이지</a>
	<br>

	<table border="1">
		<tr>
			<td>사원 번호</td><td>프로필 사진</td>
			<td>이름</td>
			<td>성</td>
			<td>이메일</td>
			<td>연릭처</td>
			<td>입사일</td>
			<td>직무</td>
			<td>급여</td>
			<td>보너스율</td>
			<td>매니저 번호</td>
			<td>부서 번호</td>
		</tr>

		<c:forEach var="emp" items="${empList }">
			<tr>
				<td>${emp.employeeId}</td><td><img alt="사진" src="/springapp/emp/pic/${emp.employeeId}" width="100"></td>
				<td><a href="${emp.employeeId}">${emp.firstName }</a></td>
				<td>${emp.lastName }</td>
				<td>${emp.email }</td>
				<td>${emp.phoneNumber }</td>
				<td>${emp.hireDate }</td>
				<td>${emp.jobId }</td>
				<td>${emp.salary }</td>
				<td>${emp.commissionPct }</td>
				<td>${emp.managerId }</td>
				<td>${emp.departmentId }</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>