package kr.or.ddit.nn.dao.myInfo;

import kr.or.ddit.nn.vo.member.MemberVO;

public interface MyInfoDao {
	
	/**
	 * 내정보를 조회한다.
	 * @param memId
	 * @return
	 */
	public MemberVO viewMyInfo(String memId);
	
	/**
	 * 내정보를 직접 입력한 내용으로 변경한다.
	 * @param member
	 * @return
	 */
	public int updateMyInfo(MemberVO member);
	
	/**
	 * 이용권 누적기간을 자동계산하여 특정일을 넘어가면 등급을 증가시키거나 감소시킨다.
	 * @param member
	 * @return
	 */
	public int updateGrade(String member);

}
