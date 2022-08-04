package vo;

import java.sql.*;

/*
 * 아이디, 비밀번호, 이름, 생년월일, 성별, 주소, 상세주소, 폰번호, 이메일, 적립금, 가입일 
 CREATE TABLE member (
 	mem_id VARCHAR(50) PRIMARY KEY,
 	mem_pass VARCHAR(16) NOT NULL,
 	mem_name VARCHAR(20) NOT NULL,
 	mem_birth DATE NOT NULL,
 	mem_gender VARCHAR(1) NOT NULL,
 	mem_address VARCHAR(50) NOT NULL,
 	mem_address_detail VARCHAR(50) NOT NULL,
 	mem_phone VARCHAR(15) UNIQUE NOT NULL,
 	mem_email VARCHAR(50) UNIQUE NOT NULL,
 	mem_point INT NOT NULL,
 	mem_date DATE NOT NULL
 );
 */

public class MemberDTO {
	private String mem_id;
	private String mem_pass;
	private String mem_name;
	private Date mem_birth;
	private String mem_gender;
	private String mem_address;
	private String mem_address_detail;
	private String mem_phone;
	private String mem_email;
	private int mem_point;
	private Date mem_date;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public Date getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(Date mem_birth) {
		this.mem_birth = mem_birth;
	}
	public String getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
	public String getMem_address() {
		return mem_address;
	}
	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}
	public String getMem_address_detail() {
		return mem_address_detail;
	}
	public void setMem_address_detail(String mem_address_detail) {
		this.mem_address_detail = mem_address_detail;
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
	public int getMem_point() {
		return mem_point;
	}
	public void setMem_point(int mem_point) {
		this.mem_point = mem_point;
	}
	public Date getMem_date() {
		return mem_date;
	}
	public void setMem_date(Date mem_date) {
		this.mem_date = mem_date;
	}
	
}
