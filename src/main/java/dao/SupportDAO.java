package dao;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.ArrayList;

import db.*;
import vo.*;
import vo.support.SupportDTO;

public class SupportDAO {

//	멤버변수 및 인스턴스 생성
	private static SupportDAO instance = new SupportDAO();

	// 2. 생성자 정의
	private SupportDAO() {
	}

	// 3. Getter 정의(자동 생성)
	public static SupportDAO getInstance() {
		return instance;
	}

	// ----------------------------------------------------------------------------------------
	// 외부(Service 클래스)로부터 Connection 객체를 전달받아 관리하기 위해
	// Connection 타입 멤버변수와 Setter 메서드 정의
	private Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}

//	supportDTO의 약어는 dto로 고정
	// 디테일
	public SupportDTO selectSupportBoard(int sup_idx) {
		System.out.println("insertSupportBoard");

		SupportDTO support = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from support where sup_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sup_idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				support = new SupportDTO();
				support.setSup_idx(rs.getInt("sup_idx"));
				support.setSup_subject(rs.getString("sup_subject"));
				support.setSup_readcount(rs.getInt("sup_readcount"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return support;

	}

	
	// ----------------------------------------------------------------------------------------

	
	// 후원 상세 페이지 조회 위한 selectBoard()메서드 정의
	public SupportDTO selectBoard(int sup_idx) {
		System.out.println("5. selectBoard DAO");
		SupportDTO dto = new SupportDTO();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		
		try {
			// idx 해당하는 데이터 dto에 넣기  
			sql = "SELECT * FROM support WHERE sup_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sup_idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setSup_idx(rs.getInt("sup_idx")); // 글번호 확인위한 필수 세팅
				dto.setSup_subject(rs.getString("sup_subject"));
				dto.setSup_date(rs.getDate("sup_date"));
				dto.setSup_readcount(rs.getInt("sup_readcount"));
				dto.setSup_goal_date(rs.getDate("sup_goal_date"));
				dto.setSup_goal_price(rs.getInt("sup_goal_price"));
				dto.setSup_content(rs.getString("sup_content"));
				dto.setSup_thumbnail_file(rs.getString("sup_thumbnail_file"));
				dto.setSup_original_file(rs.getString("sup_original_file"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("5-1. 개시물 정보 저장!");
		return dto;
	}

	
	// ----------------------------------------------------------------------------------------
	
	
	//게시판 등록 메서드
	public int insertSupportBoard(SupportDTO dto) {
		System.out.println("5. insertSupportBoard DAO");
		int insertCount = 0; 

		
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		String sql = "", sql2 = "";
		
		
		// 글 번호 지정
		int idx = 1; 

		
		try {
			
			//제일 높은 글번호 값을 조회
			sql = "SELECT max(sup_idx) FROM support";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			//기존 글이 있으면
			if (rs.next()) {
				idx = rs.getInt(1) + 1;
				System.out.println("5-1. 글번호 상승");
			}

			
			//기존 글이 없으면 
			//게시글 등록
			sql2 = "INSERT INTO support VALUES(?,'admin',?,?,?,?,?,?,?,?,?,?,now())";
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, idx); 
			pstmt2.setString(2, dto.getSup_subject());
			pstmt2.setInt(3, dto.getSup_goal_price());
			pstmt2.setDate(4, dto.getSup_goal_date());
			pstmt2.setString(5, dto.getSup_content());
			pstmt2.setString(6, dto.getSup_thumbnail_file());
			pstmt2.setString(7, dto.getSup_thumbnail_real_file());
			pstmt2.setString(8, dto.getSup_original_file());
			pstmt2.setString(9, dto.getSup_real_file());
			pstmt2.setInt(10, 0); 
			pstmt2.setInt(11, 0);

			insertCount = pstmt2.executeUpdate();
			System.out.println("5-2. 게시물 등록!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL 구문 오류 발생! - insertSupportBoard()");
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt2);
			JdbcUtil.close(rs);
		}

		
		return insertCount;

	}

	
	// ----------------------------------------------------------------------------------------

	
	// 조회수 카운트를 정의하는 updateReadcount() 정의
	public void updateReadcount(int sup_idx) {
		System.out.println("updateReadcount");
		
		PreparedStatement pstmt = null;

		try {
			String sql = "update support set sup_readcount = sup_readcount + 1  where sup_idx = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sup_idx);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - " + e.getMessage() + "updateReadcount");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

	}

	
	// ----------------------------------------------------------------------------------------

	
	// 글수정, 삭제 판별에 사용되는 isBoardWriter() 정의
	public boolean isBoardWriter(int sup_idx, String mem_pass) {
		System.out.println("4. isBoardWriter");
		boolean isBoardWriter = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try { // 번호와 비밀번호 조회해서 맞는 거 찾기
			String sql = "SELECT * FROM support s, member m WHERE s.mem_id = 'admin' AND s.sup_idx = ? AND m.mem_pass = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sup_idx);
			pstmt.setString(2, mem_pass);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				isBoardWriter = true;
//				조회 결과 있음
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - boardwriter " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return isBoardWriter;
	}

	// 후원 수정에 사용되어지는 supportUpdateBoard() 정의
	public int supportUpdateBoard(SupportDTO dto) {
		System.out.println("supportUpdateBoard");
		int updateCount = 0;
		PreparedStatement pstmt = null;

		try {
			String sql = "UPDATE support SET sup_subject = ?, mem_id = ?, sup_goal_price =?, sup_content =? ,  sup_thumbnail_file = ?,  sup_original_file = ?, sup_goal_date = ? WHERE sup_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getSup_subject());
			pstmt.setString(2, dto.getMem_id());
			pstmt.setInt(3, dto.getSup_goal_price());
			pstmt.setString(4, dto.getSup_content());
			pstmt.setString(5, dto.getSup_thumbnail_file());
			pstmt.setString(6, dto.getSup_original_file());
			pstmt.setDate(7,dto.getSup_goal_date());
			pstmt.setInt(8, dto.getSup_idx());

			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! -  updateBoard " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return updateCount;
	}

	// 후원 삭제에 사용되어지는 deleteBoard() 정의
	public int deleteBoard(int sup_idx) {
		System.out.println("6 .deleteBoard");
		int deleteCount = 0;
		PreparedStatement pstmt = null;

		try {
			String sql = "DELETE FROM support WHERE sup_idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sup_idx);

			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! -  deleteBoard " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return deleteCount;

	}

	
	// ----------------------------------------------------------------------------------------
	
	
	//리스트 
	public ArrayList<SupportDTO> selectSupportList() {
		System.out.println("5. selectSupportList DAO");
		ArrayList<SupportDTO> SupportList = null;
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		//dto객체를 저장할 arraylist객체
		SupportList = new ArrayList<SupportDTO>();
		
		
		try {
			//support 게시물 전체 조회
			String sql = "SELECT * FROM support ORDER BY sup_idx DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			// 조회된 게시글 수 만큼 반복
			while(rs.next()) {
				
				// 하나의 게시글 정보를 담는 dto객체 인스턴스 생성 
				SupportDTO dto = new SupportDTO();
				
				// 게시물 정보 저장
				dto.setSup_idx(rs.getInt("sup_idx"));
				dto.setSup_goal_price(rs.getInt("sup_goal_price"));
				dto.setMem_id(rs.getString("mem_id"));
				dto.setSup_subject(rs.getString("sup_subject"));
				dto.setSup_content(rs.getString("sup_content"));
				dto.setSup_thumbnail_real_file(rs.getString("sup_thumbnail_real_file"));
				dto.setSup_thumbnail_file(rs.getString("sup_thumbnail_file"));
				dto.setSup_real_file(rs.getString("sup_real_file"));
				dto.setSup_original_file(rs.getString("sup_original_file"));
				dto.setSup_money(rs.getInt("sup_money"));
				dto.setSup_readcount(rs.getInt("sup_readcount"));
				dto.setSup_goal_date(rs.getDate("sup_goal_date"));
				dto.setSup_date(rs.getDate("sup_date"));
				
				
				
				//리스트에 dto객체 저장
				SupportList.add(dto);
				

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("5-1. 게시물 정보 저장!");
		return SupportList;
	}
	// ----------------------------------------------------------------------------------------

		//후원금
		public int updateMoney(SupportDTO dto) {
			System.out.println("5.updateMoney");
			int updateCount = 0;
			PreparedStatement pstmt = null;
			
			try {
				String sql = "UPDATE support SET sup_money = sup_money + ? WHERE sup_idx = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, dto.getSup_money());
				pstmt.setInt(2, dto.getSup_idx());
				
				updateCount =pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 - updateMoney() : " + e.getMessage());
			} finally {
				close(pstmt);
			}
			return updateCount;
		}


}
