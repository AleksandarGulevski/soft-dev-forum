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
public class CommentDto implements Serializable {

    private Long id;
    @NotBlank(message = "Comment cannot be blank")
    @Length(message = "Maximum length 30000 characters", max = 30000)
    private String content;
    @NotNull(message = "You must enter a timestamp")
    private OffsetDateTime createdAt;
}
