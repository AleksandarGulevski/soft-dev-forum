package com.example.softdevforum.dto;

import lombok.Builder;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Value
@Builder
public class UserDto implements Serializable {

    private Long id;
    @NotBlank(message = "You must enter your first name")
    @Length(message = "Maximum length 100 characters", max = 100)
    private String firstName;
    @NotBlank(message = "You must enter your last name")
    @Length(message = "Maximum length 100 characters", max = 100)
    private String lastName;
    @NotBlank(message = "You must enter a username")
    @Length(message = "Maximum length 100 characters", max = 100)
    private String userName;
    @NotBlank(message = "You must enter a valid email address")
    @Length(message = "Maximum length 100 characters", max = 100)
    private String email;
}
