package kr.or.ddit.nn.service.faq;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.faq.FAQDaoImpl;
import kr.or.ddit.nn.vo.faq.FAQVO;
import kr.or.ddit.nn.vo.faq.FAQ_OSearchVO;
import kr.or.ddit.nn.vo.faq.FAQ_OSearchVO2;
import kr.or.ddit.nn.vo.faq.FAQ_SearchVO;

public class FAQServiceImpl extends UnicastRemoteObject implements FAQService {

	FAQDaoImpl FaqDao;
	private static FAQServiceImpl service; 
	
	private FAQServiceImpl() throws RemoteException{
		super();
		FaqDao = FAQDaoImpl.getInstance();
	}
	public static FAQServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new FAQServiceImpl();
		}
		return service;
	}
	
	/**
	 * 자주묻는질문 목록 출력
	 */
	@Override
	public List<FAQVO> selectAllFAQ() throws RemoteException {
		return FaqDao.selectAllFAQ();
	}

	/**
	 * 자주묻는질문 상세 출력
	 */
	@Override
	public FAQVO selectFAQdetail(int FAQ_id) throws RemoteException {
		return FaqDao.selectFAQdetail(FAQ_id);
	}
	
	/**
	 * 최근 자주 묻는 질문 조회
	 */
	@Override
	public List<FAQVO> selectNewFAQ() throws RemoteException {
		return FaqDao.selectNewFAQ();
	}
	
	/**
	 * 자주묻는질문 추가
	 */
	@Override
	public int insertFAQ(FAQVO fv) throws RemoteException {
		return FaqDao.insertFAQ(fv);
	}

	/**
	 * 자주묻는질문 수정
	 */
	@Override
	public int updateFAQ(FAQVO fv) throws RemoteException {
		return FaqDao.updateFAQ(fv);
	}

	/**
	 * 자주묻는질문 삭제
	 */
	@Override
	public int deleteFAQ(int FAQ_id) throws RemoteException {
		return FaqDao.deleteFAQ(FAQ_id);
	}
	
	/**
	 * 자주묻는질문 제목 + 내용 검색
	 */
	@Override
	public List<FAQVO> allSearchFaq(FAQ_SearchVO fsv) throws RemoteException {
		return FaqDao.allSearchFaq(fsv);
	}
	
	/**
	 * 자주묻는질문 제목 검색
	 */
	@Override
	public List<FAQVO> titleSearchFaq(FAQ_OSearchVO fosv) throws RemoteException {
		return FaqDao.titleSearchFaq(fosv);
	}
	
	/**
	 * 자주묻는질문 내용 검색
	 */
	@Override
	public List<FAQVO> contentSearchFaq(FAQ_OSearchVO2 fosv2) throws RemoteException {
		return FaqDao.contentSearchFaq(fosv2);
	}
}
