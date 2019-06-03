package kr.or.ddit.nn.dao.chart;

import java.util.List;

import kr.or.ddit.nn.vo.chart.ChartVO;

public interface ChartDao{

	/**
	 * 차트 목록 출력
	 * @return
	 */
	public ChartVO selectAllChart(ChartVO cv);
	
	/**
	 * 차트 추가
	 * @return
	 */
	public int insertChart(ChartVO cv);
}
