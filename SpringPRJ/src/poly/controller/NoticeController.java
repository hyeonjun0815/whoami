package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.NoticeDTO;
import poly.service.INoticeService;
import poly.util.CmmUtil;

/*
 * Controller 선언해야만 Spring 프레임워크에서 Controller인지 인식 가능
 * 자바 서블릿 역할 수행
 * */
@Controller
public class NoticeController {
	private Logger log = Logger.getLogger(this.getClass());
	
	/*
	 * 비즈니스 로직(중요 로직을 수행하기 위해 사용되는 서비스를 메모리에 적재(싱글톤패턴 적용됨)
	 * */
	@Resource(name = "NoticeService")
	private INoticeService noticeService;
	
	/*
	 * 함수명 위의 value="notice/NoticeList" => /notice/NoticeList.do로 호출되는 url은 무조건 이 함수가 실행된다.
	 * method=RequestMethod.GET => 폼 전송방법을 지정하는 것으로 get방식은 GET, post방식은 POST이다.
	 * method => 기입안하면 GET, POST 모두 가능하나, 가급적 적어주는 것이 좋다.
	 * */
	

	
	@RequestMapping(value="index")
	public String index() throws Exception{
		return "/index";
	}
 
	@RequestMapping(value="a") // a를 요청 받으면
	public String a() throws Exception{ // a 메소드를 실행하여
		return "/a";		// a 페이지를 리턴
	}
	
	@RequestMapping(value="b") // b를 요청 받을 때
	public String b(HttpServletRequest request, Model model) throws Exception{ // b메소드에 request객체와, 모델 객체 선언
		String cm = request.getParameter("cm");	//cm으로 지정된 데이터를 받습니다.
		String kg = request.getParameter("kg"); //kg으로 지정된  데이터를 받습니다.
		double bmi = Integer.parseInt(kg) / (Integer.parseInt(cm)*0.01 * Integer.parseInt(cm)*0.01); 
		//String을 int로 변환하여 double 변수에 저장합니다.
		model.addAttribute("bmi", bmi); // model 객체를 이용해 bmi라는 이름으로 bmi변수를 전송합니다.
		return "/b"; //b 페이지를 반환합니다.
	}
	
	@RequestMapping(value="c") // c를 요청 받을 때 
	public String c(HttpServletRequest request, Model model) throws Exception { // c 메소드를 실행하여
		String cm = request.getParameter("cm");
		String kg = request.getParameter("kg");
		double bmi = Integer.parseInt(kg) / (Integer.parseInt(cm)*0.01 * Integer.parseInt(cm)*0.01);
		model.addAttribute("bmi", bmi);
		return "/c"; 	// c 페이지를 반환합니다.
	}
	
	
	/**
	 * 게시판 리스트 보여주기
	 * */
	/*@RequestMapping(value="notice/NoticeList", method=RequestMethod.GET)
	public String NoticeList(HttpServletRequest request, HttpServletResponse response, 
			ModelMap model) throws Exception {
		
		//로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
		log.info(this.getClass().getName() + ".NoticeList start!");
		
		//공지사항 리스트 가져오기
		List<NoticeDTO> rList = noticeService.getNoticeList();
		
		if (rList==null){
			rList = new ArrayList<NoticeDTO>();
			
		}
		
		//조회된 리스트 결과값 넣어주기
		model.addAttribute("rList", rList);
		
		//변수 초기화(메모리 효율화 시키기 위해 사용함)
		rList = null;
		
		//로그 찍기(추후 찍은 로그를 통해 이 함수 호출이 끝났는지 파악하기 용이하다.)
		log.info(this.getClass().getName() + ".NoticeList end!");
		
		//함수 처리가 끝나고 보여줄 JSP 파일명(/WEB-INF/view/notice/NoticeList.jsp) 
		return "/notice/NoticeList";
	}*/
}
