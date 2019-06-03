package kr.or.ddit.nn.dao.grade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.grade.GradeVO;

public class GradeDaoImpl implements GradeDao {
	
	private SqlMapClient smc;
	private static GradeDao dao;
	
	private GradeDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static GradeDao getInstance() {
		if(dao == null) {
			dao = new GradeDaoImpl();
		}
		return dao;
	}

	@Override
	public GradeVO selectGrade(int id) {
		GradeVO grade = null;
		try {
			grade = (GradeVO) smc.queryForObject("myInfo.viewGrade", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grade;
		
	}

	@Override
	public List<GradeVO> viewAllGrade() {
		List<GradeVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("myInfo.viewAllGrade");
		} catch (SQLException e) {
			System.out.println("error! myTicket.viewGrade");
			e.printStackTrace();
		}
		return list;
	}

}
