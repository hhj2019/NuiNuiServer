package kr.or.ddit.nn.dao.event;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.event.EventVO;

public class EventDaoImpl implements EventDao {

	private SqlMapClient smc;
	
	public static EventDaoImpl dao;
	
	private EventDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
		
	public static EventDaoImpl getInstance() {
		if(dao == null) {
			dao = new EventDaoImpl();
		}
		return dao;
	}
	
	/**
	 * 이벤트 전체 조회
	 */
	@Override
	public List<EventVO> selectAllEvent() {

		List<EventVO> eventList = new ArrayList<>();
		
		try {
			eventList = smc.queryForList("selectAllEvent");
		}catch (SQLException e) {
			System.out.println("이벤트 전체 조회 오류");
			e.printStackTrace();
		}
		return eventList;
	}

	/**
	 * 이벤트 상세 조회
	 */
	@Override
	public EventVO selectEventdetail(int event_id) {

		EventVO selectEvent = new EventVO();
		
		try {
			selectEvent = (EventVO) smc.queryForObject("selectEventdetail", event_id);
		}catch (SQLException e) {
			System.out.println("이벤트 상세 조회 오류");
			e.printStackTrace();
		}
		return selectEvent;
	}

	/**
	 * 이벤트 기간 조회
	 */
	@Override
	public List<EventVO> selectEventDate() {
		List<EventVO> eventList	= new ArrayList<>();
		
		try {
			eventList = smc.queryForList("selectEventDate");
		}catch (SQLException e) {
			System.out.println("이벤트 기간 조회 오류");
			e.printStackTrace();
		}
		return eventList;
	}
	
	/**
	 * 이벤트 추가
	 */
	@Override
	public int insertEvent(EventVO ev) {
		int cnt = 0; 
		try {
			Object obj = smc.insert("insertEvent", ev);
				if(obj == null) {
					cnt = 1;
				}
		}catch (SQLException e) {
			System.out.println("이벤트 추가 오류");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 이벤트 수정
	 */
	@Override
	public int updateEvent(EventVO ev) {
		int cnt = 0; 
		try {
			cnt = smc.update("updateEvent", ev);
		}catch (SQLException e) {
			System.out.println("이벤트 수정 오류");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 이벤트 삭제
	 */
	@Override
	public int deleteEvent(int event_id) {
		int cnt = 0;
		try {
			cnt = smc.delete("deleteEvent", event_id);
		}catch (SQLException e) {
			System.out.println("이벤트 삭제 오류");
			e.printStackTrace();
		}
		return cnt;
	}
}
