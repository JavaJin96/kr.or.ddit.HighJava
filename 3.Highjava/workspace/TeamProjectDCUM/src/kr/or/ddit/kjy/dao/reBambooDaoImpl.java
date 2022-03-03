package kr.or.ddit.kjy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dcum.vo.BambooReplyVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class reBambooDaoImpl implements IreBambooDao{
	
	private SqlMapClient client;
	private static reBambooDaoImpl dao;
	
	private reBambooDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static reBambooDaoImpl getInstance() {
		if(dao == null) dao = new reBambooDaoImpl();
		return dao;
	}
	
	//댓글 리스트
	@Override
	public List<BambooReplyVO> getAllReBamboo(String rnum) {
		List<BambooReplyVO> bambooReList = null;
		
		try {
			bambooReList = client.queryForList("project.getAllReBamboo", rnum);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bambooReList;
	}
	
	//댓글 선택
	@Override
	public BambooReplyVO selectReBamboo(String rnum) {
		BambooReplyVO rvo = null;
		
		try {
			rvo = (BambooReplyVO)client.queryForObject("project.selectReBamboo", rnum);
			
		} catch (SQLException e) {
			rvo = null;
			e.printStackTrace();
		}
		return rvo;
	}
	
	//댓글 작성
	@Override
	public int insertReBamboo(BambooReplyVO rvo) {
		int cnt = 0;
		
		try {
			Object obj = client.insert("project.insertReBamboo", rvo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	
	//댓글 수정
	@Override
	public int updateReBamboo(BambooReplyVO rvo) {
		int cnt = 0;
		
		try {
			cnt = client.update("project.updateReBamboo", rvo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	
	//댓글 삭제
	@Override
	public int deleteReBamboo(String rnum) {
		int cnt = 0;
		
		try {
			cnt = client.update("project.deleteReBamboo", rnum);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}


}
