package vo.store;

import java.sql.Date;

/*
아이디, 상품 번호, 문의글 번호, 상품 문의 내용,
CREATE TABLE store_qna (
	mem_id VARCHAR(50),
	sto_idx INT,
	sto_qna_idx INT PRIMARY KEY,
	sto_qna_content VARCHAR(300) NOT NULL,
	FOREIGN KEY (mem_id) REFERENCES member (mem_id) ON DELETE CASCADE,
	FOREIGN KEY (sto_idx) REFERENCES store (sto_idx) ON DELETE CASCADE
);
 */
public class StoreQnaDTO {
	private int sto_qna_idx; // 문의글 번호
	private String mem_id; // 아이디
	private int sto_idx; // 상품 번호
	private String sto_qna_content; // 상품 문의 내용
	private Date sto_qna_date;
	
	public int getSto_qna_idx() {
		return sto_qna_idx;
	}
	public void setSto_qna_idx(int sto_qna_idx) {
		this.sto_qna_idx = sto_qna_idx;
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
	public String getSto_qna_content() {
		return sto_qna_content;
	}
	public void setSto_qna_content(String sto_qna_content) {
		this.sto_qna_content = sto_qna_content;
	}
	public Date getSto_qna_date() {
		return sto_qna_date;
	}
	public void setSto_qna_date(Date sto_qna_date) {
		this.sto_qna_date = sto_qna_date;
	}
	
	@Override
	public String toString() {
		return "StoreQnaDTO [sto_qna_idx=" + sto_qna_idx + ", mem_id=" + mem_id + ", sto_idx="
				+ sto_idx + ", sto_qna_content=" + sto_qna_content + ", sto_qna_date" + sto_qna_date + "]";
	}
		
}














