package kr.or.ddit.nn.dao.musicHistory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.musicHistory.MusicHistoryVO;

public class MusicHistoryDaoImpl implements MusicHistoryDao {

	private SqlMapClient smc;

	private static MusicHistoryDaoImpl dao;

	private MusicHistoryDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	public static MusicHistoryDaoImpl getInstance() {
		if (dao == null) {
			dao = new MusicHistoryDaoImpl();
		}
		return dao;
	}

	/**
	 * 뮤직 히스토리 조회
	 */
	@Override
	public List<MusicHistoryVO> selectMusicHistory(String mem_id) {
		
		List<MusicHistoryVO> musicHistory = new ArrayList<MusicHistoryVO>();
		
		try {
			musicHistory = smc.queryForList("selectMusicHistory");
		}catch (SQLException e) {
			System.out.println("비상비상 에러발생 selectMusicHistory");
			e.printStackTrace();
		}
		return musicHistory;
	}

}
