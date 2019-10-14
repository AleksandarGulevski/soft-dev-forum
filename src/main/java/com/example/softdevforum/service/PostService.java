package com.example.softdevforum.service;

import com.example.softdevforum.dto.PostDto;
import com.example.softdevforum.dto.UpdatePostDetailsDto;
import com.example.softdevforum.entity.Post;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Transactional
@Validated
public interface PostService {

    Post create(@NotNull(message = "Invalid data") final PostDto postDto, final long userId, final long categoryId);

    void delete(final long id);

    Post update(@NotNull(message = "Invalid data") @Valid final UpdatePostDetailsDto updatePostDetailsDto, final long id);

    Post getPostById(final long id);

    List<Post> getAllFromSingleUser(@NotNull(message = "Invalid data")final long userId);

    List<Post> getAll();


    //TODO get the number of comments for one post
}
