package com.example.softdevforum.mapper;

import com.example.softdevforum.dto.UserDto;
import com.example.softdevforum.entity.User;

public class UserMapper {

    public static User dtoToEntity(UserDto userDto) {
        User user = new User()
                .setFirstName(userDto.getFirstName())
                .setLastName(userDto.getLastName())
                .setUserName(userDto.getUserName())
                .setEmail(userDto.getEmail());
        return user;
    }

    public static UserDto entityToDto(User user){
        UserDto userDto = UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(user.getUserName())
                .email(user.getEmail())
                .build();
        return userDto;
    }
}