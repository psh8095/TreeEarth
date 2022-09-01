package vo.community;

import java.sql.Date;

/*
반려나무 성장일지 테이블 생성
CREATE TABLE diary (
	diary_idx int PRIMARY KEY,
	diary_id VARCHAR(50), 
	diary_subject VARCHAR(30) NOT NULL,
	diary_content VARCHAR(70) NOT NULL,
	diary_img  VARCHAR(100),
	diary_real_img VARCHAR(100),
	diary_thumb_img VARCHAR(100),
	diary_thumb_real_img VARCHAR(100),
	diary_readcount INT NOT NULL,
	diary_likecnt INT NOT NULL,
	diary_date date,
	FOREIGN KEY (diary_id) REFERENCES member(mem_id) ON DELETE CASCADE
	);
*/

public class DiaryDTO {
	private int diary_idx;
	private String diary_id;
	private String diary_subject;
	private String diary_content;
	private String diary_img;
	private String diary_real_img;
	private String diary_thumb_img;
	private String diary_thumb_real_img;
	private int diary_readcount;
	private int diary_likecnt;
	private Date diary_date;
	
	public int getDiary_idx() {
		return diary_idx;
	}
	public void setDiary_idx(int diary_idx) {
		this.diary_idx = diary_idx;
	}
	public String getDiary_id() {
		return diary_id;
	}
	public void setDiary_id(String diary_id) {
		this.diary_id = diary_id;
	}
	public String getDiary_subject() {
		return diary_subject;
	}
	public void setDiary_subject(String diary_subject) {
		this.diary_subject = diary_subject;
	}
	public String getDiary_content() {
		return diary_content;
	}
	public void setDiary_content(String diary_content) {
		this.diary_content = diary_content;
	}
	public String getDiary_thumb_img() {
		return diary_thumb_img;
	}
	public void setDiary_thumb_img(String diary_thumb_img) {
		this.diary_thumb_img = diary_thumb_img;
	}
	public String getDiary_thumb_real_img() {
		return diary_thumb_real_img;
	}
	public void setDiary_thumb_real_img(String diary_thumb_real_img) {
		this.diary_thumb_real_img = diary_thumb_real_img;
	}
	public String getDiary_img() {
		return diary_img;
	}
	public void setDiary_img(String diary_img) {
		this.diary_img = diary_img;
	}
	public String getDiary_real_img() {
		return diary_real_img;
	}
	public void setDiary_real_img(String diary_real_img) {
		this.diary_real_img = diary_real_img;
	}
	public int getDiary_readcount() {
		return diary_readcount;
	}
	public void setDiary_readcount(int diary_readcount) {
		this.diary_readcount = diary_readcount;
	}
	public int getDiary_likecnt() {
		return diary_likecnt;
	}
	public void setDiary_likecnt(int diary_likecnt) {
		this.diary_likecnt = diary_likecnt;
	}
	public Date getDiary_date() {
		return diary_date;
	}
	public void setDiary_date(Date diary_date) {
		this.diary_date = diary_date;
	}
	


}
