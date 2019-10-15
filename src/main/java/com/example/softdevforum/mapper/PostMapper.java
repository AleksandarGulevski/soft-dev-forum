package com.example.softdevforum.mapper;

import com.example.softdevforum.dto.PostDto;
import com.example.softdevforum.dto.UpdatePostDetailsDto;
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
                .id(post.getId())
                .build();
        return postDto;
    }

    public static void updatePostDetails(final UpdatePostDetailsDto dto, final Post entity){
        entity.setTitle(dto.getTitle())
                .setContent(dto.getContent())
                .setCreatedAt(dto.getCreatedAt());
    }
}
