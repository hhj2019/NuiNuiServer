package kr.or.ddit.nn.dao.chart_item;

import java.util.List;
 
import kr.or.ddit.nn.vo.chartItem.Chart_ItemVO;

public interface Chart_ItemDao{

	/**
	 * 차트 노래 목록 출력
	 * @return
	 */
	public List<Chart_ItemVO> selectAllChartItem();
	
	/**
	 * 차트 아이디에 맞는 차트 출력
	 * @return
	 */
	public List<Chart_ItemVO> selectChartMusic(int id);
	
	/**
	 * 차트에 노래 추가
	 * @param cv
	 * @return
	 */
	public int insertChartMusic(Chart_ItemVO cv);
}
