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
		/*
		setInterval(() => {
			console.log(sum);
		}, 1000);
		*/
		$('body').click(function () {
			console.log("add전 sum : " + sum)
			sum = add(sum);	
			console.log("add 후 sum : " + sum)
			$.ajax({  
				 url : '/ajp/member/list.do ',  
				 type : 'POST',
				 async : true, 
				 dataType : "Json", 
				 data : {"idx" : sum },
				 success : function(data){
					 console.log(data);
					 console.log("data : " + data);
					 console.log("\${num} : ");
					 sum = <%=application.getAttribute("num") %>;
					 console.log("sum : " + sum);
					 console.log("성공");
					 
					 $('body').html(${sum});  
					 
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