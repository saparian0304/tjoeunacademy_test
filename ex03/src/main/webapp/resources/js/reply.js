/**
 * 
 */
 console.log("Reply Module......")
 var replyService = (function() {
			// add(객체, 콜백함수)
	function add(reply, callback, error) {
		console.log("reply.....");
		
		$.ajax({
			type: 'post',
			url : '/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {	// 콜백함수가 있으면 (값이 있으면 true, 없으면 false => 함수 호출때 매개변수를 넘겨주면 true가 된다.) 
					callback(result); // 응답받은 값을 넣어서 콜백함수 실행
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er)
				}
			}
		})
	}
	
	function getList(param, callback, error) {
		var bno = param.bno;
		var page = param.page || 1;		// page에 값이 없으면 1이 들어간다
		
		$.getJSON("/replies/pages/" + bno + "/" + page + ".json", 
			function(data) {
				if (callback) {
					callback(data);
				}
			}).fail(function(xhr, status, err) {
				if (error) {
					error();
				}
			})
	}
	
	function remove(rno, callback, error) {
		
		$.ajax({
			type : 'delete',
			url : '/replies/' + rno,
			success : function(deleteResult, status, xhr) {
				if (callback) {
					callback(deleteResult);
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		})
	}
	
	function update(reply, callback, error){
		console.log("Rno: " + reply.rno);
		
		$.ajax({
			type : 'put',
			url : '/replies/' + reply.rno,
			data : JSON.stringify(reply),	// JSON.stringify : 값이나 객체를 json으로 변환하는 메서드
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		})
	}
	
	function get(rno, callback, error) {
		$.get("/replies/" + rno + ".json", function(result) {
			if(callback) {
				callback(result);
			}
		}).fail(function(xhr, status, err) {
			if (error) {
				error()
			}
		});
	}
	
	return {
		add : add,
		getList : getList,
		remove : remove,
		update : update,
		get : get
	};
})();