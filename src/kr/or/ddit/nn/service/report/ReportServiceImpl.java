package kr.or.ddit.nn.service.report;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.report.ReportDaoImpl;
import kr.or.ddit.nn.vo.report.ReportVO;

public class ReportServiceImpl extends UnicastRemoteObject implements ReportService {

	ReportDaoImpl reportDao;
	private static ReportServiceImpl service; 
	
	private ReportServiceImpl() throws RemoteException{
		super();
		reportDao = ReportDaoImpl.getInstance();
	}
	public static ReportServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new ReportServiceImpl();
		}
		return service;
	}
	
	/**
	 * 신고하기 목록 출력
	 */
	@Override
	public List<ReportVO> selectAllReport() throws RemoteException {
		return reportDao.selectAllReport();
	}

	/**
	 * 신고하기 상세 출력
	 */
	@Override
	public ReportVO selectReportdetail(int report_id) throws RemoteException {
		return reportDao.selectReportdetail(report_id);
	}

	/**
	 * 최근 신고하기 목록 출력
	 */
	@Override
	public List<ReportVO> selectNewReport() throws RemoteException {
		return reportDao.selectNewReport();
	}
	
	/**
	 * 신고하기 추가
	 */
	@Override
	public int insertReport(ReportVO rv) throws RemoteException {
		return reportDao.insertReport(rv);
	}
	
	/**
	 * 신고하기 관리자 수정
	 */
	@Override
	public int updateReport(ReportVO rv) throws RemoteException {
		return reportDao.updateReport(rv);
	}
	
	/**
	 * 자신이 작성한 신고 출력
	 */
	@Override
	public List<ReportVO> selectMyReport(String mem_id) throws RemoteException {
		return reportDao.selectMyReport(mem_id);
	}
}
