package com.springboot.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data //using this we don't need to write getters and setters, constructor, toString, etc
public class PostDto {

    private Long id;

    //title should not be null or empty
    //title should have at least 2 characters
    @NotEmpty(message = "Title cannot be empty or Null")
    @Size(min = 2, max = 20, message = "Title should have at least 2 characters and at most 20 characters")
    private String title;

    // post description should not be null or empty
    // post description should have at least 10 characters
    @NotEmpty(message = "Description cannot be empty or Null")
    @Size(min = 10, max = 100, message = "Description should have at least 10 characters and at most 100 characters")
    private String description;

    // post content should not be null or empty
    @NotEmpty(message = "Content cannot be empty or Null")
    private String content;
    private Set<CommentDto> comments;
}
