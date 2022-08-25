package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.community.FreeboardDTO;

import static db.JdbcUtil.*;

public class FreeBoardDAO {

		private static FreeBoardDAO instance = new FreeBoardDAO();
		
		private FreeBoardDAO() {}
		
		public static FreeBoardDAO getInstance() {
			return instance;
		}
	
		private Connection con;
	
		public void setConnection(Connection con) {
			this.con = con;
		}
		
		// 자유게시판 글 작성하는 함수 (완료)
		public int insertFreeBoard(FreeboardDTO board) {
			int insertCount = 0; // insert 작업결과 리턴받아 저장할 변수 선언
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int idx = 1; // 새 글 번호를 저장할 변수
			
			try {
				String sql = "SELECT MAX(free_idx) FROM freeboard";
				
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					idx = rs.getInt(1) + 1; // 조회된 가장 큰 번호 + 1 값을 새 글 번호로 저장
				}
				
				close(pstmt);
				
				sql = "INSERT INTO freeboard VALUES(?,?,?,?,?,?,?,?,?,?,now())";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, idx);
				pstmt.setString(2, board.getFree_name());
				pstmt.setString(3, board.getFree_pass());
				pstmt.setString(4, board.getFree_subject());
				pstmt.setString(5, board.getFree_content());
				pstmt.setString(6, board.getFree_img());
				pstmt.setInt(7, idx); // free_re_ref
				pstmt.setInt(8, 0); // free_re_lev
				pstmt.setInt(9, 0); // free_re_seq
				pstmt.setInt(10, 0); // free_readcount
				
				insertCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 발생! - insertFreeBoard()");
			} finally {
				close(rs);
				close(pstmt);
			}
	
			return insertCount;
		}
	
		// 게시물 목록 조회 (완료)
		public ArrayList<FreeboardDTO> selectFreeBoardList(int pageNum, int listLimit) {
			ArrayList<FreeboardDTO> boardList = null;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int startRow = (pageNum - 1) * listLimit;
			
			try {
				String sql = "SELECT * FROM freeboard ORDER BY free_re_ref DESC, free_re_seq ASC LIMIT ?,?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, listLimit);
				
				rs = pstmt.executeQuery();
				
				boardList = new ArrayList<FreeboardDTO>();
				
				while(rs.next()) {
					FreeboardDTO board = new FreeboardDTO();
					// 게시물 정보 저장
					board.setFree_idx(rs.getInt("free_idx"));
					board.setFree_name(rs.getString("free_name"));
					board.setFree_pass(rs.getString("free_pass"));
					board.setFree_subject(rs.getString("free_subject"));
					board.setFree_content(rs.getString("free_content"));
					board.setFree_img(rs.getString("free_img"));
					board.setFree_re_ref(rs.getInt("free_re_ref"));
					board.setFree_re_lev(rs.getInt("free_re_lev"));
					board.setFree_re_seq(rs.getInt("free_re_seq"));
					board.setFree_readcount(rs.getInt("free_readcount"));
					board.setFree_date(rs.getDate("free_date"));
					System.out.println(board);
					
					boardList.add(board);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 발생! - selectFreeBoardList()");
			} finally {
				close(rs);
				close(pstmt);
			}
		
			return boardList;
		}

		// 1개의 자유게시판 글을 상세조회하는 메서드 (완료)
		public FreeboardDTO selectFreeBoardList(int free_idx) {
			
			FreeboardDTO board = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT * FROM freeboard WHERE free_idx = ?"; // free_idx 가 특정한 숫자 일 경우 아래 코드 실행
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, free_idx); // ?에 값을 넣어서 그 숫자에 해당하는 free_idx를 가져옴
				rs = pstmt.executeQuery();
				
				if (rs.next()) { // 결과가 나왔다면
					board = new FreeboardDTO();
					board.setFree_idx(rs.getInt("free_idx"));
					board.setFree_name(rs.getString("free_name"));
					board.setFree_pass(rs.getString("free_pass"));
					board.setFree_subject(rs.getString("free_subject"));
					board.setFree_content(rs.getString("free_content"));
					board.setFree_img(rs.getString("free_img"));
					board.setFree_re_ref(rs.getInt("free_re_ref"));
					board.setFree_re_lev(rs.getInt("free_re_lev"));
					board.setFree_re_seq(rs.getInt("free_re_seq"));
					board.setFree_readcount(rs.getInt("free_readcount"));
					board.setFree_date(rs.getDate("free_date"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 발생! - selectFreeBoardList() " + e.getMessage());
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return board; // 결과값이 없다면 null 반환
		}
		
		
		// 조회수 증가 작업 처리 메서드 (완료)
		public void updateReadcount(int free_idx) {
			PreparedStatement pstmt = null;
			
			try {
				String sql = "UPDATE freeboard SET free_readcount=free_readcount+1 WHERE free_idx=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, free_idx);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 - updateReadcount() : " + e.getMessage());
			} finally {
				close(pstmt);
			}
		}
		
		// 전체 자유게시판 게시글 수 조회 (완료)
		public int selectListCount() {
			int listCount = 0;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT COUNT(*) FROM freeboard";
				pstmt = con.prepareStatement(sql);
				
				// 4단계
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					listCount = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 발생! - selectListCount() : " + e.getMessage());
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return listCount;
		}
		
		// 글 수정 작업을 수행하는 메서드 (완료)
		public int updateFreeBoard(FreeboardDTO board) {
			int updateCount = 0;
			
			PreparedStatement pstmt = null;
			
			try {
				String sql = "UPDATE freeboard SET free_name=?,free_subject=?,freeboard_content=? WHERE free_idx=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board.getFree_name());
				pstmt.setString(2, board.getFree_subject());
				pstmt.setString(3, board.getFree_content());
				pstmt.setInt(4, board.getFree_idx());
				
				updateCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 발생! - updateFreeBoard() : " + e.getMessage());
			} finally {
				close(pstmt);
			}
			
			return updateCount;
		}
		
		// 글 삭제 권한 판별 (완료)
		public boolean isFreeBoardWriter(int free_idx, String free_pass) {
			boolean isFreeBoardWriter = false;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				// 글번호와 패스워드가 모두 일치하는 레코드 조회
				String sql = "SELECT * FROM freeboard WHERE free_idx=? AND free_pass=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, free_idx);
				pstmt.setString(2, free_pass);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					// 조회 결과 있음 = 번호에 해당하는 패스워드가 일치한다
					isFreeBoardWriter = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 - isFreeBoardWriter() : " + e.getMessage());
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return isFreeBoardWriter;
		}
		
		
		// 글 삭제 작업 수행 메서드 (완료)
		public int deleteBoard(int free_idx) {
			int deleteCount = 0;
			
			PreparedStatement pstmt = null;
			
			try {
				String sql = "DELETE FROM freeboard WHERE free_idx=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, free_idx);
				
				deleteCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 발생! - deleteBoard() : " + e.getMessage());
			} finally {
				close(pstmt);
			}
			
			return deleteCount;
		}

		// 답글 작성을 수행하는 insertReplyFreeBoard() 메서드 (완료)
		public int insertReplyBoard(FreeboardDTO board) {
			int insertCount = 0;
			
			PreparedStatement pstmt = null, pstmt2 = null;
			ResultSet rs = null;
			
			int idx = 1; // 새 글 번호를 저장할 변수
			
			try {
				// 새 글 번호로 사용될 번호를 생성하기 위해 기존 게시물의 가장 큰 번호 조회
				// => 조회 결과가 있을 경우 해당 번호 + 1 값을 새 글 번호로 저장
				String sql = "SELECT MAX(free_idx) FROM freeboard";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					idx = rs.getInt(1) + 1; // 조회된 가장 큰 번호 + 1 값을 새 글 번호로 저장
				}
				
				// 기존 답글들에 대한 순서번호(free_re_seq) 증가 작업 처리
				// => 원본글의 참조글번호(free_re_ref) 와 같고(같은 레코드들 중에서)
				//    원본글의 순서번호(free_re_seq)보다 큰 레코드들의 순서번호를 1씩 증가시키기
				sql = "UPDATE freeboard SET free_re_seq=free_re_seq+1 "
						+ "WHERE free_re_ref=? AND free_re_seq>?";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setInt(1, board.getFree_re_ref()); // 참조글번호
				pstmt2.setInt(2, board.getFree_re_seq()); // 순서번호
				pstmt2.executeUpdate();
				
				// 답글을 freeboard 테이블에 INSERT 작업
				sql = "INSERT INTO freeboard VALUES (?,?,?,?,?,?,?,?,?,?,?,now())";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setInt(1, idx);
				pstmt2.setString(2, board.getFree_name());
				pstmt2.setString(3, board.getFree_pass());
				pstmt2.setString(4, board.getFree_subject());
				pstmt2.setString(5, board.getFree_content());
				// 답글 기능에서 파일 업로드 기능은 제외
				pstmt2.setString(6, "");
				pstmt2.setString(7, "");
				// ------------ 주의! 답글 관련 번호 ---------------
				// 답글에 사용될 참조글 번호(free_re_ref)는 원본글의 참조글번호와 동일
				pstmt2.setInt(8, board.getFree_re_ref()); // free_re_ref
				// 들여쓰기레벨(free_re_lev)과 순서번호(free_re_seq)는 원본글의 각 번호 + 1 
				pstmt2.setInt(9, board.getFree_re_lev() + 1); // free_re_lev
				pstmt2.setInt(10, board.getFree_re_seq() + 1); // free_re_seq
				// -------------------------------------------------
				pstmt2.setInt(11, 0); // free_readcount
				
				insertCount = pstmt2.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 - insertReplyBoard() : " + e.getMessage());
			} finally {
				close(pstmt);
				close(rs);
			}
			
			return insertCount;
		}

}
