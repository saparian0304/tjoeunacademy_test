<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<script>
	$(function(){
		var formObj = $('form');
		
		$('button').on('click', function(e){
			e.preventDefault();
			var operation = $(this).data('oper');
			console.log(operation);
			
			//formObj.attr("action", operation);
			
			if(operation === 'remove'){
				formObj.attr("action", "/board/remove");
			} else if (operation === 'list'){
				//self.location="/board/list";
				formObj.attr("action", "/board/list").attr("method","get");
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var keywordTag = $("input[name='keyword']").clone();
				var typeTag = $("input[name='type']").clone();
				
				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(keywordTag);
				formObj.append(typeTag);
			}
			formObj.submit();
			
		})
	})
	
</script>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!--  /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
		
			<div class="panel-heading">Board Read Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" action="/board/modify" method="post">
					<input type="hidden" name="pageNum" value="${criteria.pageNum}">
					<input type="hidden" name="amount" value="${criteria.amount}">
					<input type="hidden" name="type" value="${criteria.type}">
					<input type="hidden" name="keyword" value="${criteria.keyword}">
					<div class="form-group">
						<label>Bno</label> <input class="form-control" name="bno" value="${board.bno}" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title" value="${board.title }" >
					</div>
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name="content">${board.content}</textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer" value="${board.writer}" readonly="readonly">
					</div>
					<button type="submit" data-oper="modify" class="btn btn-default"
					onclick='location.href="/board/modify?bno=${board.bno}"'>Modify</button>
					<button type="submit" data-oper="remove" class="btn btn-danger"
					onclick='location.href="/board/modify?bno=${board.bno}"'>Remove</button>
					<button type="submit" data-oper="list" class="btn btn-info">List</button>
					<input type="button" value="List(cri)" onclick="location.href='list?${criteria.listLink }'">
				</form>
			</div>
			<!-- end panel-body -->
		</div>
		<!-- end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    