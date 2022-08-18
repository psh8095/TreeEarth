package vo.campaign;

/*
 * 
CREATE TABLE campaign_apply (
	cam_idx INT,
	mem_id VARCHAR(50),
	mem_phone VARCHAR(15) NOT NULL,
	mem_email VARCHAR(50) NOT NULL,
	apply_people INT NOT NULL,
	FOREIGN KEY (cam_idx) REFERENCES campaign(cam_idx),
	FOREIGN KEY (mem_id) REFERENCES member(mem_id)
);
 */
public class CampaignApplyDTO {
	private int cam_idx;
	private String mem_id;
	private String mem_phone;
	private String mem_email;
	private int apply_people;
	
	public int getCam_idx() {
		return cam_idx;
	}
	public void setCam_idx(int cam_idx) {
		this.cam_idx = cam_idx;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public int getApply_people() {
		return apply_people;
	}
	public void setApply_people(int apply_people) {
		this.apply_people = apply_people;
	}
	
}
