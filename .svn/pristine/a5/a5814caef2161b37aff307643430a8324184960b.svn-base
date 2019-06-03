package kr.or.ddit.nn.service.ticket;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.ticket.TicketDao;
import kr.or.ddit.nn.dao.ticket.TicketDaoImpl;
import kr.or.ddit.nn.vo.ticket.TicketVO;

public class TicketServiceImpl extends UnicastRemoteObject implements TicketService {
	
	private static TicketService service;
	private TicketDao ticketDao;
	
	private TicketServiceImpl() throws RemoteException {
		ticketDao = TicketDaoImpl.getInstance();
	}
	
	public static TicketService getInstance() throws RemoteException {
		if(service == null)
			service = new TicketServiceImpl();
		return service;
	}

	@Override
	public int insertTicket(TicketVO ticket) throws RemoteException {
		return ticketDao.insertTicket(ticket);
	}

	@Override
	public int updateTicket(TicketVO ticket) throws RemoteException {
		return ticketDao.updateTicket(ticket);
	}

	@Override
	public int removeTicket(int id) throws RemoteException {
		return ticketDao.removeTicket(id);
	}

	@Override
	public List<TicketVO> viewAllTicketToUser() throws RemoteException {
		return ticketDao.viewAllTicketToUser();
	}
	
	@Override
	public List<TicketVO> viewAllTicketToManager() throws RemoteException {
		return ticketDao.viewAllTicketToManager();
	}

	@Override
	public TicketVO selectTicekt(int id) throws RemoteException {
		return ticketDao.selectTicekt(id);
	}

}
