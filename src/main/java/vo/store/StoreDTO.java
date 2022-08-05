package vo.store;
/*
 * 상품 번호, 상품 가격, 상품 제목, 상품 내용, 상품 태그, 상품 분류
 * 상품 등록일자, 썸네일 파일, 내용 파일
CREATE TABLE store (
   sto_idx INT PRIMARY KEY,
   sto_price INT NOT NULL,
   sto_subject VARCHAR(30) NOT NULL,
   sto_content VARCHAR(2000) NOT NULL,
   sto_tag VARCHAR(20) NOT NULL,
   sto_category VARCHAR(20) NOT NULL,
   sto_date DATE NOT NULL,
   sto_thum_file VARCHAR(30) NOT NULL,
   sto_thum_real_file VARCHAR(30) NOT NULL,
   sto_content_file VARCHAR(30) NOT NULL,
   sto_content_real_file VARCHAR(30) NOT NULL
);
 */

import java.sql.Date;

public class StoreDTO {
	private int sto_idx;
	private int sto_price;
	private String sto_subject;
	private String sto_content;
	private String sto_tag;
	private String sto_category;
	private Date sto_date;
	private String sto_thum_file;
	private String sto_thum_real_file;
	private String sto_content_file;
	private String sto_content_real_file;
	
	public int getSto_idx() {
		return sto_idx;
	}
	public void setSto_idx(int sto_idx) {
		this.sto_idx = sto_idx;
	}
	public int getSto_price() {
		return sto_price;
	}
	public void setSto_price(int sto_price) {
		this.sto_price = sto_price;
	}
	public String getSto_subject() {
		return sto_subject;
	}
	public void setSto_subject(String sto_subject) {
		this.sto_subject = sto_subject;
	}
	public String getSto_content() {
		return sto_content;
	}
	public void setSto_content(String sto_content) {
		this.sto_content = sto_content;
	}
	public String getSto_tag() {
		return sto_tag;
	}
	public void setSto_tag(String sto_tag) {
		this.sto_tag = sto_tag;
	}
	public String getSto_category() {
		return sto_category;
	}
	public void setSto_category(String sto_category) {
		this.sto_category = sto_category;
	}
	public Date getSto_date() {
		return sto_date;
	}
	public void setSto_date(Date sto_date) {
		this.sto_date = sto_date;
	}
	public String getSto_thum_file() {
		return sto_thum_file;
	}
	public void setSto_thum_file(String sto_thum_file) {
		this.sto_thum_file = sto_thum_file;
	}
	public String getSto_thum_real_file() {
		return sto_thum_real_file;
	}
	public void setSto_thum_real_file(String sto_thum_real_file) {
		this.sto_thum_real_file = sto_thum_real_file;
	}
	public String getSto_content_file() {
		return sto_content_file;
	}
	public void setSto_content_file(String sto_content_file) {
		this.sto_content_file = sto_content_file;
	}
	public String getSto_content_real_file() {
		return sto_content_real_file;
	}
	public void setSto_content_real_file(String sto_content_real_file) {
		this.sto_content_real_file = sto_content_real_file;
	}
	
}
