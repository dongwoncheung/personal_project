<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
    .font-weight-bold {
      color: black;
    }
  </style>
<div class="h-100 d-flex align-items-center justify-content-between">
	<%-- logo --%>
	<div class="d-flex">
		<img src="/static/image/켈리포니아 로고.jpg" alt="mainlogo" width="80"
			height="80px">
		<h1 class="font-weight-bold">oc realestate</h1>
	</div>

	<!-- 검색 -->
			<div class="search col-7 d-flex justify-content-center align-items-center">
			<c:if test="${not empty userName}">
			<div class="searchbar col-10">
				<div class="input-group mb-3">
					<input type="text" class="form-control">
					<button class="btn btn-light" type="button">검색</button>
					<a href="/user/sign-in" class="my-2 ml-2 text-black font-weight-bold">로그아웃</a>
				</div>
			</div>
			</c:if>
		</div>


</div>