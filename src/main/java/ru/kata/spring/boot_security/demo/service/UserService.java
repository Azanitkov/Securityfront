package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAll();
    User findOne(Long id);
    void save(User user);
    void update(Long id, User user);
    void delete(Long id);
    User findByUsername(String username);

}
