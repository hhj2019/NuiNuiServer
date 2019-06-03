package kr.or.ddit.nn.service.album;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.album.albumDaoImpl;
import kr.or.ddit.nn.vo.album.albumVO;
import kr.or.ddit.nn.vo.music.viewMusicVO;

public class albumServiceImpl extends UnicastRemoteObject implements albumService {
	
	albumDaoImpl albumDao; // 사용할 다오 멤버변수 선언
	private static albumServiceImpl service; // 싱글톤 패턴
	
	private albumServiceImpl() throws RemoteException{
		super();
		albumDao = albumDaoImpl.getInstance(); // 싱글톤 패턴
	}
	public static albumServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new albumServiceImpl();
		}
		return service;
	}
	/**
	 * 앨범 추가 메서드
	 */
	@Override
	public int insertAlbum(albumVO av) throws RemoteException {
		return albumDao.insertAlbum(av);
	}
	/**
	 * 앨범 삭제 메서드
	 */
	@Override
	public int deleteAlbum(albumVO av) throws RemoteException {
		return albumDao.deleteAlbum(av);
	}
	/**
	 * 앨범 수정 메서드
	 */
	@Override
	public int updateAlbum(albumVO av) throws RemoteException {
		return albumDao.updateAlbum(av);
	}
	/**
	 * 앨범 출력 메서드
	 */
	@Override
	public albumVO selectAlbum(albumVO av) throws RemoteException {
		return albumDao.selectAlbum(av);
	}
	/**
	 * 앨범 전체 출력 메서드
	 */
	@Override
	public List<albumVO> selectAllAlbum() throws RemoteException {
		return albumDao.selectAllAlbum();
	}
	/**
	 * 최근 앨범 출력
	 */
	@Override
	public List<albumVO> selectNewAlbum() throws RemoteException {
		return albumDao.selectNewAlbum();
	}
	@Override
	public List<viewMusicVO> selectNewAlbumDetail(int album_id) throws RemoteException{
		return albumDao.selectNewAlbumDetail(album_id);
	}

}
