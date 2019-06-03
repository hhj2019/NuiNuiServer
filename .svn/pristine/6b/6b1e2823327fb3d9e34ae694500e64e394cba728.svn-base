package kr.or.ddit.nn.dao.playmusicitem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.playmusicitem.PlayMusicItemVO;

public class PlayMusicItemDaoImpl implements PlayMusicItemDao {

	
	private SqlMapClient smc; 

	// 외부에서 객체를 생성하는 것을 막음
	public static PlayMusicItemDaoImpl dao;

	private PlayMusicItemDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	// 객체 생성 및 제공
	public static PlayMusicItemDaoImpl getInstance() {
		if (dao == null) {
			dao = new PlayMusicItemDaoImpl();
		}
		return dao;
	}
	
	
	/**
	 *  1. PalyMusicItem 조회
	 */
	@Override
	public List<PlayMusicItemVO> selectPalyMusicItem() {
		ArrayList<PlayMusicItemVO> playmusicitem = new ArrayList<PlayMusicItemVO>();

		try {
			playmusicitem = (ArrayList<PlayMusicItemVO>) smc.queryForList("selectPalyMusicItem");
		} catch (SQLException e) {
			System.out.println("비상비상 에러발생 selectPalyMusicItem");
			e.printStackTrace();
		}
		return playmusicitem;
	}
	/**
	 *  2. PalyMusicItem 삭제
	 */
	@Override
	public int deletePalyMusicItem(PlayMusicItemVO vo) {
		int cnt = 0;

		try {
			cnt = smc.delete("deletePlayMusicItem", vo);

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 

		return cnt;
	}
	/**
	 *  3. PalyMusicItem 추가
	 */
	@Override
	public int insertPalyMusicItem(PlayMusicItemVO vo) {
		
		int cnt = 0;

		try {
			Object obj = smc.insert("insertPlayMusicItem", vo);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}

		return cnt;
	}

	}

