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

public class GatherDAO {

	private static GatherDAO gatherInstance = new GatherDAO();		// 싱글톤
	
	public static GatherDAO getGatherInstance(){
		return gatherInstance;
	}
	
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}

	// 글작성
	public int insert(GatherDTO gather) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			// 
			String sql  = "insert into gather values(gather_seq.nextval,?,?,?,?,?,?,sysdate)";

			pstmt = con.prepareStatement(sql);	//sql문 
			pstmt.setString(1, gather.getGathersubject());
			pstmt.setString(2, gather.getId());
			pstmt.setString(3, gather.getGatherpw());
			pstmt.setString(4, gather.getLocal());
			pstmt.setString(5, gather.getMembercnt());
			pstmt.setString(6, gather.getContent());
			result = pstmt.executeUpdate(); 
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) try {con.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
		}
		return result;
	}

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

	// 
	public List<GatherDTO> getlist(int startRow, int endRow) {
		List<GatherDTO> list = new ArrayList<GatherDTO>();
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
			
			while(rs.next()) {//next() 메서드는 선택한 요소의 다음 요소를 선택합니다.
				GatherDTO gather = new GatherDTO();
				gather.setNo(rs.getInt("no"));
				gather.setGathersubject(rs.getString("gathersubject"));
				gather.setId(rs.getString("id"));
				gather.setGatherpw(rs.getString("gatherpw"));
				gather.setLocal(rs.getString("local"));
				gather.setMembercnt(rs.getString("membercnt"));
//				gather.setMembercnt(rs.getInt("membercnt")); 		// "membercnt" 가 number이면
				gather.setContent(rs.getString("content"));
				gather.setReg_date(rs.getTimestamp("reg_date"));
				
				list.add(gather);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) try {con.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
			if(rs != null) try {rs.close();}catch(Exception e) {}
		}
		return list;
	}

	// 상세 페이지
	public GatherDTO getDetail(int no) {
		GatherDTO gather = new GatherDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from gather where no=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				gather.setNo(rs.getInt("no"));									System.out.println("no");
				gather.setGathersubject(rs.getString("gathersubject"));			System.out.println("sub");
				gather.setId(rs.getString("id"));								System.out.println("id");
				gather.setGatherpw(rs.getString("gatherpw"));					System.out.println("pw");
				gather.setLocal(rs.getString("local"));							System.out.println("local");
				gather.setMembercnt(rs.getString("membercnt"));					System.out.println("cnt");
				gather.setContent(rs.getString("content"));						System.out.println("con");
				gather.setReg_date(rs.getTimestamp("reg_date"));				System.out.println("date");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) try {con.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
			if(rs != null) try {rs.close();}catch(Exception e) {}
		}		
		return gather;
	}

	// 글 수정
	public int update(GatherDTO gather) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "update gather set gathersubject=?,local=?,membercnt=?,content=? where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gather.getGathersubject());
			pstmt.setString(2, gather.getLocal());
			pstmt.setString(3, gather.getMembercnt());
			pstmt.setString(4, gather.getContent());
			pstmt.setInt(5, gather.getNo());
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
		 e.printStackTrace();
		}finally {
			if(con != null) try {con.close();}catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch(Exception e) {}
		}
		return result;
	}

	// 글 삭제
	public int delete(int no) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql = "delete from gather where no=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) try {con.close();}catch (Exception e) {}
			if(pstmt != null) try {pstmt.close();}catch (Exception e) {}
		}
		return result;
	}	
}
