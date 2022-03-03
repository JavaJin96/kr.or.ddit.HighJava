package kr.or.ddit.kmk.service;

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
import kr.or.ddit.kmk.dao.MemberDaoImpl;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberServiceImpl implements IMemberService {
	private MemberDaoImpl dao;  
	private static MemberServiceImpl service;
	private SqlMapClient smc;
	public MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	
	
	@Override
	public MemberVO loginChk(Map<String, Object> map) {
		return dao.loginChk(map);
	}

	@Override
	public int updatePass(Map<String, Object> map) {
		return dao.updatePass(map);
	}

	@Override
	public int resetPass(Map<String, Object> map) {
		return dao.resetPass(map);
	}
	
	@Override
	public int updateStudent(MemberVO mvo) {
		return dao.updateStudent(mvo);
	}
	
	@Override
	public temp_StudentInfoVO studentAllInfo(String mem_id) {
		return dao.studentAllInfo(mem_id);
	}
	@Override
	public List<RentVO> searchRoomrent(Map<String, Object> map) {
		return dao.searchRoomrent(map);
	}
	@Override
	public int insertRoomrent(RentVO rvo) {
		return dao.insertRoomrent(rvo);
	}
	@Override
	public int insertSeatrent(SeatVO svo) {
		return dao.insertSeatrent(svo);
	}
	@Override
	public List<SeatVO> searchSeatrent() {
		return dao.searchSeatrent();
	}
	@Override
	public List<Temp_ReservationVO> selectRoomById(String mem_id) {
		return dao.selectRoomById(mem_id);
	}
	@Override
	public List<Temp_ReservationVO> selectSeatById(String mem_id) {
		return dao.selectSeatById(mem_id);
	}
	@Override
	public String ProDepInfo(String mem_id) {
		return dao.ProDepInfo(mem_id);
	}
	@Override
	public int deleteRoom(Map<String, Object> map) {
		return dao.deleteRoom(map);
	}
	@Override
	public int deleteSeat(Map<String, Object> map) {
		return dao.deleteSeat(map);
	}
	@Override
	public int updateSeat(Map<String, Object> map) {
		return dao.updateSeat(map);
	}
	@Override
	public int insertStatus(String mem_id) {
		return dao.insertStatus(mem_id);
	}
	@Override
	public int updateStatus(Map<String, Object> map) {
		return dao.updateStatus(map);
	}
	@Override
	public List<temp_StudentInfoVO> allStudentList() {
		return dao.allStudentList();
	}
	@Override
	public List<MemberVO> findProfessor(String mem_id) {
		return dao.findProfessor(mem_id);
	}
	@Override
	public List<temp_StudentInfoVO> statusChangeList() {
		return dao.statusChangeList();
	}
	@Override
	public List<Temp_ProfessorVO> printProAllInfo() {
		return dao.printProAllInfo();
	}
	@Override
	public List<CommunityVO> selectMyBoard(String mem_id) {
		return dao.selectMyBoard(mem_id);
	}
	@Override
	public String findNameById(String mem_id) {
		return dao.findNameById(mem_id);
	}
	

}
