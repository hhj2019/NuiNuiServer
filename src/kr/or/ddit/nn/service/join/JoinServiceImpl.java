package kr.or.ddit.nn.service.join;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.join.JoinDao;
import kr.or.ddit.nn.dao.join.JoinDaoImpl;
import kr.or.ddit.nn.vo.member.MemberVO;

public class JoinServiceImpl extends UnicastRemoteObject implements JoinService {

	private JoinDao joinDao;

	private static JoinService service;

	private JoinServiceImpl() throws RemoteException {
		joinDao = JoinDaoImpl.getInstance();
	}

	public static JoinService getInstance() throws RemoteException {
		if (service == null) {
			service = new JoinServiceImpl();
		}
		return service;
	}

	@Override
	public List<MemberVO> selectId(MemberVO mv) throws RemoteException {
		return joinDao.selectId(mv);
	}

	@Override
	public int insertMember(MemberVO mv) throws RemoteException {
		return joinDao.insertMember(mv);
	}

	@Override
	public int deleteMember(String memId) throws RemoteException {
		return joinDao.deleteMember(memId);
	}

	@Override
	public List<MemberVO> selectEmail(MemberVO mv) throws RemoteException {
		return joinDao.selectEmail(mv);
	}

	@Override
	public List<MemberVO> selectNick(MemberVO mv) throws RemoteException {
		return joinDao.selectNick(mv);
	}

	@Override
	public List<MemberVO> selectName(MemberVO mv) throws RemoteException {
		return joinDao.selectName(mv);
	}

	/**
	 * Level 조회
	 */
	@Override
	public int selectMemLevel(MemberVO mv) throws RemoteException {
		return joinDao.selectMemLevel(mv);
	}

}
