package kr.or.ddit.psj.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dcum.vo.EmployeeVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.ProfessorVO;
import kr.or.ddit.dcum.vo.StudentVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class JoinDaoimpl implements IJoindao {
	
	//싱글톤 패턴 -----------------------------------------------------------
	
	private static JoinDaoimpl dao;
	private SqlMapClient smc;
	
	public JoinDaoimpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static JoinDaoimpl getInstance() {
		if(dao == null) dao = new JoinDaoimpl();
		return dao;
	}
	//싱글톤 패턴 끝-----------------------------------------------------------
	
	
	//회원 등록에 관련된 메서드 (맴버, 학생, 교수, 직원)
	@Override
	public int insertMember(MemberVO vo) {
		int result = 0;
		try {
			if(smc.insert("dum.insertMember", vo) == null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int insertStudent(StudentVO vo) {
		int result = 0;
		try {
			if(smc.insert("dum.insertStudent", vo) == null) {
				result = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int insertProfessor(ProfessorVO vo) {
		int result = 0;
		try {
			if(smc.insert("dum.insertProfessor", vo) == null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int insetEmployee(EmployeeVO vo) {
		int result = 0;
		try {
			if(smc.insert("dum.insertEmployee", vo) == null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	
	// 회원 조회에 관한 메서드
	@Override
	public List<MemberVO> selectAllMember() {
		List<MemberVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectAllMember");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<MemberVO> selectOneMember(int id) {
		List<MemberVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectOneMember", id);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}		
		return list;
	}
	
	
	
	
	
}
	
	

