package com.naver.dao;


import java.sql.*;
import java.util.ArrayList;

import com.naver.db.DB;
import com.naver.dto.HugiDto;

public class HugiDaoImpl implements HugiDao{

	@Override
	public void insert(HugiDto dto) {
		// 디비 연결
		// 쿼리 만들고
		// 쿼리 실행

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.conn(); 
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO hugi (mb_num, mv_num, title, content) ");
			sql.append("VALUES (?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, dto.getMb_num());
			pstmt.setInt(2, dto.getMv_num());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<HugiDto> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		ArrayList<HugiDto> list = new ArrayList<HugiDto>();
		try {
			conn = DB.conn();
			String sql = "SELECT * FROM hugi";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
//				System.out.println(rs.getInt("num"));
//				System.out.println(rs.getString("je"));
//				System.out.println(rs.getString("bae"));
//				System.out.println(rs.getString("gam"));
//				System.out.println(rs.getString("img"));
				HugiDto dto = new HugiDto();
//				dto.setNum(rs.getInt("num"));
//				dto.setJe(rs.getString("je"));
//				dto.setBae(rs.getString("bae"));
//				dto.setGam(rs.getString("gam"));
//				dto.setImg(rs.getString("img"));	
				list.add(dto);
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if( rs != null && !rs.isClosed()){
                    rs.close();
                }
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void update(HugiDto dto) {

//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			conn = DB.conn(); 
//			String sql = "UPDATE user SET jumsu=? WHERE  id=?";
//			pstmt = conn.prepareStatement(sql);
//			
////			pstmt.setInt(1, dto.getJumsu());
//			pstmt.setString(2, dto.getId());
//			
//			int count = pstmt.executeUpdate();
//			if (count == 0) {
//				System.out.println("데이터 입력 실패");
//			} else {
//				System.out.println("데이터 입력 성공");
//			}
//
//		} catch (Exception e) {
//			System.out.println("에러: " + e);
//		} finally {
//			try {
//				if (conn != null && !conn.isClosed()) {
//					conn.close();
//				}
//				if( pstmt != null && !pstmt.isClosed()){
//                    pstmt.close();
//                }
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
	}

}