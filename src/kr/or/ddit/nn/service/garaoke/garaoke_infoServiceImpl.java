package kr.or.ddit.nn.service.garaoke;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.garaoke.garaoke_infoDaoImpl;
import kr.or.ddit.nn.vo.garaoke.garaoke_infoVO;

public class garaoke_infoServiceImpl extends UnicastRemoteObject implements garaoke_infoService {
	garaoke_infoDaoImpl garaoke_infoDao; // 사용할 다오 멤버변수 선언
	private static garaoke_infoServiceImpl service; // 싱글톤 패턴
	
	private garaoke_infoServiceImpl() throws RemoteException{
		super();
		garaoke_infoDao = garaoke_infoDaoImpl.getInstance(); // 싱글톤 패턴
	}
	public static garaoke_infoServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new garaoke_infoServiceImpl();
		}
		return service;
	}
	@Override
	public int insertGaraoke_info(garaoke_infoVO giv) throws RemoteException {
		
		return garaoke_infoDao.insertGaraoke_info(giv);
	}

	@Override
	public int updateGaraoke_info(garaoke_infoVO giv) throws RemoteException {
		return garaoke_infoDao.updateGaraoke_info(giv);
	}

	@Override
	public int deleteGaraoke_info(garaoke_infoVO giv) throws RemoteException {
		return garaoke_infoDao.deleteGaraoke_info(giv);
	}

	@Override
	public garaoke_infoVO selectGaraoke_info(garaoke_infoVO giv) throws RemoteException {
		return garaoke_infoDao.selectGaraoke_info(giv);
	}

	@Override
	public List<garaoke_infoVO> selectAllGaraoke_info() throws RemoteException {
		return garaoke_infoDao.selectAllGaraoke_info();
	}

}
