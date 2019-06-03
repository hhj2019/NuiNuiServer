package kr.or.ddit.nn.service.playlistitem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.playlistitem.PlaylistItemDaoImpl;
import kr.or.ddit.nn.vo.music.viewMusicVO;
import kr.or.ddit.nn.vo.playlistitem.PlaylistItemVO;

public class PlaylistitemServiceImpl extends UnicastRemoteObject implements PlaylistItemService {

	PlaylistItemDaoImpl playlistitemDao;
	private static PlaylistitemServiceImpl service;

	private PlaylistitemServiceImpl() throws RemoteException {
		super();
		playlistitemDao = PlaylistItemDaoImpl.getInstance();
	}

	public static PlaylistitemServiceImpl getInstance() throws RemoteException {
		if (service == null) {
			service = new PlaylistitemServiceImpl();
		}
		return service;
	}

	@Override
	public List<viewMusicVO> selectPlayListItem(int playlist_id) throws RemoteException {
		return playlistitemDao.selectPlayListItem(playlist_id);
	}

	@Override
	public int insertPlayListItem(PlaylistItemVO piv) throws RemoteException {
		return playlistitemDao.insertPlaylistItem(piv);
	}



}
