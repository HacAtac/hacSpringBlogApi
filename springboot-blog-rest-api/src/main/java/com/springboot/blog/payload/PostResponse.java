package com.springboot.blog.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor //@AllArgsConstructor generates a constructor with 1 parameter for each field in your class
@NoArgsConstructor //@NoArgsConstructor generates a constructor with no parameters
public class PostResponse {
    private List<PostDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
