package kr.or.ddit.nn.dao.ticket;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.ticket.TicketVO;

public class TicketDaoImpl implements TicketDao {
	
	private SqlMapClient smc;
	private static TicketDao dao;
	
	private TicketDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static TicketDao getInstance() {
		if(dao == null) {
			dao = new TicketDaoImpl();
		}
		return dao;
	}

	@Override
	public int insertTicket(TicketVO ticket) {
		int cnt = 0;
		try {
			Object obj = smc.insert("ticket.insertTicketInfo", ticket);
			if(obj == null)
				cnt = 1;
		} catch (SQLException e) {
			System.out.println("error! ticket.insertticketINfo");
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateTicket(TicketVO ticket) {
		int cnt = 0;
		try {
			cnt = smc.update("ticket.updateTicketInfo", ticket);
		} catch (SQLException e) {
			System.out.println("error! ticket.updateTicketInfo");
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int removeTicket(int id) {
		int cnt = 0;
		try {
			cnt = smc.delete("ticket.deleteTicketInfo", id);
		} catch (SQLException e) {
			System.out.println("error! ticket.deleteTicketInfo");
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<TicketVO> viewAllTicketToUser() {
		List<TicketVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("ticket.user.viewTicketProd");
		} catch (SQLException e) {
			System.out.println("error! ticket.user.viewTicketProd");
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<TicketVO> viewAllTicketToManager() {
		List<TicketVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("ticket.manager.viewTicketProd");
		} catch (SQLException e) {
			System.out.println("error! ticket.user.viewTicketProd");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public TicketVO selectTicekt(int id) {
		TicketVO ticket = null;
		try {
			ticket = (TicketVO) smc.queryForObject("ticket.getTicketInfo", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ticket;
	}

}
