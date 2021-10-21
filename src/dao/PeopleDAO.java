package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.GatherDTO;
import dto.MemberDTO;
import dto.PeopleDTO;

public class PeopleDAO {

	private static PeopleDAO peopleInstance = new PeopleDAO(); 		// 싱글톤
	
	public static PeopleDAO getPeopleInstance(){
		return peopleInstance;
	}
	
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	// 회원 정보 불러오기
	
	
	
	// 총데이터 갯수
	public int getCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		// ResultSet은 select sql문을 사용할 때 사용함
		
		try {
			con = getConnection();
			
			String sql = "select count(*) from gather";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("count(*)");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) try {con.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
			if(rs != null) try {rs.close();}catch(Exception e) {}
		}
		return result;
	}

	// 데이터 구해오기
	public List<PeopleDTO> getlist(int startRow, int endRow) {
		List<PeopleDTO> list = new ArrayList<PeopleDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select * from (select rownum rnum, board.* from ";	
	       	  sql+=" (select * from gather order by no desc) board ) ";
	       	  sql+=" where rnum >= ? and rnum <= ?";
	       	  
	       	pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
					
		
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) try {con.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
			if(rs != null) try {rs.close();}catch(Exception e) {}
		}
		
		
		
		return list;
	}
	
	// 개별 모임에 회원이 가입되어 있는지 확인
	public int selectmember(int no, String id) {
		int selectresult = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from people where no=? and id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();		// select SQL문 실행
			
			if(rs.next()) {
				selectresult = -1;
			}else {
				selectresult = 1;
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) try {con.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
			if(rs != null) try {rs.close();}catch(Exception e) {}
		}
		return selectresult;
	}

	// 모임에 가입(people 테이블에 모임원 추가)
	public int insertmember(PeopleDTO people) {
		int insertresult = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			
			String sql = "insert into people values(?,?,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, people.getNo());
				pstmt.setString(2, people.getGather_name());
				pstmt.setString(3, people.getId());
				pstmt.setString(4, people.getLocal());
				pstmt.setString(5, people.getGender());			
	
				insertresult = pstmt.executeUpdate(); // insert SQL문 실행
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) try {con.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
		}
		return insertresult;
	}

	// 모임원 목록 조회
	public List<PeopleDTO> getplist(int no) {
		// TODO Auto-generated method stub
		
		List<PeopleDTO> list = new ArrayList<PeopleDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql="select * from people where no = ?";
	       	  
	       	pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PeopleDTO people = new PeopleDTO();
				people.setNo(rs.getInt("no"));	
				people.setGather_name(rs.getString("gather_name"));
				people.setId(rs.getString("id"));
				people.setLocal(rs.getString("local"));
				people.setGender(rs.getString("gender"));
				
				list.add(people);				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) try {con.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
			if(rs != null) try {rs.close();}catch(Exception e) {}
		}
		return list;
		
	}

	// 내 모임 조회
	public List<PeopleDTO> mygatherings(String id) {
		// TODO Auto-generated method stub
			
		List<PeopleDTO> list = new ArrayList<PeopleDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try {
			con = getConnection();
				
			String sql="select * from people where id = ?";
		       	  
		    pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
				
			while(rs.next()) {
			PeopleDTO people = new PeopleDTO();
			people.setNo(rs.getInt("no"));	
			people.setGather_name(rs.getString("gather_name"));
			people.setId(rs.getString("id"));
			people.setLocal(rs.getString("local"));
			people.setGender(rs.getString("gender"));
					
			list.add(people);				
			}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(con != null) try {con.close();}catch(Exception e) {}
				if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
				if(rs != null) try {rs.close();}catch(Exception e) {}
			}
			return list;
			
		}

	// 각 모임의 인원 수 조회
	public int peoplecnt(int no) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		try {
			con = getConnection();
			
			String sql = "select count(*) from people where no=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("count(*)");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) try {con.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
			if(rs != null) try {rs.close();}catch(Exception e) {}
		}
		return result;
	}

	// 모임원 제거
	public int delete(int no) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "delete from people where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) try {con.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
		}
		return result;
	}
	
	
}
