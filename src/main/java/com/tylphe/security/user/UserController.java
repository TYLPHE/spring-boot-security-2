package com.tylphe.security.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/users/")
public class UserController {

    private static final List<User> USERS = Arrays.asList(
            new User(1, "James Bond"),
            new User(2, "Maria Jones"),
            new User(3, "Anna Smith")
    );

    @GetMapping("{userId}")
    public User getUser(@PathVariable Integer userId) {
        return USERS.stream()
                .filter(student -> userId.equals(student.getUserId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student does not exist"));
    }
}
