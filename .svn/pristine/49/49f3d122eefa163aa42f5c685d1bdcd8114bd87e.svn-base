package kr.or.ddit.nn.service.ticket;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.ticket.MyTicketDao;
import kr.or.ddit.nn.dao.ticket.MyTicketDaoImpl;
import kr.or.ddit.nn.vo.ticket.MyTicketVO;

public class MyTicketServiceImpl extends UnicastRemoteObject implements MyTicketService {

	private static MyTicketService service;
	private MyTicketDao myTicketDao;
	
	private MyTicketServiceImpl() throws RemoteException {
		myTicketDao = MyTicketDaoImpl.getInstance();
	}
	
	public static MyTicketService getInstance() throws RemoteException {
		if(service == null)
			service = new MyTicketServiceImpl();
		return service;
	}

	@Override
	public int insertMyTicket(MyTicketVO ticket) throws RemoteException {
		return myTicketDao.insertMyTicket(ticket);
	}

	@Override
	public int updateDownCount(MyTicketVO ticket) throws RemoteException {
		return myTicketDao.updateDownCount(ticket);
	}

	@Override
	public int deleteMyTicket(int ticketId) throws RemoteException {
		return myTicketDao.deleteMyTicket(ticketId);
	}

	@Override
	public List<MyTicketVO> viewMyTicket(String memId) throws RemoteException {
		return myTicketDao.viewMyTicket(memId);
	}

	@Override
	public List<MyTicketVO> viewUsableTicket(String memId) throws RemoteException {
		return myTicketDao.viewUsableTicket(memId);
	}

}
