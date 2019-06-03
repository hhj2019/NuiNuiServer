package kr.or.ddit.nn.dao.faq;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.faq.FAQVO;
import kr.or.ddit.nn.vo.faq.FAQ_OSearchVO;
import kr.or.ddit.nn.vo.faq.FAQ_OSearchVO2;
import kr.or.ddit.nn.vo.faq.FAQ_SearchVO;

public class FAQDaoImpl implements FAQDao {

	private SqlMapClient smc;
	
	public static FAQDaoImpl dao;
	
	private FAQDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static FAQDaoImpl getInstance() {
		if(dao == null) {
			dao = new FAQDaoImpl();
		}
		return dao;
	}
	
	/**
	 * 자주 묻는 질문 전체 조회
	 */
	@Override
	public List<FAQVO> selectAllFAQ() {
		
		List<FAQVO> faqList = new ArrayList<>();
		
		try {
			faqList = smc.queryForList("selectAllFAQ");
		}catch (SQLException e) {
			System.out.println("자주 묻는 질문 전체 조회 오류");
			e.printStackTrace();
		}
		return faqList;
	}

	/**
	 * 자주 묻는 질문 상세 조회
	 */
	@Override
	public FAQVO selectFAQdetail(int FAQ_id) {
		
		FAQVO selectFaq = new FAQVO();
		
		try {
			selectFaq = (FAQVO)smc.queryForObject("selectFAQdetail", FAQ_id);
		}catch (SQLException e) {
			System.out.println("자주 묻는 질문 상세 조회 오류");
			e.printStackTrace();
		}
		return selectFaq;
	}
	
	/**
	 * 최근 자주 묻는 질문 조회
	 */
	@Override
	public List<FAQVO> selectNewFAQ() {
		List<FAQVO> faqList = new ArrayList<>();
		
		try {
			faqList = smc.queryForList("selectNewFAQ");
		}catch (SQLException e) {
			System.out.println("최근 자주 묻는 질문 조회 오류");
			e.printStackTrace();
		}
		return faqList;
	}
	
	/**
	 * 자주 묻는 질문 추가
	 */
	@Override
	public int insertFAQ(FAQVO fv) {
		int cnt = 0;
		try {
			Object obj = smc.insert("insertFAQ", fv);
				if(obj == null) {
					cnt = 1;
				}
		}catch (SQLException e) {
			System.out.println("자주 묻는 질문 추가 오류");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 자주 묻는 질문 수정
	 */
	@Override
	public int updateFAQ(FAQVO fv) {
		int cnt = 0;
		try {
			cnt = smc.update("updateFAQ", fv);
		}catch (SQLException e) {
			System.out.println("자주 묻는 질문 수정 오류");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 자주 묻는 질문 삭제
	 */
	@Override
	public int deleteFAQ(int FAQ_id) {
		int cnt = 0;
		try {
			cnt = smc.delete("deleteFAQ", FAQ_id);
		}catch (SQLException e) {
			System.out.println("자주 묻는 질문 삭제 오류");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 자주묻는질문 제목 + 내용 검색
	 */
	@Override
	public List<FAQVO> allSearchFaq(FAQ_SearchVO fsv) {
		List<FAQVO> faqList = new ArrayList<>();
		try {
			faqList = smc.queryForList("allSearchFaq", fsv);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return faqList;
	}

	/**
	 * 자주묻는질문 제목 검색
	 */
	@Override
	public List<FAQVO> titleSearchFaq(FAQ_OSearchVO fosv) {
		List<FAQVO> faqList = new ArrayList<>();
		try {
			faqList = smc.queryForList("titleSearchFaq", fosv);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return faqList;
	}

	/**
	 * 자주묻는질문 내용 검색
	 */
	@Override
	public List<FAQVO> contentSearchFaq(FAQ_OSearchVO2 fosv2) {
		List<FAQVO> faqList = new ArrayList<>();
		try {
			faqList = smc.queryForList("contentSearchFaq", fosv2);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return faqList;
	}
}
