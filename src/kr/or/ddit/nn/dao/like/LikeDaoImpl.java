package kr.or.ddit.nn.dao.like;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.like.LikeVO;


public class LikeDaoImpl implements LikeDao {
	private SqlMapClient smc;
	
	private static LikeDaoImpl dao;
	private LikeDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static LikeDaoImpl getInstance() {
		if (dao == null) {
			dao = new LikeDaoImpl();
		}
		return dao;
	}

	@Override
	public List<LikeVO> selectLike(String mem_id) {
		List<LikeVO> likeList = new ArrayList<>(); 
		
		try { 
			likeList = smc.queryForList("selectLike", mem_id);
		} catch (SQLException e) {
			System.out.println("비상비상 selectLike 오류");
			e.printStackTrace();
		}
		return likeList;
	}

	@Override
	public int insertLike(LikeVO lvo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("insertLike", lvo);
				if(obj == null) {
					cnt = 1;
				}
		}catch (SQLException e) {
			System.out.println("비상비상 insertLike 오류");
			e.printStackTrace();
		}
		return cnt;

	}

	@Override
	public int deleteLike(int music_id) {
		int cnt = 0;
		try {
			cnt = smc.delete("deleteLike", music_id);
		}catch (SQLException e) {
			System.out.println("비상비상 deleteLike 오류");
			e.printStackTrace();
		}
		return cnt;
	}
	
	
		
}
