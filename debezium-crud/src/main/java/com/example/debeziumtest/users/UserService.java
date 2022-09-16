package com.example.debeziumtest.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<User> loadAll()
    {
        return userRepository.findAll();
    }

    public User loadById(final long id)
    {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("No user found with %d id", id)));
    }

    public User createUser(final User user)
    {
        if (Objects.nonNull(user.getId()))
            throw new RuntimeException("Can't create user, id is defined");
        return userRepository.save(user);
    }

    public User editUser(final User user, final long id)
    {
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(final long id)
    {
        userRepository.deleteById(id);
    }
}
