package kr.or.ddit.nn.service.playmusicitem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.playmusicitem.PlayMusicItemDaoImpl;
import kr.or.ddit.nn.vo.playmusicitem.PlayMusicItemVO;

public class PlayMusicItemServiceImpl extends UnicastRemoteObject implements PlayMusicItemService {

	PlayMusicItemDaoImpl playmusicitemDao;
	private static PlayMusicItemServiceImpl service;

	private PlayMusicItemServiceImpl() throws RemoteException {
		super();
		playmusicitemDao = PlayMusicItemDaoImpl.getInstance();
	}

	public static PlayMusicItemServiceImpl getInstance() throws RemoteException {
		if (service == null) {
			service = new PlayMusicItemServiceImpl();
		}
		return service;
	}

	@Override
	public List<PlayMusicItemVO> selectPalyMusicItem() throws RemoteException {
		return playmusicitemDao.selectPalyMusicItem();
	}

	@Override
	public int deletePalyMusicItem(PlayMusicItemVO vo) throws RemoteException {
		return playmusicitemDao.deletePalyMusicItem(vo);
	}

	@Override
	public int insertPalyMusicItem(PlayMusicItemVO vo) throws RemoteException {
		return playmusicitemDao.insertPalyMusicItem(vo);
	}

}
