package com.example.softdevforum.service;

import com.example.softdevforum.dto.UserDto;
import com.example.softdevforum.entity.Post;
import com.example.softdevforum.entity.User;
import com.example.softdevforum.exception.UserAlreadyRegisteredException;
import com.example.softdevforum.mapper.UserMapper;
import com.example.softdevforum.repository.UserRepository;
import com.example.softdevforum.util.ErrorCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(UserDto userDto, long id) {
        User user = UserMapper.dtoToEntity(userDto);
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUserName());
        if (userOptional.isPresent()) {
            throw new UserAlreadyRegisteredException(
                    ErrorCode.USER_ALREADY_REGISTERED, "User with that username is already registered");
        }
        return userRepository.save(user);
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
