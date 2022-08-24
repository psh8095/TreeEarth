package vo.store;

import java.sql.Date;

/*
 * 아이디, 상품 번호, 상품 구매 평점, 상품 구매 후기 내용
 * 상품 구매 후기 사진 파일
CREATE TABLE store_review (
   mem_id VARCHAR(50),
   sto_idx INT,
   sto_re_idx INT PRIMARY KEY,
   sto_re_score INT CHECK (sto_re_score IN (1,2,3,4,5)),
   sto_re_content VARCHAR(300) NOT NULL,
   sto_re_file VARCHAR(30) NOT NULL,
   sto_re_real_file VARCHAR(30) NOT NULL,
   sto_re_date DATE NOT NULL,
   FOREIGN KEY (mem_id) REFERENCES member (mem_id) ON DELETE CASCADE,
   FOREIGN KEY (sto_idx) REFERENCES store (sto_idx) ON DELETE CASCADE
);
 */
public class StoreReviewDTO {

	private int sto_re_idx;
	private String mem_id;
	private int sto_idx;
	private int sto_re_score;
	private String sto_re_content;
	private String sto_re_file;
	private String sto_re_real_file;
	private String sto_subject;
	private Date sto_re_review;
	
	public String getSto_subject() {
		return sto_subject;
	}
	public void setSto_subject(String sto_subject) {
		this.sto_subject = sto_subject;
	}
	public int getSto_re_idx() {
		return sto_re_idx;
	}
	public void setSto_re_idx(int sto_re_idx) {
		this.sto_re_idx = sto_re_idx;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getSto_idx() {
		return sto_idx;
	}
	public void setSto_idx(int sto_idx) {
		this.sto_idx = sto_idx;
	}
	public int getSto_re_score() {
		return sto_re_score;
	}
	public void setSto_re_score(int sto_re_score) {
		this.sto_re_score = sto_re_score;
	}
	public String getSto_re_content() {
		return sto_re_content;
	}
	public void setSto_re_content(String sto_re_content) {
		this.sto_re_content = sto_re_content;
	}
	public String getSto_re_file() {
		return sto_re_file;
	}
	public void setSto_re_file(String sto_re_file) {
		this.sto_re_file = sto_re_file;
	}
	public String getSto_re_real_file() {
		return sto_re_real_file;
	}
	public void setSto_re_real_file(String sto_re_real_file) {
		this.sto_re_real_file = sto_re_real_file;
	}
	
	@Override
	public String toString() {
		return "StoreReviewDTO [sto_re_idx=" + sto_re_idx + ", mem_id=" + mem_id + ", sto_idx="
				+ sto_idx + ", sto_re_score=" + sto_re_score + ", sto_re_content=" + sto_re_content
				+ ", sto_re_file=" + sto_re_file + ", sto_re_real_file=" + sto_re_real_file + "]";
	}
	public Date getSto_re_review() {
		return sto_re_review;
	}
	public void setSto_re_review(Date sto_re_review) {
		this.sto_re_review = sto_re_review;
	}
	
}
