<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<div class="d-flex justify-content-center">
	<div class="w-50">
		<!--  진짜 사이즈의 가운데 정렬 -->
		<h1>매물올리기</h1>
			<div>
			매물의 종류:
			<select name="sf1" class="sf1 my-2" style="width: 200px; font-size: 14px;">
				<option value="wr-lodging">하숙</option>
				<option value="wr-roomMate">룸메이트</option>
				<option value="wr-townHouse">타운하우스</option>
				<option value="wr-studio">스튜디오</option>
			</select>
			
			</div>
		<h4>제목</h4>
		<input type="text" id="subject" class="form-control my-3" placeholder="제목을 입력하세요">
		<h4>내용</h4>
		<textarea id="content" class="form-control my-3" rows="10" placehodler="내용을 입력하세요"></textarea>
		<h4>가격</h4>
		<input type="text" id="price" class="form-control my-3" value="$"
			placeholder="가격을 기입하세요">
		<h4>매물 사진 업로드</h4>
		<div class="d-flex justify-content-end my-4">
			<input type="file" id="file" accept=".jpg, .jpeg, .png, .gif">
		</div>
		<div class="d-flex justify-content-between">
			<div style="margin-left: auto;">
				<button type="button" id="saveBtn" class="btn btn-primary">저장</button>
			</div>
		</div>
	</div>
	
</div>
<script>
$(document).ready(function(){
	$("#saveBtn").on('click', function(){
		let subject = $('#subject').val().trim();
		let content = $('#content').val().trim();
		let price = $('#price').val().trim();
		let fileName = $('#file').val();
		
		if(!subject){
			alert("제목을 입력하세요");
			return;
		}
		if(!content){
			alert("내용을 입력하세요");
			return;
		}
		if(!price){
			alert("가격을 입력하세요");
			return;
		}
		if(fileName){
			let pic = file.split(".").pop().toLowerCase();
			if($,inArray(pic, ['jpg','jpeg','png','gif']) == -1)){
			alert("이미지만 업로드 가능합니다");
			$("#file").val("");
			return;
		}
		}
		let formData = new FormData();
		formData.append("subject", subject); 
		formData.append("content", content);
		formData.append("file", $("#file")[0].files[0]); 
		//ajax
		type:"post"
		,url:"/room/roomMine"
		,data: formData
		, enctype:"multipart/form-data" 
		,processData:false 
		,contentType:false
		
		,success:function(data){
			if(data.result== "성공"){
				alert("게시글이 업로드 되었습니다")
				location.herf="/main/main-page";
			}else{
				alert(data.errorMessage);
			}
				
		}
		,error:function(request, error, status){
			alert("게시글을 업로드 하는데 실패했습니다");
		}
	});
});
</script>
