package com.example.softdevforum.service;

import com.example.softdevforum.dto.CommentDto;
import com.example.softdevforum.entity.Comment;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Transactional
@Validated
public interface CommentService {

    Comment create(@NotNull(message = "Invalid data") final CommentDto commentDto, final long id);

    void delete(final long id);

    List<Comment> getAllFromSingleUser(final long userId);

    List<Comment> getAllForSinglePost(final long postId);


}
