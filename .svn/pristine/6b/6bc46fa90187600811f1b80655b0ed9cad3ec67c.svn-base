package kr.or.ddit.nn.dao.searchPass;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.member.MemberVO;

public class SearchPassDaoImpl implements SearchPassDao {

	private SqlMapClient smc;
	private static SearchPassDaoImpl dao;

	private SearchPassDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static SearchPassDaoImpl getInstance() {
		if(dao == null) {
			dao = new SearchPassDaoImpl();
		}
		return dao;
	}

	@Override
	public int searchPass(MemberVO mvo) {
		int cnt = 0;
		try {
			cnt = smc.update("searchPass", mvo);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	

}
