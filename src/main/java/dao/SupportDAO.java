package dao;

import static db.JdbcUtil.*;

import java.sql.*;

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

	// 후원 상세 페이지 조회 위한 selectBoard()메서드 정의
	public SupportDTO selectBoard(int sup_idx) {

		return null;
	}

	public int insertSupportBoard(SupportDTO dto) {
		System.out.println("insertSupportBoard");
		int insertCount = 0; // insert 결과를 확인하기 위한 변수 지정

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int idx = 1; // 글 번호 지정

		try {
			String sql = "SELECT max(sup_ix) FROM support";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				idx = rs.getInt(1) + 1;
			}

			sql = "INSERT INTO support VALUES(?,?,?,?,?,?,?,?,?,?,?,now()) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx); // 글 번호
			pstmt.setString(2, dto.getSup_pass()); // 글 비밀번호
			pstmt.setInt(3, dto.getSup_goal_price());
			pstmt.setInt(4, dto.getSup_money());
			pstmt.setString(5, dto.getSup_subject());
			pstmt.setString(6, dto.getSup_content());
			pstmt.setString(7, dto.getSup_original_file());
			pstmt.setString(8, dto.getSup_real_file());
			pstmt.setString(9, dto.getSup_thumbnail_file());
			pstmt.setString(10, dto.getSup_thumbnail_real_file());
			pstmt.setInt(11, 0);// readcount 자리

			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL 구문 오류 발생! - insertSupportBoard()");
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}

		return insertCount;

	}

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

	// 글수정, 삭제에 사용되는 isBoardWriter() 정의
	public boolean isBoardWriter(int sup_idx, String sup_pass) {
		System.out.println("isBoardWriter");
		boolean isBoardWriter = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try { // 번호와 비밀번호 조회해서 맞는 거 찾기
			String sql = "SELECT * FROM support WHERE sup_idx = ? and sup_pass =? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sup_idx);
			pstmt.setString(2, sup_pass);

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
			String sql = "UPDATE support SET sup_goal_price =?, sup_money = ?, sup_total = ? sup_now_total = ?, sup_subject = ?, sup_content = ?, sup_original_file = ?, sup_thumbnail_file = ? WHERE sup_idx = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getSup_goal_price());
			pstmt.setInt(2, dto.getSup_money());
			pstmt.setInt(3, dto.getSup_total());
			pstmt.setInt(4, dto.getSup_now_total());
			pstmt.setString(5, dto.getSup_subject());
			pstmt.setString(6, dto.getSup_content());
			pstmt.setString(7, dto.getSup_original_file());
			pstmt.setString(8, dto.getSup_thumbnail_file());

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
		System.out.println("deleteBoard");
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

}
