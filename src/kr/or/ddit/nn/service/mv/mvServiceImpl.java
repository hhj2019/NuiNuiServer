package kr.or.ddit.nn.service.mv;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.mv.mvDaoImpl;
import kr.or.ddit.nn.vo.mv.MVVO;

public class mvServiceImpl extends UnicastRemoteObject implements mvService {
	mvDaoImpl mvDao; // 사용할 다오 멤버변수 선언
	private static mvServiceImpl service; // 싱글톤 패턴
	
	private mvServiceImpl() throws RemoteException{
		super();
		mvDao = mvDaoImpl.getInstance(); // 싱글톤 패턴
	}
	public static mvServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new mvServiceImpl();
		}
		return service;
	}
	@Override
	public int insertMV(MVVO mvv) throws RemoteException {
		return mvDao.insertMV(mvv);
	}

	@Override
	public int updateMV(MVVO mvv) throws RemoteException {
		return mvDao.updateMV(mvv);
	}
	
	@Override
	public int deleteMV(MVVO mvv) throws RemoteException {
		return mvDao.deleteMV(mvv);
	}

	@Override
	public List<MVVO> selectAllMV() throws RemoteException {
		return mvDao.selectAllMV();
	}

	@Override
	public MVVO selectMV(MVVO mvv) throws RemoteException {
		return mvDao.selectMV(mvv);
	}

}
