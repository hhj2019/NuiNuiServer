
package kr.or.ddit.nn.service.answer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.answer.AnswerDaoImpl;
import kr.or.ddit.nn.vo.qna.AnswerVO;
import kr.or.ddit.nn.vo.qna.QnAVO;
import kr.or.ddit.nn.vo.qna.QuestionVO;

public class AnswerServiceImpl extends UnicastRemoteObject implements AnswerService {

	AnswerDaoImpl answerDao;
	private static AnswerServiceImpl service;
	
	private AnswerServiceImpl() throws RemoteException{
		super();
		answerDao = AnswerDaoImpl.getInstance();
	}
	public static AnswerServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new AnswerServiceImpl();
		}
		return service;
	}
	
	/**
	 * 답변 상세 출력 메서드
	 */
	@Override
	public QnAVO selectAnswerdetail(int question_id) throws RemoteException {
		return answerDao.selectAnswerdetail(question_id);
	}
	
	/**
	 * 답변 추가메서드
	 */
	@Override
	public int insertAnswer(AnswerVO av) throws RemoteException {
		return answerDao.insertAnswer(av);
	}
	
	/**
	 * 관리자 답변 전체 출력
	 */
	@Override
	public List<QnAVO> SelectMAnswerList(int question_id) throws RemoteException {
		return answerDao.SelectMAnswerList(question_id);
	}
	
	/**
	 * 자기질문 목록 전체 출력
	 */
	@Override
	public List<QnAVO> SelectMyAnswerList(QuestionVO qv) throws RemoteException {
		return answerDao.SelectMyAnswerList(qv);
	}
	
	/**
	 * 답변 여부 확인
	 */
	@Override
	public int SelectAnswerOK(int question_id) throws RemoteException {
		return answerDao.SelectAnswerOK(question_id);
	}
	
	/**
	 * 답변 삭제
	 */
	@Override
	public int deleteAnswer(int question_id) throws RemoteException {
		return answerDao.deleteAnswer(question_id);
	}
}
