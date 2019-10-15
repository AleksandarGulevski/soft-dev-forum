package com.example.softdevforum.mapper;

import com.example.softdevforum.dto.CategoryDto;
import com.example.softdevforum.entity.Category;

public class CategoryMapper {

    public static Category dtoToEntity(CategoryDto categoryDto){
        Category category = new Category()
                .setName(categoryDto.getName());
        return category;
    }

    public static CategoryDto entityToDto(Category category){
        CategoryDto categoryDto = CategoryDto.builder()
                .name(category.getName())
                .id(category.getId())
                .build();
        return  categoryDto;
    }
}
