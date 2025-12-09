package ru.kata.spring.boot_security.demo.init;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class Init {

    private final UserService userService;
    private final RoleRepository roleRepository;

    public Init(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    private void init() {
        // Создаем роли если их нет
        if (!roleRepository.existsById(1L))
            roleRepository.save(new Role(1L, "ROLE_ADMIN"));
        if (!roleRepository.existsById(2L))
            roleRepository.save(new Role(2L, "ROLE_USER"));

        // Создаем админа
        if (!userService.existByEmail("admin@mail.ru")) {
            User admin = new User("admin", "admin", 33, "admin@mail.ru", "admin");
            // Передаем ID ролей (1L и 2L)
            List<Long> adminRoleIds = List.of(1L, 2L);
            userService.save(admin, adminRoleIds);
        }

        // Создаем пользователя
        if (!userService.existByEmail("user@mail.ru")) {
            User user = new User( "user", "user", 25, "user@mail.ru", "user");
            // Передаем ID роли USER (2L)
            List<Long> userRoleIds = List.of(2L);
            userService.save(user, userRoleIds);
        }
    }
}