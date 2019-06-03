package kr.or.ddit.nn.dao.grade;

import java.util.List;

import kr.or.ddit.nn.vo.grade.GradeVO;

public interface GradeDao {
	/**
	 * 특정 등급에 대한 정보 반환
	 * @param id
	 * @return
	 */
	public GradeVO selectGrade(int id);
	
	/**
	 * 전체 등급에 대한 정보 반환
	 * @return
	 */
	public List<GradeVO> viewAllGrade();
}
