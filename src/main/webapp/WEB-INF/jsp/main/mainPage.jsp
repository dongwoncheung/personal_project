<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="d-flex justify-content-center mt-3">

<style>
.post-box img{
	width:300px;
	height:300px;
	}
.nav-item {
    display: flex;
    align-items: center;
}

.nav-item img {
    margin-right: 3px;
.contents {height:500px;}
.contents .nav-link:hover {background-color:lightslategrey;}
.content1 {background-color: #f4f4f4;}

.postContent-box {gap:5px 10px; padding-top:10px;} /* 상자 사이 간격   상하 5px/좌우 10px */
.post-box {width:300px;
		   box-sizing: border-box;
		   margin-right:10px;			} 
.content-text {font-size:12px; color:#888;}

}
</style>
	
	<section class="contents d-flex">
		<!-- 오른쪽 메뉴 -->
<div class=" content 1 col-10">
    <c:forEach items="${mainPage}" var="room">
        <div class="postContent-box d-flex flex-wrap justify-content-between">
            <article class="post-box">
                <img src="${room.imageUrl}" alt="${room.title}">
                <div class="font-weight-bold">${room.title}</div>
                <div class="content-text">${room.type}</div>
                <div class="content-text">${room.location}</div>
            </article>
        </div>
    </c:forEach>
</div>
		
	</section>

	<div class="content col-2">
		<ul>
			<div class="nav-item">
				<img
					src="https://www.iconninja.com/files/763/402/501/yellow-circle-icon.png"
					alt="아이콘"> <a href="#" class="nav-link font-weight-bold mr-5">하숙</a>
			</div>
			<div class="nav-item">
				<img
					src="https://www.iconninja.com/files/763/402/501/yellow-circle-icon.png"
					alt="아이콘"> <a href="#" class="nav-link font-weight-bold mr-5">룸메이트</a>
			</div>
			<div class="nav-item">
				<img
					src="https://www.iconninja.com/files/763/402/501/yellow-circle-icon.png"
					alt="아이콘"> <a href="#" class="nav-link font-weight-bold mr-5">타운하우스</a>
			</div>
			<div class="nav-item">
				<img
					src="https://www.iconninja.com/files/763/402/501/yellow-circle-icon.png"
					alt="아이콘"> <a href="#" class="nav-link font-weight-bold mr-5">스튜디오</a>
			</div>
		</ul>
		<!--  매물 추가하기 -->
		<div class="ml-5">
			<button type="button" class="btn btn-warning" id="postBtn">매물 추가하기</button>
		</div>
	</div>
</div>
<script>
$(document).ready(function(){
	$("#postBtn").on("click", function(){
		//alert("성공");
		location.href="/room/room-mine";
	});
});
</script>
