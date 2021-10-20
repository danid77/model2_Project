package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
		return ds.getConnection();
	}

	// 회원가입

	public int insert(MemberDTO member) {
		int result = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "insert into member ";
			sql += " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setInt(4, member.getYear());
			pstmt.setInt(5, member.getMonth());
			pstmt.setInt(6, member.getDay());
			pstmt.setString(7, member.getGender());
			pstmt.setString(8, member.getMailid());
			pstmt.setString(9, member.getDomain());
			pstmt.setString(10, member.getPhone1());
			pstmt.setString(11, member.getPhone2());
			pstmt.setString(12, member.getPhone3());
			pstmt.setString(13, member.getLocal());
			pstmt.setString(14, member.getImage());

			result = pstmt.executeUpdate(); // insert SQL문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (Exception e) {}
			if (con != null) try { con.close(); } catch (Exception e) {}
		}
		return result;
	}

	// ID 중복 검사(ajax)
	public int idcheck(String id) {
		int result = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select * from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // select SQL문 실행

			if (rs.next()) { // 중복 ID인 경우
				result = 1;
			} else { // 사용 가능한 ID인 경우
				result = -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception e) {}
			if (con != null) try { con.close(); } catch (Exception e) {}
		}
		return result;
	}
	
	// 로그인(회원 인증)
	public int memberAuth(String id, String passwd) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from member where id=? and passwd=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();		// select SQL문 실행
			
			if(rs.next()) {
				result = 1;
			}else {
				result = -1;
			}		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch (Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception e) {}
			if (con != null) try { con.close(); } catch (Exception e) {}
		}			
		
		System.out.println("result:"+result);
		return result;
	}
	
	// 아이디 찾기
	public String getID(String name, String mailid, String domain) {
		String id = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from member where name=? and mailid=? and domain=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, mailid);
			pstmt.setString(3, domain);
			
			rs = pstmt.executeQuery();		// select SQL문 실행
			
			if(rs.next()) {
				id = rs.getString("id");	
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch (Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception e) {}
			if (con != null) try { con.close(); } catch (Exception e) {}
		}
		
		return id;
	}
	
	// 회원 상세 정보 구하기
	public MemberDTO getMember(String id) {
		MemberDTO member = new MemberDTO();
			
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try {
			con = getConnection();
				
			String sql = "select * from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();		// select SQL문 실행
				
			if(rs.next()) {
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setYear(rs.getInt("year"));
				member.setMonth(rs.getInt("month"));
				member.setDay(rs.getInt("day"));
				member.setGender(rs.getString("gender"));
				member.setMailid(rs.getString("mailid"));
				member.setDomain(rs.getString("domain"));
				member.setPhone1(rs.getString("phone1"));
				member.setPhone2(rs.getString("phone2"));
				member.setPhone3(rs.getString("phone3"));
				member.setLocal(rs.getString("local"));
				member.setImage(rs.getString("image"));
				member.setRegister(rs.getDate("register"));				
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) try { rs.close(); } catch(Exception e) {}
				if(pstmt != null) try { pstmt.close(); } catch(Exception e) {}
				if(con != null) try { con.close(); } catch(Exception e) {}
			}
			
			return member;
		}
	
	// 회원 정보 수정(Update)
	public int update(MemberDTO member) {
		int result = 0;
			
		Connection con = null;
		PreparedStatement pstmt = null;
			
		try {
			con = getConnection();
					   
			String sql="update member set name=?,year=?,month=?,day=?,";
				   sql+="gender=?,mailid=?,domain=?,phone1=?,phone2=?,phone3=?,";
				   sql+="local=?,image=? where id=?";					   
				
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setInt(2, member.getYear());
			pstmt.setInt(3, member.getMonth());
			pstmt.setInt(4, member.getDay());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getMailid());
			pstmt.setString(7, member.getDomain());
			pstmt.setString(8, member.getPhone1());
			pstmt.setString(9, member.getPhone2());
			pstmt.setString(10, member.getPhone3());
			pstmt.setString(11, member.getLocal());
			pstmt.setString(12, member.getImage());
			pstmt.setString(13, member.getId());
				
			result = pstmt.executeUpdate();			// update SQL문 실행
					   
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try { pstmt.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
			
		return result;
	 }
	
	//비밀번호 변경
	public int changePW(MemberDTO member) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "update member set passwd=? where id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getId());
			result = pstmt.executeUpdate();		// update SQL문 실행
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try { pstmt.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return result;
	}
	
	// 회원 탈퇴
		public int delete(String id) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
				
			try {
				con = getConnection();
					
				String sql = "delete from member where id=?";
					
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				result = pstmt.executeUpdate();		// delete SQL문 실행
					
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) try { pstmt.close();}catch(Exception e) {}
				if(con != null) try { con.close();}catch(Exception e) {}
			}
				return result;
		}
	
}
