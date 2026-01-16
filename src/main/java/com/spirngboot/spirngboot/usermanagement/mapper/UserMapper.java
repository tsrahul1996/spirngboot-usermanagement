package com.spirngboot.spirngboot.usermanagement.mapper;

import com.spirngboot.spirngboot.usermanagement.dto.UserDto;
import com.spirngboot.spirngboot.usermanagement.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user){
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
                );
    }

    public User toEntity(UserDto userDto){
        return new User(userDto.id(),
                userDto.firstName(),
                userDto.lastName(),
                userDto.email());
    }
}
