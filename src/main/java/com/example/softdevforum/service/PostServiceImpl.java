package com.example.softdevforum.service;

import com.example.softdevforum.dto.PostDto;
import com.example.softdevforum.dto.UpdatePostDetailsDto;
import com.example.softdevforum.entity.Category;
import com.example.softdevforum.entity.Post;
import com.example.softdevforum.entity.User;
import com.example.softdevforum.exception.ResourceNotFoundException;
import com.example.softdevforum.exception.ResourceValidationException;
import com.example.softdevforum.mapper.PostMapper;
import com.example.softdevforum.repository.CategoryRepository;
import com.example.softdevforum.repository.PostRepository;
import com.example.softdevforum.repository.UserRepository;
import com.example.softdevforum.util.ErrorCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Post create(final PostDto postDto, final long userId, final long categoryId) {
        Post post = PostMapper.dtoToEntity(postDto);
        User user = getUserById(userId);
        Category category = getCategoryById(categoryId);
        user.addPost(post);
        category.addPost(post);
        return postRepository.save(post);

    }

    @Override
    public void delete(long id) {
        postRepository.findById(id).ifPresent((post) -> {
            postRepository.delete(post);
        });
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()){
            throw new ResourceValidationException(
                    ErrorCode.POST_DELETING_UNSUCCESSFUL, "Post deleting was unsuccessful, try again"
            );
        }
    }

    @Override
    public Post update(final UpdatePostDetailsDto updatePostDetailsDto, final long id) {
    Post post = getPostById(id);
    PostMapper.updatePostDetails(updatePostDetailsDto, post);
    return postRepository.save(post);
    }

    @Override
    public List<Post> getAll() {
      List<Post> posts = new ArrayList<>();
      postRepository.findAll().forEach(posts::add);
      return posts;
    }

    public User getUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(
                ErrorCode.USER_NOT_FOUND, "User with id " + userId + " not found!"));
    }

    public Post getPostById(long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException(
                ErrorCode.POST_NOT_FOUND, "User with id " + postId + " not found!"));
    }

    public Category getCategoryById(long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(
                ErrorCode.CATEGORY_NOT_FOUND, "User with id " + categoryId + " not found!"));
    }

}
