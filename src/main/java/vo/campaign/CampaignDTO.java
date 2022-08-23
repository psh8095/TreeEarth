package vo.campaign;

/*
*캠페인 글번호, 참여인원, 제목, 내용, 조회수, 작성일, 썸네일파일*2, 이미지파일*2 

CREATE TABLE campaign(
	cam_idx INT PRIMARY KEY,
	cam_people INT NOT NULL,
	cam_subject VARCHAR(50) NOT NULL, 
	cam_content VARCHAR(2000) NOT NULL,
	cam_img VARCHAR(100),
	cam_real_img VARCHAR(100)
);
 */


public class CampaignDTO{
	private int cam_idx;
	private int cam_people;
	private String cam_subject;
	private String cam_content;
	private String cam_img;
	private String cam_real_img;
	
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
	public String getCam_img() {
		return cam_img;
	}
	public void setCam_img(String cam_img) {
		this.cam_img = cam_img;
	}
	public String getCam_real_img() {
		return cam_real_img;
	}
	public void setCam_real_img(String cam_real_img) {
		this.cam_real_img = cam_real_img;
	}
	
}
