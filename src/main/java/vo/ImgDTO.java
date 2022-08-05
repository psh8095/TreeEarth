package vo;

public class ImgDTO {
	
	/*
	   CREATE DATABASE imgList;

		CREATE TABLE board (
			board_name VARCHAR(20) NOT NULL,
			board_subject VARCHAR(50) NOT NULL,
			board_content VARCHAR(2000) NOT NULL,
			board_file VARCHAR(50) NOT NULL,
			board_real_file VARCHAR(50) NOT NULL
		);
	 */
	
	
	private String board_name;
	private String board_subject;
	private String board_content;
	private String board_file; 
	private String board_real_file;
	
	
	public String getBoard_Name() {
		return board_name;
	}
	public void setBoard_Name(String name) {
		this.board_name = name;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_file() {
		return board_file;
	}
	public void setBoard_file(String board_file) {
		this.board_file = board_file;
	}
	public String getBoard_real_file() {
		return board_real_file;
	}
	public void setBoard_real_file(String board_real_file) {
		this.board_real_file = board_real_file;
	} 
}
