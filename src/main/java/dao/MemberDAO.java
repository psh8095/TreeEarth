package dao;

import static db.JdbcUtil.close;

import java.sql.*;

import vo.member.*;

public class MemberDAO {

	//싱글톤 디자인 패턴
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	//로그인
	public boolean selectMember(MemberDTO member) {
		boolean isLoginSuccess = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM member WHERE mem_id=? AND mem_pass=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMem_id());
			pstmt.setString(2, member.getMem_pass());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isLoginSuccess = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - selectMember 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		return isLoginSuccess;
	}
	
}
