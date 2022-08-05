package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.ImgDTO;

public class imgDAO {
	

	private static imgDAO instance = new imgDAO();
	private imgDAO() {}
	public static imgDAO getInstance() {
		return instance;
		
	}	
	
	private Connection con;
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	// ----------------------------------------------------------------------------------------

	
	public int insertBoard(ImgDTO dto) {
		System.out.println("5 - dao");
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		

		
		try {

			// 전달받은 데이터를 board 테이블에 INSERT
			String sql = "INSERT INTO board VALUES (?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getBoard_Name());
			pstmt.setString(2, dto.getBoard_subject());
			pstmt.setString(3, dto.getBoard_content());
			pstmt.setString(4, dto.getBoard_file());
			pstmt.setString(5, dto.getBoard_real_file());
	
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 발생! - insertBoard()");
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	
	
	}
	public ArrayList<ImgDTO> selectBoardList() {
		System.out.println("5 - dao");
		ArrayList<ImgDTO> boardList = null;
		
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		boardList = new ArrayList<ImgDTO>();
		
		
		try {
			String sql = "SELECT * FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			// while 문을 사용하여 조회 결과에 대한 반복 작업 수행
			while(rs.next()) {
				
				// 1개 게시물 정보를 저장할 BoardDTO 객체 생성
				ImgDTO board = new ImgDTO();
				
				// 게시물 정보 저장
				board.setBoard_Name(rs.getString("board_name"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_real_file(rs.getString("board_real_file"));


				// 전체 게시물 정보를 저장하는 ArrayList 객체에 1개 게시물 정보 BoardDTO 객체 추가
				boardList.add(board);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return boardList;
	}
	
	
	
	
	
	
	
	
	
}
