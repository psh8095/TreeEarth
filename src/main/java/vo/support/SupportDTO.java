package vo.support;

import java.sql.Date;

/*
*후원글번호, 작성자ID, 제목, 목표금액, 후원종료날짜, 내용, 썸네일파일*2, 상세파일*2, 조회수, 총 후원금, 게시일자
CREATE TABLE support (
   sup_idx int primary key,
   mem_id VARCHAR(16),
   sup_subject VARCHAR(50) NOT NULL,
   sup_goal_price int NOT NULL,
   sup_goal_date Date NOT NULL,
   sup_content VARCHAR(1000) NOT NULL,
   sup_thumbnail_file varchar(100) not null,
   sup_thumbnail_real_file  varchar(100) not null,
   sup_original_file varchar(100) NOT NULL,
   sup_real_file varchar(100) NOT NULL,
   sup_readcount  int NOT NULL,
   sup_money int NOT NULL,
   sup_date Date NOT NULL,
   FOREIGN KEY (mem_id) REFERENCES member(mem_id) ON DELETE CASCADE
);
*/

public class SupportDTO {
	
	private int sup_idx;
	private String mem_id;
	private String sup_subject;
	private int sup_goal_price;
	private Date sup_goal_date;
	private String sup_content;
	private String sup_thumbnail_file;
	private String sup_thumbnail_real_file;
	private String sup_original_file;
	private String sup_real_file;
	private int sup_readcount;
	private int sup_money;
	private Date sup_date;
	
	public int getSup_idx() {
		return sup_idx;
	}
	public void setSup_idx(int sup_idx) {
		this.sup_idx = sup_idx;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getSup_subject() {
		return sup_subject;
	}
	public void setSup_subject(String sup_subject) {
		this.sup_subject = sup_subject;
	}
	public int getSup_goal_price() {
		return sup_goal_price;
	}
	public void setSup_goal_price(int sup_goal_price) {
		this.sup_goal_price = sup_goal_price;
	}
	public Date getSup_goal_date() {
		return sup_goal_date;
	}
	public void setSup_goal_date(Date sup_goal_date) {
		this.sup_goal_date = sup_goal_date;
	}
	public String getSup_content() {
		return sup_content;
	}
	public void setSup_content(String sup_content) {
		this.sup_content = sup_content;
	}
	public String getSup_thumbnail_file() {
		return sup_thumbnail_file;
	}
	public void setSup_thumbnail_file(String sup_thumbnail_file) {
		this.sup_thumbnail_file = sup_thumbnail_file;
	}
	public String getSup_thumbnail_real_file() {
		return sup_thumbnail_real_file;
	}
	public void setSup_thumbnail_real_file(String sup_thumbnail_real_file) {
		this.sup_thumbnail_real_file = sup_thumbnail_real_file;
	}
	public String getSup_original_file() {
		return sup_original_file;
	}
	public void setSup_original_file(String sup_original_file) {
		this.sup_original_file = sup_original_file;
	}
	public String getSup_real_file() {
		return sup_real_file;
	}
	public void setSup_real_file(String sup_real_file) {
		this.sup_real_file = sup_real_file;
	}
	public int getSup_readcount() {
		return sup_readcount;
	}
	public void setSup_readcount(int sup_readcount) {
		this.sup_readcount = sup_readcount;
	}
	public int getSup_money() {
		return sup_money;
	}
	public void setSup_money(int sup_money) {
		this.sup_money = sup_money;
	}
	public Date getSup_date() {
		return sup_date;
	}
	public void setSup_date(Date sup_date) {
		this.sup_date = sup_date;
	}
	
	@Override
	public String toString() {
		return "SupportDTO [sup_idx=" + sup_idx + ", mem_id=" + mem_id + ", sup_subject=" + sup_subject
				+ ", sup_goal_price=" + sup_goal_price + ", sup_goal_date=" + sup_goal_date + ", sup_content="
				+ sup_content + ", sup_thumbnail_file=" + sup_thumbnail_file + ", sup_thumbnail_real_file="
				+ sup_thumbnail_real_file + ", sup_original_file=" + sup_original_file + ", sup_real_file="
				+ sup_real_file + ", sup_readcount=" + sup_readcount + ", sup_money=" + sup_money + ", sup_date="
				+ sup_date + "]";
	}
	
}
