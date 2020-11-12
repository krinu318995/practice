<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class = "wrap">

</div>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url : "/springapp/resources/json/MOCK_DATA.json",
			dataType : "json",
			success : function(data){
				if(data.length>0){
					var table = $("<table/>");
					for(var i in data){
						var $id = data[i].id;
						var $first_name = data[i].first_name;
						var $last_name = data[i].last_name;
						var $email = data[i].email;
						var row = $("<tr />").append(
						$("<td />").text($id),		
						$("<td />").text($first_name),		
						$("<td />").text($last_name),		
						$("<td />").text($email)		
						);
						
						table.append(row);
					}
					$(".wrap").append(table);
				}
			}
			
		})
	});
</script>
</body>
</html>