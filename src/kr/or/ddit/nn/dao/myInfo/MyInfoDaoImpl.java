package kr.or.ddit.nn.dao.myInfo;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.member.MemberVO;

public class MyInfoDaoImpl implements MyInfoDao {
	
	private SqlMapClient smc;
	private static MyInfoDao dao;
	
	private MyInfoDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static MyInfoDao getInstance() {
		if(dao == null) {
			dao = new MyInfoDaoImpl();
		}
		return dao;
	}

	@Override
	public MemberVO viewMyInfo(String memId) {
		MemberVO member = null;
		try {
			member = (MemberVO) smc.queryForObject("myInfo.viewInfo", memId);
		} catch (SQLException e) {
			System.out.println("error! myInfo.viewInfo");
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public int updateMyInfo(MemberVO member) {
		int cnt = 0;
		try {
			cnt = smc.update("myInfo.updateInfo", member);
		} catch (SQLException e) {
			System.out.println("error! myInfo.updateInfo");
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateGrade(String member) {
		int cnt = 0;
		try {
			cnt = smc.update("myInfo.updateGrade", member);
		} catch (SQLException e) {
			System.out.println("error! myInfo.updateGrade");
			e.printStackTrace();
		}
		return cnt;
	}

}
