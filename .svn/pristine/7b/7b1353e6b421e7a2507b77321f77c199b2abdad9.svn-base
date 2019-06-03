package kr.or.ddit.nn.service.notice;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.nn.dao.notice.NoticeDaoImpl;
import kr.or.ddit.nn.vo.notice.NoticeVO;
import kr.or.ddit.nn.vo.notice.Notice_OsearchVO;
import kr.or.ddit.nn.vo.notice.Notice_searchVO;

public class NoticeServiceImpl extends UnicastRemoteObject implements NoticeService {

	NoticeDaoImpl noticeDao;
	private static NoticeServiceImpl service; 
	
	private NoticeServiceImpl() throws RemoteException{
		super();
		noticeDao = NoticeDaoImpl.getInstance();
	}
	public static NoticeServiceImpl getInstance() throws RemoteException {
		if(service== null) {
			service = new NoticeServiceImpl();
		}
		return service;
	}
	
	/**
	 * 공지사항 목록 출력
	 */
	@Override
	public List<NoticeVO> selectAllNotice() throws RemoteException {
		return noticeDao.selectAllNotice();
	}

	/**
	 * 공지사항 상세 출력
	 */
	@Override
	public NoticeVO selectNoticedetail(int notice_id) throws RemoteException {
		return noticeDao.selectNoticedetail(notice_id);
	}

	/**
	 * 공지사항 추가
	 */
	@Override
	public int insertNotice(NoticeVO nv) throws RemoteException {
		return noticeDao.insertNotice(nv);
	}

	/**
	 * 최신 공지사항 출력
	 */
	@Override
	public List<NoticeVO> selectNewNotice() throws RemoteException {
		return noticeDao.selectNewNotice();
	}

	/**
	 * 공지사항 수정
	 */
	@Override
	public int updateNotice(NoticeVO nv) throws RemoteException {
		return noticeDao.updateNotice(nv);
	}

	/**
	 * 공지사항 삭제
	 */
	@Override
	public int deleteNotice(int notice_id) throws RemoteException {
		return noticeDao.deleteNotice(notice_id);
	}
	
	/**
	 * 공지사항 제목 + 내용 검색
	 */
	@Override
	public List<NoticeVO> allSearchNotice(Notice_searchVO nsv) throws RemoteException {
		return noticeDao.allSearchNotice(nsv);
	}
	
	/**
	 * 공지사항 제목 검색
	 */
	@Override
	public List<NoticeVO> titleSearchNotice(Notice_OsearchVO nosv) throws RemoteException {
		return noticeDao.titleSearchNotice(nosv);
	}
	
	/**
	 * 공지사항 내용 검색
	 */
	@Override
	public List<NoticeVO> contentSearchNotice(Notice_OsearchVO nosv) throws RemoteException {
		return noticeDao.contentSearchNotice(nosv);
	}
}
