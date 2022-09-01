package vo.mypage;

import java.sql.Date;

// 데이터 담아서 이동하기 위한 용도
// 테이블 X
public class OrderListDTO {
	private String order_id;
	private int sto_idx;
	private String sto_subject;
	private String sto_thum_file;
	private int quantity;
	private int amount;
	private Date order_date;
	private String order_status;
	private int sto_price;
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getSto_idx() {
		return sto_idx;
	}
	public void setSto_idx(int sto_idx) {
		this.sto_idx = sto_idx;
	}
	public String getSto_subject() {
		return sto_subject;
	}
	public void setSto_subject(String sto_subject) {
		this.sto_subject = sto_subject;
	}
	public String getSto_thum_file() {
		return sto_thum_file;
	}
	public void setSto_thum_file(String sto_thum_file) {
		this.sto_thum_file = sto_thum_file;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getSto_price() {
		return sto_price;
	}
	public void setSto_price(int sto_price) {
		this.sto_price = sto_price;
	}
	
}
