package com.example.softdevforum.service;

import com.example.softdevforum.dto.CommentDto;
import com.example.softdevforum.entity.Comment;
import com.example.softdevforum.entity.Post;
import com.example.softdevforum.entity.User;
import com.example.softdevforum.exception.ResourceValidationException;
import com.example.softdevforum.mapper.CommentMapper;
import com.example.softdevforum.repository.CommentRepository;
import com.example.softdevforum.util.ErrorCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final UserService userService;

    @Override
    public Comment create(final CommentDto commentDto, final long id) {
      Comment comment = CommentMapper.dtoToEntity(commentDto);
        Post post = postService.getPostById(id);
        post.addComment(comment);
        return commentRepository.save(comment);
    }

    @Override
    public void delete(final long id) {
        commentRepository.findById(id).ifPresent((comment) -> {
            commentRepository.delete(comment);
        });
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()){
            throw new ResourceValidationException(
                    ErrorCode.COMMENT_DELETING_UNSUCCESSFUL, "Comment deleting was unsuccessful, try again"
            );
        }
    }

    @Override
    public List<Comment> getAllFromSingleUser(final long userId) {
        User user = userService.getUserById(userId);
        return commentRepository.findAllByUser(user);
    }

    @Override
    public List<Comment> getAllForSinglePost(final long postId) {
        Post post = postService.getPostById(postId);
        return commentRepository.findAllByPost(post);
    }

}
