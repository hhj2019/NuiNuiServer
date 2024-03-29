package kr.or.ddit.nn.dao.album;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.album.albumVO;
import kr.or.ddit.nn.vo.music.viewMusicVO;

public class albumDaoImpl implements albumDao {
	
	private SqlMapClient smc;
	
	private static albumDaoImpl dao;
	private albumDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static albumDaoImpl getInstance() {
		if (dao == null) {
			dao = new albumDaoImpl();
		}
		return dao;
	}
	
	/**
	 * 앨범 추가 메서드
	 */
	@Override
	public int insertAlbum(albumVO av) {
		int cnt = 0;
		try {
			Object obj = smc.insert("insertAlbum", av);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			System.out.println("앨범 추가 에러");
			e.printStackTrace();
		}
		return cnt;
	}
	
	/**
	 * 앨범 수정 메서드
	 */
	@Override
	public int updateAlbum(albumVO av) {
		int cnt = 0;
		try {
			cnt = smc.update("updateAlbum", av);
		}catch(SQLException e) {
			System.out.println("앨범 수정 에러");
			e.printStackTrace();
		}
		return cnt;
	}
	/**
	 * 앨범 삭제 메서드
	 */
	@Override
	public int deleteAlbum(albumVO av) {
		int cnt = 0;
		try {
			cnt = smc.delete("deleteAlbum", av);
		}catch(SQLException e) {
			System.out.println("앨범 삭제 에러");
			e.printStackTrace();
		}
		return cnt;
	}
	
	/**
	 * 앨범 출력 메서드
	 */
	@Override
	public albumVO selectAlbum(albumVO av2) {
		albumVO av = new albumVO();
		try {
			av = (albumVO) smc.queryForObject("selectAlbum", av2);
		} catch (SQLException e) {
			System.out.println("앨범 출력 에러");
			e.printStackTrace();
		}
		return av;
	}
	
	/**
	 * 앨범 전체 출력 메서드
	 */
	@Override
	public List<albumVO> selectAllAlbum() {
		List<albumVO> aList = new ArrayList<>();
		try {
			aList = smc.queryForList("selectAllAlbum");
		} catch (SQLException e) {
			System.out.println("앨범 전체 출력 에러");
			e.printStackTrace();
		}
		return aList;
	}

	@Override
	public List<albumVO> selectNewAlbum() {
		List<albumVO> aList = new ArrayList<>();
		try {
			aList = smc.queryForList("selectNewAlbum");
		} catch (SQLException e) {
			System.out.println("최신앨범 출력 에러");
			e.printStackTrace();
		}
		return aList;
	}

	@Override
	public List<viewMusicVO> selectNewAlbumDetail(int album_id) {
		List<viewMusicVO> aList = new ArrayList<>();
		try {
			aList = smc.queryForList("selectNewAlbumDetail",album_id);
		} catch (SQLException e) {
			System.out.println("최신앨범 상세 출력 에러");
			e.printStackTrace();
		}
		return aList;
	}

}
