package poly.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.UserDTO;
import poly.service.IUserService;

@Controller
public class UserController {
	private Logger log = Logger.getLogger(this.getClass()); //톰캣으로 오는 요청을 파일로 기록한다는 뜻
	
	@Resource(name="UserService")	//이름을 UserService로 명명
	private IUserService userService; //IUserService 타입의 userService 선언
	
	
	/***********************메인페이지**************************/
	@RequestMapping(value="main") //main.jsp를 요청 할 때 
	public String main(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		return "main";
	}
	
	/***********************회원 등록 페이지**************************/
	@RequestMapping(value="user/userReg") //userReg.jsp를 요청할 때
	public String userReg() throws Exception{
		return "user/userReg"; 	//userReg페이지를 반환합니다.
	}
	
	
	/***********************회원 등록페이지 내의 회원등록 버튼을 누를 때**************************/
	@RequestMapping(value="user/userRegProc", method=RequestMethod.POST)	//userRegProc를 요청하고 전송방식은 post라고 할 떄
	public String userRegProc(HttpServletRequest request, Model model) throws Exception{
		String id = request.getParameter("id");	//id변수에 받아온 id의 값을 저장합니다.
		String password = request.getParameter("password"); //password변수에 받아온 password의 값을 저장합니다.
		String name = request.getParameter("name"); //name변수에 받아온 name의 값을 저장합니다.
		String age = request.getParameter("age"); //age변수에 받아온 age의 값을 저장합니다.
		
		/*******변수에 저장된 값을 Console창에 출력********/
		log.info("User has been registered");
		log.info("id: " + id);
		log.info("password: " + password);
		log.info("name: " + name);
		log.info("age: " + age);
		
		/*******UserDTO의 객체를 새로 선언하여 받은 인자 값을 이용하여 저장*******/		
		UserDTO uDTO = new UserDTO(); //userDTO타입의 uDTO객체 선언
		uDTO.setId(id);
		uDTO.setPassword(password);
		uDTO.setName(name);
		uDTO.setAge(age);

		
		int result = userService.insertUserDTO(uDTO); //서비스 내의 회원을 등록하는 메소드 출력하여 result에 저장 

		/************회원등록에 실패했는지 성공했는지 확인************/
		String msg = ""; 			// alert으로 띄워줄 메시지 변수
		String url ="";				// 이동할 페이지 주소를 저장할 변수
		if(result !=0) { 			//회원가입 성공시 result값에 1이 반환됩니다.
			msg = "회원가입에 성공하셨습니다 !"; 
			url = "/main.do";
		}else {
			msg = "회원가입 실패";
			url = "/user/userReg.do";
		}
		model.addAttribute("msg",msg); //저장된 msg변수를 전송
		model.addAttribute("url",url); //저장된 url변수를 전송
		return "/alert";				//alert페이지로 이동
	}
	
	/***********************회원 리스트 보기**************************/
	@RequestMapping(value="user/userList") //userList페이지를 요청 받을 때 매핑
	public String userList(HttpServletRequest request, Model model) throws Exception{  //request, model객체를 매개변수로 하는 userList작성
		
		List<UserDTO> uList = userService.getUserList(); //List형식으로 userService의 getUserList메소드를 호출
		model.addAttribute("uList", uList); //uList를 uList라는 변수명으로 전송
		
		return "user/userList"; // userList 페이지로 이동
	}
	

	/***********************회원 상세 보기**************************/
	@RequestMapping(value="user/userDetail", method=RequestMethod.GET) //GET방식으로 데이터를 받음
	public String userDetail(HttpServletRequest request, Model model) throws Exception {
		String userNo = request.getParameter("userNo"); //userNo라는 변수의 데이터를 받고 userNo의 변수에 저장
		log.info("See user's detail");
		log.info("userNo: " + userNo);					// 로그로 출력하여 확인
		UserDTO uDTO = userService.getUserDetail(userNo);	//UserDTO타입의 값을 반환하는 서비스내의 회원상세보기 메소드 호출
		model.addAttribute("uDTO", uDTO); //저장된 uDTO변수를 전송
		return "user/userDetail";		  //userDetail페이지로 이동
	}
	
	/***********************회원 삭제**************************/
	@RequestMapping(value="user/userDelete", method=RequestMethod.GET) //GET방식으로 데이터를 받아옴
	public String userDelete(HttpServletRequest request, Model model) throws Exception {
		String userNo = request.getParameter("userNo"); //userNo라는 변수로 받은 값을 userNo에 저장
		log.info("userNo " + userNo + " is deleted");	//console에서 확인하기 위해 받고 저장 된 값 출력
		int result = userService.deleteUser(userNo); //userDelete메소드를 호출하여 성공/실패 int값을  result값에 저장

	
		String msg = "";			//보여줄 문자를 저장할 변수 선언
		String url ="";				//이동할 주소를 저장할 변수 선언
		if(result !=0) { 			//회원 삭제 성공시 result에 1 리턴이 되었을 때

			msg = "회원 삭제에 성공하셨습니다 !"; 
			url = "/main.do";
		}else {				//회원 삭제 실패시 result에 0 리턴이 되었을 때
			msg = "회원삭제 실패";
			url = "/main.do";
		}
		
		model.addAttribute("msg",msg); // alert페이지에 넘겨줄 msg 보내기
		model.addAttribute("url",url); // alert페이지에 넘겨줄 url 보내기
		
		return "/alert"; 	//alert를 띄워주면서 url로 보내주는 alert페이지로 이동
	}
	
	/***********************회원 수정**************************/
	@RequestMapping(value="user/userUpdateView", method=RequestMethod.GET)
	public String userUpdateView(HttpServletRequest request, Model model) throws Exception{
		String userNo = request.getParameter("userNo");
		log.info("User Update");
		log.info("user NO: " + userNo);
		
		UserDTO uDTO = userService.getUserDetail(userNo);
		model.addAttribute("uDTO", uDTO);
			
		return "/user/userUpdateView";
	}
	
	@RequestMapping(value="user/userUpdateProc", method=RequestMethod.POST)
	public String userUpdateProc(HttpServletRequest request, Model model) throws Exception{
		
		String userNo = request.getParameter("userNo");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		log.info("User update");
		log.info("userNo: "+ userNo);
		log.info("id: " +id);
		log.info("password: "+password);
		log.info("name: "+ name);
		log.info("Age: " + age);

		UserDTO uDTO = new UserDTO();
		uDTO.setUser_no(userNo);
		uDTO.setId(id);
		uDTO.setPassword(password);
		uDTO.setName(name);
		uDTO.setAge(age);
		
		int result = userService.updateUserDTO(uDTO);
		
		String msg = "";
		String url = "/main.do";
		

		if(result != 0) {
			return "redirect:/main.do"; //redirect방식<->forward , 해당 requestMapping으로 이동
		}
		else {
			msg = "회원 정보 수정 실패";
			url = "/user/userUpdateView.do?userNo=" + userNo;
			model.addAttribute("msg",msg);
			model.addAttribute("url",url);
			return "/alert";
			
		}

		
	}
	
	/***********************로그인**************************/
	@RequestMapping(value="user/loginProc", method=RequestMethod.POST)
	public String loginProc(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		log.info("Login Procedure");
		log.info("id: " + id);
		log.info("password: " + password);
		
		UserDTO uDTO = new UserDTO();
		uDTO.setId(id);
		uDTO.setPassword(password);
		
		uDTO = userService.getUserLogin(uDTO); //서비스의 로그인 함수 호출
		if(uDTO == null) { //uDTO로 받아온 값이 없으면 null
			//로그인 실패
			String msg= "로그인에 실패하였습니다."; 
			String url ="/main.do";
			model.addAttribute("msg",msg); //로그인 실패 메시지 모델객체에 저장
			model.addAttribute("url",url); //이동할 주소를 모델객체에 저장
			return "/alert";  			//alert페이지에 저장
			
		}else {
			//로그인 성공
			session.setAttribute("id", uDTO.getId()); //세션 객체에  id 저장
			session.setAttribute("name", uDTO.getName()); //세션 객체에  name 저장
		}
		
		return "/main";
	}
	@RequestMapping(value="/user/logout")
	public String logout(HttpSession session) throws Exception {
		//세션을 초기화 시키는 함수
		session.invalidate();
		log.info("User Logout");
		return "/main";
	}
	
	/***********************게시판**************************/
	@RequestMapping(value="bbs") //bbs.jsp를 요청 할 때 
	public String bbs(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		log.info("Access bbs");
		return "/bbs";
	}
}
