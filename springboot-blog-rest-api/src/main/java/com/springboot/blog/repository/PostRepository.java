package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository annotation is optional here as it is a sub interface of JpaRepository, but it is a good practice to add it because it makes the code more readable.
@Repository
//So we need to pass in the Entity class name, and the type of the primary key
public interface PostRepository extends JpaRepository<Post, Long> {
    //We don't need to write any code here, Spring Data JPA will generate the code for us
    //Normally we would haft to write the code for the CRUD operations like Select * from Post where id = 1 etc etc.
}
