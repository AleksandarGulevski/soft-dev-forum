package com.example.softdevforum.service;

import com.example.softdevforum.dto.PostDto;
import com.example.softdevforum.entity.Post;

import javax.validation.constraints.NotNull;
import java.util.List;

public class PostServiceImpl implements PostService {
    @Override
    public Post create(@NotNull(message = "Invalid data") PostDto postDto, long id) {
        return null;
    }

    @Override
    public Post delete(long id) {
        return null;
    }

    @Override
    public Post update(long id) {
        return null;
    }

    @Override
    public Post getById(long id) {
        return null;
    }

    @Override
    public List<Post> getAll() {
        return null;
    }

}
