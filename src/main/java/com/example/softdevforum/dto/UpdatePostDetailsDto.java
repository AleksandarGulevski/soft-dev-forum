package com.example.softdevforum.dto;

import lombok.Builder;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Value
@Builder
public class UpdatePostDetailsDto implements Serializable {

    @NotBlank(message = "You must enter your first name")
    @Length(message = "Maximum length 100 characters", max = 100)
    private String title;
    @NotBlank(message = "Post cannot be blank")
    @Length(message = "Maximum length 4000 characters", max = 4000)
    private String content;
    @NotNull(message = "You must enter a timestamp")
    private OffsetDateTime createdAt;
}
