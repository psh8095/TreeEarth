package vo.community;

import java.sql.Date;

/*
자유게시판 신고번호, 원글, 신고자, 신고 이유, 신고일

CREATE TABLE free_block(
	free_block_idx INT PRIMARY KEY,
	free_block_ref INT,
	free_block_id VARCHAR(50),
	free_block_reason VARCHAR(200),
	free_block_date DATE,
	FOREIGN KEY (free_block_ref) REFERENCES freeboard(free_idx) ON DELETE CASCADE,
	FOREIGN KEY (free_block_id) REFERENCES member(mem_id) ON DELETE CASCADE
); 
*/

public class FreeBoardBlockDTO {
	private int free_block_idx; // 신고번호
	private int free_block_ref; // 원글
	private String free_block_id; // 신고자
	private String free_block_reason; // 신고 이유
	private Date free_block_date; // 신고일
	
	public int getFree_block_idx() {
		return free_block_idx;
	}
	public void setFree_block_idx(int free_block_idx) {
		this.free_block_idx = free_block_idx;
	}
	public int getFree_block_ref() {
		return free_block_ref;
	}
	public void setFree_block_ref(int free_block_ref) {
		this.free_block_ref = free_block_ref;
	}
	public String getFree_block_id() {
		return free_block_id;
	}
	public void setFree_block_id(String free_block_id) {
		this.free_block_id = free_block_id;
	}
	public String getFree_block_reason() {
		return free_block_reason;
	}
	public void setFree_block_reason(String free_block_reason) {
		this.free_block_reason = free_block_reason;
	}
	public Date getFree_block_date() {
		return free_block_date;
	}
	public void setFree_block_date(Date free_block_date) {
		this.free_block_date = free_block_date;
	}
	
	@Override
	public String toString() {
		return "FreeBoardBlockDTO [free_block_idx=" + free_block_idx + ", free_block_ref=" + free_block_ref
				+ ", free_block_id=" + free_block_id + ", free_block_reason=" + free_block_reason + ", free_block_date="
				+ free_block_date + "]";
	}
	
}
