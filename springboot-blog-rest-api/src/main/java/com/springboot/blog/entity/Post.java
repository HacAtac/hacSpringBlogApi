package com.springboot.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Instead of doing Getters/Setters Constructor, toString, etc. we can use Lombok to do it for us.
@Data //<-- This is the annotation that creates the Getters/Setters Constructor, toString, etc.
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
}
