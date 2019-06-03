package kr.or.ddit.nn.dao.mv;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.mv.MVVO;

public class mvDaoImpl implements mvDao {
	private SqlMapClient smc;
	private static mvDaoImpl dao;
	private mvDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static mvDaoImpl getInstance() {
		if (dao == null) {
			dao = new mvDaoImpl();
		}
		return dao;
	}

	/**
	 * 뮤비 추가
	 */
	@Override
	public int insertMV(MVVO mvv) {
		int cnt = 0;
		try {
			Object obj = smc.insert("insertMV", mvv);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			System.out.println("뮤비 추가 에러");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 뮤비 수정
	 */
	@Override
	public int updateMV(MVVO mvv) {
		int cnt = 0;
		try {
			cnt = smc.update("updateMV", mvv);
		}catch(SQLException e) {
			System.out.println("뮤비 수정 에러");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 뮤비 삭제
	 */
	@Override
	public int deleteMV(MVVO mvv) {
		int cnt = 0;
		try {
			cnt = smc.delete("deleteMV", mvv);
		}catch(SQLException e) {
			System.out.println("뮤비 삭제 에러");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 뮤비 전체 조회
	 */
	@Override
	public List<MVVO> selectAllMV() {
		List<MVVO> mList = new ArrayList<>();
		try {
			mList = smc.queryForList("selectAllMV");
		} catch (SQLException e) {
			System.out.println("뮤비 전체조회 에러");
			e.printStackTrace();
		}
		return mList;
	}

	/**
	 * 뮤비 조회
	 */
	@Override
	public MVVO selectMV(MVVO mvv) {
		MVVO mv = new MVVO();
		try {
			mv = (MVVO) smc.queryForObject("selectMV", mvv);
		} catch (SQLException e) {
			System.out.println("뮤비 조회 에러");
			e.printStackTrace();
		}
		return mv;
	}

}
