package kr.or.ddit.nn.dao.music;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.chartItem.Chart_ItemVO;
import kr.or.ddit.nn.vo.music.Music_searchVO;
import kr.or.ddit.nn.vo.music.musicVO;
import kr.or.ddit.nn.vo.music.viewMusicVO;

public class musicDaoImpl implements musicDao {
	private SqlMapClient smc;
	
	private static musicDaoImpl dao;
	private musicDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static musicDaoImpl getInstance() {
		if (dao == null) {
			dao = new musicDaoImpl();
		}
		return dao;
	}
	
	/**
	 * 음악 추가 메서드
	 */
	@Override
	public int insertMusic(musicVO mv) {
		int cnt = 0;
		try {
			Object obj = smc.insert("insertMusic", mv);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			System.out.println("음악 추가 에러");
			e.printStackTrace();
		}
		return cnt;
	}
	
	/**
	 * 음악 삭제 메서드
	 */
	@Override
	public int deleteMusic(int music_id) {
		int cnt = 0;
		try {
			cnt = smc.delete("deleteMusic", music_id);
		}catch(SQLException e) {
			System.out.println("음악 삭제 에러");
			e.printStackTrace();
		}
		return cnt;
	}
	
	/**
	 * 음악 수정 메서드
	 */
	@Override
	public int updateMusic(musicVO mv) {
		int cnt = 0;
		try {
			cnt = smc.update("updateMusic", mv);
		}catch(SQLException e) {
			System.out.println("음악 수정 에러");
			e.printStackTrace();
		}
		return cnt;
	}
	
	/**
	 * 음악 조회 메서드
	 */
	@Override
	public musicVO selectMusic(int music_id) {
		musicVO mv = new musicVO();
		try {
			mv = (musicVO) smc.queryForObject("selectMusic", music_id);
		} catch (SQLException e) {
			System.out.println("음악 조회 에러");
			e.printStackTrace();
		}
		return mv;
	}
	
	
	/**
	 * 음악 전체조회 메서드
	 */
	@Override
	public List<musicVO> selectAllMusic() {
		List<musicVO> mList = new ArrayList<>();
		try {
			mList = smc.queryForList("selectAllMusic");
		} catch (SQLException e) {
			System.out.println("음악 전체조회 에러");
			e.printStackTrace();
		}
		return mList;
	}
	
	/**
	 * 테이블내 음악 전체 출력
	 */
	@Override
	public List<viewMusicVO> selectViewMusic() {
		List<viewMusicVO> vmList = new ArrayList<>();
		try {
			vmList = smc.queryForList("viewMusic");
		} catch (SQLException e) {
			System.out.println("테이블내 음악 전체조회 에러");
			e.printStackTrace();
		}
		return vmList;
	}

	@Override
	public List<viewMusicVO> selectMusicCount(List<Chart_ItemVO> chart_list) {
		List<viewMusicVO> vmList = new ArrayList<>();
		try {
			vmList = smc.queryForList("selectMusicCount", chart_list);
		} catch (SQLException e) {
			System.out.println("차트내 음악 전체조회 에러");
			e.printStackTrace();
		}
		return vmList;
	}

	@Override
	public viewMusicVO selectMusicInfo(int music_id) {
		viewMusicVO vmv = new viewMusicVO();
		try {
			vmv = (viewMusicVO) smc.queryForObject("selectMusicInfo", music_id);
		} catch (SQLException e) {
			System.out.println("테이블내 음악 전체조회 에러");
			e.printStackTrace();
		}
		return vmv;
	}

	@Override
	public List<viewMusicVO> serch(Music_searchVO msh) {
		List<viewMusicVO> vlist = new ArrayList<>();
		try {
			vlist = smc.queryForList("serch", msh);
		}catch (SQLException e) {
			System.out.println("검색오류");
			e.printStackTrace();
		}
		return vlist;
	}

	@Override
	public List<viewMusicVO> selectMainChartMusic() {
		List<viewMusicVO> vlist = new ArrayList<>();
		try {
			vlist = smc.queryForList("selectMainChartMusic");
		}catch (SQLException e) {
			System.out.println("메인차트오류");
			e.printStackTrace();
		}
		return vlist;
	}

	@Override
	public List<viewMusicVO> selectNewMusic() {
		List<viewMusicVO> vlist = new ArrayList<>();
		try {
			vlist = smc.queryForList("selectNewMusic");
		}catch (SQLException e) {
			System.out.println("메인차트오류");
			e.printStackTrace();
		}
		return vlist;
	}

	@Override
	public int selectMusicForName(musicVO mv) {
		int music_id = 0;
		try {
			music_id = (int) smc.queryForObject("selectMusicForName");
		}catch (SQLException e) {
			System.out.println("메인차트오류");
			e.printStackTrace();
		}
		return music_id;
	}

	

}
