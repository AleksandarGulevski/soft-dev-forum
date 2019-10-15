package com.example.softdevforum.api;

import com.example.softdevforum.dto.UpdateUserDetailsDto;
import com.example.softdevforum.dto.UserDto;
import com.example.softdevforum.entity.User;
import com.example.softdevforum.mapper.UserMapper;
import com.example.softdevforum.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDto create(@RequestBody UserDto userDto) {
        return UserMapper.entityToDto(userService.create(userDto));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable("id") long id) {
        userService.delete(id);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User update(@RequestBody UpdateUserDetailsDto updateUserDetailsDto, @PathVariable("id") long id) {
       return userService.update(updateUserDetailsDto, id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(item -> UserMapper.entityToDto(item))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{username}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUserByUserName(@PathVariable("username") String username) {
        return userService.getUserByUserName(username);
    }

}
