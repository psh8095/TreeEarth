package vo.community;

import java.sql.*;

/*
 * 캠페인 리뷰 글번호, 작성자, 제목, 내용, 조회수, 작성일, 상세파일*2, 썸네일 파일*2 
CREATE TABLE campaign_review (
	cam_re_idx INT PRIMARY KEY,
	cam_re_id VARCHAR(50),
	cam_re_subject VARCHAR(30) NOT NULL,
	cam_re_content VARCHAR(100) NOT NULL,
	cam_re_readcount INT NOT NULL,
	cam_re_date DATE NOT NULL,
	cam_re_file VARCHAR(100),
	cam_re_real_file VARCHAR(100),
	cam_re_thum_file VARCHAR(100),
	cam_re_thum_real_file VARCHAR(100),
	FOREIGN KEY (cam_re_id) REFERENCES member(mem_id) ON DELETE CASCADE
);
 */

public class CampaignReviewDTO {
	private int cam_re_idx;
	private String cam_re_id;
	private String cam_re_subject;
	private String cam_re_content;
	private int cam_re_readcount;
	private Date cam_re_date;
	private String cam_re_file;
	private String cam_re_real_file;
	private String cam_re_thum_file;
	private String cam_re_thum_real_file;
	
	public int getCam_re_idx() {
		return cam_re_idx;
	}
	public void setCam_re_idx(int cam_re_idx) {
		this.cam_re_idx = cam_re_idx;
	}
	public String getCam_re_id() {
		return cam_re_id;
	}
	public void setCam_re_id(String cam_re_id) {
		this.cam_re_id = cam_re_id;
	}
	public String getCam_re_subject() {
		return cam_re_subject;
	}
	public void setCam_re_subject(String cam_re_subject) {
		this.cam_re_subject = cam_re_subject;
	}
	public String getCam_re_content() {
		return cam_re_content;
	}
	public void setCam_re_content(String cam_re_content) {
		this.cam_re_content = cam_re_content;
	}
	public int getCam_re_readcount() {
		return cam_re_readcount;
	}
	public void setCam_re_readcount(int cam_re_readcount) {
		this.cam_re_readcount = cam_re_readcount;
	}
	public Date getCam_re_date() {
		return cam_re_date;
	}
	public void setCam_re_date(Date cam_re_date) {
		this.cam_re_date = cam_re_date;
	}
	public String getCam_re_file() {
		return cam_re_file;
	}
	public void setCam_re_file(String cam_re_file) {
		this.cam_re_file = cam_re_file;
	}
	public String getCam_re_real_file() {
		return cam_re_real_file;
	}
	public void setCam_re_real_file(String cam_re_real_file) {
		this.cam_re_real_file = cam_re_real_file;
	}
	public String getCam_re_thum_file() {
		return cam_re_thum_file;
	}
	public void setCam_re_thum_file(String cam_re_thum_file) {
		this.cam_re_thum_file = cam_re_thum_file;
	}
	public String getCam_re_thum_real_file() {
		return cam_re_thum_real_file;
	}
	public void setCam_re_thum_real_file(String cam_re_thum_real_file) {
		this.cam_re_thum_real_file = cam_re_thum_real_file;
	}
	
	@Override
	public String toString() {
		return "CampaignReviewDTO [cam_re_idx=" + cam_re_idx + ", cam_re_id=" + cam_re_id + ", cam_re_subject="
				+ cam_re_subject + ", cam_re_content=" + cam_re_content + ", cam_re_readcount=" + cam_re_readcount
				+ ", cam_re_date=" + cam_re_date + ", cam_re_file=" + cam_re_file + ", cam_re_real_file="
				+ cam_re_real_file + ", cam_re_thum_file=" + cam_re_thum_file + ", cam_re_thum_real_file="
				+ cam_re_thum_real_file + "]";
	}
	
}
