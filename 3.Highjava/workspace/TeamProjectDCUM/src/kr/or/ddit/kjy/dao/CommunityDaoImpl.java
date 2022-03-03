package kr.or.ddit.kjy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dcum.vo.CommunityVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class CommunityDaoImpl implements ICommunityDao{
	
	private SqlMapClient client;
	private static CommunityDaoImpl dao;
	
	private CommunityDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static CommunityDaoImpl getInstance() {
		if(dao == null) dao = new CommunityDaoImpl();
		return dao;
	}

	//전체 리스트
	@Override
	public List<CommunityVO> getAllCommu() {
		List<CommunityVO> commuList = null;
		
		try {
			commuList = client.queryForList("project.getAllCommu");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commuList;
	}

	//게시글 선택
	@Override
	public CommunityVO selectCommu(String cnum) {
		CommunityVO cvo = null;
		
		try {
			cvo = (CommunityVO)client.queryForObject("project.selectCommu", cnum);
			
		} catch (SQLException e) {
			cvo = null;
			e.printStackTrace();
		}
		
		return cvo;
	}

	//게시글 추가
	@Override
	public int insertCommu(CommunityVO cvo) {
		int cnt = 0;
		
		try {
			Object obj = client.insert("project.insertCommu", cvo);
			if(obj == null) {
				cnt = 1;
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	//게시글 수정
		@Override
		public int updateCommu(CommunityVO cvo) {
			int cnt = 0;
			
			try {
				cnt = client.update("project.updateCommu", cvo);
				
			} catch (SQLException e) {
				cnt = 0;
				e.printStackTrace();
			}
			return cnt;
		}
		
	//게시글 삭제
	@Override
	public int deleteCommu(String cnum) {
		int cnt = 0;
		
		try {
			cnt = client.delete("project.deleteCommu", cnum);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	//게시글 검색
	@Override
	public List<CommunityVO> searchCommu(String ccont) {
		List<CommunityVO> commuList = null;
		
		try {
			commuList = client.queryForList("project.searchCommu", ccont);

		} catch (SQLException e) {
			commuList = null;
			e.printStackTrace();
			
		} 
		
		return commuList;
	}

	//말머리 검색
	@Override
	public List<CommunityVO> sortCommu(String sort) {
		List<CommunityVO> commuList = null;
		
		try {
			commuList = client.queryForList("project.sortCommu", sort);
			
		} catch (SQLException e) {
			commuList = null;
			e.printStackTrace();
		}
		return commuList;
	}

}
