package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UserService {
    List<User> findAll();

    User findOne(Long id);

    void save(User user, List<Long> rolesIds);

    void update(Long id, User user, List<Long> rolesIds);

    void delete(Long id);

    Set<Role> getRolesByIds(List<Long> rolesIds);

    Boolean existByEmail(String email);

    User getByEmail(String email);


}
