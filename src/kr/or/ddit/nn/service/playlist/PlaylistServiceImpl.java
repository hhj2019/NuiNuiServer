package kr.or.ddit.nn.service.playlist;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.playlist.PlaylistDaoImpl;
import kr.or.ddit.nn.vo.playlist.PlaylistVO;

public class PlaylistServiceImpl extends UnicastRemoteObject implements PlaylistService {
	PlaylistDaoImpl playlistDao;
	private static PlaylistServiceImpl service;

	private PlaylistServiceImpl() throws RemoteException {
		super();
		playlistDao = PlaylistDaoImpl.getInstance();
	}

	public static PlaylistServiceImpl getInstance() throws RemoteException {
		if (service == null) {
			service = new PlaylistServiceImpl();
		}
		return service;
	}

	

	@Override
	public PlaylistVO selectPlayList(int playlist_id) throws RemoteException {
		return playlistDao.selectPlayList(playlist_id);
	}

	@Override
	public int deletePlaylist(int playlist_id) throws RemoteException {
		return playlistDao.deletePlaylist(playlist_id);
	}

	@Override
	public int insertPlaylist(PlaylistVO vo) throws RemoteException {
		return playlistDao.insertPlaylist(vo);
	}

	@Override
	public int updatePlaylist(PlaylistVO vo) throws RemoteException {
		return playlistDao.updatePlaylist(vo);
	}

	@Override
	public List<PlaylistVO> selectPlayListAll(String mem_id) throws RemoteException {
		return playlistDao.selectPlayListAll(mem_id);
	}


}
