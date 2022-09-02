<%@page import="vo.support.SupportDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%
	// dto 객체 어트리뷰트로 받기
	SupportDTO dto = (SupportDTO)request.getAttribute("dto");
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Support 글 수정</title>
</head>
<body>
<jsp:include page="../hf/header.jsp"></jsp:include>

	<!-- top -->
   <jsp:include page="../hf/top.jsp" ></jsp:include>
	<!-- top -->

<section id="writeForm">
		<h2>후원 수정</h2>
		<form action="SupportModifyProAdmin.su" method="post"
			enctype="multipart/form-data" name="boardform">
				<input type="hidden" name="sup_idx" value="<%=dto.getSup_idx()%>">
<%-- 			<input type="hidden" name="pageNum" value="${param.pageNum }"> --%>
			<table>
			
			
				<tr>
					<td class="td_left"><label for="sup_subject">제목</label></td>
					<td class="td_right"><input type="text" name="sup_subject"
						id="board_name" value="<%=dto.getSup_subject() %>" required="required"></td>
				</tr>
				<tr>
					<td><label for="mem_pass">비밀번호</label></td>
					<td>
						<input type="password" name="mem_pass" required="required">
					</td>
				</tr>
				
				
				<tr>
					<td class="td_left"><label for="sup_goal_date">목표 날짜</label></td>
					<td class="td_right"><input type="date" name="sup_goal_date"
						id="board_subject" value="<%=dto.getSup_goal_date() %>"required="required"></td>
				</tr>
				
				
				<tr>
					<td class="td_left"><label for="sup_goal_price">목표 금액</label></td>
					<td class="td_right"><input type="text" name="sup_goal_price"
						id="board_subject" value="<%=dto.getSup_goal_price() %>"required="required"></td>
				</tr>
				
				
				<tr>
					<td class="td_left"><label for="sup_content">내용</label></td>
					<td><textarea name="sup_content" rows="15" cols="40" required="required"><%=dto.getSup_content() %></textarea>
					</td>
				</tr>
				
				
				<tr>
					<td class="td_left"><label for="sup_thumbnail_file">썸네일 파일 첨부</label></td>
					<td class="td_right"><input name="sup_thumbnail_file" type="file"
						 value="<%=dto.getSup_thumbnail_file() %>"required="required"></td>
				</tr>
				
				
				<tr>
					<td class="td_left"><label for="sup_original_file">파일 첨부</label></td>
					<td class="td_right"><input name="sup_original_file" type="file"
						 value="<%=dto.getSup_original_file() %>"required="required"></td>
				</tr>
				
				
			</table>
			<section id="commandCell">
				<input type="submit" value="수정">&nbsp;&nbsp; 
				<input type="reset" value="다시쓰기" />&nbsp;&nbsp;
					<input type="button" value="취소" onclick="history.back()">
			</section>
		</form>
	</section>
	    
    <!-- 푸터 -->
	<jsp:include page="../hf/footer.jsp"></jsp:include>

</body>
</html>