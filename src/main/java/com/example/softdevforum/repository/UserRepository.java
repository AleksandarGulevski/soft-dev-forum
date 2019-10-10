package com.example.softdevforum.repository;

import com.example.softdevforum.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

        Optional<User> findByUsername(String userName);
}
