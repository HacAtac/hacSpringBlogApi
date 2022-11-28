package com.springboot.blog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

//Instead of doing Getters/Setters Constructor, toString, etc. we can use Lombok to do it for us.
//@Data //<-- This is the annotation that creates the Getters/Setters Constructor, toString, etc.
@Getter
@Setter
@AllArgsConstructor //<-- another lombok annotation that creates a constructor with all the fields
@NoArgsConstructor //<-- another lombok annotation that creates a constructor with no fields

@Entity //<-- This is the JPA annotation that tells Spring that this is an entity so it can create the table in the database
@Table(
        name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
public class Post {
    @Id //<--@Id tells Spring that this is the primary key. Primary keys are so that we can uniquely identify a row in a table.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //<-- @GeneratedValue tells Spring that this is an auto-incrementing field
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "content", nullable = false)
    private String content;

    //We're setting a OneToMany relationship between Post and Comment. This means that a Post can have many comments.
    //We're setting cascade = CascadeType.ALL. This means that if we delete a post, we want to delete all the comments associated with that post.
    //We're using orphanRemoval = true. This means that if we remove a comment from the comments Set, we want to delete that comment from the database.
    //We're using Set instead of List because we don't want to have duplicate comments. Set by default doesn't allow duplicates.
    // Then we're using HashSet because it's the fastest implementation of Set.
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();
}
