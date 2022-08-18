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
	
	
	// @회원 가입@----------------------------------------------------------------------------------------
	
	
	//인증 번호 전송 - (이메일과 인증코드 등록)
	public int registAuthCode(String email, String authCode) {
		System.out.println("5. DAO");
		int registCount = 0;
				
		
		PreparedStatement pstmt = null, pstmt2 = null, pstmt3 = null, pstmt4 = null ;
		ResultSet rs = null;
		String sql = null, sql2 = null, sql3 = null, sql4 = null;
		int authCount = 1;
				
		
		try {
					
					
			//전달 받은 이메일에 대한 기존 인증코드가 존재하는지 판별
			sql = "SELECT mem_auth FROM auth WHERE mem_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
				
			
			// 기존 인증코드가 존재하지 않는 경우 	
			if(!rs.next()) { 
				
				
				//insert문으로 email,authCode,authCount를 입력
				sql2 = "INSERT INTO auth VALUES (?,?,?)";
				pstmt2 = con.prepareStatement(sql2);
				pstmt2.setString(1, email);
				pstmt2.setString(2, authCode);
				pstmt2.setInt(3, authCount);
				pstmt2.executeUpdate();
				
				System.out.println("5-1. 인증코드 등록 성공.");
				registCount = 1;

						
						
			// 기존 인증코드가 이미 존재하는 경우 
			} else { 
				
				
				//인증이 완료된 이메일일 경우 
				if(rs.getString("mem_auth").equals("*")) {
					
					System.out.println("5-1. 인증이 완료된 이메일");
					registCount = 1;		
				
					
					
				//인증이 완료되지 않은 이메일일 경우	
				} else {
					
					//카운트가 5이상일 때 					
					sql3 = "UPDATE auth SET mem_auth = ?, mem_auth_count = ? WHERE mem_auth_count = ?";
					pstmt3 = con.prepareStatement(sql3);
					pstmt3.setString(1, "0");
					pstmt3.setString(2, "0");
					pstmt3.setString(3, "5");					
					int updateCount = pstmt3.executeUpdate();
					
					if(updateCount > 0) {
						System.out.println("5-1. 인증코드 초기화.");
						registCount = 1;
						
						
					//카운트가 5미만일 때	
					} else {
				
					
					//update문으로 authCode와 authCount를 갱신
					sql4 = "UPDATE auth SET mem_auth=?, mem_auth_count = mem_auth_count +1 WHERE mem_email=?";
					pstmt4 = con.prepareStatement(sql4);
					pstmt4.setString(1, authCode);
					pstmt4.setString(2, email);
					pstmt4.executeUpdate();
					System.out.println("5-1. 인증코드 갱신 성공.");
					registCount = 1;
					
					}
					
				}
				
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - registAuthCode() 메서드 오류 : " + e.getMessage());
		} finally {
	
		}
				
				
		return registCount;
	}
	
	
	// ----------------------------------------------------------------------------------------

	
	//인증 확인 버튼 - (인증코드 일치 판별)
	public int checkAuthCode(AuthDTO dto) {
		System.out.println("5. DAO");
		
		//인증에 실패할 경우 - 0
		int checkAuthCode = 0;
		
		
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null, rs2 = null, rs3 = null;
		String sql = "", sql2 = "";
		
	
			try {
				// 해당 이메일에 어스코드를 출력
				sql = "SELECT mem_auth FROM auth WHERE mem_email=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getMem_email());
				rs = pstmt.executeQuery();
				
				
				if(rs.next()) {//어스 코드가 있다면
	
					
					//중복 이메일 등록 방지 
					if(rs.getString("mem_auth").equals("*")) {
						
						System.out.println("5-1. 이메일 중복.");
						checkAuthCode = 2;
					
	
					//어스코드 초기화 시 등록 방지
					} else if(rs.getString("mem_auth").equals("0")) {
						System.out.println("5-1. 이메일 인증오류");
						checkAuthCode = 3;
						
						
					//어스 코드가 유효하다면
					} else {

					
						//전달받은 이메일과 authCode 판별 작업 
						sql2 = "SELECT * FROM auth WHERE mem_email=? and mem_auth=?";
						pstmt2 = con.prepareStatement(sql2);
						pstmt2.setString(1, dto.getMem_email());
						pstmt2.setString(2, dto.getMem_auth());
						rs2 = pstmt2.executeQuery();
						
						
						//해당 이메일의 인증코드가 일치할 경우 - 1
						if(rs2.next()) { 

							System.out.println("5-1. 코드 일치.");
							checkAuthCode = 1;
							
							
						//해당 이메일의 인증코드가 일치하지 않을 경우 - 0	
						} else {

							System.out.println("5-1. 코드 불일치.");
						}
					
						
					}
					
				} else {

				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("MemberDAO - checkAuthCode() 메서드 오류 : " + e.getMessage());
			} finally {
				
			}
		
		return checkAuthCode;
	}
	
	
	// ----------------------------------------------------------------------------------------


	
	//회원 가입
	public int insertMember(MemberDTO dto) {
		System.out.println("5. DAO");
		int insertCount = 0;
		
		
		PreparedStatement pstmt = null, pstmt2 = null;
		String sql = "", sql2 = "";
		
		
		try {
			//db에 받아온 데이터 넣기
			sql = "INSERT INTO member VALUES (?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMem_id());
			pstmt.setString(2, dto.getMem_pass());
			pstmt.setString(3, dto.getMem_name());
			pstmt.setDate(4, dto.getMem_birth());
			pstmt.setString(5, dto.getMem_gender());
			pstmt.setString(6, dto.getMem_address());
			pstmt.setString(7, dto.getMem_address_detail());
			pstmt.setString(8, dto.getMem_phone());
			pstmt.setString(9, dto.getMem_email());
			pstmt.setInt(10, 0);
			
			insertCount = pstmt.executeUpdate();
			
			
			//데이터 입력에 성공하면 인증 코드를 '*'로 변경(중복 확인용)
			if(insertCount > 0) {
				
				System.out.println("5-1. 인증코드 변경완료");
				sql2 = "UPDATE auth SET mem_auth=? WHERE mem_email=?";
				pstmt2 = con.prepareStatement(sql2);
				pstmt2.setString(1, "*");
				pstmt2.setString(2, dto.getMem_email());
				pstmt2.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - insertMember() 메서드 오류 : " + e.getMessage());
		} finally {
	
		}
		
		
		return insertCount;
	}
	
	
	// ----------------------------------------------------------------------------------------


	//아이디 중복 체크
	public int checkId(String id) {
		System.out.println("5. DAO");
		int checkId = 0;
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			
			String sql = "SELECT * FROM member WHERE mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			
			//중복이라면 
			if(rs.next()) {
			System.out.println("5-1. 아이디 중복");
			
			//중복이 아니라면
			} else {
			System.out.println("5-2. 아이디 체크 완료");
				checkId = 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	
		}
		
		
		return checkId;
	}
	
	
	// @로그인@ ----------------------------------------------------------------------------------------

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

	//이름, 휴대폰으로 id 찾기
	public MemberDTO isMemberIdPhone(String mem_name, String mem_phone) {

		MemberDTO member = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM member WHERE mem_name=? AND mem_phone=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_name);
			pstmt.setString(2, mem_phone);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDTO();
				member.setMem_id(rs.getString("mem_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MemberDAO - isMemberId 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}
	
	//이름, 이메일로 id 찾기
	public MemberDTO isMemberIdEmail(String mem_name, String mem_email) {
		
		MemberDTO member = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM member WHERE mem_name=? AND mem_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_name);
			pstmt.setString(2, mem_email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDTO();
				member.setMem_id(rs.getString("mem_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MemberDAO - isMemberId 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}

	//id, email 일치하는 회원 조회
	public boolean isMemberEmail(String mem_id, String mem_email) {
		
		boolean isMemberEmail = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM member WHERE mem_id=? AND mem_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isMemberEmail = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MemberDAO - isMemberEmail 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return isMemberEmail;
	}

	//아이디, 이메일로 pass 찾기
	public MemberDTO isMemberPass(String mem_id, String mem_email) {
		
		MemberDTO member = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM member WHERE mem_id=? AND mem_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDTO();
				member.setMem_pass(rs.getString("mem_pass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MemberDAO - isMemberPass 오류");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}
	
	// 결제에 필요한 회원 1명의 정보 조회
	public MemberDTO selectMemberInfo(String sId) {
		MemberDTO member = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM member WHERE mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDTO();
				member.setMem_name(rs.getString("mem_name"));
				member.setMem_address(rs.getString("mem_address"));
				member.setMem_address_detail(rs.getString("mem_address_detail"));
				member.setMem_email(rs.getString("mem_email"));
				member.setMem_phone(rs.getString("mem_phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - selectMemberInfo()");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}

	public boolean checkPass(String sId, String mem_pass) {
		boolean isPass = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM member WHERE mem_id=? AND mem_pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			pstmt.setString(2, mem_pass);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isPass = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - checkPass()");
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return isPass;
	}

	public int updateMemberInfo(String sId, MemberDTO member) {
		int updateCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE member SET mem_pass=?, mem_phone=?, mem_address=?, mem_address_detail=? WHERE mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMem_pass());
			pstmt.setString(2, member.getMem_phone());
			pstmt.setString(3, member.getMem_address());
			pstmt.setString(4, member.getMem_address_detail());
			pstmt.setString(5, sId);
			
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 - updateMemberInfo()");
		}
		
		return updateCount;
	}

}
