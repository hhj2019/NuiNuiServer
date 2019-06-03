package kr.or.ddit.nn.service.grade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.grade.GradeDao;
import kr.or.ddit.nn.dao.grade.GradeDaoImpl;
import kr.or.ddit.nn.service.member.MyInfoService;
import kr.or.ddit.nn.service.member.MyInfoServiceImpl;
import kr.or.ddit.nn.vo.grade.GradeVO;

public class GradeServiceImpl extends UnicastRemoteObject implements GradeService {
	
	private static GradeService service;
	private GradeDao dao;

	protected GradeServiceImpl() throws RemoteException {
		super();
		dao = GradeDaoImpl.getInstance();
	}
	
	public static GradeService getInstance() throws RemoteException {
		if(service == null) {
			service = new GradeServiceImpl();
		}
		return service;
	}

	@Override
	public GradeVO selectGrade(int id) throws RemoteException {
		return dao.selectGrade(id);
	}

	@Override
	public List<GradeVO> viewAllGrade() throws RemoteException {
		return dao.viewAllGrade();
	}

}
