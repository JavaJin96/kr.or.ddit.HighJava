package kr.or.ddit.kmk.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dcum.vo.CommunityVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.RentVO;
import kr.or.ddit.dcum.vo.SeatVO;
import kr.or.ddit.dcum.vo.Temp_ProfessorVO;
import kr.or.ddit.dcum.vo.Temp_ReservationVO;
import kr.or.ddit.dcum.vo.temp_StudentInfoVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberDaoImpl implements IMemberDao {
	
	// 1번
	private static MemberDaoImpl dao;
	private SqlMapClient smc;
	// 2번
	private MemberDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	// 3번
	public static MemberDaoImpl getInstance() {
		if (dao == null)
			dao = new MemberDaoImpl();
		return dao;
	}
	
	
	@Override
	public MemberVO loginChk(Map<String, Object> map) {
		MemberVO mvo = null;
		try {
			mvo = (MemberVO)smc.queryForObject("member.loginChk",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return mvo;	
	}
	
	
	@Override
	public temp_StudentInfoVO studentAllInfo(String mem_id) {
		temp_StudentInfoVO sivo = null;
		try {
			sivo = (temp_StudentInfoVO) smc.queryForObject("member.studentAllInfo", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sivo;
	}


	@Override
	public int updatePass(Map<String, Object> map) {
		int res = 0;
		try {
			res = smc.update("member.updatePass",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return res;	
	}
	
	@Override
	public int resetPass(Map<String, Object> map) {
		int res = 0;
		try {
			res = smc.update("member.resetPass", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public int updateStudent(MemberVO mvo) {
		int res=0;
		try {
			res = smc.update("member.updateStudent",mvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public List<RentVO> searchRoomrent(Map<String, Object> map) {
		List<RentVO> rlist = null;
		try {
			rlist = smc.queryForList("member.searchRoomrent",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return rlist;
	}
	@Override
	public int insertRoomrent(RentVO rvo) {
		int res =0;
		try {
			res = (int) smc.insert("member.insertRoomrent",rvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public int insertSeatrent(SeatVO svo) {
		int res = 0;
		try {
			if(smc.insert("member.insertSeatrent",svo)==null) {
				res = 1;
			}else {
				res = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public List<SeatVO> searchSeatrent() {
		List<SeatVO> seatlist = null;
		try {
			seatlist = smc.queryForList("member.searchSeatrent");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seatlist;
	}

	
	@Override
	public List<Temp_ReservationVO> selectRoomById(String mem_id) {
		List<Temp_ReservationVO> rentlist = null;
		try {
			rentlist = smc.queryForList("member.selectRoomById",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rentlist;
	}
	@Override
	public List<Temp_ReservationVO> selectSeatById(String mem_id) {
		List<Temp_ReservationVO> rentlist = null;
		try {
			rentlist = smc.queryForList("member.selectSeatById",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rentlist;
	}
	@Override
	public String ProDepInfo(String mem_id) {
		String dep_name = null;
		try {
			dep_name = (String)smc.queryForObject("member.ProDepInfo",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dep_name;
	}
	@Override
	public int deleteRoom(Map<String, Object> map) {
		int res =0;
		try {
			res = smc.delete("member.deleteRoom",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public int deleteSeat(Map<String, Object> map) {
		int res =0;
		try {
			res = smc.delete("member.deleteSeat",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public int updateSeat(Map<String, Object> map) {
		int res =0;
		try {
			res = smc.update("member.updateSeat",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public int insertStatus(String mem_id) {
		int res = 0;
		try {
			if(smc.insert("member.insertStatus",mem_id)==null) {
				res = 1;
			}else {
				res = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}	
	@Override
	public int updateStatus(Map<String, Object> map) {
		int res = 0;
		try {
			res =smc.update("member.updateStatus",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public List<temp_StudentInfoVO> allStudentList() {
		List<temp_StudentInfoVO> sList = null;
		try {
			sList = smc.queryForList("member.allStudentList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList;
	}
	@Override
	public List<MemberVO> findProfessor(String mem_id) {
		List<MemberVO> prolist = null;
		try {
			prolist = smc.queryForList("member.findProfessor",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prolist;
	}
	@Override
	public List<temp_StudentInfoVO> statusChangeList() {
		List<temp_StudentInfoVO> sList = null;
		try {
			sList = smc.queryForList("member.statusChangeList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList;
	}
	@Override
	public List<Temp_ProfessorVO> printProAllInfo() {
		List<Temp_ProfessorVO> prolist =null;
		try {
			prolist = smc.queryForList("member.printProAllInfo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prolist;
	}
	@Override
	public List<CommunityVO> selectMyBoard(String mem_id) {
		List<CommunityVO> boardList = null;
		try {
			boardList = smc.queryForList("member.selectMyBoard",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}
	@Override
	public String findNameById(String mem_id) {
		String mem_name = null;
		try {
			mem_name = (String) smc.queryForObject("member.findNameById",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem_name;
	}


}
