package kr.or.ddit.nn.dao.report;

import java.util.List;

import kr.or.ddit.nn.vo.report.ReportVO;

public interface ReportDao{
	
	/**
	 * 신고 전체 조회
	 * @return
	 */
	public List<ReportVO> selectAllReport();
	
	/**
	 * 신고 선택 조회
	 * @param report_id
	 * @return
	 */
	public ReportVO selectReportdetail(int report_id);
	
	/**
	 * 최근 신고 조회
	 * @return
	 */
	public List<ReportVO> selectNewReport();
	
	/**
	 * 신고하기 추가
	 * @param rv
	 * @return
	 */
	public int insertReport(ReportVO rv);
	
	/**
	 * 신고하기 관리자 수정
	 * @param rv
	 * @return
	 */
	public int updateReport(ReportVO rv);
	
	/**
	 * 자신이 작성한 신고 출력
	 * @param mem_id
	 * @return
	 */
	public List<ReportVO> selectMyReport(String mem_id);
}
