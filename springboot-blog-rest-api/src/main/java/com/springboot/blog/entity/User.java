package com.springboot.blog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String email;
    private String password;

    //Lines 24-28: We use the @ManyToMany annotation to tell our program that a user can have many roles and a role can be assigned to many users.
    //             We also use the @JoinTable annotation to tell our program that we want to create a new table called user_roles that will contain the user_id and role_id columns.
    //             The @JoinColumn annotation tells our program that the user_id column will contain the id of the user and the role_id column will contain the id of the role.
    //             We then use make a variable called roles that is a Set of Role objects. Which basically is an array of Role objects.
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles; //fetch the roles when we fetch the user from the database

}
