package cn.comment.service;

import java.util.List;

import cn.comment.dto.UserDto;

public interface UserService {

	boolean validate(UserDto userDto);

	boolean add(UserDto userDto);

	List<UserDto> getList();

	UserDto getById(Long id);

	boolean modify(UserDto userDto);

	boolean remove(Long id);

}
