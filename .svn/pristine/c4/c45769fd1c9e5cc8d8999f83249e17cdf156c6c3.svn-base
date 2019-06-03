package kr.or.ddit.nn.dao.chart_item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.chartItem.Chart_ItemVO;

public class Chart_ItemDaoImpl implements Chart_ItemDao {

	private SqlMapClient smc;
	
	public static Chart_ItemDaoImpl dao;
	
	private Chart_ItemDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static Chart_ItemDaoImpl getInstance() {
		if(dao == null) {
			dao = new Chart_ItemDaoImpl();
		}
		return dao;
	}

	/**
	 * 차트 노래 상세 출력
	 */
	@Override
	public List<Chart_ItemVO> selectAllChartItem() {
		
		List<Chart_ItemVO> chartItemList = new ArrayList<>();
		
		try {
			chartItemList = smc.queryForList("selectAllChartItem");
		}catch (SQLException e) {
			System.out.println("차트 노래 전체 출력 오류");
			e.printStackTrace();
		}
		return chartItemList;
	}

	@Override
	public List<Chart_ItemVO> selectChartMusic(int id) {
		List<Chart_ItemVO> chartItemList = new ArrayList<>();
		
		try {
			chartItemList = smc.queryForList("selectChartMusic", id);
		}catch (SQLException e) {
			System.out.println("차트아이디에 맞는 노래 전체 출력 오류");
			e.printStackTrace();
		}
		return chartItemList;
	}

	@Override
	public int insertChartMusic(Chart_ItemVO cv) {
		int cnt = 0;
		try {
			Object obj = smc.queryForObject("insertChartMusic");
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
