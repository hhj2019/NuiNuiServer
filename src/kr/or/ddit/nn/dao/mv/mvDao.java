package kr.or.ddit.nn.dao.mv;

import java.util.List;

import kr.or.ddit.nn.vo.mv.MVVO;

public interface mvDao{
	
	/**
	 * 뮤비 추가
	 * @param mvv
	 * @return
	 */
	public int insertMV(MVVO mvv);
	
	/**
	 * 뮤비 수정
	 * @param mvv
	 * @return
	 */
	public int updateMV(MVVO mvv);
	
	/**
	 * 뮤비 삭제
	 * @param mvv
	 * @return
	 */
	public int deleteMV(MVVO mvv);
	
	/**
	 * 뮤비 전체 조회
	 * @return
	 */
	public List<MVVO> selectAllMV();
	
	/**
	 * 뮤비 조회
	 * @param mvv
	 * @return
	 */
	public MVVO selectMV(MVVO mvv);
}
