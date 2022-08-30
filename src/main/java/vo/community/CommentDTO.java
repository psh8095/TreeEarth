package vo.community;

import java.sql.Date;

/*
  	- 게시판 코멘트 작성 테이블 -
 
	CREATE TABLE comment (
		idx int(11) NOT NULL AUTO_INCREMENT,
		name varchar(45) DEFAULT NULL,
		password varchar(10) DEFAULT NULL,
		content varchar(45) DEFAULT NULL,
		date datetime DEFAULT CURRENT_TIMESTAMP,
		ref int(11) DEFAULT NULL, // board의 idx를 저장하는 역할
		PRIMARY KEY(idx)
	);
 */

public class CommentDTO {
	private int idx;
	private String name;
	private String password;
	private String content;
	private Date date;
	private int ref;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	
	@Override
	public String toString() {
		return "CommentDTO [idx=" + idx + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", date=" + date + ", ref=" + ref + "]";
	}
	
}
