package kr.or.ddit.nn.dao.garaoke;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.garaoke.garaoke_infoVO;

public class garaoke_infoDaoImpl implements garaoke_infoDao {
	
	private SqlMapClient smc;
	
	private static garaoke_infoDaoImpl dao;
	private garaoke_infoDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static garaoke_infoDaoImpl getInstance() {
		if (dao == null) {
			dao = new garaoke_infoDaoImpl();
		}
		return dao;
	}
	
	/**
	 * 노래방 추가
	 */
	@Override
	public int insertGaraoke_info(garaoke_infoVO giv) {
		int cnt = 0;
		try {
			Object obj = smc.insert("insertGaraoke_info", giv);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			System.out.println("노래방 추가 에러");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 노래방 수정
	 */
	@Override
	public int updateGaraoke_info(garaoke_infoVO giv) {
		int cnt = 0;
		try {
			cnt = smc.update("updateGaraoke_info", giv);
		}catch(SQLException e) {
			System.out.println("노래방 수정 에러");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 노래방 삭제
	 */
	@Override
	public int deleteGaraoke_info(garaoke_infoVO giv) {
		int cnt = 0;
		try {
			cnt = smc.delete("deleteGaraoke_info", giv);
		}catch(SQLException e) {
			System.out.println("노래방 삭제 에러");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 노래방 조회
	 */
	@Override
	public garaoke_infoVO selectGaraoke_info(garaoke_infoVO giv) {
		garaoke_infoVO av = new garaoke_infoVO();
		try {
			av = (garaoke_infoVO) smc.queryForObject("selectGaraoke_info", giv);
		} catch (SQLException e) {
			System.out.println("노래방 출력 에러");
			e.printStackTrace();
		}
		return av;
	}

	/**
	 * 노래방 전체 출력
	 */
	@Override
	public List<garaoke_infoVO> selectAllGaraoke_info() {
		List<garaoke_infoVO> List = new ArrayList<>();
		try {
			List = smc.queryForList("selectAllGaraoke_info");
		} catch (SQLException e) {
			System.out.println("노래방 전체 출력 에러");
			e.printStackTrace();
		}
		return List;
	}

}
