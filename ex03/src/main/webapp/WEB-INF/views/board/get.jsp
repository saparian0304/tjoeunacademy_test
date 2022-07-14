<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>

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
					<div class="form-group">
						<label>Bno</label> <input class="form-control" name="bno" value="${board.bno}" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title" value="${board.title }" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name="content" readonly="readonly">${board.content}</textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer" value="${board.writer}" readonly="readonly">
					</div>
					<button data-oper="modify" class="btn btn-default">Modify</button>
					<button data-oper="list" class="btn btn-info">List</button>
					
					<form id='operForm' action="/board/modify" method="get">
						<input type="hidden" id="bno" name="bno" value="${board.bno}">
						<input type="hidden" name="pageNum" value="${criteria.pageNum}">
						<input type="hidden" name="amount" value="${criteria.amount}">
						<input type="hidden" name="type" value="${criteria.type}">
						<input type="hidden" name="keyword" value="${criteria.keyword}">
					</form>
					<script src="/resources/js/reply.js"></script>
					<script>
						$(function() {
							var operForm = $('#operForm');
							$("button[data-oper='modify']").on("click", function(e) {
								operForm.attr("action", "/board/modify").submit();
							})
							$("button[data-oper='list']").on("click", function(e) {
								operForm.find("#bno").remove();
								operForm.attr("action", "/board/list")
								operForm.submit();
							})
							
							// console.log(replyService);
							var bnoValue = '${board.bno}';
							replyService.add(
								{reply:"JS Test", replyer: "tester", bno : bnoValue},
								function (result) {
									alert("RESULT : " + result);
								}
							)

							replyService.getList({bno:bnoValue, page:1}, function(list){
								
								for(var i=0, len = list.length||0; i<len; i++) {
									console.log(list[i]);
								}
							})
							
							replyService.remove(19, function(count) {
								console.log(count);
								
								if(count==="success") {
									alert("REMOVED");
								}
							}, function(err) {
								alert('ERROR...');
							});
							
							replyService.update({
								rno : 20,
								bno : bnoValue,
								reply : "Modified Reply..."
							}, function(result) {
								alert('수정완료....');
							})
							replyService.get(21, function(data) {
								console.log(data);
							})
						});
					</script>
			</div>
			<!-- end panel-body -->
		</div>
		<!-- end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    