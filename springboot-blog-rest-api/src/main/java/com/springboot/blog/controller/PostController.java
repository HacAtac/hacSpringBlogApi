package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    //Inject PostService here
    private PostService postService; //loose coupling - we don't need to know how PostService is implemented

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create blog post REST API
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // get all posts REST API
    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }
}
