package com.springboot.blog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    // name should not be null or empty
    @NotEmpty(message = "Name cannot be empty or Null")
    private String name;
    // email field validation
    // email should not be null or empty
    @NotEmpty(message = "Email cannot be empty or Null")
    @Email(message = "Please provide a valid email")
    private String email;
    // comment should not be null or empty
    @NotEmpty(message = "Comment cannot be empty or Null")
    @Size(min = 2, max = 100, message = "Comment should have at least 2 characters and at most 100 characters")
    private String body;
}
