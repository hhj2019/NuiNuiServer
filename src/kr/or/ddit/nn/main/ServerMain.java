package kr.or.ddit.nn.main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import kr.or.ddit.nn.service.album.albumService;
import kr.or.ddit.nn.service.album.albumServiceImpl;
import kr.or.ddit.nn.service.answer.AnswerService;
import kr.or.ddit.nn.service.answer.AnswerServiceImpl;
import kr.or.ddit.nn.service.artist.artistService;
import kr.or.ddit.nn.service.artist.artistServiceImpl;
import kr.or.ddit.nn.service.chart.ChartService;
import kr.or.ddit.nn.service.chart.ChartServiceImpl;
import kr.or.ddit.nn.service.chart_item.Chart_itemService;
import kr.or.ddit.nn.service.chart_item.Chart_itemServiceImpl;
import kr.or.ddit.nn.service.event.eventService;
import kr.or.ddit.nn.service.event.eventServiceImpl;
import kr.or.ddit.nn.service.faq.FAQService;
import kr.or.ddit.nn.service.faq.FAQServiceImpl;
import kr.or.ddit.nn.service.grade.GradeService;
import kr.or.ddit.nn.service.grade.GradeServiceImpl;
import kr.or.ddit.nn.service.join.JoinService;
import kr.or.ddit.nn.service.join.JoinServiceImpl;
import kr.or.ddit.nn.service.like.LikeService;
import kr.or.ddit.nn.service.like.LikeServiceImpl;
import kr.or.ddit.nn.service.member.MyInfoService;
import kr.or.ddit.nn.service.member.MyInfoServiceImpl;
import kr.or.ddit.nn.service.music.BuyMusicHistoryService;
import kr.or.ddit.nn.service.music.BuyMusicHistoryServiceImpl;
import kr.or.ddit.nn.service.music.DownService;
import kr.or.ddit.nn.service.music.DownServiceImpl;
//import kr.or.ddit.nn.service.music.DownService;
//import kr.or.ddit.nn.service.music.DownServiceImpl;
import kr.or.ddit.nn.service.music.musicService;
import kr.or.ddit.nn.service.music.musicServiceImpl;
import kr.or.ddit.nn.service.musicHistory.MusicHistoryService;
import kr.or.ddit.nn.service.musicHistory.MusicHistoryServiceImpl;
import kr.or.ddit.nn.service.notice.NoticeService;
import kr.or.ddit.nn.service.notice.NoticeServiceImpl;
import kr.or.ddit.nn.service.playlist.PlaylistService;
import kr.or.ddit.nn.service.playlist.PlaylistServiceImpl;
import kr.or.ddit.nn.service.playlistitem.PlaylistItemService;
import kr.or.ddit.nn.service.playlistitem.PlaylistitemServiceImpl;
import kr.or.ddit.nn.service.question.QuestionService;
import kr.or.ddit.nn.service.question.QuestionServiceImpl;
import kr.or.ddit.nn.service.report.ReportService;
import kr.or.ddit.nn.service.report.ReportServiceImpl;
import kr.or.ddit.nn.service.searchPass.SearchPassService;
import kr.or.ddit.nn.service.searchPass.SearchPassServiceImpl;
import kr.or.ddit.nn.service.ticket.MyTicketService;
import kr.or.ddit.nn.service.ticket.MyTicketServiceImpl;
import kr.or.ddit.nn.service.ticket.TicketHistoryService;
import kr.or.ddit.nn.service.ticket.TicketHistoryServiceImpl;
import kr.or.ddit.nn.service.ticket.TicketService;
import kr.or.ddit.nn.service.ticket.TicketServiceImpl;


public class ServerMain extends UnicastRemoteObject implements RemoteInterface{
	protected ServerMain() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		MemberVO member = new MemberVO();
//		member.setMem_id("testId");
//		
//		// join 테스트 중입니다..
//		JoinService join = JoinServiceImpl.getInstance();
//		System.out.println(join.selectId(member));
		
		try {
			ServerMain server = new ServerMain();
			Registry reg = LocateRegistry.createRegistry(8888);
			reg.rebind("server", server);
			

			//민주
			NoticeService notice = NoticeServiceImpl.getInstance();
			reg.rebind("noticeService", notice);
			
			FAQService FaQ = FAQServiceImpl.getInstance();
			reg.rebind("faqService", FaQ);
			
			ReportService report = ReportServiceImpl.getInstance();
			reg.rebind("reportService", report);
			
			eventService event = eventServiceImpl.getInstance();
			reg.rebind("eventService", event);
			
			QuestionService question = QuestionServiceImpl.getInstance();
			reg.rebind("questionService", question);
			
			AnswerService answer = AnswerServiceImpl.getInstance();
			reg.rebind("answerService", answer);
			
			//보람
			MyInfoService myInfo = MyInfoServiceImpl.getInstance();
			reg.rebind("myInfo", myInfo);
			
			DownService downService = DownServiceImpl.getInstance();
			reg.rebind("downService", downService);
			
			TicketService ticketService = TicketServiceImpl.getInstance();
			reg.rebind("ticketService", ticketService);
			
			TicketHistoryService ticketHistory = TicketHistoryServiceImpl.getInstance();
			reg.rebind("ticketHistoryService", ticketHistory);
			
			MyTicketService myTicket = MyTicketServiceImpl.getInstance();
			reg.rebind("myTicketService", myTicket);
			
			GradeService gradeService = GradeServiceImpl.getInstance();
			reg.rebind("gradeInfo", gradeService);
			
			BuyMusicHistoryService buyMusic = BuyMusicHistoryServiceImpl.getInstance();
			reg.rebind("buyMusicHistory", buyMusic);
			
			
			//정환
			PlaylistService playlistService = PlaylistServiceImpl.getInstance();
			reg.rebind("PlaylistService", playlistService);
			
			PlaylistItemService playlistItemService = PlaylistitemServiceImpl.getInstance();
			reg.rebind("PlaylistItemService", playlistItemService);
			
			LikeService likeService = LikeServiceImpl.getInstance();
			reg.rebind("LikeService", likeService);
			
			//형욱
			JoinService joinService = JoinServiceImpl.getInstance();
			reg.rebind("JoinService", joinService);
			
			SearchPassService searchPassService = SearchPassServiceImpl.getInstance();
			reg.rebind("SearchPassService", searchPassService);
			
			//상근
			albumService album = albumServiceImpl.getInstance();
			musicService music = musicServiceImpl.getInstance();
			artistService artist = artistServiceImpl.getInstance();
			ChartService chart = ChartServiceImpl.getInstance();
			Chart_itemService chart_item = Chart_itemServiceImpl.getInstance();
			reg.rebind("albumService", album);
			reg.rebind("musicService", music);
			reg.rebind("artistService", artist);
			reg.rebind("chartService", chart);
			reg.rebind("chart_itemService", chart_item);
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		System.out.println("서버구동중..");
		
		
		
		
	}
	
	@Override
	public void printMsg(String msg) {
		System.out.println(msg);
	}
}