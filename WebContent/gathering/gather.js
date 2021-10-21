/*// 도메인 선택
	$("#local").change(function(){
		if($("#local").val() == ""){		
//			$("#domain").attr("readonly", false);
			$("#local").removeAttr("readonly");
			$("#local").val("").focus();			
		}else{							
			$("#local").val($("#local").val());
		    $("#local").attr("readonly","readonly");
		}
	});*/


$(document).ready(function(){
			$("form").submit(function(){
				if($("#gathersubject").val()==""){
					alert("모임이름을 입력 하세요.");
					$("#gathersubject").focus();
					return false;
				}
				if($("#id").val()==""){
					alert("작성자를 입력 하세요.");
					$("#id").focus();
					return false;
				}
				if($("#gatherpw").val()==""){
					alert("비밀번호를 입력 하세요.");
					$("#gatherpw").focus();
					return false;
				}
				if($("#local").val()==""){
					alert("지역을 선택해 주세요.");
					$("#local").focus();
					return false;
				}
				if($("#membercnt").val()==""){
					alert("인원수를 선택해 주세요.");
					$("#membercnt").focus();
					return false;
				}
				if($("#content").val()==""){
					alert("내용을 입력 하세요.");
					$("#content").focus();
					return false;
				}
				if($("#intro").val().length > 100){
					alert("자기소개를 100자 이내로 입력하세요");
					$("#intro").focus();
					return false;
				}
			});			
});	