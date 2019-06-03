package kr.or.ddit.nn.dao.music;

import java.util.List;

import kr.or.ddit.nn.vo.chartItem.Chart_ItemVO;
import kr.or.ddit.nn.vo.music.Music_searchVO;
import kr.or.ddit.nn.vo.music.musicVO;
import kr.or.ddit.nn.vo.music.viewMusicVO;

/**
 * 뮤직 관리 인스턴스
 * @author pc15
 *
 */
public interface musicDao{
	
	/**
	 * 음악 추가
	 * @param mv
	 * @return
	 */
	public int insertMusic(musicVO mv);
	
	/**
	 * 음악 삭제
	 * @param music_id
	 * @return
	 */
	public int deleteMusic(int music_id);
	
	/**
	 * 음악 수정
	 * @param mv
	 * @return
	 */
	public int updateMusic(musicVO mv);
	
	/**
	 * 음악 출력
	 * @param music_id
	 * @return
	 */
	public musicVO selectMusic(int music_id);
	
	/**
	 * 음약 전체 출력
	 * @return
	 */
	public List<musicVO> selectAllMusic();
	
	/**
	 * 테이블 출력용 음악
	 * @return
	 */
	public List<viewMusicVO> selectViewMusic();
	
	/**
	 * 전체차트 출력용 음악
	 * @return
	 */
	public List<viewMusicVO> selectMusicCount(List<Chart_ItemVO> chart_list);
	
	/**
	 * 음악 정보 출력
	 * @return
	 */
	public viewMusicVO selectMusicInfo(int music_id);
	
	
	/**
	 * 음악 검색
	 * @param msh
	 * @return
	 */
	public List<viewMusicVO> serch(Music_searchVO msh);	
	
	/**
	 * 메인 차트 음악 출력
	 * @return
	 */
	public List<viewMusicVO> selectMainChartMusic();
	
	/**
	 * 최신 음악 출력
	 * @return
	 */
	public List<viewMusicVO> selectNewMusic();
	
	public int selectMusicForName(musicVO mv);
	
	
}
