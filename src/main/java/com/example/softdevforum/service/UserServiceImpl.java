package com.example.softdevforum.service;

import com.example.softdevforum.dto.UserDto;
import com.example.softdevforum.entity.Post;
import com.example.softdevforum.entity.User;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User create(@NotNull(message = "Invalid data") UserDto userDto, long id) {
        return null;
    }

    @Override
    public User delete(long id) {
        return null;
    }

    @Override
    public User update(long id) {
        return null;
    }

    @Override
    public User getUserByUserName(String userName) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<Post> getAllFromSingleUser(long userId) {
        return null;
    }
}
