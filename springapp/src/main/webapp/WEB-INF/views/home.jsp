<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html;charset=utf-8"%>

<html>

<head>
<title>Home</title>
<style type="text/css">
body {
	font-family: 'Nanum Brush Script', cursive;
}

a {
	text-decoration: none;
	color: #000000;
}
</style>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap')
	;
</style>
</head>
<body>
	<h2>${message }</h2>
	<h2>
		<a href="emp/count">사원 수</a>
	</h2>
	<br>
	<form action="emp/count">
		검색하려는 부서 번호를 입력하세요 : <input type="text" name="deptId"> <input
			type="submit" value="확인">
	</form>
	<form action="emp/search">
		검색하려는 부서 번호를 입력하세요 : <input type="text" name="deptId"> <input
			type="submit" value="확인">
	</form>
	<form action="emp/name">
		검색하려는 사원 이름을 입력하세요 : <input type="text" name="keyword"> <input
			type="submit" value="확인">
	</form>
	<br>
	<a href="emp/list"><button>사원 목록</button></a>
<a href="emp/insert"><button>사원 정보 등록</button></a>
<a href="emp/signup"><button>회원가입</button></a>
<a href="emp/login"><button>로그인</button></a>
</body>
</html>
