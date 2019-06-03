package kr.or.ddit.nn.service.ticket;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.ticket.TicketHistoryDao;
import kr.or.ddit.nn.dao.ticket.TicketHistoryDaoImpl;
import kr.or.ddit.nn.vo.ticket.TicketHistoryVO;

public class TicketHistoryServiceImpl extends UnicastRemoteObject implements TicketHistoryService {
	
	private static TicketHistoryService service;
	private TicketHistoryDao ticketHistoryDao;
	

	private TicketHistoryServiceImpl() throws RemoteException {
		super();
		ticketHistoryDao = TicketHistoryDaoImpl.getInstance();
	}
	
	public static TicketHistoryService getInstance() throws RemoteException {
		if(service == null) {
			service = new TicketHistoryServiceImpl();
		}
		return service;
	}

	@Override
	public int insertHistory(TicketHistoryVO ticket) throws RemoteException {
		return ticketHistoryDao.insertHistory(ticket);
	}

	@Override
	public List<TicketHistoryVO> viewHistory(String memId) throws RemoteException {
		return ticketHistoryDao.viewHistory(memId);
	}

}
