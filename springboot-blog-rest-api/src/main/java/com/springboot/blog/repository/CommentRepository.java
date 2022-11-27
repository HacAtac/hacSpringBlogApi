package com.springboot.blog.repository;

import com.springboot.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    //JPA will generate the code for us so dont need to write any code here.
    //If we want to write our own custom queries, we can do that here.
    //Like things like Select * from Comment where name = 'John' etc etc
}
