package com.application.test.service;

import com.application.test.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);

//    List<UserDto> getUser();

    List<UserDto> getAllUser();

    UserDto updateUser(Long id, UserDto userDto);

    String deleteUser(Long id);
}
