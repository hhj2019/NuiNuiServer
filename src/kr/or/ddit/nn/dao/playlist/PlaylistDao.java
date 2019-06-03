package kr.or.ddit.nn.dao.playlist;

import java.util.List;

import kr.or.ddit.nn.vo.playlist.PlaylistVO;

public interface PlaylistDao {
	/**
	 * 1. Playlist 전체 조회
	 */
	public List<PlaylistVO> selectPlayListAll(String mem_id);
	
	/**
	 * 1-1. Playlist 단일 조회
	 */
	public PlaylistVO selectPlayList(int playlist_id);
	
	/**
	 * 2. Playlist 삭제
	 */
	public int deletePlaylist(int playlist_id);

	/**
	 * 3.Playlist 수정
	 */
	public int updatePlaylist(PlaylistVO vo);
	
	/**
	 * 4. Playlist 추가
	 */
	public int insertPlaylist(PlaylistVO vo);


}
