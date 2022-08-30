package vo.campaign;

// 참가 신청 내역 조회 시 필요한 리스트
public class ApplyListDTO {
	private int cam_idx;
	private String mem_id;
	private String cam_subject;
	private String mem_name;
	private String mem_phone;
	private int apply_people;
	private String apply_etc;
	
	public int getCam_idx() {
		return cam_idx;
	}
	public void setCam_idx(int cam_idx) {
		this.cam_idx = cam_idx;
	}
	public String getCam_subject() {
		return cam_subject;
	}
	public void setCam_subject(String cam_subject) {
		this.cam_subject = cam_subject;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public int getApply_people() {
		return apply_people;
	}
	public void setApply_people(int apply_people) {
		this.apply_people = apply_people;
	}
	public String getApply_etc() {
		return apply_etc;
	}
	public void setApply_etc(String apply_etc) {
		this.apply_etc = apply_etc;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
}
