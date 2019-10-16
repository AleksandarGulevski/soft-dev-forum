package com.example.softdevforum.api;

import com.example.softdevforum.dto.PostDto;
import com.example.softdevforum.dto.UpdatePostDetailsDto;
import com.example.softdevforum.entity.Post;
import com.example.softdevforum.mapper.PostMapper;
import com.example.softdevforum.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("(\"/api/v1")
public class PostController {

    private final PostService postService;

    @PostMapping(value = "/{user}/new/post/{category}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PostDto create(@RequestBody PostDto postDto, @PathVariable ("user") long user, @PathVariable("id") long category) {
        return PostMapper.entityToDto(postService.create(postDto, user, category));
    }

    @DeleteMapping(value = "/category/posts/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable("id") long id) {
        postService.delete(id);
    }

    @PutMapping(value = "/category/posts/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Post update(@RequestBody UpdatePostDetailsDto updatePostDetailsDto, @PathVariable("id") long id) {
        return postService.update(updatePostDetailsDto, id);
    }

    @GetMapping(value = "/category/posts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PostDto> getAllUsers() {
        return postService.getAll().stream()
                .map(item -> PostMapper.entityToDto(item))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/category/posts/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Post getPostById(@PathVariable("id") long id) {
        return postService.getPostById(id);
    }
}
