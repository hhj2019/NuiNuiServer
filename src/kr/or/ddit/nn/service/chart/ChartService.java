package kr.or.ddit.nn.service.chart;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.nn.vo.chart.ChartVO;

public interface ChartService extends Remote{

	/**
	 * 차트 목록 출력
	 * @return
	 */
	public ChartVO selectAllChart(ChartVO cv) throws RemoteException;
	
	/**
	 * 차트 추가
	 * @param cv
	 * @return
	 * @throws RemoteException
	 */
	public int insertChart(ChartVO cv) throws RemoteException;
}
