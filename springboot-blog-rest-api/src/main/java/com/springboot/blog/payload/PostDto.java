package com.springboot.blog.payload;

import lombok.Data;

@Data //using this we don't need to write getters and setters, constructor, toString, etc
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;
}
