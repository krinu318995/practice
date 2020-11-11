<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%-- 삭제하려는 ${emp.firstName}&nbsp;${emp.lastName }은<br>
<h2>${count.empCount }</h2><br>
명의 매니저이고<br>
${count.deptCount}<br>
개의 부서를 책임지고 있습니다.<br>--%>
<body>
<h3>정말 삭제하시겠습니까?</h3>
<form action="delete" method=post>
<input type=hidden name=empId value="${emp.employeeId}">
<input type=submit value="삭제">
<input type="button" value="취소" onclick="history.back(-1);">
</form>
</body>
</html>