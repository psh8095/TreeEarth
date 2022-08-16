package vo.community;
import java.sql.Date;

public class FreeboardDTO {
	private int free_idx;
	private String free_userID;
	private String free_name;
	private String free_pass;
	private String free_subject;
	private String free_content;
	private String free_img;
	private String free_original_img;
	private int free_readcount;
	private int free_block;
	private Date free_date;
	
	public int getFree_idx() {
		return free_idx;
	}
	public void setFree_idx(int free_idx) {
		this.free_idx = free_idx;
	}
	public String getFree_userID() {
		return free_userID;
	}
	public void setFree_userID(String free_userID) {
		this.free_userID = free_userID;
	}
	public String getFree_name() {
		return free_name;
	}
	public void setFree_name(String free_name) {
		this.free_name = free_name;
	}
	public String getFree_pass() {
		return free_pass;
	}
	public void setFree_pass(String free_pass) {
		this.free_pass = free_pass;
	}
	public String getFree_subject() {
		return free_subject;
	}
	public void setFree_subject(String free_subject) {
		this.free_subject = free_subject;
	}
	public String getFree_content() {
		return free_content;
	}
	public void setFree_content(String free_content) {
		this.free_content = free_content;
	}
	public String getFree_img() {
		return free_img;
	}
	public void setFree_img(String free_img) {
		this.free_img = free_img;
	}
	public String getFree_original_img() {
		return free_original_img;
	}
	public void setFree_original_img(String free_original_img) {
		this.free_original_img = free_original_img;
	}
	public int getFree_readcount() {
		return free_readcount;
	}
	public void setFree_readcount(int free_readcount) {
		this.free_readcount = free_readcount;
	}
	public int getFree_block() {
		return free_block;
	}
	public void setFree_block(int free_block) {
		this.free_block = free_block;
	}
	public Date getFree_date() {
		return free_date;
	}
	public void setFree_date(Date free_date) {
		this.free_date = free_date;
	}
	
	@Override
	public String toString() {
		return "FreeboardDTO [free_idx=" + free_idx + ", free_userID=" + free_userID + ", free_name=" + free_name
				+ ", free_pass=" + free_pass + ", free_subject=" + free_subject + ", free_content=" + free_content
				+ ", free_img=" + free_img + ", free_original_img=" + free_original_img + ", free_readcount="
				+ free_readcount + ", free_block=" + free_block + ", free_date=" + free_date + "]";
	}

	
	
}
