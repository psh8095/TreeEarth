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
		
		// 글쓰기 작업
		public int insertFreeBoard(FreeboardDTO board) {
			int insertCount = 0; // insert 작업결과 리턴받아 저장할 변수 선언
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int idx = 1; // 새 글 번호를 저장할 변수
			
			try {
				String sql = "SELECT MAX(freeboard_num) FROM freeboard";
				
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					idx = rs.getInt(1) + 1; // 조회된 가장 큰 번호 + 1 값을 새 글 번호로 저장
				}
				
				close(pstmt);
				
				sql = "INSERT INTO freeboard VALUES(?,?,?,?,?,?,?,?,?,now())";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, idx);
				pstmt.setString(2, board.getFree_name());
				pstmt.setString(3, board.getFree_pass());
				pstmt.setString(4, board.getFree_subject());
				pstmt.setString(5, board.getFree_content());
				pstmt.setString(6, board.getFree_img());
				pstmt.setString(7, board.getFree_original_img());
				pstmt.setInt(8, board.getFree_block());
				pstmt.setDate(9, board.getFree_date());
				
				insertCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 - insertFreeBoard()");
			} finally {
				close(rs);
				close(pstmt);
			}
	
			return insertCount;
		}
	
		
		// 게시판 글 작성시간 체크
		public String getDate() {
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT NOW()"; // 현재 시간을 가지고오는 mysql 구문
				
				pstmt = con.prepareStatement(sql); 
				rs = pstmt.executeQuery();
				
				if (rs.next()) { 
					return rs.getString(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 - getDate()");
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return "";
		}

		
		// 게시물 목록 조회
		public ArrayList<FreeboardDTO> selectFreeBoardList(int pageNum, int listLimit) {
			ArrayList<FreeboardDTO> boardList = null;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int startRow = (pageNum - 1) * listLimit;
			
			try {
				
				String sql = "SELECT * FROM freeboard ORDER BY board_num DESC LIMIT ?,?";
				
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
					board.setFree_original_img(rs.getString("free_original_img"));
					board.setFree_readcount(rs.getInt("free_readcount"));
					board.setFree_block(rs.getInt("free_block"));
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

		// 하나의 글 내용을 불러오는 함수 생성
		public FreeboardDTO selectFreeBoardList(int free_idx) {
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT * FROM freeboard WHERE free_idx = ?"; // free_idx 가 특정한 숫자 일 경우 아래 코드 실행
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, free_idx); // ?에 값을 넣어서 그 숫자에 해당하는 free_idx를 가져옴
				rs = pstmt.executeQuery();
				
				if (rs.next()) { // 결과가 나왔다면
					FreeboardDTO board = new FreeboardDTO();
					board.setFree_idx(rs.getInt("free_idx"));
					board.setFree_name(rs.getString("free_name"));
					board.setFree_pass(rs.getString("free_pass"));
					board.setFree_subject(rs.getString("free_subject"));
					board.setFree_content(rs.getString("free_content"));
					board.setFree_img(rs.getString("free_img"));
					board.setFree_original_img(rs.getString("free_original_img"));
					board.setFree_readcount(rs.getInt("free_readcount"));
					board.setFree_block(rs.getInt("free_block"));
					board.setFree_date(rs.getDate("free_date"));
					return board; // 결과로 나온 위 변수들을 모두 board에 담아서, 그대로 selectBoardList함수를 불러오는 대상한테 반환해줌
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return null; // 결과값이 없다면 null 반환
		}
		
		
		// 조회수 증가
		public void updateReadcount(int board_num) {
			PreparedStatement pstmt = null;
			
			try {
				String sql = "UPDATE freeboard SET free_readcount=board_readcount+1 WHERE board_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 - updateReadcount() : " + e.getMessage());
			} finally {
				close(pstmt);
			}
		}
		
		// 전체 게시물 수 조회
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
				System.out.println("SQL 구문 오류 - selectListCount() : " + e.getMessage());
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return listCount;
		}
		
		// 글 수정
		public int update(int free_idx, String free_subject, String free_content) {
			int updateCount = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = "UPDATE BBS SET free_subject = ?, free_content =? WHERE free_idx =?"; // 특정한 free_idx에 해당하는 글의 제목과 내용을 변경하는 구문
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, free_subject);
				pstmt.setString(2, free_content);
				pstmt.setInt(3, free_idx); // ? 에 해당하는 값을 넣어줌
				return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 - update() : " + e.getMessage());
			} finally {
				close(pstmt);
			}
			
			return updateCount;
		}
		
		// 글 삭제 권한 판별
		public boolean isFreeBoardWriter(int board_num, String board_pass) {
			boolean isFreeBoardWriter = false;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				// 글번호와 패스워드가 모두 일치하는 레코드 조회
				String sql = "SELECT * FROM freeboard WHERE board_num=? AND board_pass=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				pstmt.setString(2, board_pass);
				
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
		
		
		// 글 삭제 수행
		public int deleteBoard(int board_num) {
			int deleteCount = 0;
			
			PreparedStatement pstmt = null;
			
			try {
				String sql = "DELETE FROM freeboard WHERE board_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, board_num);
				
				deleteCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQL 구문 오류 - deleteBoard() : " + e.getMessage());
			} finally {
				close(pstmt);
			}
			
			return deleteCount;
		}


}
