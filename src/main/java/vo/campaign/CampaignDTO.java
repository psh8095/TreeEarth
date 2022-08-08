package vo.campaign;

import java.sql.Date;

/*
 * [ campaign ]
	cam_idx
	cam_subject
	cam_content
	cam_date
	cam_thum_file
	cam_thum_real_file
	
 */
public class CampaignDTO {
	private int cam_idx;
	private Date cam_date;
	private int cam_people;
	private String cam_subject;
	private String cam_content;
	private int cam_readcount;
	
	public int getCam_idx() {
		return cam_idx;
	}
	public void setCam_idx(int cam_idx) {
		this.cam_idx = cam_idx;
	}
	public Date getCam_date() {
		return cam_date;
	}
	public void setCam_date(Date cam_date) {
		this.cam_date = cam_date;
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
	
}
