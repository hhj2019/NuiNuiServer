package kr.or.ddit.nn.service.artist;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.artist.artistDaoImpl;
import kr.or.ddit.nn.vo.artist.artistVO;

public class artistServiceImpl extends UnicastRemoteObject implements artistService{
	artistDaoImpl artistDao; // 사용할 다오 멤버변수 선언
	private static artistServiceImpl service; // 싱글톤 패턴
	
	private artistServiceImpl() throws RemoteException{
		super();
		artistDao = artistDaoImpl.getInstance(); // 싱글톤 패턴
	}
	public static artistServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new artistServiceImpl();
		}
		return service;
	}
	@Override
	public int insertArtist(artistVO av) throws RemoteException {
		return artistDao.insertArtist(av);
	}

	@Override
	public int updateArtist(artistVO av) throws RemoteException {
		return artistDao.updateArtist(av);
	}

	@Override
	public int deleteArtist(artistVO av) throws RemoteException {
		return artistDao.deleteArtist(av);
	}

	@Override
	public List<artistVO> selectAllArtist() throws RemoteException {
		return artistDao.selectAllArtist();
	}

	@Override
	public artistVO selectArtist(artistVO av) throws RemoteException {
		return artistDao.selectArtist(av);
	}
	@Override
	public artistVO selectArtistForName(String artist_name) throws RemoteException {
		return artistDao.selectArtistForName(artist_name);
	}

}
