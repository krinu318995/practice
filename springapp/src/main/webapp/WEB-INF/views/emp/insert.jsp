<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Emp ${message }</title>
</head>

<body>
	<h1>사원 정보${message eq  "insert" ? "입력" : "수정" }</h1>
	<form:form action="./${message}" enctype="multipart/form-data"
		modelAttribute="emp">

		<table>
			<tr>
				<td>사원번호</td>
				<td><form:input path="employeeId" /> <form:errors
						path="employeeId" />
					<button id="check">중복 확인</button></td>

			</tr>
			<tr>
				<td>이름</td>
				<td><form:input path="firstName" /> <form:errors
						path="firstName" /></td>

			</tr>
			<tr>
				<td>프로필 사진(5Mb)이하></td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td>성</td>
				<td><form:input path="lastName" /> <form:errors
						path="lastName" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><form:input path="email" /> <form:errors path="email" /></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><form:input path="phoneNumber" /> <form:errors
						path="phoneNumber" /></td>

			</tr>
			<tr>
				<td>입사일</td>
				<td><form:input path="hireDate" type="date" required="required" />
					<form:errors path="hireDate" /></td>

			</tr>
			<tr>
				<td>직무</td>
				<td><form:select path="jobId">
						<form:options items="${jobList}" itemLabel="jobTitle"
							itemValue="jobId" />
						<%-- 	<c:forEach var="job" items="${jobList }" >
							<option value="${job.jobId }">${job.jobTitle}</option>
						</c:forEach> --%>
					</form:select></td>

			</tr>
			<tr>
				<td>급여</td>
				<td><form:input path="salary" /> <form:errors path="salary" />
				</td>
			</tr>
			<tr>
				<td>보너스율</td>
				<td><form:input path="commissionPct" type="number" step="0.05" />
					<form:errors path="commissionPct" /></td>
			</tr>
			<tr>
				<td>매니저</td>
				<td><form:select path="managerId">
						<c:forEach var="man" items="${manList }">
							<option value="${man.managerId }">${man.managerName}</option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td>부서</td>
				<td><form:select path="departmentId">
						<c:forEach var="dept" items="${deptList }">
							<option value="${dept.departmentId }">${dept.departmentName}</option>
						</c:forEach>
					</form:select></td>
			</tr>

		</table>
		<input type="submit" value="저장" onsubmit="return check();" id="submit">
		<input type="reset" value="취소">
	</form:form>
	<script type="text/javascript">
		$(function() {
			var ck = false;
			$("#check").on("click", function() {
				if ($("#employeeId").val()) {
					$.ajax({
						
						url : "check", 
						type : "post", 
						data :{empId :  $("#employeeId").val()},
						dataType : "text",
						success : function(result){
							if(result){
								alert("중복X");
								$("#check").remove();
								$("#employeeId").val().attr("readonly", true);
								ck =! ck;
							}else {
								alert("이미 존재하는 사원번호 입니다.");
								
							}
							return false;
						},
						error : function(result){
							alert("ajax에러있음");
							return false;
						}
					});
				} else {
					alert("값이 있어야 합니다.");
					return false;
				}
			});
	
			
			$("#submit").on("click", function(){
				if(ck){
					
				}else {
					alert("사원번호 중복 검사는 필수입니다.");
					return false;
				}
			}
		);
		});
	</script>
</body>
</html>