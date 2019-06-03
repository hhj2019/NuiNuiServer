package kr.or.ddit.nn.dao.question;

import java.util.List;

import kr.or.ddit.nn.vo.qna.QnAVO;
import kr.or.ddit.nn.vo.qna.QuestionVO;

public interface QuestionDao{

	/**
	 * 관리자 질문 전체 출력
	 * @return
	 */
	public List<QnAVO> SelectMQuestionList();
	
	/**
	 * 관리자 질문 상세 출력
	 * @param question_id
	 * @return
	 */
	public QuestionVO selectQuestiondetail(int question_id);
	
	/**
	 * 자기 질문 출력
	 * @param mem_id
	 * @return
	 */
	public List<QnAVO> SelectMyQuestionList(String mem_id);
	
	/**
	 * 질문 추가
	 * @param qv
	 * @return
	 */
	public int insertQuestion(QuestionVO qv);
	
	/**
	 * 질문 삭제
	 * @param qv
	 * @return
	 */
	public int deleteQuestion(QuestionVO qvv);
}
