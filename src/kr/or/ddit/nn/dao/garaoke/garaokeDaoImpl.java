package kr.or.ddit.nn.dao.garaoke;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.garaoke.GaraokeVO;

public class garaokeDaoImpl implements garaokeDao {
	
	private SqlMapClient smc;
	
	private static garaokeDaoImpl dao;
	private garaokeDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static garaokeDaoImpl getInstance() {
		if (dao == null) {
			dao = new garaokeDaoImpl();
		}
		return dao;
	}
	
	/**
	 * 노래방 번호 추가
	 */
	@Override
	public int insertGaraoke(GaraokeVO gv) {
		int cnt = 0;
		try {
			Object obj = smc.insert("insertGaraoke", gv);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			System.out.println("노래방 번호 추가 에러");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 노래방 번호 수정
	 */
	@Override
	public int updateGaraoke(GaraokeVO gv) {
		int cnt = 0;
		try {
			cnt = smc.update("updateGaraoke", gv);
		}catch(SQLException e) {
			System.out.println("노래방 번호 수정 에러");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 노래방 번호 삭제
	 */
	@Override
	public int deleteGaraoke(GaraokeVO gv) {
		int cnt = 0;
		try {
			cnt = smc.delete("deleteGaraoke", gv);
		}catch(SQLException e) {
			System.out.println("노래방 번호 삭제 에러");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 노래방 번호 조회
	 */
	@Override
	public GaraokeVO selectGaraoke(int music_id) {
		GaraokeVO av = new GaraokeVO();
		try {
			av = (GaraokeVO) smc.queryForObject("selectGaraoke", music_id);
		} catch (SQLException e) {
			System.out.println("노래방 번호 출력 에러");
			e.printStackTrace();
		}
		return av;
	}
}
