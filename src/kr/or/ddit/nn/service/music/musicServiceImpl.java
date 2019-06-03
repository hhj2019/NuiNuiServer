package kr.or.ddit.nn.service.music;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.music.musicDaoImpl;
import kr.or.ddit.nn.vo.chartItem.Chart_ItemVO;
import kr.or.ddit.nn.vo.music.Music_searchVO;
import kr.or.ddit.nn.vo.music.musicVO;
import kr.or.ddit.nn.vo.music.viewMusicVO;

public class musicServiceImpl extends UnicastRemoteObject implements musicService {
	musicDaoImpl musicDao; // 사용할 다오 멤버변수 선언
	private static musicServiceImpl service; // 싱글톤 패턴
	
	private musicServiceImpl() throws RemoteException{
		super();
		musicDao = musicDaoImpl.getInstance(); // 싱글톤 패턴
	}
	public static musicServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new musicServiceImpl();
		}
		return service;
	}
	@Override
	public int insertMusic(musicVO mv) throws RemoteException {
		return musicDao.insertMusic(mv);
	}

	@Override
	public int deleteMusic(int music_id) throws RemoteException {
		return musicDao.deleteMusic(music_id);
	}

	@Override
	public int updateMusic(musicVO mv) throws RemoteException {
		return musicDao.updateMusic(mv);
	}

	@Override
	public musicVO selectMusic(int music_id) throws RemoteException {
		return musicDao.selectMusic(music_id);
	}

	@Override
	public List<musicVO> selectAllMusic() throws RemoteException {
		return musicDao.selectAllMusic();
	}
	@Override
	public List<viewMusicVO> selectViewMusic() throws RemoteException {
		return musicDao.selectViewMusic();
	}
	@Override
	public List<viewMusicVO> selectMusicCount(List<Chart_ItemVO> chart_list) throws RemoteException {
		return musicDao.selectMusicCount(chart_list);
	}
	@Override
	public viewMusicVO selectMusicInfo(int music_id) throws RemoteException {
		return musicDao.selectMusicInfo(music_id);
	}
	@Override
	public List<viewMusicVO> serch(Music_searchVO msh) throws RemoteException {
		return musicDao.serch(msh);
	}
	@Override
	public List<viewMusicVO> selectMainChartMusic() throws RemoteException {
		return musicDao.selectMainChartMusic();
	}
	@Override
	public List<viewMusicVO> selectNewMusic() throws RemoteException {
		return musicDao.selectNewMusic();
	}
	@Override
	public int selectMusicForName(musicVO mv) throws RemoteException {
		return musicDao.selectMusicForName(mv);
	}


}
