var httpRequest = null;

// httpRequest 객체 생성
function getXMLHttpRequest() {
	var httpRequest = null;

	if (window.ActiveXObject) {
		try {
			httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e2) {
				httpRequest = null;
			}
		}
	} else if (window.XMLHttpRequest) {
		httpRequest = new window.XMLHttpRequest();
	}
	return httpRequest;
}

// 댓글 등록
function writeCmt() {
	var form = document.getElementById("writeCommentForm");

	var board = form.comment_board.value;
	var id = form.comment_id.value;
	var content = form.comment_content.value;

	if (!content) {
		alert("내용을 입력하세요.");
		return false;
	} else {
		var param = "comment_board=" + board + "&comment_id=" + id
				+ "&comment_content=" + content;

		httpRequest = getXMLHttpRequest();
		httpRequest.onreadystatechange = checkFunc;
		httpRequest.open("POST", "CommentWriteAction.do", true);
		httpRequest.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded;charset=EUC-KR');
		httpRequest.send(param);
	}
}

function checkValue() {
	var form = document.forms[0];
	// 전송할 값을 변수에 담는다.
	var comment_num = "${comment.comment_num}";
	var comment_board = "${comment.comment_board}";
	var comment_id = "${sessionScope.id}";
	var comment_content = form.comment_content.value

	if (!comment_content) {
		alert("내용을 입력하세요");
		return false;
	} else {
		var param = "comment_num=" + comment_num + "&comment_board="
				+ comment_board + "&comment_id=" + comment_id
				+ "&comment_content=" + comment_content;

		httpRequest = getXMLHttpRequest();
		httpRequest.onreadystatechange = checkFunc;
		httpRequest.open("POST", "CommentReplyAction.do", true);
		httpRequest.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded;charset=UTF-8');
		httpRequest.send(param);
	}
}

function checkFunc() {
	if (httpRequest.readyState == 4) {
		// 결과값을 가져온다.
		var resultText = httpRequest.responseText;
		if (resultText == 1) {
			document.location.reload(); // 상세보기 창 새로고침
		}
	}
}

function cmReplyOpen(comment_num) {
	var userId = '${sessionScope.id}';

	if (userId == "" || userId == null) {
		alert("로그인후 사용가능합니다.");
		return false;
	} else {
		// 댓글 답변창 open
		window.name = "parentForm";
		window.open("/CommentReplyFormAction.do?num=" + comment_num,
				"replyForm",
				"width=570, height=350, resizable = no, scrollbars = no");
	}
}

function cmDeleteOpen(comment_num) {
	var msg = confirm("댓글을 삭제합니다.");
	if (msg == true) {
		deleteCmt(comment_num);
	} else {
		return false;
	}
}

function deleteCmt(comment_num) {
	var param = "comment_num=" + comment_num;

	httpRequest = getXMLHttpRequest();
	httpRequest.onreadystatechange = checkFunc;
	httpRequest.open("POST", "CommentDeleteAction.do", true);
	httpRequest.setRequestHeader('Content-Type',
			'application/x-www-form-urlencoded; charset=UTF-8');
	httpRequest.send(param);
}
function cmUpdateOpen(comment_num) {
	window.name = "parentForm";
	window.open("/CommentUpdateFormAction.do?num=" + comment_num, "updateForm",
			"width=570, height=350, resizable= no, scrollbars = no");
}
