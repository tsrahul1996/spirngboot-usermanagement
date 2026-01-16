package com.spirngboot.spirngboot.usermanagement.service.impl;

import com.spirngboot.spirngboot.usermanagement.dto.UserDto;
import com.spirngboot.spirngboot.usermanagement.entity.User;
import com.spirngboot.spirngboot.usermanagement.mapper.UserMapper;
import com.spirngboot.spirngboot.usermanagement.repository.UserRepository;
import com.spirngboot.spirngboot.usermanagement.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }
}
