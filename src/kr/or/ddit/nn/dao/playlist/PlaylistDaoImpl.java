package kr.or.ddit.nn.dao.playlist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.playlist.PlaylistVO;

public class PlaylistDaoImpl implements PlaylistDao {

	private SqlMapClient smc; // review.xml 연결

	// 외부에서 객체를 생성하는 것을 막음
	public static PlaylistDaoImpl dao;

	private PlaylistDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	// 객체 생성 및 제공
	public static PlaylistDaoImpl getInstance() {
		if (dao == null) {
			dao = new PlaylistDaoImpl();
		}
		return dao;
	}

	/**
	 * 1. Playlist 전체조회
	 */
	@Override
	public List<PlaylistVO> selectPlayListAll(String mem_id) {
		ArrayList<PlaylistVO> playlistAll = new ArrayList<PlaylistVO>();

		try {
			playlistAll = (ArrayList<PlaylistVO>) smc.queryForList("selectPlayListAll", mem_id);
		} catch (SQLException e) {
			System.out.println("비상비상 에러발생 selectPlayListAll");
			e.printStackTrace();
		}
		return playlistAll;
	}
	
	/**
	 * 1.1 Playlist 단일조회
	 */

	@Override
	public PlaylistVO selectPlayList(int playlist_id) {
		PlaylistVO playlist = new PlaylistVO();

		try {
			playlist = (PlaylistVO) smc.queryForObject("selectPlayList", playlist_id);
		} catch (SQLException e) {
			System.out.println("비상비상 에러발생 selectPlayList");
			e.printStackTrace();
		}
		return playlist;
	}

	/**
	 * 2. Playlist 삭제
	 */
	@Override
	public int deletePlaylist(int playlist_id) {
		int cnt = 0;

		try {
			cnt = smc.delete("deletePlaylist", playlist_id);

		} catch (SQLException e) {
			cnt = 0;
			System.out.println("비상비상 에러발생 deletePlaylist");
			e.printStackTrace();
		} 

		return cnt;
	}
	
	/**
	 * 3. Playlist 수정
	 */
	@Override
	public int updatePlaylist(PlaylistVO vo) {
		int cnt = 0;
		try {
			cnt = smc.update("updatePlaylist", vo);
		}catch(SQLException e) {
			System.out.println("비상비상 에러발생 updatePlaylist");
			e.printStackTrace();
		}
		return cnt;
	}
	/**
	 * 4. Playlist 추가
	 */
	@Override
	public int insertPlaylist(PlaylistVO vo) {
		int cnt = 0;

		try {
			Object obj = smc.insert("insertPlaylist", vo);
			if(obj == null) {
				cnt = 1;
				System.out.println("추가완료!!!");
			}
		} catch (SQLException e) {
			cnt = 0;
			System.out.println("비상비상 에러발생 insertPlaylist");
			e.printStackTrace();
		}

		return cnt;
	}


}
