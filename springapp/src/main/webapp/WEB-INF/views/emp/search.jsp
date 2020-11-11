<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>

<c:set var="keyword" value="${keyword }"/>
		<c:forEach var="emp" items="${deptList }">
			<tr>
				<td>${emp.employeeId}</td>
				<td>${emp.firstName }</td>
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

		<c:if test="${empty deptList}">
			<h1>검색하신 부서가 존재하지 않습니다.</h1>
		</c:if>
	</table>
</body>
</html>