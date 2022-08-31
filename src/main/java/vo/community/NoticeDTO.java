package vo.community;

import java.sql.Date;

/*

CREATE TABLE notice (
	no_idx INT PRIMARY KEY,
	no_id VARCHAR(50),
	no_subject VARCHAR(30) NOT NULL,
	no_content VARCHAR(100) NOT NULL,
	no_img VARCHAR(100),
	no_date date NOT NULL,
	FOREIGN KEY (no_id) REFERENCES member(mem_id) ON DELETE CASCADE
);

 */

public class NoticeDTO {
	private int no_idx; // 글 번호
	private String no_id; // 작성자
	private String no_subject; // 제목
	private String no_content; // 내용
	private String no_img; // 이미지첨부
	private Date no_date; // 날짜
	
	public int getNo_idx() {
		return no_idx;
	}
	public void setNo_idx(int no_idx) {
		this.no_idx = no_idx;
	}
	public String getNo_id() {
		return no_id;
	}
	public void setNo_id(String no_id) {
		this.no_id = no_id;
	}
	public String getNo_subject() {
		return no_subject;
	}
	public void setNo_subject(String no_subject) {
		this.no_subject = no_subject;
	}
	public String getNo_content() {
		return no_content;
	}
	public void setNo_content(String no_content) {
		this.no_content = no_content;
	}
	public String getNo_img() {
		return no_img;
	}
	public void setNo_img(String no_img) {
		this.no_img = no_img;
	}
	public Date getNo_date() {
		return no_date;
	}
	public void setNo_date(Date no_date) {
		this.no_date = no_date;
	}
	
	@Override
	public String toString() {
		return "NoticeDTO [no_idx=" + no_idx + ", no_id=" + no_id + ", no_subject=" + no_subject + ", no_content="
				+ no_content + ", no_img=" + no_img + ", no_date=" + no_date + "]";
	}
	
}
