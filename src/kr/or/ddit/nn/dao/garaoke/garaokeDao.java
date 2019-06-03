package kr.or.ddit.nn.dao.garaoke;


import kr.or.ddit.nn.vo.garaoke.GaraokeVO;

public interface garaokeDao{
	/**
	 * 노래방 번호 추가
	 * @param gv
	 * @return
	 */
	public int insertGaraoke(GaraokeVO gv);
	/**
	 * 노래방 번호 수정
	 * @param gv
	 * @return
	 */
	public int updateGaraoke(GaraokeVO gv);
	/**
	 * 노래방 번호 삭제
	 * @param gv
	 * @return
	 */
	public int deleteGaraoke(GaraokeVO gv);
	/**
	 * 노래방 번호 조회
	 * @param artist_id
	 * @return
	 */
	public GaraokeVO selectGaraoke(int music_id);
}
