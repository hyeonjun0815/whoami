package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.UserDTO;
import poly.persistance.mapper.UserMapper;
import poly.service.IUserService;

@Service("UserService") //단순한 이름 설정

public class UserService implements IUserService{ //IUserService를 상속받는 UserService 인터페이스
	@Resource(name="UserMapper")	// 객체를 생성할 때 UserMapper라고 명명
	private UserMapper userMapper; // UserMapper 타입의 userMapper라는 변수의 객체 선언
	
	@Override 
	public int insertUserDTO(UserDTO uDTO) throws Exception { //UserDTO타입의 매개변수를 받는 회원가입 메소드
		return userMapper.insertUserDTO(uDTO); 	// Mapper에서 아이디가 inserUserDTO인 메소드를 호출
	}

	@Override //회원 정보 가져올 때, 매개변수 필요 없음
	public List<UserDTO> getUserList() throws Exception { //List<UserDTO>타입을 반환하는 매개변수없는 회원정보 출력 메소드
		return userMapper.getUserList(); // Mapper의 아이디가 getUserList인 메소드를 호출
	}

	@Override
	public UserDTO getUserDetail(String userNo) throws Exception {
		return userMapper.getUserDetail(userNo);		//UserMapper.xml 작성 이전에는 오류가 남
	}

	@Override
	public int deleteUser(String userNo) throws Exception {
		return userMapper.deleteUser(userNo);	// 매퍼의 userDelete를 호출합니다.
		
	}

	@Override
	public int updateUserDTO(UserDTO uDTO) throws Exception {
		return userMapper.updateUserDTO(uDTO); // 매퍼의 회원정보수정 mapper를 호출
		
	}

	@Override
	public UserDTO getUserLogin(UserDTO uDTO) throws Exception {
		
		return userMapper.getUserLogin(uDTO);
	}

	
	
	
}




