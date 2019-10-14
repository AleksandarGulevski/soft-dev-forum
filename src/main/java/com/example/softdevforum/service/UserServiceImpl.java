package com.example.softdevforum.service;

import com.example.softdevforum.dto.UpdateUserDetailsDto;
import com.example.softdevforum.dto.UserDto;
import com.example.softdevforum.entity.Post;
import com.example.softdevforum.entity.User;
import com.example.softdevforum.exception.ResourceNotFoundException;
import com.example.softdevforum.exception.ResourceValidationException;
import com.example.softdevforum.exception.UserAlreadyRegisteredException;
import com.example.softdevforum.mapper.UserMapper;
import com.example.softdevforum.repository.PostRepository;
import com.example.softdevforum.repository.UserRepository;
import com.example.softdevforum.util.ErrorCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public User create(final UserDto userDto, final long id) {
        User user = UserMapper.dtoToEntity(userDto);
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUserName());
        if (userOptional.isPresent()) {
            throw new UserAlreadyRegisteredException(
                    ErrorCode.USER_ALREADY_REGISTERED, "User with that username is already registered");
        }
        return userRepository.save(user);
    }

    @Override
    public void delete(final long id) {
        userRepository.findById(id).ifPresent(user -> {
            userRepository.delete(user);
        });
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            throw new ResourceValidationException(
                    ErrorCode.USER_DELETING_UNSUCCESSFUL, "User deleting was unsuccessful, try again"
            );
        }
    }

    @Override
    public User update(final UpdateUserDetailsDto updateUserDetailsDto, final long id) {
        User user = getUserById(id);
        UserMapper.updateUserDetails(updateUserDetailsDto, user);
        return userRepository.save(user);
    }

    @Override
    public User getUserByUserName(final String userName) {
        return userRepository.findByUsername(userName)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ErrorCode.USER_NOT_FOUND, "User with username " + userName + " not found"));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public List<Post> getAllFromSingleUser(final long userId) {
        User user = getUserById(userId);
        return postRepository.findAllByUser(user);
    }

    public User getUserById(final long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(
                ErrorCode.USER_NOT_FOUND, "User with id " + userId + " not found!"));
    }
}
