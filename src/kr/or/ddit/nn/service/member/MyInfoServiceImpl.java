package kr.or.ddit.nn.service.member;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import kr.or.ddit.nn.dao.myInfo.MyInfoDao;
import kr.or.ddit.nn.dao.myInfo.MyInfoDaoImpl;
import kr.or.ddit.nn.vo.member.MemberVO;

public class MyInfoServiceImpl extends UnicastRemoteObject implements MyInfoService {
	
	private static MyInfoService service;
	private MyInfoDao myInfoDao;

	private MyInfoServiceImpl() throws RemoteException {
		super();
		myInfoDao = MyInfoDaoImpl.getInstance();
	}
	
	public static MyInfoService getInstance() throws RemoteException {
		if(service == null) {
			service = new MyInfoServiceImpl();
		}
		return service;
	}

	@Override
	public MemberVO viewMyInfo(String memId) throws RemoteException {
		return myInfoDao.viewMyInfo(memId);
	}

	@Override
	public int updateMyInfo(MemberVO member) throws RemoteException {
		return myInfoDao.updateMyInfo(member);
	}

	@Override
	public int updateGrade(String member) throws RemoteException {
		return myInfoDao.updateGrade(member);
	}

}
