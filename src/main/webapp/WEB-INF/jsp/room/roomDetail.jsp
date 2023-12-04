<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="d-flex justify-content-center">
	<h2>글 수정</h2>

	<input type="text" id="subject" class="form-control my-3"
		placeholder="제목을 입력하세요">
	<h4>내용</h4>
	<textarea id="content" class="form-control my-3" rows="10"
		placehodler="내용을 입력하세요"></textarea>
	<h4>가격</h4>
	<input type="text" id="price" class="form-control my-3" value="$"
		placeholder="가격을 기입하세요">
	<h4>매물 사진 업로드</h4>
	<c:if test="${not empty post.imageUrl}">
		<div class="my-4">
			<img src="${post.imageUrl}" alt="업로드 된 이미지" width="300">
		</div>
	</c:if>
	<div class="d-flex justify-content-between">
		<div style="margin-left: auto;">
			<a href="#" class="more-btn" data-toggle="modal" data-target="#modal">
				<button type="button" id="saveBtn" class="btn btn-primary">저장</button>
		</div>
		<div class="d-flex justify-content-between">
<%-- 			<button type="button" id="deleteBtn" class="btn btn-secondary"
				data-post-id="${post.id}">삭제</button> --%>

			<div>
				<a href="/post/post-detail" class="btn btn-dark">목록</a>
				<button type="button" id="saveBtn" class="btn btn-warning"
					data-post-id="${post.id}">수정</button>
					
			</div>
		</div>
	</div>
	<script>
	$(document).ready(function(){
		$('#saveBtn').on('click', function(){
			let postId = $(this).data("post-id");
			let subject = $('#subject').val().trim();
			let content = $('#content').val();
			let price = $('#price').val();
			let fileName = $("#file").val();
			
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
				let formData = new FormData();
				
				formData.append("postId", postId);
				formData.append("subject", subject); 
				formData.append("content", content);
				formData.append("file", $('#file')[0].files[0]);

				if (fileName) {
				//alert("확인");

				let ext = fileName.split(".").pop().toLowerCase();
				//alert(ext);
				
				if ($.inArray(ext, ['jpg', 'jpeg', 'png', 'gif']) == -1) {
					alert("이미지 파일만 업로드 할 수 있습니다.");
					$('#file').val("");
					return;
				}
				formData.append("file", $('#file')[0].files[0]);
				
			}
			$.ajax({
				// request
				type:"put"
				, url:"/main/update"
				, data:formData
				, enctype:"multipart/form-data" // 파일 업로드를 위한 필수 설정
				, processData:false // 파일 업로드를 위한 필수 설정
				, contentType:false // 파일 업로드를 위한 필수 설정
				
				// response
				, success:function(data) {
					if (data.result == "성공") {
						alert("메모가 수정되었습니다.");
						location.reload(true);
					} else {
						// 로직 실패
						alert(data.errorMessage);
					}
				}
				, error:function(request, status, error) {
					alert("글을 저장하는데 실패했습니다.");
				}
			});
		});
		
		// 글 삭제
		$("#deleteBtn").on("click", function() {
			let postId = $(this).data("post-id");
			//alert("확인");
			
			$.ajax({
				// request
				type:"DELETE"
				, url:"/main/delete"
				, data:{"postId":postId}
				
				// response
				, success:function(data) {
					if (data.code == 200) {
						alert("글이 삭제 되었습니다.");
						location.href = "/room/main-page";
					} else {
						alert(data.errorMessage);
					}
				}
				, error:function(request, status, error) {
					alert("삭제 하는데 실패했습니다.");
				}
			});
		});
	});
	</script>