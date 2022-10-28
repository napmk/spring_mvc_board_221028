package com.napmkmk.mvcboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.napmkmk.mvcboard.dto.BoardDto;

public class BoardDao {

	DataSource dataSource;

	public BoardDao() {
		super();
		// TODO Auto-generated constructor stub
	
	
	try {
	Context context = new InitialContext();
	dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g") ;
	}catch(  Exception e) {
		e.printStackTrace();
	}
	
}
	
	public ArrayList<BoardDto> list() { // 매게변수 안넣어줌 모든 글을 가져와야 되니까
		
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null; //중요 sql문의 결과를 받을 그릇.
		
		
		
		
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM mvc_board ORDER BY bid DESC"; //무조건 다 가져와라. 게시글 번호의 내림차순 정렬 (최근글이 가장위에 오도록 함)
			pstmt = conn.prepareStatement(sql); //sql문 객체 생성
			rs = pstmt.executeQuery();//SQL 을 실행하여 결과 값을 반환		
			
			while(rs.next()) { //rs전용함수 다음꺼 있냐 rs에 있는 글을 하나씩 뽑아줌
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				
//				BoardDto dto = new BoardDto();
//				dto.setBid(bid);
//				dto.setBname(bname);
//				dto.setBtitle(btitle);
//				dto.setBcontent(bcontent);
//				dto.setBdate(bdate);
//				dto.setBhit(bhit);
//				dto.setBgroup(bgroup);
//				dto.setBstep(bstep);
//				dto.setBindent(bindent);
				
				BoardDto dto = new BoardDto(bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent);
				dtos.add(dto);
			
			}
				
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return dtos;	
	}
	
	public void write( String bname,String btitle, String bcontent) {  //3개를 넣어줘야되니까
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try { 
			conn = dataSource.getConnection();
			String sql = "INSERT INTO mvc_board(bid,bname,btitle,bcontent,bhit,bgroup,bstep,bindent) "
					+ "VALUES (MVC_BOARD_SEQ.nextval, ?,?,?,0,MVC_BOARD_SEQ.currval,0,0)";
			

			pstmt = conn.prepareStatement(sql); //sql문 객체 생성
			
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			//sql문 완성 위에 write 인수 3개라 3개이다.
			
			
			pstmt.executeUpdate();	//완성된 sql문 완성
			
	
				
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
	
	}
}
