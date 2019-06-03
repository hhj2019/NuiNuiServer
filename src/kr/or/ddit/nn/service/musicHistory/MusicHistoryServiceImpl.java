package kr.or.ddit.nn.service.musicHistory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.musicHistory.MusicHistoryDaoImpl;
import kr.or.ddit.nn.vo.musicHistory.MusicHistoryVO;

public class MusicHistoryServiceImpl extends UnicastRemoteObject implements MusicHistoryService {

	static MusicHistoryDaoImpl musicHistoryDao;
	private static MusicHistoryServiceImpl service;

	private MusicHistoryServiceImpl() throws RemoteException {
		super();
		musicHistoryDao = MusicHistoryDaoImpl.getInstance();
	}

	public static MusicHistoryServiceImpl getInstance() throws RemoteException {
		if (service == null) {
			service = new MusicHistoryServiceImpl();
		}
		return service;
	}

	@Override
	public List<MusicHistoryVO> selectMusicHistory(String mem_id) throws RemoteException {
		return musicHistoryDao.selectMusicHistory(mem_id);
	}

}
