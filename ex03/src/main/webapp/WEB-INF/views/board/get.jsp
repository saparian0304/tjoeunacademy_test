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
							var replyUL = $('.chat');
							
							showList(1);
							
							function showList(page) {
								replyService.getList(
									{bno:bnoValue, page: page || 1 }, 
									function(list) {
										var str = "";
										if(list == null || list.length == 0 ) {
											replyUL.html("");
											return;
										}
										for (var i = 0, len = list.length || 0; i < len; i++) {
											str += 	"<li class='left clearfix' data-rno='" + list[i].rno +"'>";
											str += 		"<div><div class='header'><strong class='primary-font'>" + list[i].replyer +"</strong>";
											str += 			"<small class='pull-right text-muted'>" + replyService.displayTime(list[i].replyDate) +"</small>";
											str += 		"</div>";
											str += 			"<p>" + list[i].reply +"</p>";
											str += 		"</div>";
											str += 	"</li>";
										}
										replyUL.html(str);
									} // 익명함수 종료
								); // getList() 종료
							} // showList() 종료
							
							// 댓글 추가
							var modal = $('.modal');
							var modalInputReply = modal.find("input[name='reply']");
							var modalInputReplyer = modal.find("input[name='replyer']");
							var modalInputReplyDate = modal.find("input[name='replyDate']");
							
							var modalModBtn = $('#modalModBtn');
							var modalRemoveBtn = $('#modalRemoveBtn');
							var modalResisterBtn = $('#modalResisterBtn');
							
							$('#addReplyBtn').on('click', function(e) {
								modal.find("input").val("");
								modalInputReplyDate.closest("div").hide();
								modal.find("button[id !='modalCloseBtn']").hide();
								
								modalResisterBtn.show();
								
								$('.modal').modal("show");
							})
							
							modalResisterBtn.on("click", function(e) {
								var reply = {
										reply : modalInputReply.val(),
										replyer : modalInputReplyer.val(),
										bno : bnoValue
								}
								replyService.add(reply, function(result){
									alert(result);
									modal.find("input").val('');
									modal.modal("hide");
									
									showList(1);
								})
							})
							
							/*
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
							*/
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
<div class='row'>
	<div class="col-lg-12">
		<!-- /.panel -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i> Reply
				<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
			</div>
			
			<div class="panel-body">
			
				<ul class="chat">
					<li class="left clearfix" data-rno='12'>
						<div>
							<div class="header">
								<strong class="primary-font">user00</strong>
								<small class="pull-right text-muted">2014-01-01 13:13</small>
							</div>
							<p>Good Job!</p>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
       <div class="modal-content">
           <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
               <h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
           </div>
           <div class="modal-body">
           
                <div class="form-group">
            		<label>Reply</label>   	
            		<input class="form-control"	name='reply' value='New Reply!!!!'>
                </div>
                <div class="form-group">
            		<label>Replyer</label>   	
            		<input class="form-control"	name='replyer' value='replyer'>
                </div>
                <div class="form-group">
            		<label>Reply Date</label>   	
            		<input class="form-control"	name='replyDate' value=''>
                </div>
                
           </div>
           <div class="modal-footer">
               <button id="modalModBtn" type="button" class="btn btn-warning" >Modify</button>
               <button id="modalRemoveBtn" type="button" class="btn btn-danger" data-dismiss='modal'>Remove</button>
               <button id="modalResisterBtn" type="button" class="btn btn-primary" data-dismiss='modal'>Resister</button>
               <button id="modalCloseBtn" type="button" class="btn btn-default" data-dismiss='modal'>Close</button>
           </div>
       </div>
       <!-- /.modal-content -->
   </div>
   <!-- /.modal-dialog -->
</div>							
<!-- /.modal -->										

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    