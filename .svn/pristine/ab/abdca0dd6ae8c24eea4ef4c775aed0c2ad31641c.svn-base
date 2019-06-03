package kr.or.ddit.nn.service.searchPass;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import kr.or.ddit.nn.dao.searchPass.SearchPassDao;
import kr.or.ddit.nn.dao.searchPass.SearchPassDaoImpl;
import kr.or.ddit.nn.vo.member.MemberVO;

public class SearchPassServiceImpl extends UnicastRemoteObject implements SearchPassService {

	private SearchPassDao searchPassDao;

	private static SearchPassService service;

	private SearchPassServiceImpl() throws RemoteException {
		searchPassDao = SearchPassDaoImpl.getInstance();
	}
	
	public static SearchPassService getInstance() throws RemoteException {
		if(service == null) {
			service = new SearchPassServiceImpl();
		}
		return service;
	}

	@Override
	public int searchPass(MemberVO mvo) throws RemoteException {
		return searchPassDao.searchPass(mvo);
	}


}
