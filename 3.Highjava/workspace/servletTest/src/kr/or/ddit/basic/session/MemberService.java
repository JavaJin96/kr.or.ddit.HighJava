package kr.or.ddit.basic.session;


public class MemberService {
	
	
	private static MemberService service;
	private MemberDao dao;
	
	public MemberService() {
		dao = MemberDao.getInstance();
	}
	
	public static MemberService getInstance() {
		if(service == null) service = new MemberService();
		return service;
	}
	
	public MemberVO loginInfo(MemberVO paravo) {
		return dao.loginInfo(paravo);
	}
	
	
}
