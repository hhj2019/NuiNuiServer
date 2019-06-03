package kr.or.ddit.nn.dao.report;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.report.ReportVO;

public class ReportDaoImpl implements ReportDao {

	private SqlMapClient smc;
	
	public static ReportDaoImpl dao;
	
	private ReportDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ReportDaoImpl getInstance() {
		if(dao == null) {
			dao = new ReportDaoImpl();
		}
		return dao;
	}
	
	/**
	 * 신고하기 전체 출력
	 */
	@Override
	public List<ReportVO> selectAllReport() {
		
		List<ReportVO> reportList = new ArrayList<>();
		
		try {
			reportList = smc.queryForList("selectAllReport");
		}catch (SQLException e) {
			System.out.println("신고하기 전체 출력 오류");
			e.printStackTrace();
		}
		return reportList;
	}

	/**
	 * 신고하기 상세 출력
	 */
	@Override
	public ReportVO selectReportdetail(int report_id) {
		
		ReportVO selectReport = new ReportVO();
		
		try {
			selectReport = (ReportVO) smc.queryForObject("selectReportdetail", report_id);
		}catch (SQLException e) {
			System.out.println("신고하기 상세 출력 오류");
			e.printStackTrace();
		}
		return selectReport;
	}

	/**
	 * 신고하기 추가
	 */
	@Override
	public int insertReport(ReportVO rv) {
		int cnt = 0;
		try {
			Object obj = smc.insert("insertReport", rv);
				if(obj == null) {
					cnt = 1;
				}
		}catch (SQLException e) {
			System.out.println("신고하기 수정 오류");
			e.printStackTrace();
		}
		return cnt;
	}
	
	/**
	 * 최신 신고하기 출력
	 */
	@Override
	public List<ReportVO> selectNewReport() {
		List<ReportVO> reportList = new ArrayList<>();
		
		try {
			reportList = smc.queryForList("selectNewReport");
		}catch (SQLException e) {
			System.out.println("최근 신고하기 출력 오류");
			e.printStackTrace();
		}
		return reportList;
	}

	@Override
	public int updateReport(ReportVO rv) {
		int cnt = 0;
		try {
			cnt = smc.update("updateReport", rv);
		}catch (SQLException e) {
			System.out.println("신고하기 관리자 수정 오류");
		}
		return cnt;
	}

	@Override
	public List<ReportVO> selectMyReport(String mem_id) {
		List<ReportVO> reportList = new ArrayList<>();
		try {
			reportList = smc.queryForList("selectMyReport", mem_id);
		}catch (SQLException e) {
			System.out.println("자신이 작성한 신고출력 오류");
			e.printStackTrace();
		}
		return reportList;
	}
}
