package vo.community;
import java.sql.Date;

/*
	CREATE TABLE freeboard (
		free_idx INT PRIMARY KEY,
		free_name VARCHAR(20) REFERENCES member(mem_name),
		free_pass VARCHAR(16) NOT NULL,
		free_subject VARCHAR(50) NOT NULL,
		free_content VARCHAR(2048) NOT NULL,
		free_img VARCHAR(50) NOT NULL,
		free_re_ref INT NOT NULL,
		free_re_lev INT NOT NULL,
		free_re_seq INT NOT NULL,
		free_readcount INT NOT NULL,
		free_date DATE NOT NULL
	);
 */

public class FreeboardDTO {
	private int free_idx; // 글번호
	private String free_name; // 작성자
	private String free_pass; // 비밀번호
	private String free_subject; // 제목
	private String free_content; // 내용
	private String free_img; // 이미지
	private int free_re_ref; // 원본 글의 참조글번호
	private int free_re_lev; // 들여쓰기 레벨
	private int free_re_seq; // 원본 글의 순서번호
	private int free_readcount; // 조회수
	private Date free_date;
	
	public int getFree_idx() {
		return free_idx;
	}
	public void setFree_idx(int free_idx) {
		this.free_idx = free_idx;
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
	public int getFree_re_ref() {
		return free_re_ref;
	}
	public void setFree_re_ref(int free_re_ref) {
		this.free_re_ref = free_re_ref;
	}
	public int getFree_re_lev() {
		return free_re_lev;
	}
	public void setFree_re_lev(int free_re_lev) {
		this.free_re_lev = free_re_lev;
	}
	public int getFree_re_seq() {
		return free_re_seq;
	}
	public void setFree_re_seq(int free_re_seq) {
		this.free_re_seq = free_re_seq;
	}
	public int getFree_readcount() {
		return free_readcount;
	}
	public void setFree_readcount(int free_readcount) {
		this.free_readcount = free_readcount;
	}
	public Date getFree_date() {
		return free_date;
	}
	public void setFree_date(Date free_date) {
		this.free_date = free_date;
	}
	
	@Override
	public String toString() {
		return "FreeboardDTO [free_idx=" + free_idx + ", free_name=" + free_name + ", free_pass=" + free_pass
				+ ", free_subject=" + free_subject + ", free_content=" + free_content + ", free_img=" + free_img
				+ ", free_re_ref=" + free_re_ref + ", free_re_lev="
				+ free_re_lev + ", free_re_seq=" + free_re_seq + ", free_readcount=" + free_readcount + ", free_date="
				+ free_date + "]";
	}
	
}
