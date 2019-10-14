package com.example.softdevforum.repository;

import com.example.softdevforum.entity.Post;
import com.example.softdevforum.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    List<Post> findAllByUser(User user);
}
