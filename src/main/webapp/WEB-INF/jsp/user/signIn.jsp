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
			
		</form>
	   </div>
	</div>
</div>
<script>
$(document).ready(function() {
	// 로그인 서브밋
	$('#loginForm').submit(function(e) {
		e.preventDefault(); // submit 자동 수행 중단
		
		var loginId = $('input[name=loginId]').val().trim();
		if (loginId == '') {
			alert("아이디를 입력해주세요.");
			return;
		}
		
		var password = $('input[name=password]').val();
		if (password == '') {
			alert("비밀번호를 입력해주세요.");
			return;
		}
		
		// AJAX로 서브밋
		var url = $(this).attr("action");
		var data = $(this).serialize(); // form의 name 속성으로 data를 구성한다.
		
		$.post(url, data)
		.done(function(data) {
			if (data.result == "성공") {
				location.href="/timeline/timeline-view"; 
			} else {
				alert("로그인에 실패했습니다. 다시 시도해주세요.");
			}
		}); 
	});
});
</script>