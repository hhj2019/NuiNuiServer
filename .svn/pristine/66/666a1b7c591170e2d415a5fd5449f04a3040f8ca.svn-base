package kr.or.ddit.nn.dao.music;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.music.BuyMusicHistoryVO;

public class BuyMusicHistoryDaoImpl implements BuyMusicHistoryDao {
	
	private SqlMapClient smc;
	private static BuyMusicHistoryDao dao;
	
	private BuyMusicHistoryDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static BuyMusicHistoryDao getInstance() {
		if(dao == null) {
			dao = new BuyMusicHistoryDaoImpl();
		}
		return dao;
	}

	@Override
	public int insertHistory(BuyMusicHistoryVO history) {
		int cnt = 0;
		try {
			Object obj = smc.insert("buyMusicHistory.insertHistory", history);
			if(obj == null)
				cnt = 1;
		} catch (SQLException e) {
			System.out.println("error! ticketHistory.insertHistory");
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BuyMusicHistoryVO> viewHistory(String memId) {
		List<BuyMusicHistoryVO> list = null;
		try {
			list = smc.queryForList("buyMusicHistory.viewHistory", memId);
		} catch (SQLException e) {
			System.out.println("error! buyMusicHistory.viewHistory");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int selectHistory(BuyMusicHistoryVO history) {
		int cnt = 0;
		try {
			cnt = (int) smc.queryForObject("buyMusicHistory.selectHistory", history);
		} catch (SQLException e) {
			System.out.println("error! buyMusicHistory.selectHistory");
			e.printStackTrace();
		}
		return cnt;
	}

}
