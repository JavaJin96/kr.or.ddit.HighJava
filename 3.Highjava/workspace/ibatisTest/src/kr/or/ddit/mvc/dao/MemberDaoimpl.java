package kr.or.ddit.mvc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberDaoimpl implements IMemberDao {
	
	private SqlMapClient smc;	// ibatis를 사용하기 위해 SqlMapClient객체 변수 선언
	
	// 1. 자기 자신이 저장될 변수를 선언
	private static MemberDaoimpl dao;
	
	// 2.
	private MemberDaoimpl() {	
		// ibatis의 사용 환경을 구성하고 SqlMapClient 객체 생성하기
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	// 3.
	public static MemberDaoimpl getInstance() {
		if(dao == null) dao = new MemberDaoimpl();
		
		return dao;
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		int res = 0;
		try {
			Object obj = smc.insert("mymember.insertMember", memVo);
			if(obj == null) {
				res = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	
		return res;
	}

	@Override
	public int deleteMember(String memId) {
		int res = 0;
		
		try {
			
			res = smc.delete("mymember.deleteMember", memId);

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
		return res;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int res = 0;
		
		try {
			
			res = smc.update("mymember.updateMember" , memVo);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return res;
	}

	@Override
	public List<MemberVO> selectMember() {
		List<MemberVO> list = new ArrayList<>(); 
		
		try {
			
			list = smc.queryForList("mymember.selectAllMember");

			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
		return list;
	}

	@Override
	public int getMemberCount(String memId) {
		int count = 0;
		
		try {
			
			count = (int) smc.queryForObject("mymember.selectCountMember", memId);
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		int res = 0;
		
		try {
			
			res = smc.update("mymember.updateMember2" , paramMap);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
		
	}
	
}




















