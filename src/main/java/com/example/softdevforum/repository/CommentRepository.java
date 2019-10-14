package com.example.softdevforum.repository;

import com.example.softdevforum.entity.Comment;
import com.example.softdevforum.entity.Post;
import com.example.softdevforum.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    List<Comment> findAllByUser(User user);

    List<Comment> findAllByPost(Post post);
}
