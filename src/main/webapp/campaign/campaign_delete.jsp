<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TreeEarth</title>
<link href="../css/index.css" rel="stylesheet">
<style type="text/css">
	#deleteForm {
		width: 300px;
		margin: auto;
		border: 1px;
		text-align: center;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		width: 300px;
		margin: auto;
		text-align: center;
	}
</style>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../hf/header.jsp"></jsp:include>
	<!-- 헤더 -->
	
	<section id="deleteForm">
	<h2>캠페인 게시글 삭제</h2>
		 <section>
			<form action="CampaignDeletePro.cp" method="post">
				<input type="hidden" name="cam_idx" value="${param.cam_idx }">
				<input type="hidden" name="pageNum" value="${param.pageNum }">
				<table>
					<tr>
						<td colspan="2">
							<input type="submit" value="삭제">&nbsp;&nbsp;
							<input type="button" value="돌아가기" onclick="javascript:history.back()">					
						</td>
					</tr>
				</table>
			</form>
		</section>
	</section>
	
	<!-- 푸더 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>
	<!-- 푸더 -->
</body>
</html>