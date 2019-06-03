package kr.or.ddit.nn.dao.chart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.chart.ChartVO;

public class ChartDaoImpl implements ChartDao {

private SqlMapClient smc;
	
	public static ChartDaoImpl dao;
	
	private ChartDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ChartDaoImpl getInstance() {
		if(dao == null) {
			dao = new ChartDaoImpl();
		}
		return dao;
	}
	
	/**
	 * 차트 목록 출력
	 */
	@Override
	public ChartVO selectAllChart(ChartVO cv) {
		
		ChartVO chart = new ChartVO();
		
		try {
			chart = (ChartVO) smc.queryForObject("selectAllChart",cv);
		}catch (SQLException e) {
			System.out.println("차트 목록 출력 오류");
			e.printStackTrace();
		}
		return chart;
	}

	@Override
	public int insertChart(ChartVO cv) {
		int cnt = 0;
		try {
			Object obj = smc.queryForObject("insertChart", cv);
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
