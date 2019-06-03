package kr.or.ddit.nn.dao.ticket;

import java.util.List;

import kr.or.ddit.nn.vo.ticket.MyTicketVO;

public interface MyTicketDao {
	
	/**
	 * 현재 적용중인 티켓을 등록한다.
	 * @param ticket
	 * @return
	 */
	public int insertMyTicket(MyTicketVO ticket);
	
	/**
	 * 현재 적용중인 이용권의 다운로드 가능 갯수를 차감한다.
	 * @param ticket
	 * @return
	 */
	public int updateDownCount(MyTicketVO ticket);
	
	/**
	 * 현재 적용중인 이용권의 기간이 만료되거나 다운로드 가능 갯수가 0이 되면 테이블에서 제거한다.
	 * @param id
	 * @return
	 */
	public int deleteMyTicket(int ticketId);
	
	/**
	 * 현재 적용중인 모든 이용권을 조회한다.
	 * @param id
	 * @return
	 */
	public List<MyTicketVO> viewMyTicket(String memId);
	
	/**
	 * 다운로드 갯수가 남아있는 이용권을 조회한다.
	 * @param id
	 * @return
	 */
	public List<MyTicketVO> viewUsableTicket(String memId);
	

}
