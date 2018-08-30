package poly.service;

import java.util.List;

import poly.dto.UserDTO;

public interface IUserService {
	public int insertUserDTO(UserDTO uDTO) throws Exception; //UserDTO 형식의 변수를 매개변수로 받는 회원정보를 입력하는 메소드
	public List<UserDTO> getUserList() throws Exception; //리스트 형식의 값을 반환하는 getUserList() 메소드
	public UserDTO getUserDetail(String userNo) throws Exception; //UserDTO 형식의 값을 반환하는 회원 상세정보를 보기위한 메소드 
	public int deleteUser(String userNo) throws Exception; //int값을 반환하는 회원삭제 메소드
	public int updateUserDTO(UserDTO uDTO) throws Exception; //int값을 반환하는 UserDTO를 매개변수로 받는 회원정보 수정 메소드
	public UserDTO getUserLogin(UserDTO uDTO) throws Exception; //UserDTO 형식의 값을 매개변수로 받고 반환하는 로그인 메소드
}
