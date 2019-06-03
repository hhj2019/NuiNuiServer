package kr.or.ddit.nn.dao.playlistitem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.music.viewMusicVO;
import kr.or.ddit.nn.vo.playlistitem.PlaylistItemVO;

public class PlaylistItemDaoImpl implements PlaylistItemDao {
	
	private SqlMapClient smc; // review.xml 연결

	// 외부에서 객체를 생성하는 것을 막음
	public static PlaylistItemDaoImpl dao;

	private PlaylistItemDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	// 객체 생성 및 제공
	public static PlaylistItemDaoImpl getInstance() {
		if (dao == null) {
			dao = new PlaylistItemDaoImpl();
		}
		return dao;
	}
	/**
	 * Playlistitem 조회
	 * @param playlist_id 
	 */
	@Override
	public List<viewMusicVO> selectPlayListItem(int playlist_id) {
		
		ArrayList<viewMusicVO> playlistitem = new ArrayList<viewMusicVO>();

		try {
			playlistitem = (ArrayList<viewMusicVO>) smc.queryForList("selectPlayListItem", playlist_id);
		} catch (SQLException e) {
			System.out.println("비상비상 에러발생 selectPlayListItem");
			e.printStackTrace();
		}
		return playlistitem;
	}

	@Override
	public int insertPlaylistItem(PlaylistItemVO piv) {
		int cnt = 0;
		try {
			Object obj =  (PlaylistItemVO) smc.insert("insertPlayListItem", piv);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			System.out.println("비상비상 에러발생 insertPlayListItem");
			e.printStackTrace();
		}
		return cnt;
	}

}
