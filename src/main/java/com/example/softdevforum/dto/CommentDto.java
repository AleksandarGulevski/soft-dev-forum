package com.example.softdevforum.dto;

import lombok.Builder;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;

@Value
@Builder
public class CommentDto implements Serializable {

    private Long id;
    @NotBlank(message = "Comment cannot be blank")
    @Length(message = "Maximum length 30000 characters", max = 30000)
    private String content;
    @NotBlank(message = "You must enter a timestamp")
    private Timestamp timestamp;
}
