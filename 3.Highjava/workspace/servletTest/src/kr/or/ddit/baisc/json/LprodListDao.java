package kr.or.ddit.baisc.json;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.util.DBUtil3;

public class LprodListDao {
	
	
	private static LprodListDao dao;
	Connection con;
	Statement ste;
	ResultSet rs;
	
	public LprodListDao() {
	}
	
	public static LprodListDao getInstance() {
		if(dao == null) dao = new LprodListDao();
		return dao;
	}
	
	public List<LprodVO> seletAll () {

		List<LprodVO> list = new ArrayList<>();
		
		try {
			
			con = DBUtil3.getConnection();
			
			ste = con.createStatement();
			
			String sql = "select * from LPROD";
			
			rs = ste.executeQuery(sql);
			
			while(rs.next()) {
				LprodVO vo = new LprodVO();
				vo.setLprod_id(rs.getInt(1));
				vo.setLprod_gu(rs.getString(2));
				vo.setLprod_nm(rs.getString(3));
				list.add(vo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ste != null) try {ste.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		} 
		
		return list;
		
	}
	
	
}
