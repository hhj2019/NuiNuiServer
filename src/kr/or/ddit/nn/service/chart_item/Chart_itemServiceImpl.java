package kr.or.ddit.nn.service.chart_item;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.chart_item.Chart_ItemDaoImpl;
import kr.or.ddit.nn.vo.chartItem.Chart_ItemVO;

public class Chart_itemServiceImpl extends UnicastRemoteObject implements Chart_itemService {

	Chart_ItemDaoImpl Chart_itemDao;
	private static Chart_itemServiceImpl service; 
	
	private Chart_itemServiceImpl() throws RemoteException{
		super();
		Chart_itemDao = Chart_ItemDaoImpl.getInstance();
	}
	public static Chart_itemServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new Chart_itemServiceImpl();
		}
		return service;
	}
	
	/**
	 * 차트 전체 출력
	 */
	@Override
	public List<Chart_ItemVO> selectAllChartItem() throws RemoteException {
		return Chart_itemDao.selectAllChartItem();
	}
	
	/**
	 * 차트아이디에 맞는 차트 노래 전체 출력
	 */
	@Override
	public List<Chart_ItemVO> selectChartMusic(int id) throws RemoteException {
		return Chart_itemDao.selectChartMusic(id);
	}
	
	/**
	 * 차트에 노래 추가
	 */
	@Override
	public int insertChartMusic(Chart_ItemVO cv) throws RemoteException {
		return Chart_itemDao.insertChartMusic(cv);
	}

}
