package dao;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.ArrayList;

import db.*;
import vo.*;
import vo.community.*;

public class DiaryDAO {

//	멤버변수 및 인스턴스 생성
	private static DiaryDAO instance = new DiaryDAO();

	// 2. 생성자 정의
	private DiaryDAO() {
	}

	// 3. Getter 정의(자동 생성)
	public static DiaryDAO getInstance() {
		return instance;
	}

	// ----------------------------------------------------------------------------------------
	// 외부(Service 클래스)로부터 Connection 객체를 전달받아 관리하기 위해
	// Connection 타입 멤버변수와 Setter 메서드 정의
	private Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}

	//전체 게시물 갯수 조회
	public int selectListCount() {
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM diary";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DiaryDAO - selectListCount 오류 : " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;

	}
	//목록 조회
	public ArrayList<DiaryDTO> selectDiaryList(int pageNum, int listLimit) {
		System.out.println("5.selectDiaryList");
		ArrayList<DiaryDTO> diaryList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int startRow = (pageNum - 1) * listLimit;
		
		try {
			String sql = "SELECT * FROM diary ORDER BY diary_idx DESC LIMIT ?,? " ;
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, listLimit);
			
			rs = pstmt.executeQuery();
			
			diaryList = new ArrayList<DiaryDTO>();
			
			while(rs.next()) {
				DiaryDTO diary = new DiaryDTO();
				diary.setDiary_idx(rs.getInt("diary_idx"));
				diary.setDiary_id(rs.getString("diary_id"));
				diary.setDiary_subject(rs.getString("diary_subject"));
				diary.setDiary_content(rs.getString("diary_content"));
				diary.setDiary_img(rs.getString("diary_img"));
				diary.setDiary_real_img(rs.getString("diary_real_img"));
				diary.setDiary_thumb_img(rs.getString("diary_thumb_img"));
				diary.setDiary_thumb_real_img(rs.getString("diary_thumb_real_img"));
				diary.setDiary_readcount(rs.getInt("diary_readcount"));
				diary.setDiary_date(rs.getDate("diary_date"));
				
				diaryList.add(diary);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DiaryDAO - selectDiaryList 오류" + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return diaryList;
	}

	public int insertDiary(DiaryDTO diary) {
		System.out.println("5.insertDiary");
		
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//글 번호 지정
		int num = 1;
		
		//가장 높은 글 번호 값 조회
		try {
			String sql = "SELECT MAX(diary_idx) FROM diary";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//기존 글 존재시
			if(rs.next()) {
				num = rs.getInt(1) + 1;
				System.out.println("5-1. 글번호 상승");
			}
			sql = "INSERT INTO diary VALUES (?,?,?,?,?,?,?,?,?,0,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, diary.getDiary_id());
			pstmt.setString(3, diary.getDiary_subject());
			pstmt.setString(4, diary.getDiary_content());
			pstmt.setString(5, diary.getDiary_img());
			pstmt.setString(6, diary.getDiary_real_img());
			pstmt.setString(7, diary.getDiary_thumb_img());
			pstmt.setString(8, diary.getDiary_thumb_real_img());
			pstmt.setInt(9, 0);
			
			insertCount = pstmt.executeUpdate();
			System.out.println("5-2. 게시물 등록!");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insertDiary 오류 :" + e.getMessage());
		}finally{
			close(pstmt);
			close(rs);
		}
		return insertCount;
	}

	public DiaryDTO selectDiaryDetail(int diary_idx) {
		DiaryDTO diary = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM diary WHERE diary_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, diary_idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				diary = new DiaryDTO();
				diary.setDiary_idx(rs.getInt("diary_idx"));
				diary.setDiary_id(rs.getString("diary_id"));
				diary.setDiary_subject(rs.getString("diary_subject"));
				diary.setDiary_content(rs.getString("diary_content"));
				diary.setDiary_img(rs.getString("diary_img"));
				diary.setDiary_real_img(rs.getString("diary_real_img"));
				diary.setDiary_thumb_img(rs.getString("diary_thumb_img"));
				diary.setDiary_thumb_real_img(rs.getString("diary_thumb_real_img"));
				diary.setDiary_readcount(rs.getInt("diary_readcount"));
				diary.setDiary_likecnt(rs.getInt("diary_likecnt"));
				diary.setDiary_date(rs.getDate("diary_date"));
				
				System.out.println(diary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("selectCampaignReviewDetail 오류 :" + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return diary;
	}

	public void updateReadcount(int diary_idx) {
			PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE diary SET diary_readcount=diary_readcount+1 WHERE diary_idx=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, diary_idx);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("updateReadcount 오류 : " + e.getMessage());
		} finally {
			close(pstmt);
		}
		
	}


	public boolean isDiaryWriter(int diary_idx, String mem_pass) {
	System.out.println("5.isDiaryWriter");
		boolean isDiaryWriter = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM diary d, member m WHERE d.diary_id = m.mem_id AND mem_pass = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_pass);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isDiaryWriter = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("isDiaryWriter 오류 : " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return isDiaryWriter;
	}

	public int deleteDiary(int diary_idx) {
		System.out.println("6.deleteDiary");
		
		int deleteCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM diary WHERE diary_idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, diary_idx);
			
			deleteCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(" deleteDiary 오류 : " + e.getMessage());
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}

	public int updateDiary(DiaryDTO diary) {
		int updateCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE diary SET diary_subject=?,diary_content=? WHERE diary_idx=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, diary.getDiary_subject());
			pstmt.setString(2, diary.getDiary_content());
			pstmt.setInt(3, diary.getDiary_idx());
			
			updateCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("updateCampaignReview 오류 :"  + e.getMessage());
		}
		
		return updateCount;
	}

	public int updateLike(int diaryno, String mid) {
		
		  int updateLike = 0;
	      boolean isSelect = false;
	      /*
	       * idx와 nickname에 해당하는 data를 조회시 return 값이 0일경우
	       * likes 에 + 1을 update
	       * 
	       * return 값이 있을 경우
	       * 해당데이터 delete
	       * 
	       * 둘중의 하나의 처리가 완료 되었을 경우 updateLike = 1;
	       */
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      int num = 1;
	      
	      // 1. 좋아요가 있는지 없는지 조회
	      try {
	         String sql = "SELECT * FROM d_heart WHERE diaryno=? AND mid=?";
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, diaryno);
	         pstmt.setString(2, mid);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	            isSelect = true; 
	         }
	         
	         close(pstmt);
	         close(rs);
	         
	         sql = "SELECT MAX(like_idx) FROM d_heart";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				//기존 글 존재시
				if(rs.next()) {
					num = rs.getInt(1) + 1;
				}
				
				close(pstmt);
	         
	         if(!isSelect) { // likes 가 없을 경우, insert
	            sql = "INSERT INTO d_heart VALUES(?, 1, ?, ?)";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setInt(1, num);
	            pstmt.setInt(2,diaryno);
	            pstmt.setString(3, mid);
	            updateLike = pstmt.executeUpdate();
	            System.out.println("review_likes - 좋아요 추가");
	         
	         } else { // likes가 있는 경우 기존의 data를 delete
	            
	            sql="DELETE FROM d_heart WHERE diaryno=? AND mid=?";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setInt(1, diaryno);            
	            pstmt.setString(2, mid);
	            updateLike = pstmt.executeUpdate();
	            updateLike = -1;
	            System.out.println("review_likes - 좋아요 취소");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	         System.out.println("sql 구문 실행 및 작성오류 - review_likes update");
	      } finally {
	         close(pstmt);
	      }
	      return updateLike;
	   }
	
	public int updateDiary(int diaryno, int updateLike, int likecnt) {
		System.out.println(likecnt);
	      int updateCount = 0;
	      String sql = "";
	      PreparedStatement pstmt = null;
	   
	      if (updateLike == 1) {
	         sql =  "UPDATE diary d"
	         		+ "inner join d_heart h on d.diary_idx= h.diaryno"
	         		+ "SET d.likecnt = d.likecnt + h.likeno WHERE h.diaryno=?";
	         System.out.println("리뷰 좋아요 증가");
	      } else {
	         if(updateLike  > 0) {
	         sql = "UPDATE diary SET likecnt=likecnt  - 1 WHERE diaryno=?";
	         } else {
	            sql = "UPDATE diary SET likecnt = 0 WHERE diaryno=?";
	         }
	         System.out.println("다이어리 좋아요 취소");
	      }
	      
	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, diaryno);
	         updateCount = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	         System.out.println("sql 구문 작성 및 실행 오류 - updateReview - (reviewBoard좋아요");
	      }

	      return updateCount;
	   }

}