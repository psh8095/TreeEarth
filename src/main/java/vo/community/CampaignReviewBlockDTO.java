package vo.community;

import java.sql.*;

/*
 * 캠페인리뷰 신고번호, 원글, 신고자, 신고 이유, 신고일
CREATE TABLE cam_re_block(
	cam_re_block_idx INT PRIMARY KEY,
	cam_re_block_ref INT,
	cam_re_block_id VARCHAR(50),
	cam_re_block_reason VARCHAR(200),
	cam_re_block_date DATE,
	FOREIGN KEY (cam_re_block_ref) REFERENCES campaign_review(cam_re_idx) ON DELETE CASCADE,
	FOREIGN KEY (cam_re_block_id) REFERENCES member(mem_id) ON DELETE CASCADE
); 
*/

public class CampaignReviewBlockDTO {

	private int cam_re_block_idx;
	private int cam_re_block_ref;
	private String cam_re_block_id;
	private String cam_re_block_reason;
	private Date cam_re_block_date;
	
	public int getCam_re_block_idx() {
		return cam_re_block_idx;
	}
	public void setCam_re_block_idx(int cam_re_block_idx) {
		this.cam_re_block_idx = cam_re_block_idx;
	}
	public int getCam_re_block_ref() {
		return cam_re_block_ref;
	}
	public void setCam_re_block_ref(int cam_re_block_ref) {
		this.cam_re_block_ref = cam_re_block_ref;
	}
	public String getCam_re_block_id() {
		return cam_re_block_id;
	}
	public void setCam_re_block_id(String cam_re_block_id) {
		this.cam_re_block_id = cam_re_block_id;
	}
	public String getCam_re_block_reason() {
		return cam_re_block_reason;
	}
	public void setCam_re_block_reason(String cam_re_block_reason) {
		this.cam_re_block_reason = cam_re_block_reason;
	}
	public Date getCam_re_block_date() {
		return cam_re_block_date;
	}
	public void setCam_re_block_date(Date cam_re_block_date) {
		this.cam_re_block_date = cam_re_block_date;
	}
	
	@Override
	public String toString() {
		return "CampaignReviewBlockDTO [cam_re_block_idx=" + cam_re_block_idx + ", cam_re_block_ref=" + cam_re_block_ref
				+ ", cam_re_block_id=" + cam_re_block_id + ", cam_re_block_reason=" + cam_re_block_reason
				+ ", cam_re_block_date=" + cam_re_block_date + "]";
	}
	
}
