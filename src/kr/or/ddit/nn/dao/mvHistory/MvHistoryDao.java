package kr.or.ddit.nn.dao.mvHistory;

import java.util.List;

import kr.or.ddit.nn.vo.mvHistory.MvHistoryVO;

public interface MvHistoryDao{
	/**
	 * 1. mvHistory 조회
	 */
	
	public List<MvHistoryVO> selectMvHistory(String mem_id);
	
}
