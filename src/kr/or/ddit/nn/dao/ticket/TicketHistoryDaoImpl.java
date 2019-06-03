package kr.or.ddit.nn.dao.ticket;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.ticket.MyTicketVO;
import kr.or.ddit.nn.vo.ticket.TicketHistoryVO;

public class TicketHistoryDaoImpl implements TicketHistoryDao {
	
	private SqlMapClient smc;
	private static TicketHistoryDao dao;
	
	private TicketHistoryDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static TicketHistoryDao getInstance() {
		if(dao == null) {
			dao = new TicketHistoryDaoImpl();
		}
		return dao;
	}

	@Override
	public int insertHistory(TicketHistoryVO ticket) {
		int cnt = 0;
		try {
			Object obj = smc.insert("ticketHistory.insertHistory", ticket);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			System.out.println("error! ticketHistory.insertHistory");
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<TicketHistoryVO> viewHistory(String memId) {
		List<TicketHistoryVO> list = null;
		try {
			list = smc.queryForList("ticketHistory.viewHistory", memId);
		} catch (SQLException e) {
			System.out.println("error! ticketHistory.viewHistory");
			e.printStackTrace();
		}
		return list;
	}

}
