package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberDaoimpl implements IMemberDao {
	
	private static IMemberDao dao;
	private SqlMapClient smc;
	
	private MemberDaoimpl() {
		 smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IMemberDao getInstance() {
		if(dao == null) dao = new MemberDaoimpl();
		return dao;
	}

	@Override
	public List<MemberVO> AllMemberList() {
		List<MemberVO> list = new ArrayList<>();
		
		try {
			list =smc.queryForList("member.AllMemberList");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberVO SelectMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void InsertMember(MemberVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void UpdateMember(MemberVO vo) {
		// TODO Auto-generated method stub

	}

}
