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