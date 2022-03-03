package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

// JDBC드라이버를 로딩하고 Connection객체를 생성하는 메서드로 구성된 class 만들기


// ResourceBundle객체 이용하기
public class DBUtil3 {
	private static ResourceBundle bundle;	// ResourceBundle객체 변수 선언
	private static Logger logger = Logger.getLogger(DBUtil3.class);		// Logger객체 생성
	
	static {
		// ResourceBundle객체 생성
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		logger.info("ResourceBundle객체 생성 - dbinfo.properties파일을 참조하고 있습니다..");
		
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(bundle.getString("driver"));
			logger.debug("DB 드라이버 로딩 성공..[oracle.jdbc.driver.OracleDriver]");
			
		} catch (ClassNotFoundException e) {
			//System.out.println("드라이버 로딩 실패");
			logger.error("DB 드라이버 로딩 실패..[oracle.jdbc.driver.OracleDriver]", e);
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection con = null;
		try {
//			return DriverManager.getConnection("jdbc:oracle:thin:@localhost", "PSJ96", "java");
			con =   DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("user"),
					bundle.getString("pass"));
			
			logger.info("DB 연결 success : loginfo[jdbc:oracle:thin:@localhost, PSJ96, java]");
					
		} catch (SQLException e) {
			//System.out.println("오라클 연결 실패");
			
			logger.error("DB 연결 fail : loginfo[jdbc:oracle:thin:@localhost, PSJ96, java]");
			return null;
		}
		
		return con;
		
	}
	
	
	
}
