package com.example.softdevforum.mapper;

import com.example.softdevforum.dto.CommentDto;
import com.example.softdevforum.entity.Comment;

public class CommentMapper {

    public static Comment dtoToEntity(CommentDto commentDto){
        Comment comment = new Comment()
                .setContent(commentDto.getContent())
                .setCreatedAt(commentDto.getCreatedAt());
        return comment;
    }

    public static CommentDto entityToDto(Comment comment){
        CommentDto commentDto = CommentDto.builder()
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .id(comment.getId())
                .build();
        return commentDto;
    }
}
