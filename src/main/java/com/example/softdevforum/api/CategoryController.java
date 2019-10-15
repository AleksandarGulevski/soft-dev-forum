package com.example.softdevforum.api;

import com.example.softdevforum.dto.CategoryDto;
import com.example.softdevforum.mapper.CategoryMapper;
import com.example.softdevforum.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

private final CategoryService categoryService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CategoryDto create(@RequestBody CategoryDto categoryDto) {
        return CategoryMapper.entityToDto(categoryService.create(categoryDto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAll().stream()
                .map(item -> CategoryMapper.entityToDto(item))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CategoryDto getCategoryById(@PathVariable("id") long id) {
        return CategoryMapper.entityToDto(categoryService.getCategoryById(id));
    }
}
