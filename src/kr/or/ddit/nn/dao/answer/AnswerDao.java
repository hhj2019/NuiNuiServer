package kr.or.ddit.nn.dao.answer;


import java.util.List;

import kr.or.ddit.nn.vo.qna.AnswerVO;
import kr.or.ddit.nn.vo.qna.QnAVO;
import kr.or.ddit.nn.vo.qna.QuestionVO;

public interface AnswerDao{

	/**
	 * 답변 상세 조회
	 * @param av
	 * @return
	 */
	public QnAVO selectAnswerdetail(int question_id);
	
	/**
	 * 답변 추가
	 * @param av
	 * @return
	 */
	public int insertAnswer(AnswerVO av);
	
	/**
	 * 관리자 답변 전체 출력
	 * @param question_id
	 * @return
	 */
	public List<QnAVO> SelectMAnswerList(int question_id);
	
	/**
	 * 자기 질문 전체 출력
	 * @param qav
	 * @return
	 */
	public List<QnAVO> SelectMyAnswerList(QuestionVO qv);
	
	/**
	 * 답변 여부 확인
	 * @param question
	 * @return
	 */
	public int SelectAnswerOK(int question_id);
	
	/**
	 * 답변 삭제
	 * @param question_id
	 * @return
	 */
	public int deleteAnswer(int question_id);
}
