package kr.or.ddit.nn.dao.mvHistory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.mvHistory.MvHistoryVO;

public class MvHistoryDaoImpl implements MvHistoryDao {

	private SqlMapClient smc;

	private static MvHistoryDaoImpl dao;

	private MvHistoryDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	public static MvHistoryDaoImpl getInstance() {
		if (dao == null) {
			dao = new MvHistoryDaoImpl();
		}
		return dao;
	}

	/**
	 * 마이 히스토리 조회
	 */
	@Override
	public List<MvHistoryVO> selectMvHistory(String mem_id) {

		List<MvHistoryVO> mvHistory = new ArrayList<MvHistoryVO>();

		try {
			mvHistory = smc.queryForList("selectMvHistory");
		} catch (SQLException e) {
			System.out.println("비상비상 에러발생 selectMvHistory");
			e.printStackTrace();
		}
		return mvHistory;
	}

}
