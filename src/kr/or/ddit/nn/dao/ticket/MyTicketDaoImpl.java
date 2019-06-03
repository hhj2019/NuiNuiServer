package kr.or.ddit.nn.dao.ticket;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.service.ticket.MyTicketService;
import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.ticket.MyTicketVO;

public class MyTicketDaoImpl implements MyTicketDao {
	
	private SqlMapClient smc;
	private static MyTicketDao dao;
	
	private MyTicketDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static MyTicketDao getInstance() {
		if(dao == null) {
			dao = new MyTicketDaoImpl();
		}
		return dao;
	}

	@Override
	public int insertMyTicket(MyTicketVO ticket) {
		int cnt = 0;
		try {
			Object obj = smc.insert("myTicket.insertMyTicket", ticket);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			System.out.println("error! myTicket.insertMyTicket");
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateDownCount(MyTicketVO ticket) {
		int cnt = 0;
		try {
			Object obj = smc.insert("myTicket.updateDownCount", ticket);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			System.out.println("error! myTicket.updateDownCount");
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMyTicket(int ticketId) {
		int cnt = 0;
		try {
			Object obj = smc.insert("myTicket.deleteTicket", ticketId);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			System.out.println("error! myTicket.deleteTicket");
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<MyTicketVO> viewMyTicket(String memId) {
		List<MyTicketVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("myTicket.viewList", memId);
		} catch (SQLException e) {
			System.out.println("error! myTicket.viewList");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MyTicketVO> viewUsableTicket(String memId) {
		
		List<MyTicketVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("myTicket.usableTicketList", memId);
		} catch (SQLException e) {
			System.out.println("error! myTicket.usableTicketList");
			e.printStackTrace();
		}
		return list;
	}

}
