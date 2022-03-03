package kr.or.ddit.psj.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class LoginServiceImpl {
	//싱글톤 패턴 -----------------------------------------------------------
	
	private static LoginServiceImpl service;
	private SqlMapClient smc;
	
	public LoginServiceImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static LoginServiceImpl getInstance() {
		if(service == null) service = new LoginServiceImpl();
		return service;
	}
	
	public MemberVO loginChk (Map<String, Object> map){
		MemberVO mvo = null;
		try {
			mvo = (MemberVO)smc.queryForObject("member.loginChk",map);
			System.out.println(mvo + "dsigjsoeigos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return mvo;	
	}
}
