<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<script type="text/javascript">
	function blockForm() {
		window.open("CampaignReviewBlockForm.cm?cam_re_idx=${campaign_review.cam_re_idx}&pageNum=${param.pageNum}", 
				'treeEarth', 'width=450,height=550');
	}
</script>
<link href="../css/index.css" rel="stylesheet">
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	<section id="">
		<h2>글 상세내용 보기</h2>
		
		<section id="container">
			<table>
			<tr><th width="70">제 목</th><td colspan="3" >${campaign_review.cam_re_subject }</td></tr>
			<tr>
				<th width="70">작성자</th><td>${campaign_review.cam_re_id }</td>
				<th width="70">작성일</th><td>${campaign_review.cam_re_date }</td>
			</tr>
			<tr>
				<th width="70">첨부파일</th>
				<td>
					<a href="img/community/${campaign_review.cam_re_real_file }">
						${campaign_review.cam_re_file }
					</a>
				</td>
				<th width="70">조회수</th>
				<td>${campaign_review.cam_re_readcount }</td>
			</tr>
			<tr>
				<th width="70">내용</th>
				<td>
					${campaign_review.cam_re_content }<br><br>
					<img alt="${campaign_review.cam_re_file }" src="img/community/${campaign_review.cam_re_real_file }">
				</td>
			</tr>
			</table>
		</section>
	</section>
	
	<section id="">
		<input type="button" value="수정" onclick="location.href='CampaignReviewModifyForm.cm?cam_re_idx=${campaign_review.cam_re_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="삭제" onclick="location.href='CampaignReviewDeleteForm.cm?cam_re_idx=${campaign_review.cam_re_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="목록" onclick="location.href='CampaignReviewList.cm?pageNum=${param.pageNum}'">
		
		<c:if test="${not empty sessionScope.sId}">
			<input type="button" value="신고하기" onclick="blockForm()">
		</c:if>
	</section>
	
	<!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸터 -->
</body>
</html>