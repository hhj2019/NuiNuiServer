package kr.or.ddit.nn.dao.artist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.artist.artistVO;

public class artistDaoImpl implements artistDao {
	
	private SqlMapClient smc;
	
	private static artistDaoImpl dao;
	private artistDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static artistDaoImpl getInstance() {
		if (dao == null) {
			dao = new artistDaoImpl();
		}
		return dao;
	}
	
	/**
	 * 아티스트 추가
	 */
	@Override
	public int insertArtist(artistVO av) {
		int cnt = 0;
		try {
			Object obj = smc.insert("insertArtist", av);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			System.out.println("아티스트 추가 에러");
			e.printStackTrace();
		}
		return cnt;
	}
	
	/**
	 * 아티스트 수정
	 */
	@Override
	public int updateArtist(artistVO av) {
		int cnt = 0;
		try {
			cnt = smc.update("updateArtist", av);
		}catch(SQLException e) {
			System.out.println("아티스트 수정 에러");
			e.printStackTrace();
		}
		return cnt;
	}
	
	/**
	 * 아티스트 삭제
	 */
	@Override
	public int deleteArtist(artistVO av) {
		int cnt = 0;
		try {
			cnt = smc.delete("deleteArtist", av);
		}catch(SQLException e) {
			System.out.println("아티스트 삭제 에러");
			e.printStackTrace();
		}
		return cnt;
	}
	
	/**
	 * 아티스트 전체 조회
	 */
	@Override
	public List<artistVO> selectAllArtist() {
		List<artistVO> aList = new ArrayList<>();
		try {
			aList = smc.queryForList("selectAllArtist");
		} catch (SQLException e) {
			System.out.println("아티스트 전체 출력 에러");
			e.printStackTrace();
		}
		return aList;
	}
	
	/**
	 * 아티스느 조회
	 */
	@Override
	public artistVO selectArtist(artistVO av) {
		try {
			av = (artistVO) smc.queryForObject("selectArtist", av);
		} catch (SQLException e) {
			System.out.println("아티스트 출력 에러");
			e.printStackTrace();
		}
		return av;
	}

	@Override
	public artistVO selectArtistForName(String artist_name) {
		artistVO av = new artistVO();
		try {
			av = (artistVO) smc.queryForObject("selectArtistForName", artist_name);
		} catch (SQLException e) {
			System.out.println("아티스트 출력 에러");
			e.printStackTrace();
		}
		return av;
	}

}
