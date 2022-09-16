package com.example.debeziumtest.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.UserSessionEvent;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(final UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping
    public List<User> loadAll()
    {
        return userService.loadAll();
    }

    @GetMapping(path = "/{id}")
    public User loadById(final @PathVariable("id") long id)
    {
        return userService.loadById(id);
    }

    @PostMapping
    public User createUser(final @RequestBody User user)
    {
        return userService.createUser(user);
    }

    @PutMapping(path = "/{id}")
    public User editUser(final @RequestBody User user, final @PathVariable("id") long id)
    {
        return userService.editUser(user, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(final @PathVariable("id") long id)
    {
        userService.deleteUser(id);
    }
}
