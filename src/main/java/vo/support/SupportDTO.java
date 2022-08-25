package vo.support;

import java.sql.Date;


//서포트 테이블
/*후원글번호, 후원 제목, 목표금액, 목표날짜, 내용, 썸네일파일*2, 파일*2, 조회수, 사이트 총 후원금액, 각 후원당 총 금액, 게시일 
CREATE TABLE support (
		   sup_idx int primary key,
		   sup_subject VARCHAR(50) NOT NULL,
		   sup_goal_price int NOT NULL,
		   sup_goal_date Date NOT NULL,
		   sup_content VARCHAR(1000) NOT NULL,
		   sup_thumbnail_file varchar(100) not null,
		   sup_thumbnail_real_file  varchar(100) not null,
		   sup_original_file varchar(100) NOT NULL,
		   sup_real_file varchar(100) NOT NULL,
		   sup_readcount  int NOT NULL,
		   sup_total int NOT NULL,
		   sup_money int NOT NULL,
		   sup_date Date NOT NULL
		);
*/

public class SupportDTO {
	
	private int sup_idx; //1
	private String sup_subject; //2
	private String sup_pass; //3
	private int sup_goal_price; //4
	private Date sup_goal_date;//5
	private String sup_content; //6
	private String sup_thumbnail_file; //7
	private String sup_thumbnail_real_file; //8
	private String sup_real_file; //9
	private String sup_original_file; //10
	private int sup_readcount; //11
	private int sup_total; //12
	private int sup_money; //14
	private Date sup_date; //14
	
	
	
	public int getSup_total() {
		return sup_total;
	}
	public void setSup_total(int sup_total) {
		this.sup_total = sup_total;
	}



	
	
	
	public Date getSup_goal_date() {
		return sup_goal_date;
	}
	public void setSup_goal_date(Date sup_goal_date) {
		this.sup_goal_date = sup_goal_date;
	}
	public int getSup_idx() {
		return sup_idx;
	}
	public void setSup_idx(int sup_idx) {
		this.sup_idx = sup_idx;
	}
	public int getSup_goal_price() {
		return sup_goal_price;
	}
	public void setSup_goal_price(int sup_goal_price) {
		this.sup_goal_price = sup_goal_price;
	}
	public String getSup_pass() {
		return sup_pass;
	}
	public void setSup_pass(String sup_pass) {
		this.sup_pass = sup_pass;
	}
	public String getSup_subject() {
		return sup_subject;
	}
	public void setSup_subject(String sup_subject) {
		this.sup_subject = sup_subject;
	}
	public String getSup_content() {
		return sup_content;
	}
	public void setSup_content(String sup_content) {
		this.sup_content = sup_content;
	}
	public String getSup_thumbnail_real_file() {
		return sup_thumbnail_real_file;
	}
	public void setSup_thumbnail_real_file(String sup_thumbnail_real_file) {
		this.sup_thumbnail_real_file = sup_thumbnail_real_file;
	}
	public String getSup_thumbnail_file() {
		return sup_thumbnail_file;
	}
	public void setSup_thumbnail_file(String sup_thumbnail_file) {
		this.sup_thumbnail_file = sup_thumbnail_file;
	}
	public String getSup_real_file() {
		return sup_real_file;
	}
	public void setSup_real_file(String sup_real_file) {
		this.sup_real_file = sup_real_file;
	}
	public String getSup_original_file() {
		return sup_original_file;
	}
	public void setSup_original_file(String sup_original_file) {
		this.sup_original_file = sup_original_file;
	}
	public int getSup_money() {
		return sup_money;
	}
	public void setSup_money(int sup_money) {
		this.sup_money = sup_money;
	}
	public int getSup_readcount() {
		return sup_readcount;
	}
	public void setSup_readcount(int sup_readcount) {
		this.sup_readcount = sup_readcount;
	}
	public Date getSup_date() {
		return sup_date;
	}
	public void setSup_date(Date sup_date) {
		this.sup_date = sup_date;
	}
	
	
	@Override
	public String toString() {
		return "SupportDTO [sup_idx=" + sup_idx + ", sup_goal_price=" + sup_goal_price + ", sup_pass=" + sup_pass
				+ ", sup_subject=" + sup_subject + ", sup_content=" + sup_content + ", sup_thumbnail_real_file="
				+ sup_thumbnail_real_file + ", sup_thumbnail_file=" + sup_thumbnail_file + ", sup_real_file="
				+ sup_real_file + ", sup_original_file=" + sup_original_file + ", sup_money=" + sup_money
				+ ", sup_readcount=" + sup_readcount + ", sup_date=" + sup_date + "]";
	}
	

	
	
	


	
	
}
