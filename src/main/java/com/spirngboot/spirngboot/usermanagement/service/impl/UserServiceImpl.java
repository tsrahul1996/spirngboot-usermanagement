package com.spirngboot.spirngboot.usermanagement.service.impl;

import com.spirngboot.spirngboot.usermanagement.dto.UserDto;
import com.spirngboot.spirngboot.usermanagement.entity.User;
import com.spirngboot.spirngboot.usermanagement.exception.ResourceNotFoundException;
import com.spirngboot.spirngboot.usermanagement.mapper.UserMapper;
import com.spirngboot.spirngboot.usermanagement.repository.UserRepository;
import com.spirngboot.spirngboot.usermanagement.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public UserDto getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+id));


        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();

        return userList.stream()
                .map(userMapper::toDto)
                .toList();

    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
//        User savedUser = null;
//        if(userRepository.existsById(id)){
//
//         userRepository.deleteById(id);
//            savedUser = userRepository.save(userMapper.toEntity(userDto));
//
//        }
//
//        return userMapper.toDto(savedUser);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+id));

        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setEmail(userDto.lastName());

        User savedUser = userRepository.save(user);

        return userMapper.toDto(savedUser);

    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+id));

        userRepository.deleteById(id);

    }
}
