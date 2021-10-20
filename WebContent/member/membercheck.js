$(document).ready(function(){	
	
	// 아이디 중복 검사
	$("#idcheck").click(function(){
		if($("#id").val()==""){
			alert("아이디를 입력하세요");
			$("#id").focus();
			return false;
		}else{
			
			var id = $("#id").val();	
			
			$.ajax({
				type:"post",
				url:"/Model2Project/MemberIdCheck.do",
				data:{"id":id},
				datatype:"text",
				success:function(data){
//					alert(data);
					
					if(data==1){	// 중복 ID
						$("#myid").text("중복 아이디입니다.");
						$("#id").val("").focus();
					}else{			// 사용 가능한 ID
						$("#myid").text("사용 가능한 아이디입니다.");
						$("#passwd").focus();
					}					
				}
			});			
		}		
	});
	
	
	// 도메인 선택
	$("#email").change(function(){
		if($("#email").val() == ""){	// 직접 입력 선택	
//			$("#domain").attr("readonly", false);
			$("#domain").removeAttr("readonly");
			$("#domain").val("").focus();			
		}else{							// 도메인명 선택
			$("#domain").val($("#email").val());
		    $("#domain").attr("readonly","readonly");
		}
	});
	
	//비밀번호 정규식 검사 : 영문자+숫자+특수조합(8~25자리 입력)
	$("#passwd").focusout(function(){
		var passwdtype = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,12}$/;
		if($("#passwd").val() != ""){
			  
			if (!passwdtype.test(passwd.value)) {
				alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~12자리를 입력해주세요.");
			$("#passwd").val("").focus();
			return false;
			}
		}
	});
	

	// 유효성 검사
	$("form").submit(function(){
		
		if($("#id").val() == ""){
			alert("아이디를 입력하세요.");
			$("#id").focus();
			return false;
		}		
		if($("#idcheck").val() == ""){
			alert("아이디 중복검사가 필요합니다.");
			return false;
		}
		if($("#passwd").val()==""){
			alert("비밀번호를 입력하세요.");
			$("#passwd").focus();
			return false;
		}		
		if($("#passwd_check").val()==""){
			alert("비밀번호 확인을 입력하세요.");
			$("#passwd_check").focus();
			return false;
		}
		if($("#passwd_check").val()!=$("#passwd").val()){
			alert("비밀번호가 일치하지 않습니다.");
			$("#passwd_check").focus();
			return false;
		}
		if($("#name").val()==""){
			alert("이름을 입력하세요.");
			$("#name").focus();
			return false;
		}
		if($("#year").val()==""){
			alert("년도를 입력하세요.");
			$("#year").focus();
			return false;
		}
		if($("#year").val().length != 4){
			alert("년도를 4자리로 입력하세요.");
			$("#year").focus();
			return false;
		}
		if(isNaN($("#year").val())){
			alert("숫자만 입력하세요.");
			$("#year").val("").focus();
			return false;
		}
		if($("#month").val()==""){
			alert("월을 선택하세요.");
			$("#month").focus();
			return false;
		}
		if($("#day").val()==""){
			alert("날짜를 입력하세요.");
			$("#day").focus();
			return false;
		}
		if(isNaN($("#year").val())){
			alert("숫자만 입력하세요.");
			$("#year").val("").focus();
			return false;
		}
		if($("#male").is(":checked")==false &&
				   $("#female").is(":checked")==false){
					alert("성별을 선택하세요.");
					return false;
		}
		if($("#mailid").val()==""){
			alert("이메일 아이디를 입력하세요.");
			$("#mailid").focus();
			return false;
		}
		if($("#domain").val()==""){
			alert("이메일 도메인을 입력하세요.");
			$("#domain").focus();
			return false;
		}
		if($("#phone1").val()==""){
			alert("핸드폰 앞자리를 선택하세요.");
			$("#phone1").focus();
			return false;
		}
		if(isNaN($("#phone1").val())){
			alert("숫자만 입력하세요.");
			$("#phone1").val("").focus();
			return false;
		}
		if($("#phone2").val()==""){
			alert("핸드폰 가운데자리를 입력하세요.");
			$("#phone2").focus();
			return false;
		}
		if(isNaN($("#phone2").val())){
			alert("숫자만 입력하세요.");
			$("#phone2").val("").focus();
			return false;
		}
		if($("#phone3").val()==""){
			alert("핸드폰 끝자리를 입력하세요.");
			$("#phone3").focus();
			return false;
		}
		if(isNaN($("#phone3").val())){
			alert("숫자만 입력하세요.");
			$("#phone3").val("").focus();
			return false;
		}
		if($("#local").val()==""){
			alert("지역을 선택하세요.");
			$("#local").focus();
			return false;
		}
		/*if($("#passwd_old").val() == ""){
			alert("현재 비밀번호를 입력하세요.");
			$("#passwd_old").focus();
			return false;
		}	
		if($("#passwd_new").val()==""){
			alert("새 비밀번호를 입력하세요.");
			$("#passwd_new").focus();
			return false;
		}
		if($("#passwd_new_check").val()==""){
			alert("새 비밀번호 확인을 입력하세요.");
			$("#passwd_new_check").focus();
			return false;
		}
		if($("#passwd_new_check").val() != $("#passwd_new").val()){
			alert("비밀번호가 일치하지 않습니다.");
			$("#passwd_new_check").focus();
			return false;
		}
		if($("#passwd_new").val() == $("#passwd_old").val()){
			alert("새 비밀번호가 현재 비밀번호와 같습니다. 새로운 비밀번호를 입력해주세요.");
			$("#passwd_new").val("").focus();
			$("#passwd_new_check").val("");
			return false;
		}*/
		
	}); // submit() end		
	
});  // ready() end