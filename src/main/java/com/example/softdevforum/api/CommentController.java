package com.example.softdevforum.api;

import com.example.softdevforum.dto.CommentDto;
import com.example.softdevforum.mapper.CommentMapper;
import com.example.softdevforum.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/category/{postid}/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommentDto create(@RequestBody CommentDto commentDto, @PathVariable("postid") long postid) {
        return CommentMapper.entityToDto(commentService.create(commentDto, postid));
    }

    @DeleteMapping(value = "/category/posts/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable("id") long id) {
        commentService.delete(id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CommentDto> getAllFromSingleUser(@PathVariable ("id") long id) {
        return commentService.getAllFromSingleUser(id).stream()
                .map(CommentMapper::entityToDto)
                .collect(Collectors.toList());
    }


}
