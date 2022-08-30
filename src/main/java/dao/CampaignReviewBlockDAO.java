package dao;

import static db.JdbcUtil.close;

import java.sql.*;
import java.util.*;

import vo.community.*;

public class CampaignReviewBlockDAO {

	//싱글톤 디자인 패턴
	private static CampaignReviewBlockDAO instance = new CampaignReviewBlockDAO();
	
	private CampaignReviewBlockDAO() {}
	
	public static CampaignReviewBlockDAO getInstance() {
		return instance;
	}	
	
	private Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	//게시글 신고
	public int insertCampaignReviewBlock(CampaignReviewBlockDTO cam_re_block) {
		System.out.println("CampaignReviewBlockDAO");
		
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = 1;
		
		try {
			//새 신고글번호 저장
			String sql = "SELECT MAX(cam_re_block_idx) FROM cam_re_block";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			}
			
			close(pstmt);
			
			//신고글 DB에 저장
			sql = "INSERT INTO cam_re_block VALUES (?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, cam_re_block.getCam_re_block_ref());
			pstmt.setString(3, cam_re_block.getCam_re_block_id());
			pstmt.setString(4, cam_re_block.getCam_re_block_reason());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CampaignReviewBlockDAO - insertCampaignReviewBlock 오류");
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return insertCount;
	}

	//신고글 조회
	public ArrayList<CampaignReviewBlockDTO> getBlockList() {
		
		ArrayList<CampaignReviewBlockDTO> blockList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM cam_re_block ORDER BY cam_re_block_ref";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			blockList = new ArrayList<CampaignReviewBlockDTO>();
			
			while(rs.next()) {
				CampaignReviewBlockDTO cam_re_block = new CampaignReviewBlockDTO();
				cam_re_block.setCam_re_block_idx(rs.getInt("cam_re_block_idx"));
				cam_re_block.setCam_re_block_ref(rs.getInt("cam_re_block_ref"));
				cam_re_block.setCam_re_block_id(rs.getString("cam_re_block_id"));
				cam_re_block.setCam_re_block_reason(rs.getString("cam_re_block_reason"));
				cam_re_block.setCam_re_block_date(rs.getDate("cam_re_block_date"));
				
				blockList.add(cam_re_block);
			}
			
//			System.out.println(blockList.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CampaignReviewBlockDAO - getBlockList 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return blockList;
	}

	//신고글 상세조회
	public CampaignReviewBlockDTO selectCampaignReviewBlockDetail(int cam_re_block_ref) {
		
		CampaignReviewBlockDTO cam_re_block = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM cam_re_block WHERE cam_re_block_ref=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cam_re_block_ref);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cam_re_block = new CampaignReviewBlockDTO();
				cam_re_block.setCam_re_block_idx(rs.getInt("cam_re_block_idx"));
				cam_re_block.setCam_re_block_ref(rs.getInt("cam_re_block_ref"));
				cam_re_block.setCam_re_block_id(rs.getString("cam_re_block_id"));
				cam_re_block.setCam_re_block_reason(rs.getString("cam_re_block_reason"));
				cam_re_block.setCam_re_block_date(rs.getDate("cam_re_block_date"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CampaignReviewBlockDAO - selectCampaignReviewBlockDetail 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return cam_re_block;
	}
	
}
