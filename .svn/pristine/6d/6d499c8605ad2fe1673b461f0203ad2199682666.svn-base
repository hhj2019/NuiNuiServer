package kr.or.ddit.nn.service.music;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.music.BuyMusicHistoryDao;
import kr.or.ddit.nn.dao.music.BuyMusicHistoryDaoImpl;
import kr.or.ddit.nn.vo.music.BuyMusicHistoryVO;

public class BuyMusicHistoryServiceImpl extends UnicastRemoteObject implements BuyMusicHistoryService {
	
	private static BuyMusicHistoryService service;
	private BuyMusicHistoryDao buyMusicHistoryDao;

	private BuyMusicHistoryServiceImpl() throws RemoteException {
		super();
		buyMusicHistoryDao = BuyMusicHistoryDaoImpl.getInstance();
	}
	
	public static BuyMusicHistoryService getInstance() throws RemoteException {
		if(service == null) {
			service = new BuyMusicHistoryServiceImpl();
		}
		return service;
	}

	@Override
	public int insertHistory(BuyMusicHistoryVO history) throws RemoteException {
		return buyMusicHistoryDao.insertHistory(history);
	}

	@Override
	public List<BuyMusicHistoryVO> viewHistory(String memId) throws RemoteException {
		return buyMusicHistoryDao.viewHistory(memId);
	}

	@Override
	public int selectHistory(BuyMusicHistoryVO history) throws RemoteException {
		return buyMusicHistoryDao.selectHistory(history);
	}

}
