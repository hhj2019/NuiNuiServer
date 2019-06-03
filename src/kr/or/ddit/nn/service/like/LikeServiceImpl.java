package kr.or.ddit.nn.service.like;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.like.LikeDaoImpl;
import kr.or.ddit.nn.vo.like.LikeVO;

public class LikeServiceImpl extends UnicastRemoteObject implements LikeService {

	static LikeDaoImpl likeDao;
	private static LikeServiceImpl service;

	private LikeServiceImpl() throws RemoteException {
		super();
		likeDao = LikeDaoImpl.getInstance();
	}

	public static LikeServiceImpl getInstance() throws RemoteException {
		if (service == null) {
			service = new LikeServiceImpl();
		}
		return service;
	}

	@Override
	public List<LikeVO> selectLike(String mem_id) throws RemoteException {
		return likeDao.selectLike(mem_id);
	}

	@Override
	public int insertLike(LikeVO lvo) throws RemoteException {
		return likeDao.insertLike(lvo);
	}

	@Override
	public int deleteLike(int music_id) throws RemoteException {
		return likeDao.deleteLike(music_id);
	}



}
