package vo.support;

import java.sql.Date;

/*
 *후원번호, 회원id, 후원글번호, 후원금액, 후원일시
CREATE TABLE supportHistory(
	suphi_idx int PRIMARY KEY,
	mem_id VARCHAR(50) NOT NULL, 
	sup_idx int NOT NULL,
	suphi_money int NOT NULL,
	suphi_date DATE NOT NULL,
	FOREIGN KEY (mem_id) REFERENCES member(mem_id) ON DELETE CASCADE,
	FOREIGN KEY (sup_idx) REFERENCES support(sup_idx) ON DELETE CASCADE
); 
 */

public class SupportHistoryDTO {

	private int suphi_idx;
	private String mem_id;
	private int sup_idx;
	private int suphi_money;
	private Date suphi_date;
	
	public int getSuphi_idx() {
		return suphi_idx;
	}
	public void setSuphi_idx(int suphi_idx) {
		this.suphi_idx = suphi_idx;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getSup_idx() {
		return sup_idx;
	}
	public void setSup_idx(int sup_idx) {
		this.sup_idx = sup_idx;
	}
	public int getSuphi_money() {
		return suphi_money;
	}
	public void setSuphi_money(int suphi_money) {
		this.suphi_money = suphi_money;
	}
	public Date getSuphi_date() {
		return suphi_date;
	}
	public void setSuphi_date(Date suphi_date) {
		this.suphi_date = suphi_date;
	}
	
	@Override
	public String toString() {
		return "SupportHistoryDTO [suphi_idx=" + suphi_idx + ", mem_id=" + mem_id + ", sup_idx=" + sup_idx
				+ ", suphi_money=" + suphi_money + ", suphi_date=" + suphi_date + "]";
	}
	
}
