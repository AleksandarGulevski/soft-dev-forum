package com.example.softdevforum.mapper;

import com.example.softdevforum.dto.PostDto;
import com.example.softdevforum.entity.Post;

public class PostMapper {

    public static Post dtoToEntity(PostDto postDto) {
        Post post = new Post()
                .setTitle(postDto.getTitle())
                .setContent(postDto.getContent())
                .setCreatedAt(postDto.getCreatedAt());
        return post;
    }

    public static PostDto entityToDto(Post post) {
        PostDto postDto = PostDto.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .build();
        return postDto;
    }
}
