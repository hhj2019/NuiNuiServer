package kr.or.ddit.nn.service.question;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.question.QuestionDaoImpl;
import kr.or.ddit.nn.vo.qna.QnAVO;
import kr.or.ddit.nn.vo.qna.QuestionVO;

public class QuestionServiceImpl extends UnicastRemoteObject implements QuestionService {

	QuestionDaoImpl questionDao;
	private static QuestionServiceImpl service; 
	
	private QuestionServiceImpl() throws RemoteException{
		super();
		questionDao = QuestionDaoImpl.getInstance();
	}
	public static QuestionServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new QuestionServiceImpl();
		}
		return service;
	}
	
	/**
	 * 관리자 질문 목록 출력
	 */
	@Override
	public List<QnAVO> SelectMQuestionList() throws RemoteException {
		return questionDao.SelectMQuestionList();
	}

	/**
	 * 관리자 질문 상세 출력
	 */
	@Override
	public QuestionVO selectQuestiondetail(int question_id) throws RemoteException {
		return questionDao.selectQuestiondetail(question_id);
	}

	/**
	 * 자기 질문 목록 출력
	 */
	@Override
	public List<QnAVO> SelectMyQuestionList(String mem_id) throws RemoteException {
		return questionDao.SelectMyQuestionList(mem_id);
	}

	/**
	 * 질문 추가
	 */
	@Override
	public int insertQuestion(QuestionVO qv) throws RemoteException {
		return questionDao.insertQuestion(qv);
	}
	
	/**
	 * 질문 삭제
	 */
	@Override
	public int deleteQuestion(QuestionVO qvv) throws RemoteException {
		return questionDao.deleteQuestion(qvv);
	}
}
