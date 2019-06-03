package kr.or.ddit.nn.dao.artist;

import java.util.List;

import kr.or.ddit.nn.vo.artist.artistVO;

public interface artistDao{
	
	/**
	 * 아티스트 추가
	 * @param av
	 * @return
	 */
	public int insertArtist(artistVO av);
	/**
	 * 아티스트 수정
	 * @param av
	 * @return
	 */
	public int updateArtist(artistVO av);
	/**
	 * 아티스트 삭제
	 * @param av
	 * @return
	 */
	public int deleteArtist(artistVO av);
	/**
	 * 아티스트 전체조회
	 * @return
	 */
	public List<artistVO> selectAllArtist();
	
	/**
	 * 아티스트 조회
	 * @param artist_id
	 * @return
	 */
	public artistVO selectArtist(artistVO av);
	
	public artistVO selectArtistForName(String artist_name);
	
}
