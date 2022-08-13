package vo.campaign;

import java.sql.Date;

/*
*캠페인 아이디, 글번호, 참여인원, 제목, 내용, 조회수, 작성일, 썸네일파일*2, 이미지파일*2 

CREATE TABLE campaign(
	cam_id VARCHAR(50) REFERENCES member(mem_id),
	cam_idx INT PRIMARY KEY,
	cam_people INT NOT NULL,
	cam_subject VARCHAR(50) NOT NULL, 
	cam_content VARCHAR(2000) NOT NULL,
	cam_readcount INT DEFAULT 0,
	cam_date DATE,
	cam_thum_file VARCHAR(100),
	cam_thum_real_file VARCHAR(100),
	cam_img VARCHAR(100),
	cam_original_img VARCHAR(100)
);
 */


public class CampaignDTO{
	private String cam_id;
	private int cam_idx;
	private int cam_people;
	private String cam_subject;
	private String cam_content;
	private int cam_readcount;
	private Date cam_date;
	private String cam_thum_file;
	private String cam_thum_real_file;
	private String cam_img;
	private String cam_original_img;
	
	public String getCam_id() {
		return cam_id;
	}
	public void setCam_id(String cam_id) {
		this.cam_id = cam_id;
	}
	public int getCam_idx() {
		return cam_idx;
	}
	public void setCam_idx(int cam_idx) {
		this.cam_idx = cam_idx;
	}
	public int getCam_people() {
		return cam_people;
	}
	public void setCam_people(int cam_people) {
		this.cam_people = cam_people;
	}
	public String getCam_subject() {
		return cam_subject;
	}
	public void setCam_subject(String cam_subject) {
		this.cam_subject = cam_subject;
	}
	public String getCam_content() {
		return cam_content;
	}
	public void setCam_content(String cam_content) {
		this.cam_content = cam_content;
	}
	public int getCam_readcount() {
		return cam_readcount;
	}
	public void setCam_readcount(int cam_readcount) {
		this.cam_readcount = cam_readcount;
	}
	public Date getCam_date() {
		return cam_date;
	}
	public void setCam_date(Date cam_date) {
		this.cam_date = cam_date;
	}
	public String getCam_thum_file() {
		return cam_thum_file;
	}
	public void setCam_thum_file(String cam_thum_file) {
		this.cam_thum_file = cam_thum_file;
	}
	public String getCam_thum_real_file() {
		return cam_thum_real_file;
	}
	public void setCam_thum_real_file(String cam_thum_real_file) {
		this.cam_thum_real_file = cam_thum_real_file;
	}
	public String getCam_img() {
		return cam_img;
	}
	public void setCam_img(String cam_img) {
		this.cam_img = cam_img;
	}
	public String getCam_original_img() {
		return cam_original_img;
	}
	public void setCam_original_img(String cam_original_img) {
		this.cam_original_img = cam_original_img;
	}
	
	@Override
	public String toString() {
		return "CampaignDTO [cam_id=" + cam_id + ", cam_idx=" + cam_idx + ", cam_people=" + cam_people
				+ ", cam_subject=" + cam_subject + ", cam_content=" + cam_content + ", cam_readcount=" + cam_readcount
				+ ", cam_date=" + cam_date + ", cam_thum_file=" + cam_thum_file + ", cam_thum_real_file="
				+ cam_thum_real_file + ", cam_img=" + cam_img + ", cam_original_img=" + cam_original_img + "]";
	}
	
}
