package kr.or.ddit.nn.dao.notice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.nn.util.SqlMapClientFactory;
import kr.or.ddit.nn.vo.notice.NoticeVO;
import kr.or.ddit.nn.vo.notice.Notice_OsearchVO;
import kr.or.ddit.nn.vo.notice.Notice_searchVO;

public class NoticeDaoImpl implements NoticeDao {

	private SqlMapClient smc;
	
	public static NoticeDaoImpl dao;
	
	private NoticeDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
		
	public static NoticeDaoImpl getInstance() {
		if(dao == null) {
			dao = new NoticeDaoImpl();
		}
		return dao;
	}
	
	/**
	 * 공지사항 전체 조회
	 */
	@Override
	public List<NoticeVO> selectAllNotice() {

		List<NoticeVO> noticeList = new ArrayList<>();
		
		try {
			noticeList = smc.queryForList("selectAllNotice");
		}catch (SQLException e) {
			System.out.println("공지사항 전체 조회 오류");
			e.printStackTrace();
		}
		return noticeList;
	}

	/**
	 * 공지사항 상세 조회
	 */
	@Override
	public NoticeVO selectNoticedetail(int notice_id) {
		
		NoticeVO selectNotice = new NoticeVO();
		
		try {
			selectNotice = (NoticeVO) smc.queryForObject("selectNoticedetail", notice_id);
		}catch (SQLException e) {
			System.out.println("공지사항 상세 조회 오류");
			e.printStackTrace();
		}
		return selectNotice;
	}
	
	/**
	 * 최근 공지사항 출력
	 */
	@Override
	public List<NoticeVO> selectNewNotice() {
		List<NoticeVO> noticeList = new ArrayList<>();
		
		try {
			noticeList = smc.queryForList("selectNewNotice");
		}catch (SQLException e) {
			System.out.println("공지사항 전체 조회 오류");
			e.printStackTrace();
		}
		return noticeList;
	}

	/**
	 * 공지사항 추가
	 */
	@Override
	public int insertNotice(NoticeVO nv) {
		int cnt = 0;
		try {
			Object obj = smc.insert("insertNotice", nv);
				if(obj == null) {
					cnt = 1;
				}
		}catch (SQLException e) {
			System.out.println("공지사항 추가 오류");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 공지사항 수정
	 */
	@Override
	public int updateNotice(NoticeVO nv) {
		int cnt = 0; 
		try {
			cnt = smc.update("updateNotice", nv);
		}catch (SQLException e) {
			System.out.println("공지사항 수정 오류");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 공지사항 삭제
	 */
	@Override
	public int deleteNotice(int notice_id) {
		int cnt = 0;
		try {
			cnt = smc.delete("deleteNotice", notice_id);
		}catch (SQLException e) {
			System.out.println("공지사항 삭제 오류");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * 공지사항 제목+내용 검색
	 */
	@Override
	public List<NoticeVO> allSearchNotice(Notice_searchVO nsv) {
		List<NoticeVO> noticeList = new ArrayList<>();
		try {
			noticeList = smc.queryForList("allSearchNotice", nsv);
		}catch (SQLException e) {
			System.out.println("공지사항 제목+내용 검색 오류");
			e.printStackTrace();
		}
		return noticeList;
	}

	/**
	 * 공지사항 제목 검색
	 */
	@Override
	public List<NoticeVO> titleSearchNotice(Notice_OsearchVO nosv) {
		List<NoticeVO> noticeList = new ArrayList<>();
		try {
			noticeList = smc.queryForList("titleSearchNotice", nosv);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return noticeList;
	}

	/**
	 * 공지사항 내용 검색
	 */
	@Override
	public List<NoticeVO> contentSearchNotice(Notice_OsearchVO nosv) {
		List<NoticeVO> noticeList = new ArrayList<>();
		try {
			noticeList = smc.queryForList("contentSearchNotice", nosv);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return noticeList;
	}
}
