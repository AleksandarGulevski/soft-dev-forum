package com.example.softdevforum.service;

import com.example.softdevforum.dto.CommentDto;
import com.example.softdevforum.entity.Comment;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    @Override
    public Comment create(@NotNull(message = "Invalid data") CommentDto commentDto, long id) {
        return null;
    }

    @Override
    public Comment delete(long id) {
        return null;
    }

    @Override
    public Comment update(long id) {
        return null;
    }

    @Override
    public List<Comment> getAllFromSingleUser(long userId) {
        return null;
    }

    @Override
    public List<Comment> getAllForSinglePost(long postId) {
        return null;
    }
}
