package dao;

import static db.JdbcUtil.close;

import java.sql.*;
import java.util.*;

import vo.campaign.*;

public class CampaignDAO {

	//싱글톤 디자인 패턴
	private static CampaignDAO instance = new CampaignDAO();
	
	private CampaignDAO() {}
	
	public static CampaignDAO getInstance() {
		return instance;
	}	
	
	private Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	//----------------------------------------------------------------------------
	//글쓰기 작업
	public int insertCampaign(CampaignDTO campaign) {
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		int num = 1;
		
		try {
			// 새 글 번호로 사용될 번호를 생성하기 위해 기존 게시물의 가장 큰 번호 조회
			// => 조회 결과가 있을 경우 해당 번호 + 1 값을 새 글 번호로 저장
			String sql = "SELECT MAX(cam_idx) FROM campaign";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1; // 조회된 가장 큰 번호 + 1 값을 새 글 번호로 저장
			}
			
			close(pstmt);
			
			//새 글 DB에 저장
			sql = "INSERT INTO campaign VALUES(?,0,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, campaign.getCam_subject());
			pstmt.setString(3, campaign.getCam_content());
			pstmt.setString(4, campaign.getCam_img());
			pstmt.setString(5, campaign.getCam_real_img());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CampaignDAO - insertCampaign 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return insertCount;
		
	}	
	
	//전체 게시물 수 조회
	public int selectListCount() {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM campaign";
			pstmt = con.prepareStatement(sql);
				
			rs = pstmt.executeQuery();
				
			if(rs.next()) {
				listCount = rs.getInt(1);
		}
				
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CampaignDAO - selectListCount 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}
	
	//게시물 목록 조회
	public ArrayList<CampaignDTO> selectCampaignList() {
		ArrayList<CampaignDTO> campaignList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM campaign";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			campaignList = new ArrayList<CampaignDTO>();
			
			while(rs.next()) {
				CampaignDTO campaign = new CampaignDTO();
				
				campaign.setCam_idx(rs.getInt("cam_idx"));
				campaign.setCam_people(rs.getInt("cam_people"));
				campaign.setCam_subject(rs.getString("cam_subject"));
				campaign.setCam_content(rs.getString("cam_content"));
				campaign.setCam_img(rs.getString("cam_img"));
				campaign.setCam_real_img(rs.getString("cam_real_img"));
				
				campaignList.add(campaign);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CampaignDAO - selectCampaignList 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return campaignList;
	}
	
	//게시물 1개 상세 정보 조회
	public CampaignDTO selectCampaignDetail(int cam_idx) {
		CampaignDTO campaign = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			String sql = "SELECT * FROM campaign WHERE cam_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cam_idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				campaign = new CampaignDTO();
				campaign.setCam_idx(rs.getInt("cam_idx"));
				campaign.setCam_people(rs.getInt("cam_people"));
				campaign.setCam_subject(rs.getString("cam_subject"));
				campaign.setCam_content(rs.getString("cam_content"));
				campaign.setCam_img(rs.getString("cam_img"));
				campaign.setCam_real_img(rs.getString("cam_real_img"));
				
				System.out.println(campaign);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CampaignDAO - selectCampaignDetail 오류");
		} finally {
			close(rs);
			close(pstmt);
		}

		return campaign;
	}
	
	//게시물 삭제
	public int deleteCampaign(int cam_idx) {
		int deleteCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM campaign WHERE cam_idx";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cam_idx);
			
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CampaignDAO - deleteCampaign 오류");
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}

	// 캠페인 참가 신청 데이터 저장
	public int insertCampaignApply(CampaignApplyDTO apply) {
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO campaign_apply VALUES(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, apply.getCam_idx());
			pstmt.setString(2, apply.getMem_id());
			pstmt.setString(3, apply.getMem_phone());
			pstmt.setString(4, apply.getMem_email());
			pstmt.setString(5, apply.getMem_name());
			pstmt.setInt(6, apply.getApply_people());
			pstmt.setString(7, apply.getApply_etc());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - insertCampaignApply()");
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}

	// 관리자 - 캠페인 참가 신청 내역 조회(전체)
	public List<ApplyListDTO> selectCampaignApplyList() {
		List<ApplyListDTO> applyList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM campaign c JOIN campaign_apply a ON c.cam_idx = a.cam_idx";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			applyList = new ArrayList<ApplyListDTO>();
			
			while(rs.next()) {
				ApplyListDTO apply = new ApplyListDTO();
				apply.setCam_idx(rs.getInt("cam_idx"));
				apply.setCam_subject(rs.getString("cam_subject"));
				apply.setMem_phone(rs.getString("mem_phone"));
				apply.setMem_name(rs.getString("mem_name"));
				apply.setApply_people(rs.getInt("apply_people"));
				apply.setApply_etc(rs.getString("apply_etc"));
				apply.setMem_id(rs.getString("mem_id"));
				
				applyList.add(apply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - selectCampaignApplyList()");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return applyList;
	}
	
	// 사용자 - 캠페인 참가 신청 내역 조회(개인)
	public List<ApplyListDTO> selectCampaignApplyList(String sId) {
		List<ApplyListDTO> applyList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM campaign c JOIN campaign_apply a ON c.cam_idx = a.cam_idx WHERE mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			rs = pstmt.executeQuery();
			
			applyList = new ArrayList<ApplyListDTO>();
			
			while(rs.next()) {
				ApplyListDTO apply = new ApplyListDTO();
				apply.setCam_idx(rs.getInt("cam_idx"));
				apply.setCam_subject(rs.getString("cam_subject"));
				apply.setMem_phone(rs.getString("mem_phone"));
				apply.setMem_name(rs.getString("mem_name"));
				apply.setApply_people(rs.getInt("apply_people"));
				apply.setApply_etc(rs.getString("apply_etc"));
				apply.setMem_id(rs.getString("mem_id"));
				
				applyList.add(apply);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - selectCampaignApplyList()");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return applyList;
	}
}
