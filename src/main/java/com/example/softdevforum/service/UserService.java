package com.example.softdevforum.service;

import com.example.softdevforum.dto.UserDto;
import com.example.softdevforum.entity.Post;
import com.example.softdevforum.entity.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Transactional
@Validated
public interface UserService {

    User create(@NotNull(message = "Invalid data") final UserDto userDto, final long id);

    User delete(final long id);

    User update(final long id);

    User getUserByUserName(String userName);

    List<User> getAllUsers();

    List<Post> getAllFromSingleUser(final long userId);

    //TODO Get the number of all posts from one user


}
