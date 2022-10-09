<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<div class="mb-3 mt-3">
			<input id="username" type="text" class="form-control"
				placeholder="Enter username" maxlength="20">
			<button id="btnUsernameSameCheck" class="btn btn-warning"
				type="button">유저네임 중복체크</button>
		</div>
		<div class="mb-3">
			<input id="password" type="password" class="form-control"
				placeholder="Enter password" maxlength="20">
		</div>
		<div class="mb-3">
			<input id="passwordSame" type="password" class="form-control"
				placeholder="Enter passwordSame">
		</div>
		<div class="mb-3">
			<input id="email" type="email" class="form-control"
				placeholder="Enter email" maxlength="50">
		</div>
		<button id="btnJoin" type="button" class="btn btn-primary">회원가입</button>
	</form>
</div>

<script>
	
</script>

<script>

$("#btnJoin").click(() => {

	join();
});


function join() {
	
	let data = {
			username : $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
	};
	
	$.ajax("/join", {
		type: "POST",
		dataType: "json", //응답 데이터(CMRespDto)
		data: JSON.stringify(data), // http body에 들고갈 요청 데이터
		headers: { // http header에 들고갈 요청 데이터
			"Content-Type": "application/json"
		}
	}).done((res) => {
		alert("잘실행됨")
		if (res.code == 1) {
			location.href = "/loginForm";		
			} else {
			alert(res.msg);
			history.back();
		}
	});
	
	
}















</script>

<%@ include file="../layout/footer.jsp"%>