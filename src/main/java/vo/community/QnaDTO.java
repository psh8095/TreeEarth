package vo.community;

import java.sql.*;

/*
 * 글번호, 작성자, 카테고리(FAQ, 배송문의, 교환반품문의, 상품문의, 기타문의), 질문, 답변, 작성일
 CREATE TABLE qna(
	qna_idx int PRIMARY KEY,
	qna_id VARCHAR(50),
	qna_tag VARCHAR(10) NOT NULL,
	qna_subject VARCHAR(50) NOT NULL,
	qna_content VARCHAR(100),
	qna_date DATE NOT NULL,
	FOREIGN KEY (qna_id) REFERENCES member(mem_id) ON DELETE CASCADE
);
 */

public class QnaDTO {

	private int qna_idx;
	private String qna_id;
	private String qna_tag;
	private String qna_subject;
	private String qna_content;
	private Date qna_date;
	
	public int getQna_idx() {
		return qna_idx;
	}
	public void setQna_idx(int qna_idx) {
		this.qna_idx = qna_idx;
	}
	public String getQna_id() {
		return qna_id;
	}
	public void setQna_id(String qna_id) {
		this.qna_id = qna_id;
	}
	public String getQna_tag() {
		return qna_tag;
	}
	public void setQna_tag(String qna_tag) {
		this.qna_tag = qna_tag;
	}
	public String getQna_subject() {
		return qna_subject;
	}
	public void setQna_subject(String qna_subject) {
		this.qna_subject = qna_subject;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public Date getQna_date() {
		return qna_date;
	}
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}
	
	@Override
	public String toString() {
		return "QnaDTO [qna_idx=" + qna_idx + ", qna_id=" + qna_id + ", qna_tag=" + qna_tag + ", qna_subject="
				+ qna_subject + ", qna_content=" + qna_content + ", qna_date=" + qna_date
				+ "]";
	}
	
}
