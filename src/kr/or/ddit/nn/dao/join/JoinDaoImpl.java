package kr.or.ddit.nn.dao.join;

import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.member.MemberVO;

public class JoinDaoImpl implements JoinDao {

	private SqlMapClient smc;
	private static JoinDaoImpl dao;

	private JoinDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static JoinDaoImpl getInstance() {
		if (dao == null) {
			dao = new JoinDaoImpl();
		}
		return dao;
	}

	/**
	 * 아이디 중복체크
	 */
	@Override
	public List<MemberVO> selectId(MemberVO mv) {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			memberList = (List<MemberVO>) smc.queryForList("idSearch", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	/**
	 * 이메일로 중복체크
	 */
	@Override
	public List<MemberVO> selectEmail(MemberVO mv) {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			memberList = (List<MemberVO>) smc.queryForList("emailSearch", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public List<MemberVO> selectNick(MemberVO mv) {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			memberList = (List<MemberVO>) smc.queryForList("nickSearch", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	/**
	 * 카카오 로그인할 떄 사용자 이름 비교를 위해 사용예정
	 */
	@Override
	public List<MemberVO> selectName(MemberVO mv) {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try {
			memberList = (List<MemberVO>) smc.queryForList("nameSearch", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public int insertMember(MemberVO mv) {
		int cnt = 0;
		try {
			Object obj = smc.insert("insertMember", mv);
			if (obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;

		return cnt;
	}

	/**
	 * Level 조회
	 */
	@Override
	public int selectMemLevel(MemberVO mv) {
		int cnt = 0;
		
		try {
			cnt = (int)smc.queryForObject("selectMemLevel", mv);
		}catch (SQLException e) {
			System.out.println("레벨 조회 오류");
			e.printStackTrace();
		}
		return cnt;
	}



	// public static void main(String[] args) {
	// JoinDaoImpl dao = new JoinDaoImpl();
	// MemberVO member = new MemberVO();
	// ArrayList<MemberVO> list = new ArrayList<>();
	// member.setMem_id("testId");
	// list = (ArrayList<MemberVO>) dao.selectId(member);
	// System.out.println(list.size());
	// }

}
