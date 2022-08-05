package vo.community;

/*
 * 캠페인리뷰 신고자, 신고하는 내용, 신고 이유
CREATE TABLE cam_re_block(
	cam_re_id VARCHAR(50) REFERENCES member(mem_id),
	cam_re_content VARCHAR(100) REFERENCES campaign_review(cam_re_content),
	cam_re_block_reason VARCHAR(200)
); 
*/

public class CampaignReviewBlockDTO {
	private String cam_re_id;
	private String cam_re_content;
	private String cam_re_block_reason;
	
	public String getCam_re_id() {
		return cam_re_id;
	}
	public void setCam_re_id(String cam_re_id) {
		this.cam_re_id = cam_re_id;
	}
	public String getCam_re_content() {
		return cam_re_content;
	}
	public void setCam_re_content(String cam_re_content) {
		this.cam_re_content = cam_re_content;
	}
	public String getCam_re_block_reason() {
		return cam_re_block_reason;
	}
	public void setCam_re_block_reason(String cam_re_block_reason) {
		this.cam_re_block_reason = cam_re_block_reason;
	}
	
}
