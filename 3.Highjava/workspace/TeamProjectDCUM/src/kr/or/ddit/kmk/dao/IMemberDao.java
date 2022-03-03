package kr.or.ddit.kmk.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.dcum.vo.CommunityVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.RentVO;
import kr.or.ddit.dcum.vo.SeatVO;
import kr.or.ddit.dcum.vo.Temp_ProfessorVO;
import kr.or.ddit.dcum.vo.Temp_ReservationVO;
import kr.or.ddit.dcum.vo.temp_StudentInfoVO;

public interface IMemberDao {
	
	/**
	 * 로그인 체크
	 * @param MemberVO > mem_id , mem_pass
	 * @return 로그인한 회원정보 (로그인 실패시 null)
	 */
	public MemberVO loginChk (Map<String, Object> map);
	
	/**
	 * 조인) 회원정보 검색
	 * @param mem_id
	 * @return 아이디로 검색된 회원 정보
	 * 조인테이블 : MEMBER , STUDENT , DEPARTMENT ,MANAGEMENT ,CLASS_STUDENT
	 */
	public temp_StudentInfoVO studentAllInfo(String mem_id);
	
	/**
	 * 비밀번호 초기화 (본인생일로 초기화)
	 * @param map > mem_id , mem_mail(아이디 , 메일)
	 * @return 1: 작업성공 / 0 :작업실패
	 */
	public int resetPass(Map<String, Object> map);
	
	/**
	 * 비번변경
	 * @param map > mem_id , mem_pass(변경할 비밀번호)
	 * @return 1: 작업성공 / 0 :작업실패
	 */
	public int updatePass(Map<String, Object> map);
	
	/**
	 * 학생정보변경
	 * @param MemberVO (변경할 주소,메일,핸드폰번호)
	 * @return 1: 작업성공 / 0 :작업실패
	 */
	public int updateStudent(MemberVO mvo);
	
	/**
	 * 스터디룸예약내역 검색
	 * @param map >rent-date , rent_num
	 * @return List<RentVO> 날짜,룸번호에 예약된 예약내용
	 */
	public List<RentVO> searchRoomrent(Map<String, Object> map);
	
	/**
	 * 스터디룸 예약하기
	 * @param rvo 
	 * @return 1: 작업성공 / 0 :작업실패
	 */
	public int insertRoomrent(RentVO rvo);
	
	
	/**
	 * 스터디룸 예약취소
	 * @param map > mem_id , rent_num 
	 * @return 1: 작업성공 / 0 :작업실패
	 */
	public int deleteRoom(Map<String, Object> map);
	
	/**
	 * 스터디룸 예약취소
	 * @param map > mem_id , seat_num 
	 * @return 1: 작업성공 / 0 :작업실패
	 */
	public int deleteSeat(Map<String, Object> map);
	/**
	 * 열람실 시간연장
	 * @param map > mem_id , seat_num 
	 * @return 1: 작업성공 / 0 :작업실패
	 */
	public int updateSeat(Map<String, Object> map);
	
	/**
	 * 열람실 예약하기
	 * @param svo >seat_num / mem_id
	 * @return 1: 작업성공 / 0 :작업실패
	 */
	public int insertSeatrent(SeatVO svo);
	
	/**
	 * 현재 열람실 예약현황
	 * @return List<SeatVO>
	 */
	public List<SeatVO> searchSeatrent();
	
	
	
	/**
	 * [스터디룸 예약현황]아이디 검색
	 * @param mem_id
	 * @return 스터디룸 예약내역
	 */
	public List<Temp_ReservationVO> selectRoomById(String mem_id);
	
	/**
	 * [열람실 예약현황]아이디 검색
	 * @param mem_id
	 * @return 열람실 예약내역
	 */
	public List<Temp_ReservationVO> selectSeatById(String mem_id);
	
	/**
	 * 교수 학과명 검색
	 * @param mem_id
	 * @return 학과명
	 */
	public String ProDepInfo(String mem_id);
	/**
	 * 재학상태 insert
	 * @param mem_id
	 * @return 1: 작업성공 / 0 :작업실패
	 */
	public int insertStatus(String mem_id);
	/**
	 * 재학상태 update
	 * @param status(변경할 상태값), mem_id
	 * @return 1: 작업성공 / 0 :작업실패
	 */
	public int updateStatus(Map<String, Object> map);
	
	/**
	 * 조인) 모든 학생 리스트 불러오기
	 * @return 모든회원 정보
	 * 조인테이블 : MEMBER , STUDENT , DEPARTMENT ,MANAGEMENT ,CLASS_STUDENT
	 */
	public List<temp_StudentInfoVO> allStudentList();
	
	/**
	 * 학생아이디로 해당학과 교수 리스트
	 * @param mem_id (학생아이디)
	 * @return
	 */
	public List<MemberVO> findProfessor(String mem_id);
	
	/**
	 * 조인) 모든 학생 리스트 불러오기
	 * @return 모든회원 정보
	 * 조인테이블 : MEMBER ,MANAGEMENT 
	 */
	public List<temp_StudentInfoVO> statusChangeList();
	
	/**
	 * 조인) 교수정보 불러오기
	 * @return 교수정보리스트
	 */
	public List<Temp_ProfessorVO> printProAllInfo();

	/**
	 * 내가쓴 게시글 찾기
	 * @param mem_id
	 * @return 내가쓴 커뮤니티 보드 글리스트
	 */
	public List<CommunityVO> selectMyBoard(String mem_id);

	/**
	 * 아이디로 회원명 찾기
	 * @param mem_id
	 * @return
	 */
	public String findNameById(String mem_id);


}
