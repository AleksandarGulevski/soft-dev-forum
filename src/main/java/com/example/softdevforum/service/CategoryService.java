package com.example.softdevforum.service;

import com.example.softdevforum.dto.CategoryDto;
import com.example.softdevforum.entity.Category;
import com.example.softdevforum.entity.Post;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Transactional
@Validated
public interface CategoryService {

    Category create(@NotNull(message = "Invalid data") final CategoryDto categoryDto, final long id);

    Category delete(final long id);

    List<Post> getAllFromSingleCategory(final long userId);
}
