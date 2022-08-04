package vo;

/*
 * 장바구니 목록 번호, 회원 아이디, 상품 번호
CREATE TABLE cart (
  cart_idx INT PRIMARY KEY,
  mem_id VARCHAR(50),
  sto_idx INT,
  FOREIGN KEY (mem_id) REFERENCES member(mem_id),
  FOREIGN KEY (sto_idx) REFERENCES store(sto_idx)
);
 */
public class CartDTO {
	private int cart_idx;
	private String mem_id;
	private int sto_idx;
	
	public int getCart_idx() {
		return cart_idx;
	}
	public void setCart_idx(int cart_idx) {
		this.cart_idx = cart_idx;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getSto_idx() {
		return sto_idx;
	}
	public void setSto_idx(int sto_idx) {
		this.sto_idx = sto_idx;
	}
	
}
