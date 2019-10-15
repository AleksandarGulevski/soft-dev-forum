package com.example.softdevforum.service;

import com.example.softdevforum.dto.CategoryDto;
import com.example.softdevforum.entity.Category;
import com.example.softdevforum.entity.Post;
import com.example.softdevforum.exception.ResourceNotFoundException;
import com.example.softdevforum.exception.ResourceValidationException;
import com.example.softdevforum.mapper.CategoryMapper;
import com.example.softdevforum.repository.CategoryRepository;
import com.example.softdevforum.repository.PostRepository;
import com.example.softdevforum.util.ErrorCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;

    @Override
    public Category create(@NotNull(message = "Invalid data") CategoryDto categoryDto) {
        Category category = CategoryMapper.dtoToEntity(categoryDto);
        return categoryRepository.save(category);
    }


    @Override
    public void delete(long id) {
        categoryRepository.findById(id).ifPresent((category) -> {
            categoryRepository.delete(category);
        });
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()){
            throw new ResourceValidationException(
                    ErrorCode.CATEGORY_DELETING_UNSUCCESSFUL, "Category deleting was unsuccessful, try again"
            );
        }
    }

    @Override
    public List<Post> getAllFromSingleCategory(long userId) {
       Category category = getCategoryById(userId);
       return postRepository.findAllByCategory(category);
    }

    @Override
    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                ErrorCode.CATEGORY_NOT_FOUND, "Category with id " + id + " not found!"));
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories ::add);
        return categories;
    }
}
