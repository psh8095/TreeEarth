package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.store.StoreDTO;
import vo.store.StoreReviewDTO;

public class StoreDAO {
	// 싱글톤 디자인 패턴으로 StoreDAO 인스턴스 생성
	// 1. 멤버변수 선언 및 인스턴스 생성
	private static StoreDAO instance = new StoreDAO();
	// 2. 생성자 정의
	private StoreDAO() {}
	// 3. Getter 정의
	public static StoreDAO getInstance() {
		return instance;
	}
	
	// Service 클래스로부터 Connection 객체를 전달받아 관리하기 위해 Connection 타입
	// 멤버변수와 Setter 메서드 정의
	private Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	//----------------------------------------------------------------------------
	
	// 상품등록(글쓰기) 작업을 수행하는 메서드
	public int insertStore(StoreDTO sto) {
		int insertCount = 0; // insert 작업결과 리턴받아 저장할 변수 선언
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int idx = 1; // 새 글 번호를 저장할 변수
		
		try {
			String sql = "SELECT MAX(sto_idx) FROM store";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				idx = rs.getInt(1) + 1; // 조회된 가장 큰 번호 + 1 값을 새 글 번호로 저장
			}
			
			close(pstmt);
			
			sql = "INSERT INTO store VALUES(?,?,?,?,?,?,now(),?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setInt(2, sto.getSto_price());
			pstmt.setString(3, sto.getSto_subject());
			pstmt.setString(4, sto.getSto_content());
			pstmt.setString(5, sto.getSto_tag());
			pstmt.setString(6, sto.getSto_category());
			pstmt.setString(7, sto.getSto_thum_file());
			pstmt.setString(8, sto.getSto_thum_real_file());
			pstmt.setString(9, sto.getSto_content_file());
			pstmt.setString(10, sto.getSto_content_real_file());
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - insertStore()");
		} finally {
			close(rs);
			close(pstmt);
		}

		return insertCount;
	}
	
	// 전체 상품 목록 수를 조회할 selectItemListCount() 메서드 정의
	public int selectItemListCount() {
		
		int itemListCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM store";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				itemListCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("StoreDAO - selectItemListCount() 메서드 오류 발생 : " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return itemListCount;
	}
	
	// 상품 목록을 조회하는 selectStoreItemList() 메서드 정의
	public ArrayList<StoreDTO> selectStoreItemList(int pageNum, int listLimit) {
		
		ArrayList<StoreDTO> storeList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 현재 페이지 번호를 활용하여 조회 시 시작행 번호 계산
		int startRow = (pageNum - 1) * listLimit;
		
		try {
			String sql = "SELECT * FROM store ORDER BY sto_idx DESC LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, listLimit);
			
			rs = pstmt.executeQuery();
			
			storeList = new ArrayList<StoreDTO>();
			
			while(rs.next()) {
				StoreDTO store = new StoreDTO();
				store.setSto_idx(rs.getInt("sto_idx"));
				store.setSto_price(rs.getInt("sto_price"));
				store.setSto_subject(rs.getString("sto_subject"));
				store.setSto_content(rs.getString("sto_content"));
				store.setSto_tag(rs.getString("sto_tag"));
				store.setSto_category(rs.getString("sto_category"));
				store.setSto_date(rs.getDate("sto_date"));
				store.setSto_thum_file(rs.getString("sto_thum_file"));
				store.setSto_thum_real_file(rs.getString("sto_thum_real_file"));
				store.setSto_content_file(rs.getString("sto_content_file"));
				store.setSto_content_real_file(rs.getString("sto_content_real_file"));
				System.out.println(store); //-> 확인 출력
				
				storeList.add(store);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("StoreDAO - selectStoreItemList() 메서드 오류 발생 : " + e.getMessage());	
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return storeList;
	}
	
	public ArrayList<StoreDTO> StoreItemImg() {
		System.out.println("StoreDAO 왔음");
		ArrayList<StoreDTO> itemimg = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		itemimg = new ArrayList<StoreDTO>();
		
		try {
			String sql = "SELECT * FROM store";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StoreDTO store = new StoreDTO();
				store.setSto_idx(rs.getInt("sto_idx"));
				store.setSto_price(rs.getInt("sto_price"));
				store.setSto_subject(rs.getString("sto_subject"));
				store.setSto_content(rs.getString("sto_content"));
				store.setSto_tag(rs.getString("sto_tag"));
				store.setSto_category(rs.getString("sto_category"));
				store.setSto_date(rs.getDate("sto_date"));
				store.setSto_thum_file(rs.getString("sto_thum_file"));
				store.setSto_thum_real_file(rs.getString("sto_thum_real_file"));
				store.setSto_content_file(rs.getString("sto_content_file"));
				store.setSto_content_real_file(rs.getString("sto_content_real_file"));
				
				itemimg.add(store);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("StoreDAO - StoreItemImg() 메서드 오류 발생 : " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return itemimg;
	}
	
	// 상품 목록 상세 조회
	public StoreDTO selectItemDetail(int sto_idx) {
		
		StoreDTO store = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM store WHERE sto_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sto_idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				store = new StoreDTO();
				store.setSto_idx(rs.getInt("sto_idx"));
				store.setSto_price(rs.getInt("sto_price"));
				store.setSto_subject(rs.getString("sto_subject"));
				store.setSto_content(rs.getString("sto_content"));
				store.setSto_tag(rs.getString("sto_tag"));
				store.setSto_category(rs.getString("sto_category"));
				store.setSto_date(rs.getDate("sto_date"));
				store.setSto_thum_file(rs.getString("sto_thum_file"));
				store.setSto_thum_real_file(rs.getString("sto_thum_real_file"));
				store.setSto_content_file(rs.getString("sto_content_file"));
				store.setSto_content_real_file(rs.getString("sto_content_real_file"));
				
				System.out.println(store);
			}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("StoreDAO - selectItemDetail() 메서드 오류 발생 : " + e.getMessage());
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return store;
	
		}
		// 글 삭제 권한을 판별하는 메서드
		public boolean isStoreWriter(int sto_idx) {
			boolean isStoreWriter = false;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT * FROM store WHERE sto_idx=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, sto_idx);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					// 조회 결과 있음
					isStoreWriter = true; // 결과값을 true 로 변경
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 - isStoreWriter() : " + e.getMessage());
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return isStoreWriter;
		}
		
		// 게시글을 삭제하는 메서드
		public int deleteStore(int sto_idx) {
			int deleteCount = 0;
			
			PreparedStatement pstmt = null;
			
			try {
				String sql = "DELETE FROM store WHERE sto_idx=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, sto_idx);
				deleteCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 - deleteStore() : " + e.getMessage());
			} finally {
				close(pstmt);
			}
			
			return deleteCount;
		}	
		
		// 게시글 수정하는 메서드
		public int updateStore(StoreDTO sto) {
			int updateCount = 0;
			
			PreparedStatement pstmt = null;
			
			try {
				String sql = "UPDATE store "
						+ "SET sto_subject=?,sto_content=? "
						+ "WHERE sto_idx=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sto.getSto_subject());
				pstmt.setString(2, sto.getSto_content());
				pstmt.setInt(3, sto.getSto_idx());
				
				updateCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 - updateStore() : " + e.getMessage());
			} finally {
				close(pstmt);
			}
			
			return updateCount;
		}
		
		// 조회수 증가 작업을 처리하는 updateReadcount() 메서드 
		public void updateReadcount(int sto_idx) {

		
	}
		// 상품 구매 후기글 작성 작업 메서드
		public int insertStoreReview(StoreReviewDTO storeReview) {
			
			int insertReviewCount = 0;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int num = 1; // 새 리뷰 글 번호를 저장할 변수 선언
			
			try {
				String sql = "SELECT MAX(sto_re_idx) FROM store_review";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					num = rs.getInt(1) + 1;
				}
				
				close(pstmt); // 사용 완료된 PreparedStatement 객체를 먼저 반환
				
				// 전달받은 데이터를 store_review 테이블에 INSERT
				sql = "INSERT INTO store_review VALUES (?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, storeReview.getMem_id());
				pstmt.setInt(2, storeReview.getSto_idx());
				pstmt.setInt(3, num);
				pstmt.setInt(4, 1);
				pstmt.setString(5, storeReview.getSto_re_content());
				pstmt.setString(6,storeReview.getSto_re_file());
				pstmt.setString(7, storeReview.getSto_re_real_file());
				
				insertReviewCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("StoreDAO - insertStoreReview() 메서드 오류 발생 : " + e.getMessage());
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return insertReviewCount;
		}
		
		// 전체 상품 구매 후기글 수를 조회할 selectStoreReviewListCount() 메서드
		// 파라미터 : 없음, 리턴타입 : int
		public int selectStoreReviewListCount() {
			
			int storeReviewListCount  = 0;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT COUNT(*) FROM store_review";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					storeReviewListCount = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("StoreDAO - selectStoreReviewListCount() 메서드 오류 발생 : " + e.getMessage());
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return storeReviewListCount;
		}
		
		// 구매 후기 목록을 조회하는 selectStoreReviewList() 메서드
		public ArrayList<StoreReviewDTO> selectStoreReviewList(int pageNum, int listLimit) {
			
			ArrayList<StoreReviewDTO> storeReviewList = null;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			// 현재 페이지 번호를 활용하여 조회 시 시작행 번호 계산
			int startRow = (pageNum - 1) * listLimit;
			
			try {
				String sql = "SELECT * FROM store_review ORDER BY sto_re_idx LIMIT ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, listLimit);
				
				rs = pstmt.executeQuery();
				
				storeReviewList = new ArrayList<StoreReviewDTO>();
				
				while(rs.next()) {
					// 1개 구매 후기 정보를 저장할 StoreReviewDTO 객체 생성
					StoreReviewDTO store_review = new StoreReviewDTO();
					// 저장
					store_review.setMem_id(rs.getString("mem_id"));
					store_review.setSto_idx(rs.getInt("sto_idx"));
					store_review.setSto_re_idx(rs.getInt("sto_re_idx"));
					store_review.setSto_re_score(rs.getInt("sto_re_score"));
					store_review.setSto_re_content(rs.getString("sto_re_content"));
					store_review.setSto_re_file(rs.getString("sto_re_file"));
					store_review.setSto_re_real_file(rs.getString("sto_re_real_file"));
					// 전체 구매 후기글 정보를 저장하는 ArrayList 객체에 1개 구매 후기 정보 StoreReviewDTO 객체 추가
					storeReviewList.add(store_review);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("StoreDAO - selectStoreReviewList() 메서드 오류 발생 : " + e.getMessage());
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return storeReviewList;
		}
		
		// 구매후기 상세 정보를 조회하는 selectStoreReviewDetail() 메서드
		// 리턴타입 : StoreReviewDTO 객체 , 파라미터 : int(sto_re_idx)
		public StoreReviewDTO selectStoreReviewDetail(int sto_re_idx) {
			
			StoreReviewDTO store_review = null;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT * FROM store_review WHERE sto_re_idx=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, sto_re_idx);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					store_review = new StoreReviewDTO();
					store_review.setMem_id(rs.getString("mem_id"));
					store_review.setSto_idx(rs.getInt("sto_idx"));
					store_review.setSto_re_idx(rs.getInt("sto_re_idx"));
					store_review.setSto_re_score(rs.getInt("sto_re_score"));
					store_review.setSto_re_content(rs.getString("sto_re_content"));
					store_review.setSto_re_file(rs.getString("sto_re_file"));
					store_review.setSto_re_real_file(rs.getString("sto_re_real_file"));
					
					System.out.println(store_review); // 확인용
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("StoreDAO - selectStoreReviewDetail() 메서드 오류 발생 : " + e.getMessage());
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return store_review;
		}
		
		

}




























