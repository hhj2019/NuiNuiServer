package kr.or.ddit.nn.service.garaoke;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import kr.or.ddit.nn.dao.garaoke.garaokeDaoImpl;
import kr.or.ddit.nn.vo.garaoke.GaraokeVO;

public class garaokeServiceImpl extends UnicastRemoteObject implements garaokeService {
	garaokeDaoImpl garaokeDao; // 사용할 다오 멤버변수 선언
	private static garaokeServiceImpl service; // 싱글톤 패턴
	
	private garaokeServiceImpl() throws RemoteException{
		super();
		garaokeDao = garaokeDaoImpl.getInstance(); // 싱글톤 패턴
	}
	public static garaokeServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new garaokeServiceImpl();
		}
		return service;
	}
	@Override
	public int insertGaraoke(GaraokeVO gv) throws RemoteException {
		return garaokeDao.insertGaraoke(gv);
	}

	@Override
	public int updateGaraoke(GaraokeVO gv) throws RemoteException {
		
		return garaokeDao.updateGaraoke(gv);
	}

	@Override
	public int deleteGaraoke(GaraokeVO gv) throws RemoteException {
		
		return garaokeDao.updateGaraoke(gv);
	}

	@Override
	public GaraokeVO selectGaraoke(int music_id) throws RemoteException {
		
		return garaokeDao.selectGaraoke(music_id);
	}

}
