package kr.or.ddit.nn.service.chart;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.chart.ChartDaoImpl;
import kr.or.ddit.nn.vo.chart.ChartVO;

public class ChartServiceImpl extends UnicastRemoteObject implements ChartService {

	ChartDaoImpl ChartDao;
	private static ChartServiceImpl service; 
	
	private ChartServiceImpl() throws RemoteException{
		super();
		ChartDao = ChartDaoImpl.getInstance();
	}
	public static ChartServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new ChartServiceImpl();
		}
		return service;
	}
	
	/**
	 * 차트 목록 출력
	 */
	@Override
	public ChartVO selectAllChart(ChartVO cv) throws RemoteException {
		return ChartDao.selectAllChart(cv);
	}
	@Override
	public int insertChart(ChartVO cv) throws RemoteException {
		return ChartDao.insertChart(cv);
	}

}
