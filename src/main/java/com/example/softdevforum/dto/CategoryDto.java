package com.example.softdevforum.dto;

import lombok.Builder;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Value
@Builder
public class CategoryDto implements Serializable {

    private Long id;
    @NotBlank(message = "You must enter the category name")
    @Length(message = "Maximum length 100 characters", max = 100)
    private String name;

}
