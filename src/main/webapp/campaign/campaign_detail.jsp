<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<link href="../css/index.css" rel="stylesheet">
<style type="text/css">
#articleForm {
		width: 500px;
		height: 550px;
		border: 1px;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		border: 1px solid black;
		border-collapse: collapse; 
	 	width: 500px;
	}
	
	th {
		text-align: center;
	}
	
	td {
		width: 150px;
		text-align: center;
	}
	
	#basicInfoArea {
		height: 70px;
		text-align: center;
	}
	
	#articleContentArea {
		background: skyblue;
		margin-top: 20px;
		height: 350px;
		text-align: center;
		overflow: auto;
		white-space: pre-line;
	}
	
	#commandList {
		margin: auto;
		width: 500px;
		text-align: center;
	}

</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<section id="articleForm">
		<h2>캠페인 상세내용 보기</h2>
		
		<section id="basicInfoArea">
			<table border="1">
			<tr><th width="70">제목</th><td colspan="3">${campaign.cam_subject }</td></tr>
			<tr>
				<th width="70">작성일</th><td>${campaign.cam_date }</td>
				<th width="70">조회수</th><td>${campaign.cam_readcount }</td>
			</tr>
			<tr><th width="70">첨부파일</th>
				<td colspan="3">
				<a href="upload/${campaign.cam_original_img }"></a>
				</td>
			</tr>
			</table>
			<section id="articleContentArea">
				${campaign.cam_content }
			</section>
		</section>
	</section>	
	<section id="commandList">
		<input type="button" value="수정" onclick="location.href='CampaignModifyForm.cp?cam_idx=${campaign.cam_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="삭제" onclick="location.href='CampaignDeleteForm.cp?cam_idx=${campaign.cam_idx}&pageNum=${param.pageNum}'">
		<input type="button" value="목록" onclick="location.href='CampaignList.cp?cam_idx=${campaign.cam_idx}&pageNum=${param.pageNum}'">
	</section>		
		
	<!-- 푸더 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸더 -->
</body>
</html>