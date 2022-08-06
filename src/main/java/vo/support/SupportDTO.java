package vo.support;

import java.sql.Date;

//팀프로젝트 데이터 베이스
//서포트 테이블 생성

//CREATE TABLE support (
//	sup_idx int primary key
//REFERENCES  member( mem_id ),
//	sup_goal_price int NOT NULL,
//	sup_now_total int NOT NULL,
//	sup_total  int NOT NULL,
//sup_money  int NOT NULL,
//sup_readcount  int NOT NULL,
//	sup_date Date NOT NULL,
//sup_subject VARCHAR(50) NOT NULL,
//sup_content VARCHAR(1000) NOT NULL,
//sup_original_file varchar(100) NOT NULL,
//sup_real_file varchar(100) NOT NULL,
//sup_thumbnail_file varchar(100) not null,
// sup_thumbnail_real_file  varchar(100) not null,
//sup_pass varchar(20) not null
//);


public class SupportDTO {
	
	private int sup_idx;
	private String sup_pass;
	private int sup_goal_price;
	private int sup_now_total;
	private int sup_total;
	private int sup_money;
	private int sup_readcount;
	private Date sup_date;
	private String sup_subject;
	private String sup_content;
	private String sup_original_file;
	private String sup_real_file;
	private String sup_thumbnail_real_file;
	private String sup_thumbnail_file;
	
	public String getSup_original_file() {
		return sup_original_file;
	}
	public void setSup_original_file(String sup_original_file) {
		this.sup_original_file = sup_original_file;
	}
	public String getSup_thumbnail_file() {
		return sup_thumbnail_file;
	}
	public void setSup_thumbnail_file(String sup_thumbnail_file) {
		this.sup_thumbnail_file = sup_thumbnail_file;
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
	public int getSup_now_total() {
		return sup_now_total;
	}
	public void setSup_now_total(int sup_now_total) {
		this.sup_now_total = sup_now_total;
	}
	public int getSup_total() {
		return sup_total;
	}
	public void setSup_total(int sup_total) {
		this.sup_total = sup_total;
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
	public String getSup_subject() {
		return sup_subject;
	}
	public String getSup_pass() {
		return sup_pass;
	}
	public void setSup_pass(String sup_pass) {
		this.sup_pass = sup_pass;
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
	public String getSup_real_file() {
		return sup_real_file;
	}
	public void setSup_real_file(String sup_real_file) {
		this.sup_real_file = sup_real_file;
	}
	public String getSup_thumbnail_real_file() {
		return sup_thumbnail_real_file;
	}
	public void setSup_thumbnail_real_file(String sup_thumbnail_real_file) {
		this.sup_thumbnail_real_file = sup_thumbnail_real_file;
	}
	@Override
	public String toString() {
		return "SupportDTO [sup_idx=" + sup_idx + ", sup_goal_price=" + sup_goal_price + ", sup_now_total="
				+ sup_now_total + ", sup_total=" + sup_total + ", sup_money=" + sup_money + ", sup_readcount="
				+ sup_readcount + ", sup_date=" + sup_date + ", sup_subject=" + sup_subject + ", sup_content="
				+ sup_content + ", sup_original_file=" + sup_original_file + ", sup_thumbnail_file="
				+ sup_thumbnail_file + "]";
	}


	
	
}
