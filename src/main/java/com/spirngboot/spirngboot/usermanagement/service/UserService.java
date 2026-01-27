package com.spirngboot.spirngboot.usermanagement.service;

import com.spirngboot.spirngboot.usermanagement.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);


}
