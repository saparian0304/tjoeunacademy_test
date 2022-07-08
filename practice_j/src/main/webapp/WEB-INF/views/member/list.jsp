<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function() {
		var sum = 0;
		setInterval(() => {
//			sum = add(sum);
			
			console.log(sum);
		}, 1000);
		
		$('body').click(function () {
			sum = add(sum);	
			
			$.ajax({  
				 url : '/ajp/member/list.do ',  
				 type : 'POST',
				 async : true, 
				 dataType : "Json", 
				 data : {"idx" : sum },
				 success : function(data){
					 console.log(data);
					 sum = <%=application.getAttribute("num") %>;
					 console.log("성공");
				 }, 
				 error : function (e){
					console.log("실패");
				}
			}); 
			console.log(sum);
		});
		
	});
	
	function add(sum) {
		sum += 1;
		return sum;
	}
</script>
</head>
<body>
<h2>멤버 리스트</h2>
</body>
</html>