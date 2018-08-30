package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.UserDTO;

@Mapper("UserMapper") //UserMapper라는 이름의 Mapper라고 선언
public interface UserMapper {
	public int insertUserDTO(UserDTO uDTO) throws Exception; //inserUserDTO 메소드
	public List<UserDTO> getUserList() throws Exception; //List<UserDTO>를 반환하는 getUserList메소드
	public UserDTO getUserDetail(String userNo) throws Exception; //UserDTO 타입을 반환하는 userNo를 인자로 받는 회원상세보기 메소드
	public int deleteUser(String userNo) throws Exception; // int를 반환하는 userNo를 인자로 받는 회원 삭제 메소드
	public int updateUserDTO(UserDTO uDTO) throws Exception;
	public UserDTO getUserLogin(UserDTO uDTO) throws Exception;
}


