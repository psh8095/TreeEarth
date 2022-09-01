package dao;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;

import vo.community.*;

public class FreeBoardBlockDAO {

	//싱글톤 디자인 패턴
	private static FreeBoardBlockDAO instance = new FreeBoardBlockDAO();
	
	private FreeBoardBlockDAO() {}
	
	public static FreeBoardBlockDAO getInstance() {
		return instance;
	}	
	
	private Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	//게시글 신고
	public int insertFreeBoardBlock(FreeBoardBlockDTO free_block) {
		
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		
		int num = 1;
		
		try {
			//새 신고글번호 저장
			String sql = "SELECT MAX(free_block_idx) FROM free_block";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			}
			
			//신고글 DB에 저장
			sql = "INSERT INTO free_block VALUES (?,?,?,?,now())";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, num);
			pstmt2.setInt(2, free_block.getFree_block_ref());
			pstmt2.setString(3, free_block.getFree_block_id());
			pstmt2.setString(4, free_block.getFree_block_reason());
			
			insertCount = pstmt2.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FreeBoardBlockDAO - insertFreeBoardBlock() 메서드 오류");
		} finally {
		}
		
		return insertCount;
	}

	//신고글 조회
	public ArrayList<FreeBoardBlockDTO> getBlockList() {
		
		ArrayList<FreeBoardBlockDTO> blockList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM free_block ORDER BY free_block_ref";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			blockList = new ArrayList<FreeBoardBlockDTO>();
			
			while(rs.next()) {
				FreeBoardBlockDTO free_block = new FreeBoardBlockDTO();
				free_block.setFree_block_idx(rs.getInt("free_block_idx"));
				free_block.setFree_block_ref(rs.getInt("free_block_ref"));
				free_block.setFree_block_id(rs.getString("free_block_id"));
				free_block.setFree_block_reason(rs.getString("free_block_reason"));
				free_block.setFree_block_date(rs.getDate("free_block_date"));
				
				blockList.add(free_block);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FreeBoardBlockDAO - getBlockList() 메서드 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return blockList;
	}

	//신고글 상세조회
	public FreeBoardBlockDTO selectFreeBoardBlockDetail(int free_block_ref) {
		
		FreeBoardBlockDTO free_block = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM free_block WHERE free_block_ref=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, free_block_ref);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				free_block = new FreeBoardBlockDTO();
				free_block.setFree_block_idx(rs.getInt("free_block_idx"));
				free_block.setFree_block_ref(rs.getInt("free_block_ref"));
				free_block.setFree_block_id(rs.getString("free_block_id"));
				free_block.setFree_block_reason(rs.getString("free_block_reason"));
				free_block.setFree_block_date(rs.getDate("free_block_date"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FreeBoardBlockDAO - selectFreeBoardBlockDetail() 메서드 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return free_block;
	}
	
}
