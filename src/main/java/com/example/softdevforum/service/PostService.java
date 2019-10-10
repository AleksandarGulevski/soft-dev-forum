package com.example.softdevforum.service;

import com.example.softdevforum.dto.PostDto;
import com.example.softdevforum.entity.Post;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Transactional
@Validated
public interface PostService {

    Post create(@NotNull(message = "Invalid data") final PostDto postDto, final long id);

    Post delete(final long id);

    Post update(final long id);

    Post getById(final long id);

    List<Post> getAll();




    //TODO get the number of comments for one post
}
