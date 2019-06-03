package kr.or.ddit.nn.dao.playmusicitem;

import java.util.List;

import kr.or.ddit.nn.vo.playmusicitem.PlayMusicItemVO;



public interface PlayMusicItemDao {
	/**
	 * 1-1. Playmusicitem 조회
	 */
	public List<PlayMusicItemVO> selectPalyMusicItem();
	
	/**
	 * 2. Playmusicitem 삭제
	 */
	public int deletePalyMusicItem(PlayMusicItemVO vo);

	/**
	 * 3. Playmusicitem 추가
	 */
	public int insertPalyMusicItem(PlayMusicItemVO vo);
	
	
}
