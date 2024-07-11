package com.veryveg.product.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.veryveg.product.DTO.UserDTO;
import com.veryveg.product.entity.User;

@Mapper
public interface UserMapper {
	
	User toUserEntity (UserDTO dto);
	
	UserDTO toUserDTO (User u);
	
	List<User> ListToUserEntity (List<UserDTO> dtoList);
	
	List<UserDTO> ListToUserDTO (List<User> uList);

}
