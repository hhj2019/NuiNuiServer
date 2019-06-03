package kr.or.ddit.nn.service.event;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.event.EventDaoImpl;
import kr.or.ddit.nn.vo.event.EventVO;

public class eventServiceImpl extends UnicastRemoteObject implements eventService {

	EventDaoImpl EventDao;
	private static eventServiceImpl service; 
	
	private eventServiceImpl() throws RemoteException{
		super();
		EventDao = EventDaoImpl.getInstance();
	}
	public static eventServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new eventServiceImpl();
		}
		return service;
	}
	
	/**
	 * 이벤트 목록 조회
	 */
	@Override
	public List<EventVO> selectAllEvent() throws RemoteException {
		return EventDao.selectAllEvent();
	}

	/**
	 * 이벤트 상세 조회
	 */
	@Override
	public EventVO selectEventdetail(int event_id) throws RemoteException {
		return EventDao.selectEventdetail(event_id);
	}
	
	/**
	 * 이벤트 기간 조회
	 */
	@Override
	public List<EventVO> selectEventDate() throws RemoteException {
		return EventDao.selectEventDate();
	}

	/**
	 * 이벤트 추가
	 */
	@Override
	public int insertEvent(EventVO ev) throws RemoteException {
		return EventDao.insertEvent(ev);
	}

	/**
	 * 이벤트 수정
	 */
	@Override
	public int updateEvent(EventVO ev) throws RemoteException {
		return EventDao.updateEvent(ev);
	}

	/**
	 * 이벤트 삭제
	 */
	@Override
	public int deleteEvent(int event_id) throws RemoteException {
		return EventDao.deleteEvent(event_id);
	}
}
