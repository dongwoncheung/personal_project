<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

			<div class="postContent-box d-flex flex-wrap justify-content-between">
				<article class="post-box">
					<img
						src="https://www.radiokorea.com/bulletin/data/file/c_realestate/1273884075_Lu2GQwxX_IMG_1097.jpg"
						alt="잇츠원 유태양">
					<div class="font-weight-bold">test1</div>
					<div class="content-text">하숙</div>
					<div class="content-text">부에나팍</div>
				</article>
				<article class="post-box">
					<img
						src="https://www.radiokorea.com/bulletin/data/file/c_realestate/401827735_1T3UdO8y_7E596E45-0B32-4D2E-AF4E-DDC4A592CEA8.jpg"
						alt="아이즈원 권은비">
					<div class="font-weight-bold">test2</div>
					<div class="content-text">하숙</div>
					<div class="content-text">풀러턴</div>
				</article>
				<article class="post-box">
					<img
						src="https://www.radiokorea.com/bulletin/data/file/c_realestate/1745442635_2H8JIxsG_1699830935349.jpg"
						alt="스트레이 키즈 리노">
					<div class="font-weight-bold">test3</div>
					<div class="media-info-text">N-net Ent</div>
					<div class="content-text">풀러턴</div>
				</article>
				<article class="post-box">
					<img
						src="https://www.radiokorea.com/bulletin/data/file/c_realestate/3283460896_TH8tWZl1_3.jpg"
						alt="아이즈원 장원영">
					<div class="font-weight-bold">test4</div>
					<div class="content-text">하숙</div>
					<div class="content-text">애너하임</div>
				</article>
				<article class="post-box mr-3">
					<img
						src="https://www.radiokorea.com/bulletin/data/file/c_realestate/2893492055_l1xaIwos_IMG_0085.JPG"
						alt="NCT DREAM 제노">
					<div class="font-weight-bold">test5</div>
					<div class="content-text">하숙</div>
					<div class="content-text">코리아타운</div>
				</article>
				<article class="post-box">
					<img
						src="https://www.radiokorea.com/bulletin/data/file/c_realestate/2935199457_x5wBDoAF_IMG_20231001_141057.jpg"
						alt="아이즈원 미야와키 사쿠라">
					<div class="font-weight-bold">test6</div>
					<div class="content-text">얼바인</div>
				</article>


			</div>
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
	</div>
</div>
