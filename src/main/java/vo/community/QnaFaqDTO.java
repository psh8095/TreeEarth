package vo.community;

import java.sql.*;

/*
 *자주묻는질문. 글번호, 제목(질문), 내용(답변), 작성일
CREATE TABLE QnaFaq(
	faq_idx int PRIMARY KEY,
	faq_subject VARCHAR(50) NOT NULL,
	faq_content VARCHAR(100) NOT NULL,
	faq_date DATE NOT NULL
);
 */

public class QnaFaqDTO {
	
	private int faq_idx;
	private String faq_subject;
	private String faq_content;
	private Date faq_date;
	
	public int getFaq_idx() {
		return faq_idx;
	}
	public void setFaq_idx(int faq_idx) {
		this.faq_idx = faq_idx;
	}
	public String getFaq_subject() {
		return faq_subject;
	}
	public void setFaq_subject(String faq_subject) {
		this.faq_subject = faq_subject;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}
	public Date getFaq_date() {
		return faq_date;
	}
	public void setFaq_date(Date faq_date) {
		this.faq_date = faq_date;
	}
	
	@Override
	public String toString() {
		return "QnaFaqDTO [faq_idx=" + faq_idx + ", faq_subject=" + faq_subject + ", faq_content=" + faq_content
				+ ", faq_date=" + faq_date + "]";
	}

}
