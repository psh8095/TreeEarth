package vo;

public class StorePageInfo {
	
	private int pageNum; // 현재 페이지 번호
	private int maxPage; // 최대 페이지 수
	private int startPage; // 시작 페이지 번호
	private int endPage; // 끝 페이지 번호
	private int itemListCount; // 총 상품 목록 수
	
	public StorePageInfo(int pageNum, int maxPage, int startPage, int endPage, int itemListCount) {
		super();
		this.pageNum = pageNum;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.itemListCount = itemListCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getItemListCount() {
		return itemListCount;
	}

	public void setItemListCount(int itemListCount) {
		this.itemListCount = itemListCount;
	}
	
}
