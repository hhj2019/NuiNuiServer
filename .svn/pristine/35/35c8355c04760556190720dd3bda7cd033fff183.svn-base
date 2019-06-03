package kr.or.ddit.nn.dao.event;

import java.util.List;

import kr.or.ddit.nn.vo.event.EventVO;

public interface EventDao{

	/**
	 * 이벤트 목록 조회
	 * @return
	 */
	public List<EventVO> selectAllEvent();
	
	/**
	 * 이벤트 상세 조회
	 * @param event_id
	 * @return
	 */
	public EventVO selectEventdetail(int event_id);
	
	/**
	 * 이벤트 기간 조회
	 */
	public List<EventVO> selectEventDate();
	
	/**
	 * 이벤트 추가
	 * @param ev
	 * @return
	 */
	public int insertEvent(EventVO ev);
	
	/**
	 * 이벤트 수정
	 * @param ev
	 * @return
	 */
	public int updateEvent(EventVO ev);
	
	/**
	 * 이벤트 삭제
	 * @param event_id
	 * @return
	 */
	public int deleteEvent(int event_id);
}
