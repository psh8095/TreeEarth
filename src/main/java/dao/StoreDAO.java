package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.store.StoreDTO;

import static db.JdbcUtil.*;

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

}



























