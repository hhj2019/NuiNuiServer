package kr.or.ddit.nn.dao.answer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.qna.AnswerVO;
import kr.or.ddit.nn.vo.qna.QnAVO;
import kr.or.ddit.nn.vo.qna.QuestionVO;

public class AnswerDaoImpl implements AnswerDao {
	
	private SqlMapClient smc;
	
	public static AnswerDaoImpl dao;
	
	private AnswerDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static AnswerDaoImpl getInstance() {
		if(dao == null) {
			dao = new AnswerDaoImpl();
		}
		return dao;
	}

	/**
	 * 답변 상세 조회
	 */
	@Override
	public QnAVO selectAnswerdetail(int question_id) {

		QnAVO selectanswer = new QnAVO();
		
		try {
			selectanswer = (QnAVO)smc.queryForObject("selectAnswerdetail", question_id);
		}catch (SQLException e) {
			System.out.println("답변 상세 보기 오류");
			e.printStackTrace();
		}
		return selectanswer;
	}

	/**
	 * 답변 추가
	 */
	@Override
	public int insertAnswer(AnswerVO av) {
		int cnt = 0; 
		try {
			Object obj = smc.insert("insertAnswer", av);
				if(obj == null) {
					cnt = 1;
				}
		}catch (SQLException e) {
			System.out.println("답변 추가 오류");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 관리자 답변 전체 출력
	 */
	@Override
	public List<QnAVO> SelectMAnswerList(int question_id) {
		List<QnAVO> answerList = new ArrayList<>();
		
		try {
			answerList = smc.queryForList("SelectMAnswerList", question_id);
		}catch (SQLException e) {
			System.out.println("관리자 답변 전체 출력 오류");
			e.printStackTrace();
		}
		return answerList;
	}

	/**
	 * 자기 질문 전체 출력
	 */
	@Override
	public List<QnAVO> SelectMyAnswerList(QuestionVO qv) {
		List<QnAVO> answerList = new ArrayList<>();
		
		try {
			answerList = smc.queryForList("SelectMyAnswerList", qv);
		}catch (SQLException e) {
			System.out.println("자기 질문 전체 출력 오류");
			e.printStackTrace();
		}
		return answerList;
	}
	
	/**
	 * 답변 여부 확인
	 */
	@Override
	public int SelectAnswerOK(int question_id) {
		int cnt = 0;
		try {
			cnt = (int) smc.queryForObject("SelectAnswerOK", question_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 답변 삭제
	 */
	@Override
	public int deleteAnswer(int question_id) {
		int cnt = 0;
		try{
			cnt = smc.delete("deleteAnswer", question_id);
		}catch (SQLException e) {
			System.out.println("답변 삭제 오류");
			e.printStackTrace();
		}
		return cnt;
	}	
}
