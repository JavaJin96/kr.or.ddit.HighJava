package kr.or.ddit.kjy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dcum.vo.CommuReplyVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class reCommunityDaoImpl implements IreCommunityDao{

	private SqlMapClient client;
	private static reCommunityDaoImpl dao;
	
	private reCommunityDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static reCommunityDaoImpl getInstance() {
		if(dao == null) dao = new reCommunityDaoImpl();
		return dao;
	}
	
	//댓글 리스트
	@Override
	public List<CommuReplyVO> getAllReCommu(String rnum) {
		List<CommuReplyVO> bambooReList = null;
		
		try {
			bambooReList = client.queryForList("project.getAllReCommu", rnum);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bambooReList;
	}
	
	//댓글 선택
	@Override
	public CommuReplyVO selectReCommu(String rnum) {
		CommuReplyVO rvo = null;
		
		try {
			rvo = (CommuReplyVO)client.queryForObject("project.selectReCommu", rnum);
			
		} catch (SQLException e) {
			rvo = null;
			e.printStackTrace();
		}
		return rvo;
	}
	
	//댓글 작성
	@Override
	public int insertReCommu(CommuReplyVO rvo) {
		int cnt = 0;
		
		try {
			Object obj = client.insert("project.insertReCommu", rvo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	
	//댓글 수정
	@Override
	public int updateReCommu(CommuReplyVO rvo) {
		int cnt = 0;
		
		try {
			cnt = client.update("project.updateReCommu", rvo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	
	//댓글 삭제
	@Override
	public int deleteReCommu(String rnum) {
		int cnt = 0;
		
		try {
			cnt = client.delete("project.deleteReCommu", rnum);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

}
