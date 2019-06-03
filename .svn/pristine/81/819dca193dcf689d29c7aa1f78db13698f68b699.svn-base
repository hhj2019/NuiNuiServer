package kr.or.ddit.nn.dao.notice;

import java.util.List;

import kr.or.ddit.nn.vo.notice.NoticeVO;
import kr.or.ddit.nn.vo.notice.Notice_OsearchVO;
import kr.or.ddit.nn.vo.notice.Notice_searchVO;

public interface NoticeDao{

	/**
	 * 공지사항 전체 조회
	 * @return
	 */
	public List<NoticeVO> selectAllNotice();
	
	/**
	 * 공지사항 선택 조회
	 * @param notice_id
	 * @return
	 */
	public NoticeVO selectNoticedetail(int notice_id);
	
	/**
	 * 최신 공지사항 조회
	 * @return
	 */
	public List<NoticeVO> selectNewNotice();
	/**
	 * 공지사항 추가
	 * @param nv
	 * @return
	 */
	public int insertNotice(NoticeVO nv);
	
	/**
	 * 공지사항 수정
	 * @param nv
	 * @return
	 */
	public int updateNotice(NoticeVO nv);
	
	/**
	 * 공지사항 삭제
	 * @param notice_id
	 * @return
	 */
	public int deleteNotice(int notice_id);
	
	/**
	 * 제목 + 내용 검색
	 * @param search_text
	 * @return
	 */
	public List<NoticeVO> allSearchNotice(Notice_searchVO nsv);
	
	/**
	 * 제목 검색
	 * @param nosv
	 * @return
	 */
	public List<NoticeVO> titleSearchNotice(Notice_OsearchVO nosv);
	
	/**
	 * 내용 검색
	 * @param nosv
	 * @return
	 */
	public List<NoticeVO> contentSearchNotice(Notice_OsearchVO nosv);
}
