package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.util.SqlMapClientFactory;

/*
 * 	Lprod테이블에 새로운 데이터를 추가해보자.
 * 
 * 	Lprod_GU와 Lprod_Nm은 사용자로부터 직접 입력 받아서 처리하고,
 * 	Lprod_ID는 현재의 Lprod_Id값 중에서 제일 큰 값보다 1크게 지정한다.
 * 
 * 	입력 받은 Lprod_Gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
 * 
 * 
 * 	Statement와 PreparedStatement의 차이점
 * 
 * 	SQL문이 들어있는 xml문서명 : jdbc.xml
 * 
 */
public class JdbcToIbatis {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		SqlMapClient smc = null;
		
		smc = SqlMapClientFactory.getSqlMapClient();
		
		/*try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);;
			
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
			
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		try {
			
			System.out.println("insert 작업시작...");
			while(true) {
				System.out.println("등록할 LPROD_GU의 값을 입력해주세요.");
				String lprodgu = s.next();
				
				String LPROD_GU = (String) smc.queryForObject("jdbc.selectLPROD_GU", lprodgu);
				if(LPROD_GU != null) {
					System.out.println("이미 등록된 LPROD_GU의 값이 존재합니다.");
					System.out.println("다시 한번 확인해주세요.");
					continue;
				}
					
				
				
				System.out.println("등록할 LPROD_NM의 값을 입력해주세요.");
				String lprodnm = s.next();
				System.out.println();
				
				int maxid = (int) smc.queryForObject("jdbc.selectLPROD_ID") + 1;
				
				LprodVO lprodvo = new LprodVO();
				lprodvo.setLprod_gu(lprodgu);
				lprodvo.setLprod_id(maxid);
				lprodvo.setLprod_nm(lprodnm);
				
				Object obj = smc.insert("jdbc.insertLPROD", lprodvo);
				if(obj == null) {
					System.out.println("등록이 성공되었습니다.");
					System.out.println("===================================");
					continue;
				}else {
					System.out.println("등록에 실패했습니다.");
					System.out.println("===================================");
					return;
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		
		
	}

}
