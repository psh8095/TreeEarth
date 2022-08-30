package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.community.CampaignReviewBlockDTO;
import vo.support.SupportHistoryDTO;

import static db.JdbcUtil.*;

public class SupportHistoryDAO {

	private static SupportHistoryDAO instance = new SupportHistoryDAO();
	
	private SupportHistoryDAO() {}
	
	public static SupportHistoryDAO getInstance() {
		return instance;
	}	
	
	private Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	//후원 내역 저장
	public int insertHistory(SupportHistoryDTO supporthistory) {
		
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = 1;
		
		try {
			String sql = "SELECT MAX(suphi_idx) FROM supporthistory";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			}
			
			close(pstmt);
			
			sql = "INSERT INTO supporthistory VALUES(?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, supporthistory.getMem_id());
			pstmt.setInt(3, supporthistory.getSup_idx());
			pstmt.setInt(4, supporthistory.getSuphi_money());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SupportHistoryDAO - insertHistory");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return insertCount;
	}

	//후원 내역 조회
	public ArrayList<SupportHistoryDTO> getsupportList(String mem_id) {
		
		ArrayList<SupportHistoryDTO> supList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM supporthistory WHERE mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			
			rs = pstmt.executeQuery();
			
			supList = new ArrayList<SupportHistoryDTO>();
			
			while(rs.next()) {
				SupportHistoryDTO supporthistory = new SupportHistoryDTO();
				supporthistory.setSuphi_idx(rs.getInt("suphi_idx"));
				supporthistory.setMem_id(rs.getString("mem_id"));
				supporthistory.setSup_idx(rs.getInt("sup_idx"));
				supporthistory.setSuphi_money(rs.getInt("suphi_money"));
				supporthistory.setSuphi_date(rs.getDate("suphi_date"));
				
				supList.add(supporthistory);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SupportHistoryDAO - getsupportList");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return supList;
	}
	
}
