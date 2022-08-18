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
				String sql = "SELECT MAX(cam_idx)FROM campaign";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					num = rs.getInt(1) + 1; // 조회된 가장 큰 번호 + 1 값을 새 글 번호로 저장
				}
			
			close(pstmt);
			
			//새 글 DB에 저장
			sql = "INSERT INTO campaign VALUES(?,?,?,?,?,now(),?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, campaign.getCam_people());
			pstmt.setString(3, campaign.getCam_subject());
			pstmt.setString(4, campaign.getCam_content());
			pstmt.setInt(5, campaign.getCam_readcount());
			pstmt.setString(6, campaign.getCam_thum_file());
			pstmt.setString(7, campaign.getCam_thum_real_file());
			pstmt.setString(8, campaign.getCam_img());
			pstmt.setString(9, campaign.getCam_original_img());
			
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
	public ArrayList<CampaignDTO> selectCampaignList(int pageNum, int listLimit) {
			ArrayList<CampaignDTO> campaignList = null;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int startRow = (pageNum - 1) * listLimit;
		
		try {
				String sql = "SELECT * FROM campaign ORDER BY cma_idx LIMIT ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, listLimit);
				
				rs = pstmt.executeQuery();
				
				campaignList = new ArrayList<CampaignDTO>();
				
				while(rs.next()) {
					CampaignDTO campaign = new CampaignDTO();
					
					campaign.setCam_idx(rs.getInt("cam_idx"));
					campaign.setCam_people(rs.getInt("cam_people"));
					campaign.setCam_subject(rs.getString("cam_subject"));
					campaign.setCam_content(rs.getString("cam_content"));
					campaign.setCam_readcount(rs.getInt("cam_readcount"));
					campaign.setCam_date(rs.getDate("cam_date"));
					campaign.setCam_thum_file(rs.getString("cam_thum_file"));
					campaign.setCam_thum_real_file(rs.getString("cam_thum_real_file"));
					campaign.setCam_img(rs.getString("cam_img"));
					campaign.setCam_original_img(rs.getString("cam_original_img"));
					
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
			String sql = "SELECT * FROM campaign WHERE cam_dix=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cam_idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				campaign = new CampaignDTO();
				campaign.setCam_idx(rs.getInt("cam_idx"));
				campaign.setCam_people(rs.getInt("cam_people"));
				campaign.setCam_subject(rs.getString("cam_subject"));
				campaign.setCam_content(rs.getString("cam_content"));
				campaign.setCam_readcount(rs.getInt("cam_readcount"));
				campaign.setCam_date(rs.getDate("cam_date"));
				campaign.setCam_thum_file(rs.getString("cam_thum_file"));
				campaign.setCam_thum_real_file(rs.getString("cam_thum_real_file"));
				campaign.setCam_img(rs.getString("cam_img"));
				campaign.setCam_original_img(rs.getString("cam_original_img"));
				
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
	
	//조회수 증가
	public void updateReadcount(int cam_idx) {
			PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE campaign SET cam_readcount=cam_readcount+1 WHERE cam_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cam_idx);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CampaignDAO - updateReadcount 오류");
		} finally {
			close(pstmt);
		}
	}
	
	//게시물 수정
	public int updateCampaign(CampaignDTO campaign) {
			int updateCount = 0;
			
			PreparedStatement pstmt = null;
		
		try {
				String sql = "UPDATE campaign SET cam_subject=?,cam_content=? WHERE cam_idx=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, campaign.getCam_subject());
				pstmt.setString(2, campaign.getCam_content());
				pstmt.setInt(3, campaign.getCam_idx());
				
				updateCount = pstmt.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CampaignDAO - updateCampaign 오류");
		} 

		return updateCount;
	}
	
	//게시글 권한 판별
	public boolean isCampaignWriter(int cam_idx, String mem_pass) {
			boolean isCampaignWriter = false;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
		try {
				String sql = "SELECT * FROM campaign c, member m WHERE c.cam_id = m.mem_pass=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mem_pass);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					isCampaignWriter = true;
				}
				
		} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("CampaignDAO - isCampaignWriter 오류");
		} finally {
				close(rs);
				close(pstmt);
		}
			
		 return isCampaignWriter;
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
	
}
