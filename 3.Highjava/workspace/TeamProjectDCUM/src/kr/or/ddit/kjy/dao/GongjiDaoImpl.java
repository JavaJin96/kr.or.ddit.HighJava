package kr.or.ddit.kjy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dcum.vo.GongjiVO;
import kr.or.ddit.dcum.vo.StudyVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class GongjiDaoImpl implements IGongjiDao{
	
	private SqlMapClient client;
	private static GongjiDaoImpl dao;
	
	private GongjiDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static GongjiDaoImpl getInstance() {
		if(dao == null) dao = new GongjiDaoImpl();
		return dao;
	}

	//전체 리스트
	@Override
	public List<GongjiVO> getAllGongji() {
		List<GongjiVO> gongjiList = null;
		
		try {
			gongjiList = client.queryForList("project.getAllGongji");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gongjiList;
	}

	//선택 공지
	@Override
	public GongjiVO selectGongji(String gnum) {
		GongjiVO gvo = null;
		
		try {
			gvo = (GongjiVO)client.queryForObject("project.selectGongji", gnum);
			
		} catch (SQLException e) {
			gvo = null;
			e.printStackTrace();
		}
		return gvo;
	}

	//공지 작성
	@Override
	public int insertGongji(GongjiVO gvo) {
		int cnt = 0;
		
		try {
			Object obj = client.insert("project.insertGongji", gvo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	//공지 수정
	@Override
	public int updateGongji(GongjiVO gvo) {
		int cnt = 0;
		
		try {
			cnt = client.update("project.updateGongji", gvo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	//공지 삭제
	@Override
	public int deleteGongji(String gnum) {
		int cnt = 0;
		
		try {
			cnt = client.delete("project.deleteGongji", gnum);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	//공지 검색
	@Override
	public List<GongjiVO> searchGongji(String gtitle) {
		List<GongjiVO> gongjiList = null;
		
		try {
			gongjiList = client.queryForList("project.searchGongji", gtitle);

		} catch (SQLException e) {
			gongjiList = null;
			e.printStackTrace();
			
		} 
		
		return gongjiList;
	}

}
