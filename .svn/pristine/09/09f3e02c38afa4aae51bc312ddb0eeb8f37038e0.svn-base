package kr.or.ddit.nn.service.mvHistory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.mvHistory.MvHistoryDaoImpl;
import kr.or.ddit.nn.vo.mvHistory.MvHistoryVO;

public class MvHistoryServiceImpl extends UnicastRemoteObject implements MvHistoryService {
	static MvHistoryDaoImpl mvHistoryDao;
	private static MvHistoryServiceImpl service;

	private MvHistoryServiceImpl() throws RemoteException {
		super();
		mvHistoryDao = MvHistoryDaoImpl.getInstance();
	}

	public static MvHistoryServiceImpl getInstance() throws RemoteException {
		if (service == null) {
			service = new MvHistoryServiceImpl();
		}
		return service;
	}
	@Override
	public List<MvHistoryVO> selectMvHistory(String mem_id) throws RemoteException {
		return mvHistoryDao.selectMvHistory(mem_id);
	}

}
