package vo.mypage;

import java.sql.Date;

/*
 * 주문 아이디, 회원 아이디, 회원 이름, 회원 주소, 회원 휴대폰 번호, 회원 이메일, 결제 금액, 주문 일자
CREATE TABLE order_info (
    order_id VARCHAR(30) PRIMARY KEY,
    mem_id VARCHAR(50),
    mem_name VARCHAR(20) NOT NULL,
    mem_address VARCHAR(50) NOT NULL,
    mem_address_detail VARCHAR(50) NOT NULL,
    mem_phone VARCHAR(15) NOT NULL,
    mem_email VARCHAR(50) NOT NULL,
    amount INT NOT NULL,
    order_date DATE NOT NULL,
    FOREIGN KEY (mem_id) REFERENCES member(mem_id) ON DELETE CASCADE
);
 */

public class OrderDTO {
	private String order_id;
	private String mem_id;
	private String mem_name;
	private String mem_address;
	private String mem_address_detail;
	private String mem_phone;
	private String mem_email;
	private int amount;
	private Date order_date;
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
}
