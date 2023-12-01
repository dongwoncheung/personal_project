<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="shadow-box m-5">
	 <div class="d-flex justify-content-center m-5">
		<form id="loginForm" action="/user/sign-in" method="post">
			<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">ID</span>
					</div>
					<input type="text" class="form-control" name="loginId">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">PW</span>
					</div>
					<input type="password" class="form-control" name="password">
				</div>
				<input type="submit" class="btn btn-block btn-warning" value="로그인">
				<a class="btn btn-block btn-dark" href="/user/sign-up">회원가입</a>
				
				<!-- <a href="/user/searchId" class="btn btn-warning btn-user btn-block">아이디 찾기</a>
				<a href="/user/searchPwd" class="btn btn-warning btn-user btn-block">비밀번호찾기 찾기</a> -->
				
		</form>
	   </div>
	</div>
</div>
<script>
$(document).ready(function(){
	
	// 로그인 하는 페이지
	$('#loginForm').submit(function(e){
		e.preventDefault();
		let loginId = $('input[name=loginId]').val().trim();
		if(loginId == ''){
			alert("아이디를 입력하세요");
			return;
		}
		
		let password = $('#password').val();
		if(password == ''){
			alert("비밀번호를 입력하세요");
			return;
		}
		
		//ajax

		let url = $(this).attr("action");
		let data = $(this).serialize();
		
		$.post(url,data)
		.done(function(data){
			if(data.result == "성공"){
				location.href="/room/room-main-page"
			}else{
				alert("로그인에 실패했습니다");
			}
		})
		
		
	});
});
</script>