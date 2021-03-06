package kr.or.ddit.kjy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dcum.vo.BambooVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class BambooDaoImpl implements IBambooDao{

	private SqlMapClient client;
	private static BambooDaoImpl dao;
	
	private BambooDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static BambooDaoImpl getInstance() {
		if(dao == null) dao = new BambooDaoImpl();
		return dao;
	}
	
	//전체 리스트
	@Override
	public List<BambooVO> getAllBamboo() {
		List<BambooVO> bambooList = null;
		
		try {
			bambooList = client.queryForList("project.getAllBamboo");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bambooList;
	}
	
	//게시글 선택
	@Override
	public BambooVO selectBamboo(String bnum) {
		BambooVO bvo = null;
		
		try {
			bvo = (BambooVO)client.queryForObject("project.selectBamboo", bnum);
			
		} catch (SQLException e) {
			bvo = null;
			e.printStackTrace();
		}
		
		return bvo;
	}
	
	//게시글 추가
	@Override
	public int insertBamboo(BambooVO bvo) {
		int cnt = 0;
		
		try {
			Object obj = client.insert("project.insertBamboo", bvo);
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
	public int updateBamboo(BambooVO bvo) {
		int cnt = 0;
		
		try {
			cnt = client.update("project.updateBamboo", bvo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	
	//게시글 삭제
	@Override
	public int deleteBamboo(String bnum) {
		int cnt = 0;
		
		try {
			cnt = client.delete("project.deleteBamboo", bnum);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	//게시글 검색
	@Override
	public List<BambooVO> searchBamboo(String bnum) {
		List<BambooVO> bambooList = null;
		
		try {
			bambooList = client.queryForList("project.searchBamboo");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bambooList;
	}



}
