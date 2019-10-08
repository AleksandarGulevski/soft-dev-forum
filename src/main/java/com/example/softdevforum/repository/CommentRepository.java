package com.example.softdevforum.repository;

import com.example.softdevforum.entity.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
