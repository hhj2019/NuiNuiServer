package kr.or.ddit.nn.dao.playlistitem;

import java.util.List;

import kr.or.ddit.nn.vo.music.viewMusicVO;
import kr.or.ddit.nn.vo.playlistitem.PlaylistItemVO;


public interface PlaylistItemDao{
	/**
	 * 1-1. Playlistitem 조회
	 */
	public List<viewMusicVO> selectPlayListItem(int playlist_id);
	
	
	public int insertPlaylistItem(PlaylistItemVO piv);
}
