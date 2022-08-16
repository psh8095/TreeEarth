package vo.store;

/*
 * 주문 상세 번호, 주문 아이디, 상품 번호 
CREATE TABLE order_detail (
    order_detail_idx INT PRIMARY KEY,
    order_id VARCHAR(30),
    sto_idx INT,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES order_info(order_id),
    FOREIGN KEY (sto_idx) REFERENCES store(sto_idx)
);
 */

public class OrderDetailDTO {
	private int order_detail_idx;
	private String order_id;
	private int sto_idx;
	
	public int getOrder_detail_idx() {
		return order_detail_idx;
	}
	public void setOrder_detail_idx(int order_detail_idx) {
		this.order_detail_idx = order_detail_idx;
	}
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
}
