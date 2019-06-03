package kr.or.ddit.nn.dao.join;

import java.util.List;

import kr.or.ddit.nn.vo.member.MemberVO;

public interface JoinDao {

	public List<MemberVO> selectId(MemberVO mv);
	
	public List<MemberVO> selectEmail(MemberVO mv);
	
	public List<MemberVO> selectNick(MemberVO mv);
	
	public List<MemberVO> selectName(MemberVO mv); // 카카오 로그인 시 사용자 이름으로 조회
	
	public int insertMember(MemberVO mv);
	
	public int deleteMember(String memId);

	/**
	 * Level 조회
	 */
	public int selectMemLevel (MemberVO mv);
}
