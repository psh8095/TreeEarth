package vo.community;

/*
 * 좋아요 수, 킹려나무번호, 아이디
CREATE d_heart (
	like_idx INT PRIMARY KEY,
	likeno INT NOT NULL,
	diaryno INT NOT NULL,
	mid VARCHAR(50) NOT NULL,
	FOREIGN KEY (mid) REFERENCES member (mem_id),
	FOREIGN KEY (diaryno) REFERENCES diary (diary_idx)
);
 */

public class DiaryHeartDTO {

	private int likeno;
	private int diaryno;
	private String mid;
	
	public int getLikeno() {
		return likeno;
	}
	public void setLikeno(int likeno) {
		this.likeno = likeno;
	}
	public int getDiaryno() {
		return diaryno;
	}
	public void setDiaryno(int diaryno) {
		this.diaryno = diaryno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
}
