package com.example.softdevforum.service;

import com.example.softdevforum.dto.CategoryDto;
import com.example.softdevforum.entity.Category;
import com.example.softdevforum.entity.Post;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public Category create(@NotNull(message = "Invalid data") CategoryDto categoryDto, long id) {
        return null;
    }

    @Override
    public Category delete(long id) {
        return null;
    }

    @Override
    public List<Post> getAllFromSingleCategory(long userId) {
        return null;
    }
}
