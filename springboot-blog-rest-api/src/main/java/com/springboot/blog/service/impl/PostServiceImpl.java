package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // this indicates that this class is a service so that Spring can find it and use it
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired // this indicates that Spring should inject an instance of PostRepository here.
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        //convert DTO to entity
        Post post = mapToEntity(postDto);
        //save the entity
        Post newPost = postRepository.save(post);
        // convert entity to DTO
        PostDto postResponse = mapToDTO(newPost);
        return postDto;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        //this basically converts a list of Post entities to a list of PostDto objects
        return posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDTO(post);
    }

    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        // get post by id from the database || if not found throw an exception
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        //set the new values by passing it to the postDto object
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        //save the updated post to the database
        Post updatedPost = postRepository.save(post);

        //convert entity to DTO and return the updated post DTO to client
        return mapToDTO(updatedPost);
    }


    //convert Entity into DTO
    private PostDto mapToDTO(Post post) {
       PostDto postDto = new PostDto();
       postDto.setId(post.getId());
       postDto.setTitle(post.getTitle());
       postDto.setDescription(post.getDescription());
       postDto.setContent(post.getContent());
       return postDto;
    }

    //convert DTO into Entity
    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
