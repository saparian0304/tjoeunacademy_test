<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 첨부형 게시판</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function validateForm(form) {
		if (form.name.value =="" ) {
			alert("작성자를 입력하세요");
			form.name.focus();
			return false;
		}
		
		if (form.title.value =="") {
			alert("제목을 입력하세요.");
			form.title.focus();
			return false;
		}
		
		if (form.content.value =="") {
			alert("내용을 입력하세요.");
			form.content.focus();
			return false;
		}
	}
	
	$(function (){
		var cnt = 1;
		$('.plus').click(function(){
			//console.log($('.addfile').length);
			if ($('.addfile').length > 4){
				alert('5개 이상 만들수 없습니다.');
				return;			
			}
			cnt = cnt + 1;
			var html = '';
			html += '<tr class="addfile">';
			html +=		'<td>첨부파일</td>';
			html +=		'<td>';
			html +=			'<input type="file" name="ofile'+cnt+'">';
			html +=			'<img src="<c:url value="/img/minus.png"/>" width="17px" align="center" class="minus">';
			html +=		'</td>';
			html +=	'</tr>';
			$(this).closest('tr').after(html);
		})
		
		$('.delete').click(function(){
            $.ajax({
                url : '/delete.do',
                dataType : 'HTML',
                cache : false,
                data : {
                    param1 : 'a',
                    param2 : 'b'
                },
                type : 'get',
                success : function(data) {
                    // 응답받은 결과를 처리
                    console.log(data)
                    $('#area').html(data);
                }, 
                error : function(res) {
                    console.log(res);
                    
                }
            })
        });
		
	})
	
	$(document).on('click', '.plus', function(){    
            $('.minus').click(function(){
                $(this).closest('tr').remove();
            });
        }); 
</script>
</head>
<body>
	<h2>파일 첨부형 게시판 - 수정하기(edit)</h2>
	<form name="wirteFrm" method="post" enctype="multipart/form-data"
		action="../mvcboard/edit.do" onsubmit="return validateForm(this);">
		<input type="hidden" name="idx" value="${dto.idx }">
		<input type="hidden" name="prevOfile" value="${dto.ofile }">
		<input type="hidden" name="prevSfile" value="${dto.sfile }">
		
		<table border="1" width="90%">
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="name" style="width:150px;" value="${dto.name }">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title" style="width:90%;" value="${dto.title }">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" style="width:90%;height:100px;">${dto.content }</textarea>
				<td>
			</tr>
	<c:forEach var="file" items="${fileList }" varStatus="status">
		<tr class="addfile">
			<td>첨부파일</td>
			<td colspan="3">${file } <a href="../mvcboard/download.do?ofile=${dto.ofile }&sfile=${dto.sfile}&idx=${dto.idx}">
				[다운로드]
				</a>&nbsp;&nbsp;&nbsp;
				<img src="/web/img/delete.png" class="delete" height="15px">
			</td>
		</tr>	
	</c:forEach>
			<tr class="addfile">
				<td>첨부파일</td>
				<td>
					<input type="file" name="ofile1">${dto.ofile }
					<img src="<c:url value="/img/plus.png"/>" width="17px" align="center" class="plus">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">작성 완료</button>
					<button type="reset">RESET</button>
					<button type="button" onclick="location.href='../mvcboard/list.do';">
					목록 바로가기
					</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>