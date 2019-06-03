package kr.or.ddit.nn.dao.question;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.qna.QnAVO;
import kr.or.ddit.nn.vo.qna.QuestionVO;

public class QuestionDaoImpl implements QuestionDao {

	private SqlMapClient smc;
	
	public static QuestionDaoImpl dao;
	
	private QuestionDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static QuestionDaoImpl getInstance() {
		if(dao == null) {
			dao = new QuestionDaoImpl();
		}
		return dao;
	}
	
	/**
	 * 관리자 질문 전체 출력
	 */
	@Override
	public List<QnAVO> SelectMQuestionList() {
		
		List<QnAVO> MquestionList = new ArrayList<>();
		
		try {
			MquestionList = smc.queryForList("SelectMQuestionList");
		}catch (SQLException e) {
			System.out.println("관리자 질문 전체 출력 오류");
			e.printStackTrace();
		}
		return MquestionList;
	}

	/**
	 * 관리자 질문 상세 출력
	 */
	@Override
	public QuestionVO selectQuestiondetail(int question_id) {

		QuestionVO selectQuestion = new QuestionVO();
		
		try {
			selectQuestion = (QuestionVO) smc.queryForObject("selectQuestiondetail", question_id);
		}catch (SQLException e) {
			System.out.println("관리자 질문 상세 출력 오류");
			e.printStackTrace();
		}
		return selectQuestion;
	}

	/**
	 * 자기 질문 전체 출력
	 */
	@Override
	public List<QnAVO> SelectMyQuestionList(String mem_id) {
		
		List<QnAVO> questionList = new ArrayList<>();
		
		try {
			questionList = smc.queryForList("SelectMyQuestionList", mem_id);
		}catch (SQLException e) {
			System.out.println("회원 질문 전체 출력 오류");
			e.printStackTrace();
		}
		return questionList;
	}

	/**
	 * 질문 추가
	 */
	@Override
	public int insertQuestion(QuestionVO qv) {
		int cnt = 0;
		try {
			Object obj = smc.insert("insertQuestion", qv);
				if(obj == null) {
					cnt = 1;
				}
		}catch (SQLException e) {
			System.out.println("질문 추가 오류");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 질문 삭제
	 */
	@Override
	public int deleteQuestion(QuestionVO qvv) {
		int cnt = 0;
		try {
			cnt = smc.delete("deleteQuestion", qvv);
		}catch (SQLException e) {
			System.out.println("질문 삭제 오류");
			e.printStackTrace();
		}
		return cnt;
	}
}
